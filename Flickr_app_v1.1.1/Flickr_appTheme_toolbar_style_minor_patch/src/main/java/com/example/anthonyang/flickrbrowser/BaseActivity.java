package com.example.anthonyang.flickrbrowser;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by anthonyang on 10/10/17.
 */

public class BaseActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    protected Toolbar activateToolbar() {
        if (mToolbar == null) {
            mToolbar = (Toolbar) findViewById(R.id.app_bar); //aware of toolbar.xml from content_main.xml
            if (mToolbar != null) {
                setSupportActionBar(mToolbar); //set and replace actionbar with toolbar
            }
        }
        return mToolbar;
    }
}
