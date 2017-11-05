package com.example.android.otherLang;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//add a return button back to parent activity

        //create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("red", "Hóng sè\n" + "红色", R.drawable.color_red, R.raw.color_red_chn));
        words.add(new Word("yellow", "Huáng sè\n" + "黄色", R.drawable.color_mustard_yellow, R.raw.color_yellow_chn));
        words.add(new Word("green", "Lǜ sè\n" + "绿色", R.drawable.color_green, R.raw.color_green_chn));
        words.add(new Word("brown", "Zōng sè\n" + "棕色", R.drawable.color_brown, R.raw.color_brown_chn));
        words.add(new Word("black", "Hēi sè\n" + "黑色", R.drawable.color_black, R.raw.color_black_chn));
        words.add(new Word("grey", "Huī sè\n" + "灰色", R.drawable.color_gray, R.raw.color_grey_chn));
        words.add(new Word("white", "Bái sè\n" + "白色", R.drawable.color_white, R.raw.color_white_chn));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors); // list of data + instruction to make list item view
        ListView listView = (ListView) findViewById(R.id.list); //reference listView in xml, listView -> 'empty container'
        listView.setAdapter(adapter);   //3.pass and display the list of 'rows' to word_list/        GridView gridview = (GridView) findViewById(R.id.grid_view);
//        gridview.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Release the media player if it currently exists because we are about to play a different sound file
                releaseMediaPlayer();

                /**Get the {@link Word} object from the words array at the given position the user clicked on**/
                Word word = words.get(position);
                Log.v("ColorsActivity", "Current word: " + word);

                /**create and setup {@link MediaPlayer} with audio res id from the current word object**/
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getmAudioResourceId());
                mMediaPlayer.start();

                // Setup a listener on the media player, so that we can stop and release the media player once the sound has finished playing.
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();
            // Set the media player back to null.
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}


