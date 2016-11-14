LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := optional

LOCAL_SRC_FILES:= \
    jni_jvc.cpp

LOCAL_SHARED_LIBRARIES := \
    libandroid_runtime \
    libnativehelper \
    libutils \
    libbinder \
    libui \
    libcutils \
    libicuuc

LOCAL_PRELINK_MODULE := false

LOCAL_C_INCLUDES += \
    frameworks/base/core/jni \
    external/icu4c/common \
    $(JNI_H_INCLUDE)
	
LOCAL_MODULE:= libjvcjni

include $(BUILD_SHARED_LIBRARY)

