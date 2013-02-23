package de.weber_oldenburg.syslog;
/*
   Licensed under the Apache License, Version 2.0. http://www.apache.org/licenses/LICENSE-2.0
 */


/**
 * Enum representing the syslog facilities
 */
public enum Facility {
  /** kernel messages: (0<<3) */
  KERN(0<<3),
  /** random user-level messages: (1<<3) */
  USER(1<<3),
  /** mail system: (2<<3) */
  MAIL(2<<3),
  /** system daemons: (3<<3) */
  DAEMON(3<<3),
  /** security/authorization messages: (4<<3) */
  AUTH(4<<3),
  /** messages generated internally by syslogd: (5<<3) */
  SYSLOG(5<<3),
  /** line printer subsystem: (6<<3) */
  LPR(6<<3),
  /** network news subsystem: (7<<3) */
  NEWS(7<<3),
  /** UUCP subsystem: (8<<3) */
  UUCP(8<<3),
  /** clock daemon: (9<<3) */
  CRON(9<<3),
  /** security/authorization messages (private): (10<<3) */
  AUTHPRIV(10<<3),
  /** ftp daemon: (11<<3) */
  FTP(11<<3),

  /** reserved for local use: (16<<3) */
  LOCAL0(16<<3),
  /** reserved for local use: (17<<3) */
  LOCAL1(17<<3),
  /** reserved for local use: (18<<3) */
  LOCAL2(18<<3),
  /** reserved for local use: (19<<3) */
  LOCAL3(19<<3),
  /** reserved for local use: (20<<3) */
  LOCAL4(20<<3),
  /** reserved for local use: (21<<3) */
  LOCAL5(21<<3),
  /** reserved for local use: (22<<3) */
  LOCAL6(22<<3),
  /** reserved for local use: (23<<3) */
  LOCAL7(23<<3);

  private int code;

  private Facility(int code) {
    this.code = code;
  }

  /**
   * Returns the facility code.
   * @return The facility code value
   */
  public int getCode() {
    return code;
  }

  /**
   * Returns the Facility enum constant with the specified name. The string must match case insensitive an identifier.
   * (Extraneous whitespace characters are not permitted.)
   * @param facilityName The name to parse
   * @return The parsed Facility enum constant
   * @throws IllegalArgumentException  If the specified name can't mapped to a Facility enum constant
   */
  public static Facility parse(String facilityName) throws IllegalArgumentException {
    return Facility.valueOf(facilityName.toUpperCase());
  }
}
