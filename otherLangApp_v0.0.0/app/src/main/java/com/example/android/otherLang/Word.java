package com.example.android.otherLang;

/**
 * Created by antho on 1/11/2017.
 */

public class Word {
    private String mDefaultTranslation;
    private String mOtherLangTranslation;
    private int mImageResId = NO_IMAGE_PROVIDED; //set NO_IMAGE_PROVIDED as default value
    private int mAudioResourceId;

    /**
     * Constant value that represents no image was provided for this word
     */
    private static final int NO_IMAGE_PROVIDED = -1; //-1 is out of range of all possible res id value

    public Word(String mDefaultTranslation, String mOtherLangTranslation, int mImageResId, int mAudioResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mOtherLangTranslation = mOtherLangTranslation;
        this.mImageResId = mImageResId;
        this.mAudioResourceId = mAudioResourceId;
    }

    public Word(String mDefaultTranslation, String mOtherLangTranslation, int mAudioResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mOtherLangTranslation = mOtherLangTranslation;
        this.mAudioResourceId = mAudioResourceId;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getmOtherLangTranslation() {
        return mOtherLangTranslation;
    }

    public int getmImageResId() {
        return mImageResId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResId != NO_IMAGE_PROVIDED;
    }

    public int getmAudioResourceId() {
        return mAudioResourceId;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mOtherLangTranslation='" + mOtherLangTranslation + '\'' +
                ", mImageResId=" + mImageResId +
                ", mAudioResourceId=" + mAudioResourceId +
                '}';
    }
}
