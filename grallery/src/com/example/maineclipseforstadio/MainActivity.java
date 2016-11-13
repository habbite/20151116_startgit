package com.example.maineclipseforstadio;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {


	private Gallery mg;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mg = (Gallery) findViewById(R.id.galleryid);
		mg.setAdapter(new ImageAdapter(this));
		mg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
				Toast.makeText(MainActivity.this, "click" + i + "’≈Õº∆¨", Toast.LENGTH_LONG).show();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private class ImageAdapter extends BaseAdapter {
		private Context mcontext;
		private Integer mImage[] = {
				R.drawable.a,
				R.drawable.b,
				R.drawable.c,
				R.drawable.d,
				R.drawable.e
		};
		public ImageAdapter(Context context) {
			mcontext =context;
		}



		@Override
		public int getCount() {
			return mImage.length;
		}

		@Override
		public Object getItem(int i) {
			return i;
		}

		@Override
		public long getItemId(int i) {
			return i;
		}

		@Override
		public View getView(int p, View view, ViewGroup viewGroup) {
			ImageView i = new ImageView(mcontext);
			i.setImageResource(mImage[p]);
			i.setScaleType(ImageView.ScaleType.FIT_XY);
			i.setLayoutParams(new Gallery.LayoutParams(300,300));
			return null;
		}
	}
}
