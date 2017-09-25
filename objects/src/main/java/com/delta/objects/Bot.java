package com.delta.objects;

import android.util.Log;

/**
 * Created by anthonyang on 24/9/17.
 */

public class Bot {

    private final static String creatorName = "Anthony";
    private String robotName = "MR ROBOT";

    public String getCreatorName() {
        return creatorName;
    }

    public String getRobotName() {
        return robotName;
    }

    public void setRobotName(String robotName) {
        this.robotName = robotName;
    }


    protected void talk(String speech){
        Log.e(getRobotName(), speech);
    }
}
