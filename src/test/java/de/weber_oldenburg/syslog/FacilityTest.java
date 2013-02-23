package de.weber_oldenburg.syslog;
/*
   Licensed under the Apache License, Version 2.0. http://www.apache.org/licenses/LICENSE-2.0
 */

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class FacilityTest {

  @Test(dataProvider = "provideTestParseData")
  public void testParse(String facilityName, Facility expected) throws Exception {
    if (expected != null) {
      assertThat(Facility.parse(facilityName)).describedAs("facilityName").isEqualTo(expected);
    } else {
      IllegalArgumentException exception = null;
      try {
        Facility.parse(facilityName);
      } catch (IllegalArgumentException e) {
        exception = e;
      }
      assertThat(exception).describedAs("parse exception").isExactlyInstanceOf(IllegalArgumentException.class);
    }
  }

  @DataProvider
  public Object[][] provideTestParseData() {
    return new Object[][] {
        new Object[] {"KERN", Facility.KERN},
        new Object[] {"kern", Facility.KERN},
        new Object[] {"USER", Facility.USER},
        new Object[] {"user", Facility.USER},
        new Object[] {"MAIL", Facility.MAIL},
        new Object[] {"mail", Facility.MAIL},
        new Object[] {"DAEMON", Facility.DAEMON},
        new Object[] {"daemon", Facility.DAEMON},
        new Object[] {"AUTH", Facility.AUTH},
        new Object[] {"auth", Facility.AUTH},
        new Object[] {"SYSLOG", Facility.SYSLOG},
        new Object[] {"syslog", Facility.SYSLOG},
        new Object[] {"LPR", Facility.LPR},
        new Object[] {"lpr", Facility.LPR},
        new Object[] {"NEWS", Facility.NEWS},
        new Object[] {"news", Facility.NEWS},
        new Object[] {"UUCP", Facility.UUCP},
        new Object[] {"uucp", Facility.UUCP},
        new Object[] {"CRON", Facility.CRON},
        new Object[] {"cron", Facility.CRON},
        new Object[] {"AUTHPRIV", Facility.AUTHPRIV},
        new Object[] {"authpriv", Facility.AUTHPRIV},
        new Object[] {"FTP", Facility.FTP},
        new Object[] {"ftp", Facility.FTP},

        new Object[] {"LOCAL0", Facility.LOCAL0},
        new Object[] {"local0", Facility.LOCAL0},
        new Object[] {"LOCAL1", Facility.LOCAL1},
        new Object[] {"local1", Facility.LOCAL1},
        new Object[] {"LOCAL2", Facility.LOCAL2},
        new Object[] {"local2", Facility.LOCAL2},
        new Object[] {"LOCAL3", Facility.LOCAL3},
        new Object[] {"local3", Facility.LOCAL3},
        new Object[] {"LOCAL4", Facility.LOCAL4},
        new Object[] {"local4", Facility.LOCAL4},
        new Object[] {"LOCAL5", Facility.LOCAL5},
        new Object[] {"local5", Facility.LOCAL5},
        new Object[] {"LOCAL6", Facility.LOCAL6},
        new Object[] {"local6", Facility.LOCAL6},
        new Object[] {"LOCAL7", Facility.LOCAL7},
        new Object[] {"local7", Facility.LOCAL7},
    };
  }

  public static final int FACILITY_KERN     = (0 <<3);   /* kernel messages */
  public static final int FACILITY_USER     = (1 <<3);   /* random user-level messages */
  public static final int FACILITY_MAIL     = (2 <<3);   /* mail system */
  public static final int FACILITY_DAEMON   = (3 <<3);   /* system daemons */
  public static final int FACILITY_AUTH     = (4 <<3);   /* security/authorization messages */
  public static final int FACILITY_SYSLOG   = (5 <<3);   /* messages generated internally by syslogd */
  public static final int FACILITY_LPR      = (6 <<3);   /* line printer subsystem */
  public static final int FACILITY_NEWS     = (7 <<3);   /* network news subsystem */
  public static final int FACILITY_UUCP     = (8 <<3);   /* UUCP subsystem */
  public static final int FACILITY_CRON     = (9 <<3);   /* clock daemon */
  public static final int FACILITY_AUTHPRIV = (10 <<3);  /* security/authorization messages (private) */
  public static final int FACILITY_FTP      = (11 <<3);  /* ftp daemon */
  /* other codes through 15 reserved for system use */
  public static final int FACILITY_LOCAL0   = (16 <<3);  /* reserved for local use */
  public static final int FACILITY_LOCAL1   = (17 <<3);  /* reserved for local use */
  public static final int FACILITY_LOCAL2   = (18 <<3);  /* reserved for local use */
  public static final int FACILITY_LOCAL3   = (19 <<3);  /* reserved for local use */
  public static final int FACILITY_LOCAL4   = (20 <<3);  /* reserved for local use */
  public static final int FACILITY_LOCAL5   = (21 <<3);  /* reserved for local use */
  public static final int FACILITY_LOCAL6   = (22 <<3);  /* reserved for local use */
  public static final int FACILITY_LOCAL7   = (23 <<3);  /* reserved for local use */


  @Test(dataProvider = "provideTestOrdinalData")
  public void testOrdinal(Facility facility, int expected) {
    assertThat(facility.getCode()).describedAs("Facility.ordinal()").isEqualTo(expected);
  }

  @DataProvider
  public Object[][] provideTestOrdinalData() {
    return new Object[][] {
        new Object[] {Facility.KERN, FACILITY_KERN},
        new Object[] {Facility.USER, FACILITY_USER},
        new Object[] {Facility.MAIL, FACILITY_MAIL},
        new Object[] {Facility.DAEMON, FACILITY_DAEMON},
        new Object[] {Facility.AUTH, FACILITY_AUTH},
        new Object[] {Facility.SYSLOG, FACILITY_SYSLOG},
        new Object[] {Facility.LPR, FACILITY_LPR},
        new Object[] {Facility.NEWS, FACILITY_NEWS},
        new Object[] {Facility.UUCP, FACILITY_UUCP},
        new Object[] {Facility.CRON, FACILITY_CRON},
        new Object[] {Facility.AUTHPRIV, FACILITY_AUTHPRIV},
        new Object[] {Facility.FTP, FACILITY_FTP},

        new Object[] {Facility.LOCAL0, FACILITY_LOCAL0},
        new Object[] {Facility.LOCAL1, FACILITY_LOCAL1},
        new Object[] {Facility.LOCAL2, FACILITY_LOCAL2},
        new Object[] {Facility.LOCAL3, FACILITY_LOCAL3},
        new Object[] {Facility.LOCAL4, FACILITY_LOCAL4},
        new Object[] {Facility.LOCAL5, FACILITY_LOCAL5},
        new Object[] {Facility.LOCAL6, FACILITY_LOCAL6},
        new Object[] {Facility.LOCAL7, FACILITY_LOCAL7},
    };
  }
}
