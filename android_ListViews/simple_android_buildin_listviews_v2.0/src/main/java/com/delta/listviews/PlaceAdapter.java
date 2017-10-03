package com.delta.listviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by anthonyang on 2/10/17.
 */

public class PlaceAdapter extends ArrayAdapter<Place> {

    Context mContext;
    int mLayoutResourceId;
    Place mData[] = null;

    /*
        mLayoutResourceId -> row.xml (ID for an XML layout resource to load)
        mData (Object) -> data
     */
    public PlaceAdapter(Context context,int mLayoutResourceId, Place[] mData) {
        super(context, mLayoutResourceId, mData);
        this.mContext = context;
        this.mLayoutResourceId = mLayoutResourceId;
        this.mData = mData;
    }

    @Override
    public Place getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        /*
            Inflate the layout for a single row
            Obtains the LayoutInflater from the given context
         */
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        //1. Inflate a new (create) view hierarchy from the specified xml resource on it's own without any attachment.
        row = layoutInflater.inflate(mLayoutResourceId, parent, false);

        //2. get reference to the different elements from row View that needs to be updated
        TextView nameView = (TextView) row.findViewById(R.id.nameTextView);
        TextView zipView = (TextView) row.findViewById(R.id.zipcodeTextView);
        ImageView imageView = (ImageView) row.findViewById(R.id.imageView);

        //3. get data (place objects) from array
        Place place = mData[position];

        //4. setting the view to reflect data to be displayed
        nameView.setText(place.mNameOfPlace);
        zipView.setText(String.valueOf(place.mZipCode)); //convert zipcode (int) -> string representative -> setText()

        /*
            get resource object from context
            get resource identifier for the given resource name
                @param name -> The name of the desired resource.
                @param defType ->  Optional default resource type to find
                @param defPackage -> Optional default package to find
         */
        int resId = mContext.getResources().getIdentifier(place.mNameOfImage, "drawable", mContext.getPackageName()); //Return the name of this application's package
        imageView.setImageResource(resId);

        return row;

    }
}
