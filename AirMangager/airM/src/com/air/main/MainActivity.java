package com.air.main;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

	private static String TAG = MainActivity.class.getSimpleName();

	private Button searchbt;
	private Button managerbt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void init(){
		searchbt = (Button) MainActivity.this.findViewById(R.id.bt1);
		searchbt.setFocusable(true);
		managerbt = (Button) MainActivity.this.findViewById(R.id.bt2);
		searchbt.setOnClickListener(MainActivity.this);
		managerbt.setOnClickListener(MainActivity.this);

	}

	@Override
	public void onClick(View view) {
	switch (view.getId()){
		case R.id.bt1://search
			Log.i(TAG,"search click");
			break;
		case R.id.bt2:
			Log.i(TAG,"manager");
			break;
	}
	}
}
