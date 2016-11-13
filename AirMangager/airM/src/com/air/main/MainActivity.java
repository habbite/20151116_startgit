package com.air.main;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener,View.OnFocusChangeListener {

	private static String TAG = MainActivity.class.getSimpleName();

	private TextView searchbt;
	private TextView managerbt;
	private LinearLayout searchlyout;
	private LinearLayout managerlyout;
	private ImageView searchim;
	private ImageView managerim;
	private RelativeLayout mainlyout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mainlyout =(RelativeLayout) findViewById(R.id.mainLyout);
		WallpaperManager wallpaperManager = WallpaperManager.getInstance(MainActivity.this);
		mainlyout.setBackgroundDrawable(wallpaperManager.getDrawable());
		init();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void init(){
		searchbt = (TextView) MainActivity.this.findViewById(R.id.bt1);
		managerbt = (TextView) MainActivity.this.findViewById(R.id.bt2);
		searchim = (ImageView) findViewById(R.id.im1);
		managerim = (ImageView) findViewById(R.id.im2);

		searchlyout = (LinearLayout) findViewById(R.id.searchlyout);
		searchlyout.requestFocus();
		searchlyout.setOnClickListener(this);
		searchlyout.setOnFocusChangeListener(this);
		searchbt.setTextColor(this.getResources().getColor(R.color.red));
		searchim.setImageResource(R.drawable.ic_action_emo_angry2);

		managerlyout = (LinearLayout) findViewById(R.id.managerlyout);
		managerlyout.setOnClickListener(this);
		managerlyout.setOnFocusChangeListener(this);
	}

	@Override
	public void onClick(View view) {
		Intent intent = new Intent();
	switch (view.getId()){
		case R.id.searchlyout://search
			Log.i(TAG, "search click");
			intent.setClass(this, search.class);
			break;
		case R.id.managerlyout:
			Log.i(TAG,"manager");
			break;
	}
		MainActivity.this.startActivity(intent);

	}

	@Override
	public void onFocusChange(View view, boolean focus) {
		switch (view.getId()){
			case R.id.searchlyout:
				if(focus){
					searchbt.setTextColor(this.getResources().getColor(R.color.red));
					searchim.setImageResource(R.drawable.ic_action_emo_angry2);
					//searchim.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_action_emo_angry2));
				}else{
					searchbt.setTextColor(this.getResources().getColor(R.color.white));
					searchim.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_action_emo_angry));
				}
				break;
			case R.id.managerlyout:
				if(focus){
					managerbt.setTextColor(this.getResources().getColor(R.color.red));
					managerim.setImageResource(R.drawable.ic_action_emo_basic2);
					//managerim.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_action_emo_basic2));
				}else {
					managerbt.setTextColor(this.getResources().getColor(R.color.white));
					managerim.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_action_emo_basic));
				}

				break;
		}
	}
}
