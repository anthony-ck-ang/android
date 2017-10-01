package com.delta.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by anthonyang on 30/9/17.
 */

public class SecondActivity extends Activity{

    public static final int DETAIL_REQUEST = 1;
    /*
        If >= 0, this code will be returned in
        onActivityResult() when the activity exits.
     */

    private Button mbutton = null;
    private Button mDetailButton = null;
    private TextView mSelectedView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second); //set view from activity_second.xml

        //reference to the TextView id == userSelection in activity_second.xml
        mSelectedView = (TextView)(findViewById(R.id.userSelection));

        mbutton = (Button) (findViewById(R.id.goFirstActivty)); //find mbutton by it's id in res.layout.activity_first.xml
        mbutton.setOnClickListener(new View.OnClickListener() { //callback when view is clicked
            @Override
            public void onClick(View v) {
                //get and access view's context and execute a hard-coded class name
                Intent i = new Intent(v.getContext(), FirstActivity.class);
                startActivity(i);
            }
        });

        //------------------------------------------------------------
        mDetailButton = (Button)(findViewById(R.id.goDetailActivity));
        mDetailButton.setOnClickListener((View)-> {
            Intent i = new Intent(View.getContext(), DetailActivity.class);
            //K,V pair (Data)
            i.putExtra("SendKey", "Data from SecondActivity");

            //STARTS HERE
            /*
                 Launch an activity for which you would like a result when it finished.
                 When this activity exits, your
                 onActivityResult() method will be called with the given requestCode.
                 Using a negative requestCode is the same as calling
             */
            startActivityForResult(i,DETAIL_REQUEST);

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        /*
            requestCode = self defined above 1 -> success
            resultCode = -1  -> Standard activity result: operation succeeded
         */
        if(requestCode == DETAIL_REQUEST && resultCode == RESULT_OK){
            if(data.hasExtra("ReturnKey")){     //check if value is present, prevents (unchecked/runtime) nullPointerException
                String myValue = data.getExtras().getString("ReturnKey"); //get value from key
                mSelectedView.setText(myValue); //set values
            }
        }
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
        // automatically handle clicks on the Home/Up mbutton, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
