package com.example.anthonyang.flickrbrowser;

/**
 * Created by anthonyang on 7/10/17.
 */

//bean to store json data
public class Photo {
    private String mTitle;
    private String mAuthor;
    private String mAuthorId;
    private String mLink;
    private String mTag;
    private String mImage;

    public Photo(String mTitle, String mAuthor, String mAuthorId, String mLink, String mTag, String mImage) {
        this.mTitle = mTitle;
        this.mAuthor = mAuthor;
        this.mAuthorId = mAuthorId;
        this.mLink = mLink;
        this.mTag = mTag;
        this.mImage = mImage;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public String getmAuthorId() {
        return mAuthorId;
    }

    public String getmLink() {
        return mLink;
    }

    public String getmTag() {
        return mTag;
    }

    public String getmImage() {
        return mImage;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "mTitle='" + mTitle + '\'' +
                ", mAuthor='" + mAuthor + '\'' +
                ", mAuthorId='" + mAuthorId + '\'' +
                ", mLink='" + mLink + '\'' +
                ", mTag='" + mTag + '\'' +
                ", mImage='" + mImage + '\'' +
                '}';
    }
}
