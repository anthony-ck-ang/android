package com.delta.abstraction;

import android.util.Log;

/**
 * Created by anthonyang on 26/9/17.
 */

public class Light extends Device implements Switchable{

    public Light(String name) {
        setDeviceName(name);

    }
    public Light() {
        setDeviceName("LIGHT");
    }

    //implementation from interface
    @Override
    public void turnOn() {
        Log.e(getDeviceName(), "Light is on... Now I see...");
        setState(true);
    }

    @Override
    public void turnOff() {
        Log.e(getDeviceName(), "Lights turned off... I can't see anything!");
        setState(false);
    }

    //implement from abstract method
    @Override
    public void breakDevice() {
        Log.e(getDeviceName(), "Lights are smashed and broken...");
    }
}
