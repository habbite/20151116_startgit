package com.air.jni;

/**
 * Created by Administrator on 2016/11/13.
 */
public class jvc {
    private static jvc ourInstance = new jvc();

    public static jvc getInstance() {
        return ourInstance;
    }

    private jvc() {
    }


    static {
        System.loadLibrary("jvcjni");
       // native_init();
    }

    //private static native final void native_init();
    public native final void native_getnum();

}
