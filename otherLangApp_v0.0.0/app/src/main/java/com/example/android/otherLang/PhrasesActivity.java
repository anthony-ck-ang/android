package com.example.android.otherLang;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
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
        words.add(new Word("Where are you going?", "你要去哪里？\n" + "Nǐ yào qù nǎlǐ?", R.raw.phrases_wryg_chn));
        words.add(new Word("What is your name?", "你叫什么名字？\n" + "Nǐ jiào shénme míngzì?", R.raw.phrases_wiyn_chn));
        words.add(new Word("My name is...", "我的名字是...\n" + "Wǒ de míngzì shì...", R.raw.phrases_mni_chn));
        words.add(new Word("How are you feeling?", "你感觉怎么样？\n" + "Nǐ gǎnjué zěnme yàng?", R.raw.phrases_hayf_chn));
        words.add(new Word("I am feeling good.", "我感觉很好。\n" + "Wǒ gǎnjué hěn hǎo.", R.raw.phrases_iafg_chn));
        words.add(new Word("Are you coming?", "你来吗？\n" + "Nǐ lái ma?", R.raw.phrases_ayc_chn));
        words.add(new Word("Yes I am coming.", "是的，我来了。\n" + "Shì de, wǒ láile.", R.raw.phrases_yiac_chn));

        words.add(new Word("Let's go.", "我们走吧。\n" + "Wǒmen zǒu ba.", R.raw.phrases_lg_chn));
        words.add(new Word("Come here.", "过来。\n" + "Guòlái.", R.raw.phrases_ch_chn));
        words.add(new Word("Thank you.", "谢谢。\n" + "Xièxiè.", R.raw.phrases_ty_chn));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases); // list of data + instruction to make list item view
        ListView listView = (ListView) findViewById(R.id.list); //reference listView in xml, listView -> 'empty container'
        listView.setAdapter(adapter);   //3.pass and display the list of 'rows' to word_list

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Release the media player if it currently exists because we are about to play a different sound file
                releaseMediaPlayer();

                /**Get the {@link Word} object from the words array at the given position the user clicked on**/
                Word word = words.get(position);

                /**create and setup {@link MediaPlayer} with audio res id from the current word object**/
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getmAudioResourceId());
                mMediaPlayer.start();

                // Setup a listener on the media player, so that we can stop and release the media player once the sound has finished playing.
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Toast.makeText(PhrasesActivity.this,"starting...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Toast.makeText(PhrasesActivity.this,"pausing...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        //Toast.makeText(PhrasesActivity.this,"stopping...", Toast.LENGTH_SHORT).show();
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
