package de.weber_oldenburg.syslog;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SyslogJniAppenderTest {

  private static final Logger SYS_LOG = LogManager.getLogger("sysLog");
  private static final Logger MAIL_LOG = LogManager.getLogger("mailLog");

  public static void main(String[] args) {

    String ident = null;
    Facility facility = Facility.USER;
    org.apache.logging.log4j.Level level = org.apache.logging.log4j.Level.INFO;

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
          level = org.apache.logging.log4j.Level.getLevel(args[++i]);
          break;
        default:
          message = message + " " + args[i];
          break;
      }
    }

    switch (facility) {
      case MAIL:
         MAIL_LOG.log(level, message);
         break;
      default:
        SYS_LOG.log(level, message);
    }

  }
}
