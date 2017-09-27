package com.delta.generics;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by anthonyang on 27/9/17.
 */

/*
Generic adapter -> can work with any class Cats... Dogs... birds...
    Usages:
    Java collections
    Async tasks
 */

/*
    T -> this class can take any type but specifically classes that implements <<I>> Animal
    Generics only provide method from the Object (root) class.
    If require additional methods, just add the classes in between < >
 */

public class AdoptAdapter<T extends Animal & Adoptable> {

    private Activity activity;
    private TextView name;
    private TextView description;
    private RatingBar ratingBar;
    private ImageView imageView;

    //T -> "type"
    private T t;

    public AdoptAdapter(Activity activity, TextView name, TextView description, RatingBar ratingBar, ImageView imageView) {
        this.activity = activity;
        this.name = name;
        this.description = description;
        this.ratingBar = ratingBar;
        this.imageView = imageView;
    }

    public void setT(T t) {
        this.t = t;
        //call method to change the view
        updateView();
    }

    public T getT() {
        return t;
    }

    private void updateView() {
        int resID = t.getImageResourceId(activity);
        imageView.setImageResource(resID);

        name.setText(t.getName());
        description.setText(t.getDescription());
        ratingBar.setNumStars(5);
        ratingBar.setRating(t.getRating());
    }


}
