package com.delta.listviews;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends Activity {

    private ListView mListView;
    private PlaceAdapter mPlaceAdapter;
    private Place[] myPlacesArray = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        myPlacesArray = PlaceDataStore.getPlaceArray(); //fetch data

            //reference ListView from activity_list_view.xml
        mListView = (ListView) findViewById(R.id.myListView);
            //initialise PlaceAdapter with context + row.xml (resource) + data[]
        mPlaceAdapter = new PlaceAdapter(getApplicationContext(), R.layout.row, myPlacesArray);

        if(mListView != null){
            //set adapter to ListView
            mListView.setAdapter(mPlaceAdapter);
        }

        /*
            Register a callback to be invoked when an item in this AdapterView has
            been clicked.
            set listener on ListView
         */

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.v("PLACE", myPlacesArray[position].mNameOfPlace); //display name of place
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
