/*
   Licensed under the Apache License, Version 2.0. http://www.apache.org/licenses/LICENSE-2.0
 */


#include "de_weber_oldenburg_syslog_Syslog.h"
#include <syslog.h>

JNIEXPORT void JNICALL Java_de_weber_1oldenburg_syslog_Syslog_log (JNIEnv *env, jclass claz, jstring jident, jint jfacility, jint jlevel, jstring jmessage) {
  const char* message = NULL;
  if (jmessage) {
    message = (*env)->GetStringUTFChars(env, jmessage, 0);
  }
  const char* ident = NULL;
  if (jident) {
    ident = (*env)->GetStringUTFChars(env, jident, 0);
  }
  openlog(ident, 0, 0);
  syslog(jfacility | jlevel, message, "");
  closelog();
}
