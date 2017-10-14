package com.example.anthonyang.flickrbrowser;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by anthonyang on 10/10/17.
 */

public class BaseActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    public static final String FLICKR_QUERY = "FLICKR_QUERY";

    protected Toolbar activateToolbar() {
        if (mToolbar == null) {
            mToolbar = (Toolbar) findViewById(R.id.app_bar); //aware of toolbar.xml from content_main.xml
            if (mToolbar != null) {
                setSupportActionBar(mToolbar); //set and replace actionbar with toolbar
            }
        }
        return mToolbar;
    }

    protected Toolbar activateToolbarWithHomeEnabled() {
        activateToolbar();
        if (mToolbar != null) {
            /*
                Retrieve a reference to this activity's ActionBar
                Set to true if selecting "home" returns up by a single level in your UI
            */
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        return mToolbar;
    }
}
