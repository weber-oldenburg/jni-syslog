package de.weber_oldenburg.syslog;
/*
   Licensed under the Apache License, Version 2.0. http://www.apache.org/licenses/LICENSE-2.0
 */

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class LevelTest {

  @Test(dataProvider = "provideTestParseData")
  public void testParse(String levelName, Level expected) throws Exception {
    if (expected != null) {
      assertThat(Level.parse(levelName)).describedAs("levelName").isEqualTo(expected);
    } else {
      IllegalArgumentException exception = null;
      try {
        Level.parse(levelName);
      } catch (IllegalArgumentException e) {
        exception = e;
      }
      assertThat(exception).describedAs("parse exception").isExactlyInstanceOf(IllegalArgumentException.class);
    }
  }

  @DataProvider
  public Object[][] provideTestParseData() {
    return new Object[][] {
        new Object[] {"EMERG", Level.EMERG},
        new Object[] {"emerg", Level.EMERG},
        new Object[] {"ALERT", Level.ALERT},
        new Object[] {"alert", Level.ALERT},
        new Object[] {"CRIT", Level.CRIT},
        new Object[] {"crit", Level.CRIT},
        new Object[] {"ERR", Level.ERR},
        new Object[] {"err", Level.ERR},
        new Object[] {"WARNING", Level.WARNING},
        new Object[] {"warning", Level.WARNING},
        new Object[] {"NOTICE", Level.NOTICE},
        new Object[] {"notice", Level.NOTICE},
        new Object[] {"INFO", Level.INFO},
        new Object[] {"info", Level.INFO},
        new Object[] {"DEBUG", Level.DEBUG},
        new Object[] {"debug", Level.DEBUG},
        new Object[] {"other", null}
    };
  }

  public static final int LEVEL_EMERG   = 0;  /* system is unusable */
  public static final int LEVEL_ALERT   = 1;  /* action must be taken immediately */
  public static final int LEVEL_CRIT    = 2;  /* critical conditions */
  public static final int LEVEL_ERR     = 3;  /* error conditions */
  public static final int LEVEL_WARNING = 4;  /* warning conditions */
  public static final int LEVEL_NOTICE  = 5;  /* normal but significant condition */
  public static final int LEVEL_INFO    = 6;  /* informational */
  public static final int LEVEL_DEBUG   = 7;  /* debug-level messages */


  @Test(dataProvider = "provideTestOrdinalData")
  public void testOrdinal(Level level, int expected) {
    assertThat(level.ordinal()).describedAs("Level.ordinal()").isEqualTo(expected);
  }

  @DataProvider
  public Object[][] provideTestOrdinalData() {
    return new Object[][] {
        new Object[] {Level.EMERG, LEVEL_EMERG},
        new Object[] {Level.ALERT, LEVEL_ALERT},
        new Object[] {Level.CRIT, LEVEL_CRIT},
        new Object[] {Level.ERR, LEVEL_ERR},
        new Object[] {Level.WARNING, LEVEL_WARNING},
        new Object[] {Level.NOTICE, LEVEL_NOTICE},
        new Object[] {Level.INFO, LEVEL_INFO},
        new Object[] {Level.DEBUG, LEVEL_DEBUG}
    };
  }

}
