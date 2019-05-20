package com.example.macskapp.ui.macsklist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.macskapp.AnalyticsApplication;
import com.example.macskapp.MacskAboutActivity;
import com.example.macskapp.ui.macskAdd.MacskAddActivity;
import com.example.macskapp.R;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class MacskListActivity extends AppCompatActivity{
    /*public static final String TAG = "LIST_CATS";
    public static final String NAME = "LIST";
    Tracker mTracker;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macsk_list);

        /*AnalyticsApplication application = (AnalyticsApplication) getApplication();
        mTracker = application.getDefaultTracker();*/

        FloatingActionButton add = findViewById(R.id.addNewCat);
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Snackbar.make(view, "movie added", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
               /* mTracker.send(new HitBuilders.EventBuilder()
                        .setCategory("repulos")
                        .setAction("Share")
                        .setLabel("HUSSSSS")
                        .build());*/

                Intent intent = new Intent(MacskListActivity.this, MacskAddActivity.class);
                startActivity(intent);
            }

        });
    }

    //toolbar icon beállítása
    private void about() {
        startActivity(new Intent(this, MacskAboutActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_favorite) {
            about();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onResume(){
        super.onResume();
        /*Log.i(TAG, "Setting screen name: " + NAME);
        mTracker.setScreenName("Image~" + NAME);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());*/

    }
}


