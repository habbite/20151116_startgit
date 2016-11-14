#include "utils/Log.h"

#include <stdio.h>
#include <assert.h>
#include <limits.h>
#include <unistd.h>
#include <fcntl.h>
#include <utils/threads.h>
#include "jni.h"
#include "JNIHelp.h"
#include "android_runtime/AndroidRuntime.h"
#include "utils/Errors.h"  // for status_t
#include "utils/KeyedVector.h"
#include "utils/String8.h"



static void jni_jvc_getnum(JNIEnv *env, jobject thiz)
{
   // LOGV("jni_jvc_getnum");

}


static const JNINativeMethod gMethods[]{
	{"native_getnum",     "()V",   (void *)jni_jvc_getnum},
};

static int registerMethods(JNIEnv *env){
        static const char* const kclassName = "com/air/jni/jvc";
        jclass clazz;
        clazz = env->FindClass(kclassName);
        if(clazz == NULL){
        return -1;
        }

        //register
        if(env->RegisterNatives(clazz,gMethods,sizeof(gMethods)/sizeof(gMethods[0])) != JNI_OK){
        return -1;
        }

        return 0;
}

jint JNI_OnLoad(JavaVM* vm, void* reserved)
{
    JNIEnv* env = NULL;
    jint result = -1;

    //LOGV("JNI_OnLoad was called");

    if (vm->GetEnv((void**) &env, JNI_VERSION_1_4) != JNI_OK) {
       // LOGE("ERROR: GetEnv failed\n");
        goto fail;
    }
    assert(env != NULL);

    if(registerMethods(env)!=0){
        goto fail;
    }

    /* success -- return valid version number */
    result = JNI_VERSION_1_4;

fail:
    return result;
}