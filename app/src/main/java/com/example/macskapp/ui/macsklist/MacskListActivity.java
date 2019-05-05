package com.example.macskapp.ui.macsklist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.macskapp.DataModel;
import com.example.macskapp.MacskAboutActivity;
import com.example.macskapp.MacskAddActivity;
import com.example.macskapp.R;

import java.util.ArrayList;

public class MacskListActivity extends AppCompatActivity{

    ArrayList<DataModel> dataModels;
    ListView listView;
    Button addCatBtn;
    private static ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macsk_list);
        listView= findViewById(R.id.Catlist);
        addCatBtn= findViewById(R.id.AddCat);
        dataModels= new ArrayList<>();

        dataModels.add(new DataModel("Czirmi", "vmi foltos", "Elég jófej, tud programozni","ezt most nem"));
        dataModels.add(new DataModel("Banana", "típus", "2","20/2345678"));
        dataModels.add(new DataModel("cake", "tipikus2", "pont ez","30/4050607"));
        dataModels.add(new DataModel("Donut","pontosan","#justAndroidThings","061-2345678"));

        addCatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add = new Intent(MacskListActivity.this, MacskAddActivity.class);
                startActivity(add);
            }
        });

        adapter= new ListAdapter(dataModels,getApplicationContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DataModel dataModel= dataModels.get(position);

                Snackbar.make(view, dataModel.getName()+"\n"+dataModel.getType()+" API: "+dataModel.getDescription(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
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
}


