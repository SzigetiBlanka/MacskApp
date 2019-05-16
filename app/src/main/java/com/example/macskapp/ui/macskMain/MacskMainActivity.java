package com.example.macskapp.ui.macskMain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.macskapp.MacskAboutActivity;
import com.example.macskapp.MacskAppApplication;
import com.example.macskapp.R;
import com.example.macskapp.ui.macsklist.MacskListActivity;

import javax.inject.Inject;

public class MacskMainActivity extends AppCompatActivity  implements MacskMainScreen{
    public static final String KEY_CATS = "KEY_CATS";
    @Inject
    MacskMainPresenter macskMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macsk_main);

        MacskAppApplication.injector.inject(this);

        Button btnShowCatsList = findViewById(R.id.btnShowCatList);
        btnShowCatsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                macskMainPresenter.showCatsList();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        macskMainPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        macskMainPresenter.detachScreen();
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
    public void showCats() {
        Intent intent = new Intent(MacskMainActivity.this, MacskListActivity.class);
        startActivity(intent);
    }
}
