package com.example.anthonyang.flickrbrowser;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by anthonyang on 8/10/17.
 */

/**
    Photo obj (Image) -> View
    //TODO: change this...
    ("container" for data (Data obj) to be transferred -> adapter -> View )

    RecyclerView:
    A flexible view for providing a limited window into a large data set.
 */

public class FlickrImageViewHolder extends RecyclerView.ViewHolder{
    protected static ImageView thumbnail;
    protected static TextView title;

    public FlickrImageViewHolder(View view) {
        super(view);
        this.thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        this.title = (TextView) view.findViewById(R.id.title);
    }
}
