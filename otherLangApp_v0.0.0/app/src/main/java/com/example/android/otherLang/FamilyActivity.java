package com.example.android.otherLang;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    /**
     * OnCompletion Listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
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
        words.add(new Word("grandfather", "Zǔ fù\n" + "祖父", R.drawable.family_grandfather, R.raw.fam_gp_chn));
        words.add(new Word("grandmother", "Zǔ mǔ\n" + "祖母", R.drawable.family_grandmother, R.raw.fam_gm_chn));
        words.add(new Word("father", "Fù qīn\n" + "父亲", R.drawable.family_father, R.raw.fam_f_chn));
        words.add(new Word("mother", "Mǔ qīn\n" + "母亲", R.drawable.family_mother, R.raw.fam_m_chn));
        words.add(new Word("elder brother", "Gē gē\n" + "哥哥", R.drawable.family_older_brother, R.raw.fam_eb_chn));
        words.add(new Word("elder sister", "jiě jiě\n" + "姐姐", R.drawable.family_older_sister, R.raw.fam_es_chn));
        words.add(new Word("younger brother", "dì dì\n" + "弟弟", R.drawable.family_younger_brother, R.raw.fam_yb_chn));
        words.add(new Word("younger sister", "Mèi mei\n" + "妹妹", R.drawable.family_younger_sister, R.raw.fam_ys_chn));
        words.add(new Word("son", "Ér zi\n" + "儿子", R.drawable.family_son, R.raw.fam_son_chn));
        words.add(new Word("daughter", " Nǚ'ér\n" + "女儿", R.drawable.family_daughter, R.raw.fam_daughter_chn));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family); // list of data + instruction to make list item view
        ListView listView = (ListView) findViewById(R.id.list); //reference listView in xml, listView -> 'empty container'
        listView.setAdapter(adapter);   //3.pass and display the list of 'rows' to word_list/        GridView gridview = (GridView) findViewById(R.id.grid_view);
//        gridview.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Release the media player if it currently exists because we are about to play a different sound file
                releaseMediaPlayer();

                /**Get the {@link Word} object from the words array at the given position the user clicked on**/
                Word word = words.get(position);

                /**create and setup {@link MediaPlayer} with audio res id from the current word object**/
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getmAudioResourceId());
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



