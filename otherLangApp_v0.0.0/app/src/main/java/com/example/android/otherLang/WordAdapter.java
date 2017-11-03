package com.example.android.otherLang;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by antho on 1/11/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();
    /**
     * Resource ID for the background color for this list of words
     */
    private int mColorResourceId;

    /**
     * Create a new {@link WordAdapter} object.
     *
     * @param context         is the current context (i.e. Activity) that the adapter is being created in.
     * @param words           is the list of {@link Word}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of words
     */
    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);   //0 is passed in instead of layout file resource ID as inflating a View is done by the override getView method
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView; //existing view to be reused
        if (listItemView == null) { //listItemView is referencing the 'root' LinearLayout of list_item.xml
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false); //getView will inflate/create/convert a listItemView (View Object) from our own list_item.xml (xml Object/element)
        }

        // Get the Word object located at this position in the list from super class
        Word currentWord = getItem(position);

        // Find the TextView down the DOM tree in the list_item.xml layout with the ID version_name
        TextView otherLangTextView = (TextView) listItemView.findViewById(R.id.other_lang_text_view);
        // Get the other language translation and set in text view
        otherLangTextView.setText(currentWord.getmOtherLangTranslation());

        TextView defaultLangTextView = (TextView) listItemView.findViewById(R.id.default_lang_text_view);
        defaultLangTextView.setText(currentWord.getmDefaultTranslation());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image_view);

        if (currentWord.hasImage()) {
            // If an image is available, set the image to iconView and display it.
            iconView.setImageResource(currentWord.getmImageResId());
            iconView.setVisibility(View.VISIBLE); //if previous view was hidden and is being reuse, it will reset the status to VISIBLE
        } else {
            iconView.setVisibility(View.GONE); //hide it and does not take up space
        }

        // Reference the list_item View that needs it's color to be set
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to and Set the background color of the text container View
        textContainer.setBackgroundColor(ContextCompat.getColor(getContext(), mColorResourceId));

        //2.return the whole list of 'rows' with 2 TextView + 1 ImageView   -> to be shown in the ListView (word_list.xml)
        return listItemView;

    }

}
