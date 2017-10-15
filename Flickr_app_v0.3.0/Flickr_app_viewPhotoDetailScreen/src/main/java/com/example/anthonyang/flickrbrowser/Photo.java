package com.example.anthonyang.flickrbrowser;

import java.io.Serializable;

/**
 * Created by anthonyang on 7/10/17.
 */

//bean to store json data
public class Photo implements Serializable{

    private static final long serialVersionUID = 1L; //version of this class (typical implementation with serializable interface)
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getAuthorId() {
        return mAuthorId;
    }

    public String getLink() {
        return mLink;
    }

    public String getTag() {
        return mTag;
    }

    public String getImage() {
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
