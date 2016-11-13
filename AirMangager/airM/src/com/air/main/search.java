package com.air.main;

import android.app.Activity;
import android.os.Bundle;

import com.air.jni.jvc;

/**
 * Created by Administrator on 2016/11/13.
 */
public class search extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);


        getInfo();

    }

    private void getInfo(){
        jvc j = jvc.getInstance();
        j.native_getnum();
    }
}
