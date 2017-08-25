package de.weber_oldenburg.syslog.log4j;

/*
   Licensed under the Apache License, Version 2.0. http://www.apache.org/licenses/LICENSE-2.0
 */

import java.io.Serializable;

import de.weber_oldenburg.syslog.Facility;
import de.weber_oldenburg.syslog.Level;
import de.weber_oldenburg.syslog.Syslog;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;

/**
 * Log4j appender to log messages via {@link Syslog} to the syslog daemon
 */
@Plugin(name = SyslogJniAppender.APPENDER_NAME, category = "Core", elementType = "appender", printObject = true)
public class SyslogJniAppender extends AbstractAppender {

  public static final String APPENDER_NAME = "SyslogJniAppender";

  private Facility facility = Facility.USER;

  protected SyslogJniAppender(String name, Filter filter, Layout<? extends Serializable> layout, Facility facility) {
    super(name, filter, layout);
    this.facility = facility;
  }

  @Override
  public void append(LogEvent event) {
    String identBuilder = getName() + "[" + event.getThreadName() + "]";
    Syslog.log(identBuilder, facility, getLevel(event.getLevel()), getLayout().toSerializable(event).toString());
  }

  private Level getLevel(org.apache.logging.log4j.Level level) {
    return Level.getSyslogEquivalent(level);
  }



  @PluginFactory
  public static SyslogJniAppender createAppender(
      @PluginAttribute("name") String name,
      @PluginElement("Layout") Layout<? extends Serializable> layout,
      @PluginElement("Filter") final Filter filter,
      @PluginAttribute("facility") String facility
  ) {
    if (name == null) {
      LOGGER.error("SyslogJniAppender name must not be null.");
      return null;
    }

    if (layout == null) {
      layout = PatternLayout.createDefaultLayout();
    }

    return new SyslogJniAppender(name, filter, layout, Facility.parse(facility));
  }

}
