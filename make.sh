#! /bin/bash
#
# Licensed under the Apache License, Version 2.0. http://www.apache.org/licenses/LICENSE-2.0
#


mvn clean

mvn compile

mvn source:jar

set -x
${JAVA_HOME}/bin/javah -classpath target/classes -d src/main/c de.weber_oldenburg.syslog.Syslog

cc -shared -fPIC -I ${JAVA_HOME}/include -I ${JAVA_HOME}/include/linux -o target/classes/de/weber_oldenburg/syslog/libSyslog_amd64.so src/main/c/de_weber_oldenburg_syslog_Syslog.c
cc -m32 -shared -fPIC -I ${JAVA_HOME}/include -I ${JAVA_HOME}/include/linux -o target/classes/de/weber_oldenburg/syslog/libSyslog_i386.so src/main/c/de_weber_oldenburg_syslog_Syslog.c
set +x

mvn install

${JAVA_HOME}/bin/javadoc -classpath target/classes/:/home/weber/.m2/repository/log4j/log4j/1.2.17/log4j-1.2.17.jar\
    -d target/apidocs -source 1.7 -public -sourcepath src/main/java/\
    de.weber_oldenburg.syslog de.weber_oldenburg.syslog.log4j


