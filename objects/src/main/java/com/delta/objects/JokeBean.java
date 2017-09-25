package com.delta.objects;

/**
 * Created by learnovate on 3/5/14.
 */
public class JokeBean {

    private String jokeSetup;
    private String jokePunchline;

    public JokeBean(String jokeSetup, String jokePunchline) {
        this.jokeSetup = jokeSetup;
        this.jokePunchline = jokePunchline;
    }

    public JokeBean() {

    }

    public String getJokeSetup() {
        return jokeSetup;
    }

    public void setJokeSetup(String jokeSetup) {
        this.jokeSetup = jokeSetup;
    }

    public String getJokePunchline() {
        return jokePunchline;
    }

    public void setJokePunchline(String jokePunchline) {
        this.jokePunchline = jokePunchline;
    }
}
