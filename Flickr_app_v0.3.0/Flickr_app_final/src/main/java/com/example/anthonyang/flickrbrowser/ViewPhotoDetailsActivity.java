package com.example.anthonyang.flickrbrowser;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ViewPhotoDetailsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_details);
        activateToolbarWithHomeEnabled();

        Intent intent = getIntent();
        Photo photo = (Photo) intent.getSerializableExtra(PHOTO_TRANSFER);//get photo from intent that was passed from MainActivity

        TextView photoTitle = (TextView) findViewById(R.id.photo_title);
        photoTitle.setText("Title: " + photo.getTitle());

        TextView phototags = (TextView) findViewById(R.id.photo_tags);
        phototags.setText("Tags " + photo.getTag());

        TextView photoAuthor = (TextView) findViewById(R.id.photo_author);
        photoAuthor.setText(photo.getAuthor());

        ImageView photoImage = (ImageView) findViewById(R.id.photo_image);
        Picasso.with(this).load(photo.getLink())
//                .error(R.drawable.placeholder)          //An error drawable to be used if the request image could not be loaded
                .placeholder(R.drawable.placeholder)      //A placeholder drawable to be used while the image is being loaded
                .into(photoImage);                        //Asynchronously fulfills the request into the specified {@link ImageView}.
    }

}
