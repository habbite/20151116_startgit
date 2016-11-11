package com.air.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Yuriy on 2016/11/11.
 */
public class flashActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flash);
        enterMain();
    }

    private void enterMain(){

        Thread tt = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5*1000);
                    Intent intent = new Intent();
                    intent.setClass(flashActivity.this,MainActivity.class);
                    flashActivity.this.startActivity(intent);
                    flashActivity.this.finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        tt.start();
    }
}
