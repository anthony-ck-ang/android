package com.delta.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by anthonyang on 30/9/17.
 */

public class DetailActivity extends Activity {

    private Button mReturnButton = null;
    private Spinner mSpinner = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Get data out of the intent object and assign to Bundle
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String detailValue = extras.getString("SendKey"); //get value with key
            if (detailValue != null) {
                /*
                    A toast is a view containing a quick little message for the user.
                    The toast class helps you create and show those.
                 */
                Toast.makeText(this, detailValue, Toast.LENGTH_SHORT).show(); //Display Data
            }

        }

        //prepare the other UIs

        //reference of spinner and button on activity_detail.xml
        mSpinner = (Spinner) findViewById(R.id.spinnerSelection);

        mReturnButton = (Button) (findViewById(R.id.returnToSecondActivity));


//        mReturnButton.setOnClickListener((view) -> {
//
//            //create blank Intent object
//            Intent returnIntent = new Intent();
//            //get the selected spinner object -> cast toString -> save to variable
//            String mySelection = mSpinner.getSelectedItem().toString();
//            //put value in K,V pair
//            returnIntent.putExtra("returnKey", mySelection);
//
//            //Call this to set the result that your activity will return to its caller
//            setResult(RESULT_OK, returnIntent);
//            //end activity
//            finish();
//
//
////            //get and access view's context and execute a hard-coded class name
////            Intent i = new Intent(view.getContext(),SecondActivity.class);
////            startActivity(i);
//        });

        mReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create blank Intent object
                Intent returnValue = new Intent();

                //get the selected spinner object (drop-down list) -> cast toString -> save to variable
                String mySelection = mSpinner.getSelectedItem().toString();

                //put value in K,V pair
                returnValue.putExtra("ReturnKey", mySelection);

                /*
                    Call this to set the result that your activity will return to its caller
                    RESULT_OK = -1 -> Standard activity result: operation succeeded.
                 */
                setResult(RESULT_OK, returnValue);
                //ends activity
                finish();
            }
        });
}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.first, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up mReturnButton, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
