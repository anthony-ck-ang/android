package com.delta.objects;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class ObjectActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object);

        //fetch a list of jokes from JokeWriterDataStore class
        ArrayList<JokeBean> listOfJokeBeen = JokeWriterDataStore.getJokeListOne();

        //input the listOfJokeBeen into the JokeBotService class
        JokeBotService jokeBotService = new JokeBotService(listOfJokeBeen);

        //execute pickJoke() in jokeBotService class and say/log joke
        jokeBotService.pickJoke();

        //input a second list of jokes (optional)
        jokeBotService.setJokesList(JokeWriterDataStore.getJokeListTwo());

        //performance from drHilarious
        ComedianBot drHilarious = new ComedianBot("drHilarious");
        drHilarious.performShow();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.object, menu);
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
