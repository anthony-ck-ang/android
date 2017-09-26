package com.delta.abstraction;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class AbstractionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abstraction);
        //
        // Start here
        //
        Fan myFan = new Fan("Fanny");
        myFan.breakDevice();

        Light myLight = new Light("lighting");
        myLight.breakDevice();

        /*
            Separation of concerns (low dependency)
            Switch should only care about changing the state (ON/OFF 1/0)

            Should NOT care about what the specific object it is wired to
            Should not be aware of the specific class type of the objects at compile time.
         */
        Switch mySwitch = new Switch();

        /*
            Different object type.
            commonality between both class(objects) is they both implement Switchable
         */
        mySwitch.wireUp(myFan);
        mySwitch.wireUp(myLight);

        mySwitch.flipSwitchUp();
        mySwitch.flipSwitchDown();

        mySwitch.unWire(myFan);
        mySwitch.unWire(myLight);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.abstraction, menu);
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
