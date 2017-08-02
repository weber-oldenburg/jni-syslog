package de.weber_oldenburg.syslog.log4j;

import de.weber_oldenburg.syslog.Facility;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LoggerFactory {

  public static Logger initializeLogger(String name, Facility facility, Level level) {
    Logger logger = LogManager.exists(name);
    if (logger == null) {
      logger = LogManager.getLogger(name);
      SyslogAppender syslogAppender = new SyslogAppender();
      syslogAppender.setFacility(facility);
      logger.addAppender(syslogAppender);
      logger.setLevel(level);
    }
    return logger;
  }
}
