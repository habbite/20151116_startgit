package com.doni.tabhost;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends Activity {

	private TabHost mTabhost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mTabhost = (TabHost) MainActivity.this.findViewById(R.id.tabhost);
		mTabhost.setup();
		mTabhost.addTab(mTabhost.newTabSpec(MainActivity.this.getResources().getString(R.string.left))
				.setIndicator("", MainActivity.this.getResources().getDrawable(R.drawable.c))
				.setContent(R.id.tabview1));

		mTabhost.addTab(mTabhost.newTabSpec(MainActivity.this.getResources().getString(R.string.down))
				.setIndicator("", MainActivity.this.getResources().getDrawable(R.drawable.b))
				.setContent(R.id.tabview2));

		mTabhost.addTab(mTabhost.newTabSpec(MainActivity.this.getResources().getString(R.string.right))
				.setIndicator("",MainActivity.this.getResources().getDrawable(R.drawable.a))
				.setContent(R.id.tabview3));

	}



}
