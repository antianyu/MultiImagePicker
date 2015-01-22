package com.antianyu.test;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;

public class ImageActivity extends Activity
{
	private ImageView imageView;
	
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);
		initView();
	}

	protected void onResume()
	{
		super.onResume();
	}

	protected void onPause()
	{
		super.onPause();
	}
	
	private void initView()
	{
		getActionBar().hide();
		
		String imagePath = getIntent().getStringExtra("imagePath");
		Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
		
		if (bitmap == null)
		{
			finish();
		}
		
		imageView = (ImageView)findViewById(R.id.imageView);
		imageView.setImageBitmap(bitmap);

		DisplayMetrics metrics = getResources().getDisplayMetrics();
		
		double imageRatio = ((double)bitmap.getHeight())/bitmap.getWidth();
		double screenRatio = ((double)metrics.heightPixels)/metrics.widthPixels;
		
		LayoutParams params = imageView.getLayoutParams();
		if (imageRatio > screenRatio)
		{
			params.height = metrics.heightPixels;
			params.width = (int) (metrics.heightPixels / imageRatio);
		}
		else
		{
			params.height = (int) (metrics.widthPixels * imageRatio);
			params.width = metrics.widthPixels;
		}
		
		imageView.setLayoutParams(params);
		imageView.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				finish();
			}
		});
	}
}
