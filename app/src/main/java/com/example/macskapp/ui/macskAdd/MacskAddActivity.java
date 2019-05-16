package com.example.macskapp.ui.macskAdd;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.example.macskapp.MacskAboutActivity;
import com.example.macskapp.MacskAppApplication;
import com.example.macskapp.R;
import com.example.macskapp.model.Cat;
import com.example.macskapp.ui.macskMain.MacskMainActivity;

import javax.inject.Inject;

public class MacskAddActivity extends Activity implements MacskAddScreen{

    @Inject
    MacskAddPresenter macskAddPresenter;

    TextInputEditText catNameTxtIn;
    TextInputEditText catDescTxtIn;
    TextInputEditText catCategoryTxtIn;
    TextInputEditText catContactTxtIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macsk_add);

        MacskAppApplication.injector.inject(this);

        catNameTxtIn = findViewById(R.id.cat_name_edit_text);

        catDescTxtIn = findViewById(R.id.cat_description_edit_text);

        catCategoryTxtIn = findViewById(R.id.cat_category_edit_text);

        catContactTxtIn = findViewById(R.id.cat_contact_edit_text);

        Button addNewMovieButton = findViewById(R.id.add_new_cat_button);
        addNewMovieButton.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View view) {
                                                     Cat m = new Cat(catNameTxtIn.getText().toString(), catDescTxtIn.getText().toString(),
                                                             catCategoryTxtIn.getText().toString(), catContactTxtIn.getText().toString());
                                                     macskAddPresenter.saveCat(m);
                                                 }
                                             }
        );
    }

    @Override
    protected void onStart() {
        super.onStart();
        macskAddPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        macskAddPresenter.detachScreen();
    }

    @Override
    public void saveCat(Cat m) {
        m.save();
        Intent intent = new Intent(MacskAddActivity.this, MacskMainActivity.class);
        startActivity(intent);
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

}
