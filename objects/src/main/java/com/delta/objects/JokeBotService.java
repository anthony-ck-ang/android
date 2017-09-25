package com.delta.objects;

import java.util.ArrayList;

/**
 * Created by anthonyang on 24/9/17.
 */

public class JokeBotService extends Bot{

    //share this list
    private static ArrayList<JokeBean> jokesList = null;

    public JokeBotService(ArrayList<JokeBean> jokesList) {
        this.jokesList = jokesList;
    }

    public JokeBotService() {
    }

    public ArrayList<JokeBean> getJokesList() {
        return jokesList;
    }

    public void setJokesList(ArrayList<JokeBean> jokesList) {
        this.jokesList = jokesList;
    }

    //say a joke based on an input
    //protected allows class in same package or subclass (inherited) to use this method
    protected void sayJoke(JokeBean aJokeBean){
        talk(aJokeBean.getJokeSetup());
        talk(aJokeBean.getJokePunchline());
    }

    //pick a joke from a random pick
    public void pickJoke(){

        //create a Double object that takes in a double value
        Double randomNumDouble = new Double(Math.random() * jokesList.size());
        //convert the double value of the object to int
        int randomNum = randomNumDouble.intValue();

        //pick a jokeBean from a random generated index
        JokeBean jokeBean = jokesList.get(randomNum);

        //write the jokeBean to the log
        sayJoke(jokeBean);
    }
}
