package com.vikas.elibrary.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.vikas.elibrary.R;


public class Splash extends Activity {


	
	@Override
	protected void onCreate(Bundle vrockskbh) {
		// TODO Auto-generated method stub
		super.onCreate(vrockskbh);

		setContentView(R.layout.splash);
      
		Thread timer = new Thread() {

			@Override
			public void run() {
				try {   ImageView iv1=(ImageView) findViewById(R.id.imageView1);

					sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent openMain = new Intent("com.vikas.elibrary.activity.MainActivity");
					startActivity(openMain);
					finish();
				}
			}

		};
		timer.start();
	}


}
