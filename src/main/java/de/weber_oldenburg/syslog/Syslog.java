package de.weber_oldenburg.syslog;
/*
   Licensed under the Apache License, Version 2.0. http://www.apache.org/licenses/LICENSE-2.0
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.logging.Logger;

/**
 *
 */
public class Syslog {

  private static Logger LOG = Logger.getLogger(Syslog.class.getName());

  static {
    String osArch = System.getProperties().getProperty("os.arch");
    String libPath = "de/weber_oldenburg/syslog/libSyslog_" + osArch + ".so";
    InputStream inputStream = Syslog.class.getClassLoader().getResourceAsStream(libPath);

    try {
      if (inputStream != null) {
//        System.out.println("found libraty at " + libPath);
        File libSyslog_ = File.createTempFile("libSyslog_", ".so");
        FileOutputStream outputStream = new FileOutputStream(libSyslog_);
        byte[] buffer = new byte[1024];
        int len = inputStream.read(buffer);
        while (len != -1) {
          outputStream.write(buffer, 0, len);
          len = inputStream.read(buffer);
        }
        outputStream.flush();
        System.load(libSyslog_.getAbsolutePath());
        libSyslog_.delete();
      } else {
        System.err.println("Library for " + osArch + " at path \"" + libPath + "\" not found!");
      }
    } catch (Throwable e) {
      System.err.println(e.getMessage());
      e.printStackTrace(System.err);
      LOG.log(java.util.logging.Level.SEVERE, "Caught: ", e);
    }
  }

  private Syslog() {
  }

  /**
   * Write a message to the syslog daemon
   * @param ident Token to identify the program who writes the message, may be null to fallback to default.
   * @param facility The syslog {@link Facility}
   * @param level The syslog log {@link Level}
   * @param message The log message
   */
  public static void log(String ident, Facility facility, Level level, String message) {
    try {
      log(ident, facility.getCode(), level.ordinal(), message);
    } catch (Throwable e) {
      System.err.println(e.getMessage());
      e.printStackTrace(System.err);
    }
  }

  private static native void log(String ident, int facility, int level, String message);

  /**
   * just to enable easy testing
   * @param args
   */
  public static void main(String[] args) {

    String ident = null;
    Facility facility = Facility.USER;
    Level level = Level.NOTICE;

    String message = "";
    int i = 0;
    for (; i < args.length; i++) {
      switch (args[i]) {
        case "-i":
        case "--ident":
          ident = args[++i];
          break;
        case "-f":
        case "--facility":
          facility = Facility.parse(args[++i]);
          break;
        case "-l":
        case "--level":
          level = Level.parse(args[++i]);
          break;
        default:
          message = message + " " + args[i];
          break;
      }
    }
    
    log(ident, facility.getCode(), level.ordinal(), message.trim());
//    System.getProperties().list(System.out);
  }
}
