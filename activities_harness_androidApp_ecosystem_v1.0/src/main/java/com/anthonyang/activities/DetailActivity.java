package com.anthonyang.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

/**
 * Created by anthonyang on 30/9/17.
 */

public class DetailActivity extends Activity {

    private Button mReturnButton = null;
    private Button mPerformButton = null;
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

        mPerformButton = (Button) (findViewById(R.id.performImplicit));
        mPerformButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get selected position from drop-down list of "actions"
                int position = mSpinner.getSelectedItemPosition();
                Intent implicitIntent = null;
                /*
                    implicit -> run any application that can requires handling a action
                    explicit -> run a particular application only for this action
                 */

                switch (position) {
                    case 0:
                        //nothing selected
                        break;
                    case 1:
                        //angstDotCom.com
                        implicitIntent = new Intent(Intent.ACTION_VIEW, //Display the data to the user
                                //Creates a Uri which parses the given encoded URI string
                                /*
                                    The URI class provides constructors for creating URI instances
                                    from their components or by parsing their string forms,
                                    methods for accessing the various components of an instance,
                                    and methods for normalizing, resolving, and relativizing URI instances.
                                 */
                                Uri.parse("http://angstDotCom.com")); //http:
                        break;
                    case 2:
                        //call someone
                        implicitIntent = new Intent(Intent.ACTION_DIAL,
                                Uri.parse("tel:(+65)123456789")); //tel:
                        break;
                    case 3:
                        //Map of YETspace using geo intent
                        implicitIntent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("geo:1.2840999,103.8513269")); //geo: latitude,longitude
                        break;
                    case 4:
                        /*
                            do an image capture registered action on android os
                            activate camera app (does not return picture)
                        */
                        implicitIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                        break;
                    case 5:
                        //Provide explicit editable access to the first contact
                        implicitIntent = new Intent(Intent.ACTION_EDIT,
                                Uri.parse("content://contacts/people/1"));
                        break;
                }
                if (implicitIntent != null) {
                    if (isIntentAvailable(implicitIntent)) {
                        startActivity(implicitIntent);
                    } else {
                        Toast.makeText(v.getContext(), "no application available", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }

    private boolean isIntentAvailable(Intent intent) {
        /*
            retrieve info of the application
            packages that are currently installed on the device
         */
        PackageManager manager = getPackageManager();
        List<ResolveInfo> activities = manager.queryIntentActivities(intent, 0); //get all activities performed for the given intent
        boolean isIntentSafe = activities.size() > 0;
        return isIntentSafe;
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
