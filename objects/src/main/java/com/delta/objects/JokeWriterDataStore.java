package com.delta.objects;

import java.util.ArrayList;

/**
 * Created by learnovate on 3/5/14.
 */
public class JokeWriterDataStore {

    /*
        getJokeListOne() is shared for all JokeWriterDataStore class
        accessable on a class level (no need to create object)
     */

    public static ArrayList<JokeBean> getJokeListOne(){

        JokeBean j;
        ArrayList<JokeBean> jokeBeanList = new ArrayList<JokeBean>();

        jokeBeanList.add(new JokeBean("Why couldn't the bicycle stand up?",
                              "Because it was two tired"));
        jokeBeanList.add(new JokeBean("What do you call a cheese that isn't yours?",
                              "Nacho Cheese!"));
        jokeBeanList.add(new JokeBean("Before I criticize a man, I like to walk a mile in his shoes.",
                              "That way, when I do criticize him, I'm a mile away and I have his shoes."));
        jokeBeanList.add(new JokeBean("What do you call a fish with no eye?",
                              "Fssshh"));
        jokeBeanList.add(new JokeBean("Have you heard the one about the Corduroy pillow?",
                              "It's making HEADLINES!"));
        jokeBeanList.add(new JokeBean("What's red and bad for your teeth?",
                              "A brick."));
        return jokeBeanList;
    }

    public static ArrayList<JokeBean> getJokeListTwo(){

        JokeBean j;
        ArrayList<JokeBean> jokeBeanList = new ArrayList<JokeBean>();

        jokeBeanList.add(new JokeBean("Why didn't the melons get married?",
                              "Because they cantaloupe!"));
        jokeBeanList.add(new JokeBean("What did the cobbler say when a cat wandered into his shop?",
                              "Shoe!"));
        jokeBeanList.add(new JokeBean("What did the Buddhist say to the hot dog vendor?",
                              "Make me one with everything!"));
        jokeBeanList.add(new JokeBean("The face of a child can say it all",
                              "especially the mouth part of the face."));
        jokeBeanList.add(new JokeBean("Why did the cookie go to the hospital?",
                              "Because he felt crummy."));
        jokeBeanList.add(new JokeBean("I intend to live forever...",
                              "So far, so good."));
        return jokeBeanList;

    }

}
