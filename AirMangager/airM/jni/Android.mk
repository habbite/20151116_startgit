LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := optional

LOCAL_SRC_FILES:= \
    jin_jvc.cpp

LOCAL_SHARED_LIBRARIES := \
    libandroid_runtime \
    libnativehelper \
    libutils \
    libbinder \
    libui \
    libcutils \
    libicuuc

LOCAL_PRELINK_MODULE := false

LOCAL_MODULE:= libdjvcjni

include $(BUILD_SHARED_LIBRARY)

