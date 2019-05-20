package com.example.macskapp.ui.macskMain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.macskapp.AnalyticsApplication;
import com.example.macskapp.MacskAboutActivity;
import com.example.macskapp.MacskAppApplication;
import com.example.macskapp.R;
import com.example.macskapp.ui.macsklist.MacskListActivity;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

import javax.inject.Inject;

public class MacskMainActivity extends AppCompatActivity implements MacskMainScreen{
    public static final String TAG = "KEY_CATS";
    public static final String NAME = "MAIN";
    //Tracker mTracker;
    //@Inject
    //MacskMainPresenter macskMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_macsk_main);

        //MacskAppApplication.injector.inject(this);

        // Obtain the shared Tracker instance.
        //AnalyticsApplication application = (AnalyticsApplication)this.getApplication();
        //mTracker = application.getDefaultTracker();

        Button btnShowCatsList = findViewById(R.id.btnShowCatList);
        btnShowCatsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*mTracker.send(new HitBuilders.EventBuilder()
                        .setCategory("Foltos")
                        .setAction("Share")
                        .setLabel("Miauuu")
                        .build());
*/
                //macskMainPresenter.showCatsList();
                showCats();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        //macskMainPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //macskMainPresenter.detachScreen();
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
    protected void onResume(){
        super.onResume();
        /*Log.i(TAG, "Setting screen name: " + NAME);
        mTracker.setScreenName("Image~" + NAME);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());*/

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

    private void logUser() {
        // TODO: Use the current user's information
        // You can call any combination of these three methods
        Crashlytics.setUserIdentifier("12345");
        Crashlytics.setUserEmail("szigeti@fabric.io");
        Crashlytics.setUserName("Test User");
    }


    //@Override
    public void showCats() {
        // TODO: Move this to where you establish a user session
        logUser();


        Intent intent = new Intent(MacskMainActivity.this, MacskListActivity.class);
        startActivity(intent);
    }

    public void forceCrash(View view) {
        throw new RuntimeException("This is a crash");
    }

}
