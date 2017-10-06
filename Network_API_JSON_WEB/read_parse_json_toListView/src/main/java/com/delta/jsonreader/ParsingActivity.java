package com.delta.jsonreader;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;


public class ParsingActivity extends Activity {
    ListView mListView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parsing);

        String s = getJSONFile(); //read and retrieve String data from file
        String myDataArray[] = {};

        //
        // Parse some JSON and display it in a listview.
        //
        try {

            //Creates a new JSONObject with name/value mappings from the JSON string.
            JSONObject rootJSON = new JSONObject(s);

            //using Json obj, from the root -> traverse and get JSONArray that has key/named "topping"
            JSONArray toppingJSON = rootJSON.getJSONArray("topping");

            myDataArray = new String[toppingJSON.length()]; //initialise new String array with JSONArray length.

            for (int i = 0; i < toppingJSON.length(); i++) {

                //each array element of toppingJSON array is a json object
                JSONObject jsonObject = toppingJSON.getJSONObject(i);

                //get the value of the key named "type" in each json object and save to myDataArray[]
                myDataArray[i] = jsonObject.getString("type");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        //Display the array elements in a listView
        mListView = (ListView) findViewById(R.id.myListView);

        /*
           @param context The current context.
           @param resource The resource ID for a layout file containing a TextView to use when instantiating views.
           @param objects The objects to represent in the ListView.
         */
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.row, myDataArray);

        //Adapter takes in "row" layout + "data" (array of Strings) -> drop into ListView
        if (mListView != null) {
            mListView.setAdapter(stringArrayAdapter);
        }
    }


    //Just a simple helper method to read the file. (READ from INPUT obj. WRITE To OUTPUT Obj.)
    public String getJSONFile() {
        String json = null;
        try {

            //input streams obj that read data from the samplejson file.
            InputStream is = getResources().openRawResource(R.raw.samplejson);

            //using InputStream obj, return an estimated number of bytes that can be read
            int size = is.available();

            //initialise byte array with size (no of bytes)
            byte[] buffer = new byte[size];

            /*
                Reads a single byte from this stream and stores them in the byte array
                Returns -1 if the end of the stream has been reached
             */
            is.read(buffer);
            is.close();

            //Converts the byte array to a string using the named charset
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json; //return string

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.parsing, menu);
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
