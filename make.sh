#! /bin/bash

mvn clean

mvn compile

set -x
$JAVA_HOME/bin/javah -classpath target/classes -d src/main/c de.weber_oldenburg.syslog.Syslog

cc -shared -fPIC -I /opt/Apps/jdk/include -I /opt/Apps/jdk/include/linux -o target/classes/de/weber_oldenburg/syslog/libSyslog_amd64.so src/main/c/de_weber_oldenburg_syslog_Syslog.c
cc -m32 -shared -fPIC -I /opt/Apps/jdk/include -I /opt/Apps/jdk/include/linux -o target/classes/de/weber_oldenburg/syslog/libSyslog_i386.so src/main/c/de_weber_oldenburg_syslog_Syslog.c
set +x

mvn install


