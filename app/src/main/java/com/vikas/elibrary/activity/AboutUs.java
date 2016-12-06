package com.vikas.elibrary.activity;

/**
 * Created by Dell on 1/10/2016.
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.vikas.elibrary.R;

public class AboutUs extends AppCompatActivity implements View.OnClickListener {
    ImageView fb,linkedin,youtube,google,whatsapp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        Toolbar toolbar=(Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fb=(ImageView)findViewById(R.id.fb);
        linkedin=(ImageView)findViewById(R.id.ln);
        whatsapp=(ImageView)findViewById(R.id.wt);
        youtube=(ImageView)findViewById(R.id.gp);
        google=(ImageView)findViewById(R.id.youtube);
        fb.setOnClickListener(this);
        linkedin.setOnClickListener(this);
        whatsapp.setOnClickListener(this);
        youtube.setOnClickListener(this);
        google.setOnClickListener(this);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.help, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {

            NavUtils.navigateUpFromSameTask(this);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fb:Uri uri6 = Uri.parse("https://www.facebook.com/vikas.desale.963"); // missing 'http://' will cause crashed
                Intent intent6 = new Intent(Intent.ACTION_VIEW, uri6);
                startActivity(intent6);
                break;
            case R.id.wt:
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "VirLibrary");

                String sAux = " \n\t\t\tThank you for downloading the app E-library...";
                sAux = sAux + "\nFor Any Queries Please Contact Us on \n\t\t 8600507926 or\n\t\tvikas.desaleu@gmail.com" +
                        "\t\t\t\t\t By\n\t\t\t\tVikas Desale";
                i.putExtra(Intent.EXTRA_TEXT, sAux);
                Intent in=    Intent.createChooser(i, "Choose one");
              in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                getBaseContext().startActivity(in);break;
            case R.id.youtube:Uri uri1 = Uri.parse("https://plus.google.com/101910787809465436804/posts/p/pub"); // missing 'http://' will cause crashed
                Intent intent1 = new Intent(Intent.ACTION_VIEW, uri1);

                startActivity(intent1);
                break;
            case R.id.gp:Uri uri2 = Uri.parse("https://www.youtube.com/channel/UC6-f1uwcuwU-2j1T_HMb75Q"); // missing 'http://' will cause crashed
                Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
                startActivity(intent2);break;
            case R.id.ln:
            Uri uri7 = Uri.parse("https://www.linkedin.com/in/vikas-desale-01756774");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri7);
            startActivity(intent);break;


        }
    }
}
