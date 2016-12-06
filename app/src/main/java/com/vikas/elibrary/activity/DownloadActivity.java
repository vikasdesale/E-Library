package com.vikas.elibrary.activity;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.vikas.elibrary.Logging.L;
import com.vikas.elibrary.R;

public class DownloadActivity extends Activity {
    private String url = null;
    private long enqueue;
    private DownloadManager dm;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        Intent intent = getIntent();
        url = intent.getStringExtra("key");
        if (url != null) {
            dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
            Request request = new Request(
                    Uri.parse(url));
            enqueue = dm.enqueue(request);
        } else {
            L.t(this, "Please try later..");
        }
        YoYo.with(Techniques.BounceInDown)
                .duration(3000)
                .playOn(findViewById(R.id.animv));
        // finish();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //schedule the job after the delay has been elapsed

                 finish();
            }
        }, 3000);

    }
}