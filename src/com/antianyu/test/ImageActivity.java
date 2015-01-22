package com.antianyu.test;

import uk.co.senab.photoview.PhotoView;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;

public class ImageActivity extends Activity
{	
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
		
		PhotoView photoView = (PhotoView)findViewById(R.id.photoView);
		photoView.setImageBitmap(bitmap);

		DisplayMetrics metrics = getResources().getDisplayMetrics();
		
		double imageRatio = ((double)bitmap.getHeight())/bitmap.getWidth();
		double screenRatio = ((double)metrics.heightPixels)/metrics.widthPixels;
		
		LayoutParams params = photoView.getLayoutParams();
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
		
		photoView.setLayoutParams(params);
	}
}
