package com.example.maineclipseforstadio;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

public class MainActivity extends Activity {

	DatePicker dp;
	TimePicker tp;
	Button gatdate,gettime;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		dp = (DatePicker) findViewById(R.id.datapick1);
		tp = (TimePicker) findViewById(R.id.timipck);
		gatdate = (Button) findViewById(R.id.bt1);
		gettime = (Button) findViewById(R.id.bt2);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void getData(View v){
		String data;
		data = dp.getYear()+"Äê"+dp.getMonth()+"ÔÂ"+dp.getDayOfMonth();
		gatdate.setText(data);
	}


	public void getTime(View v){
		String time ;
		time = tp.getCurrentHour()+":"+tp.getCurrentMinute();
		gettime.setText(time);
	}

}
