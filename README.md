# jni-syslog
This is a log4j2 Appender writing via imuxsock module to the local syslog daemon (on linux systems).
The appender writes via jni to the c syslog library. Binarys for 32 and 64 bit are bundled and loaded as needed.

Configuration example could be found at https://github.com/weber-oldenburg/jni-syslog/blob/master/src/test/resources/log4j2-test.xml
