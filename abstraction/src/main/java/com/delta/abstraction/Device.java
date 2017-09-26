package com.delta.abstraction;

/**
 * Created by anthonyang on 26/9/17.
 */

public abstract class Device {
    protected String deviceName;
    protected boolean isOn;

    /* abstract away implementation details
     let other "devices" classes implement their own breakDevice method */
    public abstract void breakDevice();
//    public abstract void turnOn();
//    public abstract void turnOff();

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setState(boolean state) {
        isOn = state;
    }
}
