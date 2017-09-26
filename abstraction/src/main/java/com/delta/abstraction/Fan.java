package com.delta.abstraction;

import android.util.Log;

/**
 * Created by anthonyang on 26/9/17.
 */

public class Fan extends Device implements Switchable{

    public Fan(String name) {
        setDeviceName(name);
    }

    public Fan() {
        setDeviceName("FAN");
    }

    //@Override
    public void turnOn(){
        Log.e(getDeviceName(),"Blowing winds... my hair!");
        setState(true);
    }
    //@Override
    public void turnOff(){
        Log.e(getDeviceName(),"Fan Turned off... arrgghh is it me or is it getting warmer");
        setState(false);
    }

    @Override
    public void breakDevice() {
        Log.e(getDeviceName(), "BANG! Broken and smashed!");
    }
}
