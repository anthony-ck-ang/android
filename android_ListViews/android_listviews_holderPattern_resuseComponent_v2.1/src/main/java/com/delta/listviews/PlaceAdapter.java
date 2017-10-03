package com.delta.listviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by anthonyang on 3/10/17.
 */

public class PlaceAdapter extends ArrayAdapter<Place> {

    Context mContext;
    int mLayoutResourceId; //row.xml
    Place mData[] = null;

    public PlaceAdapter(Context context, int resource, Place[] objects) {
        super(context, resource, objects);

        this.mContext = context;
        this.mLayoutResourceId = resource;
        this.mData = objects;
    }

    @Override
    public Place getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /*
            Holder pattern (creating a "middle layer" placeholder class/obj for code re-use)
            use case : moving scroll windows, need for recycle of objects
                if unable to process all the data at once (too lag)
                (re-creating row View objects at run time)
                while scrolling the window
         */

        View row = convertView; //view that is passed in -> can be converted for reuse
        PlaceHolder holder = null;

        //When app first startup and there is no convertView for reuse. (runs once only at startup)
        if (row == null) {

            /* Pseudo code Logic
            if(existing row View do not exist)
                create a new row View
                create a new Placeholder obj
                save element ref to Placeholder obj
                tag Placeholder obj to row View

            if(existing row View exist)
                get Placeholder obj from row View

                get data from array
                change and set Placeholder obj (tagged to row) elements with the data
                return row
             */

            //create a new View
            LayoutInflater inflater = LayoutInflater.from(mContext); //get inflater
            row = inflater.inflate(mLayoutResourceId, parent, false); //inflate inflater and assign to row variable

            //saving the row.xml elements reference in PlaceHolder obj
            holder = new PlaceHolder();
            holder.nameView = (TextView) row.findViewById(R.id.nameTextView);
            holder.zipView = (TextView) row.findViewById(R.id.zipcodeTextView);
            holder.imageView = (ImageView) row.findViewById(R.id.imageView);

            /*
                Sets the tag associated with this view.
                Tags can be used to store data within a view without
                resorting to another data structure.

                holder object is tagged to row ref variable (View)
             */
            row.setTag(holder);

        } else {
            //otherwise use an existing one
            holder = (PlaceHolder) row.getTag(); //return the Object stored in this view as a tag
        }

        //Getting the data from the array
        Place place = mData[position];

        //Setup and resuse the same listener for each row
        /*
            recycle onTouch/ onClick functionality on imageView
            create a listener object once and resuse it -> save heap memory
         */
        holder.imageView.setOnClickListener(PopupListener);
        Integer rowPosition = position; // auto box int -> Integer object
        holder.imageView.setTag(rowPosition);

        //Setting the view to reflect data to be displayed
        holder.nameView.setText(place.mNameOfPlace); //set data to holder object that is tagged (point) to row (memory address)
        holder.zipView.setText(String.valueOf(place.mZipCode));

        //getting the image
        int resID = mContext.getResources().getIdentifier(place.mNameOfImage, "drawable", mContext.getPackageName());
        holder.imageView.setImageResource(resID);

        return row;

    }

    View.OnClickListener PopupListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Integer viewPosition = (Integer) view.getTag();
            Place place = mData[viewPosition];
            Toast.makeText(getContext(),place.mPopup,Toast.LENGTH_SHORT).show();
        }
    };

    private static class PlaceHolder {
        //include xml elements from row.xml that needs to be changed/ reused
        TextView nameView;
        TextView zipView;
        ImageView imageView;
    }
}
