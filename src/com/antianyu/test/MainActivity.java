package com.antianyu.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity
{
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == Constant.ACTION_PICK_CODE && resultCode == Activity.RESULT_OK)
		{
			String[] paths = data.getStringArrayExtra("paths");

			for (int i = 0; i < paths.length; i++)
			{
				System.out.println(i + ": " + paths[i]);
			}
		}
	}

	private void init()
	{
		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				Intent intent = new Intent(MainActivity.this, GalleryActivity.class);
				intent.putExtra("maxCount", 2);
				startActivityForResult(intent, Constant.ACTION_PICK_CODE);
			}
		});
	}
}
