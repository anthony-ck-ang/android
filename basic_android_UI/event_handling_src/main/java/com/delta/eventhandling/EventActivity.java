package com.delta.eventhandling;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class EventActivity extends Activity {

    Button mButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        //R object is created in runtime -> contains all the views to be used
        mButton = (Button) findViewById(R.id.myButton);

        //every view element can set different listener for different events
        /*
            create an object of a class that implements an onClickListener or...
            create handler on the fly...
            Anonymous class
            does not have a name

            mButton.setOnClickListener(new MyClass implements View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
         */

        mButton.setOnClickListener(new View.OnClickListener() {
            //method that runs when button pressed
            @Override
            public void onClick(View v) {
                mButton.setText("weeeeeee");
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.event, menu);
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
