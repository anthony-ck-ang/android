package com.example.anthonyang.flickrbrowser;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by anthonyang on 7/10/17.
 */

    /*
        Possible states
        PROCESSING = download data
        NOT_INITIALISED = no valid url to download
        FAILED_OR_EMPTY = data return null
     */
enum DownloadStatus {
    IDLE, PROCESSING, NOT_INITIALISED, FAILED_OR_EMPTY, OK
};

//Generic get data class
public class GetRawData {
    private String LOG_TAG = GetRawData.class.getSimpleName();
    private String mRawUrl;
    private String mData;
    private DownloadStatus mDownloadStatus;

    public GetRawData(String mRawUrl) {
        this.mRawUrl = mRawUrl;
        this.mDownloadStatus = DownloadStatus.IDLE; //initial state
    }

    public void reset() {
        this.mDownloadStatus = DownloadStatus.IDLE;
        this.mRawUrl = null;
        this.mData = null;
    }

    public String getmData() {
        return mData;
    }

    public DownloadStatus getmDownloadStatus() {
        return mDownloadStatus;
    }

    public void setmRawUrl(String mRawUrl) {
        this.mRawUrl = mRawUrl;
    }

    public void execute() {
        this.mDownloadStatus = DownloadStatus.PROCESSING;
        DownloadRawData downloadRawData = new DownloadRawData();
        downloadRawData.execute(mRawUrl); //pass the url
    }


    /*
    INNER CLASS
        download and save in inner bean

            AsyncTask class allows you
            to perform background operations and publish results on the UI thread without
            Having to manipulate threads and/or handlers
     */
    public class DownloadRawData extends AsyncTask<String, Void, String> { //Params, Progress, Result

        @Override
        protected void  onPostExecute(String webData) { //data coming back from web-call/download
            super.onPostExecute(webData);
            //TODO: fill in later
            mData = webData;

            //processing and testing
            Log.v(LOG_TAG, "Data returned was: " + mData);
            if (mData == null) {
                if (mRawUrl == null) {
                    mDownloadStatus = DownloadStatus.NOT_INITIALISED; // no valid url
                } else {
                    mDownloadStatus = DownloadStatus.FAILED_OR_EMPTY;
                }
            } else {
                //success
                mDownloadStatus = DownloadStatus.OK;
            }

        }

        @Override //accept multiple params
        protected String doInBackground(String... params) {
            //create connection
            HttpURLConnection urlConnection = null; //A URLConnection with support for HTTP-specific features
            //Declare BufferedReader
            BufferedReader reader = null;

            if (params == null) {
                return null;
            }

            try {
                /*
                    Uniform Resource Locator, a pointer to a "resource" on the World
                    Wide Web. A resource can be something as simple as a file or a
                    directory, or it can be a reference to a more complicated object,
                    such as a query to a database or to a search engine

                    HTTP -> protocol
                 */
                URL url = new URL(params[0]); //@param the String to parse as a URL.
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                //Returns an input stream that reads from this open connection
                InputStream inputStream = urlConnection.getInputStream();

                if (inputStream == null) { //no data
                    return null;
                }

                //Initialise BufferedReader
                reader = new BufferedReader(new InputStreamReader(inputStream));

                //initialise StringBuffer for appending/store data (TBR)
                StringBuffer buffer = new StringBuffer();
                String line; // temp variable to read

                while ((line = reader.readLine()) != null) { //use buffered reader to read line sequentially
                    buffer.append(line + "\n");
                }

                return buffer.toString();

            } catch (IOException e) {
                Log.e(LOG_TAG, "Error", e);
                return null;
            } finally {

                //close and release resource
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e(LOG_TAG, "Error closing stream", e);
                    }
                }
            }
        }
    }

}
