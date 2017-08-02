package de.weber_oldenburg.syslog.log4j;

/*
   Licensed under the Apache License, Version 2.0. http://www.apache.org/licenses/LICENSE-2.0
 */

import de.weber_oldenburg.syslog.Facility;
import de.weber_oldenburg.syslog.Level;
import de.weber_oldenburg.syslog.Syslog;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

/**
 * Log4j appender to log messages via {@link Syslog} to the syslog daemon
 */
public class SyslogAppender extends AppenderSkeleton {

  private Facility facility = Facility.USER;

  @Override
  protected void append(LoggingEvent event) {
    StringBuilder identBuilder = new StringBuilder(event.getLogger().getName())
        .append("[").append(event.getThreadName()).append("]");
    Syslog.log(identBuilder.toString(), facility, getLevel(event.getLevel()), String.valueOf(event.getMessage()));
  }

  private Level getLevel(org.apache.log4j.Level level) {
    return Level.values()[level.getSyslogEquivalent()];
  }

  @Override
  public void close() {

  }

  @Override
  public boolean requiresLayout() {
    return false;
  }

  public void setFacility(Facility facility) {
    this.facility = facility;
  }

  public void setFacilityName(String facilityName) {
    this.facility = Facility.parse(facilityName);
  }
}
