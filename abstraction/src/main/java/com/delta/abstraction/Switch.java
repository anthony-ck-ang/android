package com.delta.abstraction;

import java.util.ArrayList;

/**
 * Created by anthonyang on 26/9/17.
 */

public class Switch {

    //list of objects that will respond to turn on/off
    ArrayList<Switchable> listOfSwitchableItems = new ArrayList<Switchable>();

    //method to register or deregister from list
    public void wireUp(Switchable switchable){
        listOfSwitchableItems.add(switchable);
    }
    public void unWire(Switchable switchable){
        listOfSwitchableItems.remove(switchable);
    }

    public void flipSwitchUp() {
        //turn an interface into a type
        for (Switchable s : listOfSwitchableItems) {
            s.turnOn();
        }
    }

    public void flipSwitchDown() {
        for (Switchable s : listOfSwitchableItems) {
            s.turnOff();
        }

    }

//    public void turnOnSwitchable(Switchable switchable){
//        switchable.turnOn();
//    }
//
//    public void turnOffSwitchable(Switchable switchable){
//        switchable.turnOff();
//    }

}
