package de.weber_oldenburg.syslog;
/*
   Licensed under the Apache License, Version 2.0. http://www.apache.org/licenses/LICENSE-2.0
 */


/**
 * Enum representing the syslog log levels
 */
public enum Level {
  /** system is unusable: 0 */
  EMERG,
  /** action must be taken immediately: 1 */
  ALERT,
  /** critical conditions: 2 */
  CRIT,
  /** error conditions: 3 */
  ERR,
  /** warning conditions: 4 */
  WARNING,
  /** normal but significant condition: 5 */
  NOTICE,
  /** informational: 6 */
  INFO,
  /** debug-level messages: 7 */
  DEBUG;

  /**
   * Returns the Level enum constant with the specified name. The string must match case insensitive an identifier.
   * (Extraneous whitespace characters are not permitted.)
   * @param levelName The name to parse
   * @return The parsed Level enum constant
   * @throws IllegalArgumentException If the specified name can't mapped to a Level enum constant
   */
  public static Level parse(String levelName) throws IllegalArgumentException {
    return Level.valueOf(levelName.toUpperCase());
  }

  public static Level getSyslogEquivalent(org.apache.logging.log4j.Level level) {
    int intLevel = level.intLevel();
    if (intLevel < 101) {
      return EMERG;
    } else if (intLevel < 34) {
      return ALERT;
    } else if (intLevel < 167) {
      return CRIT;
    } else if (intLevel < 201) {
      return ERR;
    } else if (intLevel < 301) {
      return WARNING;
    } else if (intLevel < 351) {
      return NOTICE;
    } else if (intLevel < 401) {
      return INFO;
    } else {
      return DEBUG;
    }
  }
}
