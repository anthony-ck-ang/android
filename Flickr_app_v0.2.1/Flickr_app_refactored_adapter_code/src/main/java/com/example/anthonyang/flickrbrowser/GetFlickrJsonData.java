package com.example.anthonyang.flickrbrowser;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anthonyang on 7/10/17.
 */

//specific to flickr data

public class GetFlickrJsonData extends GetRawData {

    private String LOG_TAG = GetFlickrJsonData.class.getSimpleName();
    private List<Photo> mPhotos;
    private Uri mDestinationUri;

    public List<Photo> getPhotos() {
        return mPhotos;
    }

    /*
        person calling this class will have no idea how it is created or searched
        Access and call this class by sending tags (params) ? = , &
     */

    public GetFlickrJsonData(String searchCriteria, Boolean matchAll) {

        super(null); //Need to initialise super class first (constructor)
        createAndUpdateUri(searchCriteria, matchAll);//create uri
        mPhotos = new ArrayList<Photo>(); //instantiate an arrayList
    }

    @Override
    public void execute() {
        super.setmRawUrl(mDestinationUri.toString()); //set the uri in parent class member variable (mRawUrl)
        DownloadJsonData downloadJsonData = new DownloadJsonData();
        Log.v(LOG_TAG, "Built URI = " + mDestinationUri.toString()); //check uri in logcat first
        downloadJsonData.execute(mDestinationUri.toString()); //Executes the task with the specified parameters.
    }

    //construct uri
    public Boolean createAndUpdateUri(String searchCriteria, boolean matchAll) {

        //https://api.flickr.com/services/feeds/photos_public.gne?tags=android,nougat&format=json&nojsoncallback=1

        /*
            define and extract the params in URL
            Refer to url below for params list
                https://www.flickr.com/services/feeds/docs/photos_public/
         */

        final String FLICKR_API_BASE_URL = "https://api.flickr.com/services/feeds/photos_public.gne";
        final String TAGS_PARAM = "tags";
        final String TAGMODE_PARAM = "tagmode";
        final String FORMAT_PARAM = "format";
        final String NO_JSON_CALLBACK_PARAM = "nojsoncallback";

        /*
            Creates a Uri which parses the given encoded URI string

            caller ->
            tags=a,b,c
            tagsmode=all || tagmode=any
         */

        //construct
        mDestinationUri = Uri.parse(FLICKR_API_BASE_URL)
                .buildUpon()
                .appendQueryParameter(TAGS_PARAM, searchCriteria)
                .appendQueryParameter(TAGMODE_PARAM, matchAll ? "ALL" : "ANY")
                .appendQueryParameter(FORMAT_PARAM, "json")
                .appendQueryParameter(NO_JSON_CALLBACK_PARAM, "1")
                .build();

        return mDestinationUri !=null; //true
    }

    /*
        1.download raw data
        2. process data (Extract + Transform)

        Inner Class
     */
    public class DownloadJsonData extends DownloadRawData{ //inherits AsyncTask

        @Override
        protected void onPostExecute(String webData) { //mDestinationUri.toString
            super.onPostExecute(webData); //save data and set status (pass and invoke parent constructor)
            processResult(); //processing
        }


        @Override //get raw data
        protected String doInBackground(String... params) {
            String[] par = {mDestinationUri.toString()};
            return super.doInBackground(par); //pass string uri instead of params back to parent
        }
    }

    private void processResult() {
        if(getmDownloadStatus() != DownloadStatus.OK){
            Log.e(LOG_TAG, "Error downloading raw file");
            return; //if downloaded data is not ok, do not parse and just return
        }

        final String FLICKR_ITEMS = "items"; //"items" is key to an array of json objects (value)

        final String FLICKR_LINK ="link";
        final String FLICKR_TITLE = "title";
        final String FLICKR_AUTHOR = "author";
        final String FLICKR_AUTHOR_ID = "author_id";
        final String FLICKR_TAGS = "tags";

        final String FLICKR_MEDIA = "media"; //"media" key, has a json obj as value
        final String FLICKR_PHOTO_URL = "m"; //json obj in "media", has a key "m" that contains the photo url (value)

        //just in case there in error while parsing
        try{
            JSONObject jsonData = new JSONObject(getmData()); //get Data from GetRawData Class (Super class)
            JSONArray itemsArray = jsonData.getJSONArray(FLICKR_ITEMS); //get array out of jsonData

            for (int i = 0; i < itemsArray.length() ; i++) {

                //Extract data
                JSONObject jsonPhoto = itemsArray.getJSONObject(i); //extract each photo obj from array[i]

                String link = jsonPhoto.getString(FLICKR_LINK);
                String title = jsonPhoto.getString(FLICKR_TITLE); //extract the value of the key "title" (attributes)
                String author = jsonPhoto.getString(FLICKR_AUTHOR);
                String authorId = jsonPhoto.getString(FLICKR_AUTHOR_ID);
                String tags = jsonPhoto.getString(FLICKR_TAGS);

                //to access photo url...
                JSONObject jsonMedia = jsonPhoto.getJSONObject(FLICKR_MEDIA); //extract the json obj from "media"
                String photoUrl = jsonMedia.getString(FLICKR_PHOTO_URL);

                //Create a Photo object from Photo bean (Transform)
                Photo photoObject = new Photo(title,author,authorId,link,tags,photoUrl);
                this.mPhotos.add(photoObject); //add to list above

            }

        }catch (JSONException e){
            e.printStackTrace();
            Log.e(LOG_TAG, "Error processing Json data");
        }

        //print list to check
        for (Photo p: mPhotos) {
            Log.v(LOG_TAG, p.toString());
        }


    }


}
