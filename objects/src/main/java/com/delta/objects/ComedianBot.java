package com.delta.objects;

import java.util.ArrayList;

/**
 * Created by anthonyang on 25/9/17.
 */

public class ComedianBot extends JokeBotService {
    /*
    All instance variable from JokeBotService or Bot are inherited and accessable.
     */

    ArrayList<JokeBean> jokesList;

//    public ComedianBot(ArrayList<JokeBean> jokesList) {
//
//        //Show that functionality of parent class can be overwritten
//        super(null); //comedianBot creates a joke bot that does not have any joke...
//        //super refers to a Parent class (can be direct or grandparent)
//
//        this.jokesList = JokeWriterDataStore.getJokeListTwo(); // goes to dataStore directly to get joke
//    }

//    public ComedianBot() {
//        this.jokesList = JokeWriterDataStore.getJokeListTwo();
//    }

    public ComedianBot(String name) {
        setRobotName(name); //replace default name
        this.jokesList = JokeWriterDataStore.getJokeListTwo(); //get joke list directly from dataStore
        //this.jokesList = JokeBotService.jokesList; // get jokeList from JokeBotService
    }

    public void performShow() {
        talk("Good evening everyone, my name is ..." + getRobotName());
        talk("Why don't I tell you some of my favourite jokes?");

        for (JokeBean joke : jokesList) {
            sayJoke(joke);
        }

        talk("Thanks everyone, Goodnight!");
    }

    @Override
    protected void sayJoke(JokeBean aJokeBean) {
        talk(aJokeBean.getJokeSetup() + "..." + aJokeBean.getJokePunchline());
    }
}
