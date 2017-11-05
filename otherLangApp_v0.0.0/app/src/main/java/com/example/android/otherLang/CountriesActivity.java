package com.example.android.otherLang;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class CountriesActivity extends AppCompatActivity {
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
        words.add(new Word("united states", "Měi guó\n" + "美国", R.drawable.united_states, R.raw.countries_unitedstates_chn));
        words.add(new Word("china", "Zhōng guó\n" + "中国", R.drawable.china, R.raw.countries_china_chn));
        words.add(new Word("japan", "Rì běn\n" + "日本", R.drawable.japan, R.raw.countries_japan_chn));
        words.add(new Word("germany", "Dé guó\n" + "德国", R.drawable.germany, R.raw.countries_germany_chn));
        words.add(new Word("united kingdom", "Yīng guó\n" + "英国", R.drawable.united_kingdom, R.raw.countries_unitedkingdom_chn));
        words.add(new Word("india", "Yìn dù\n" + "印度", R.drawable.india, R.raw.countries_india_chn));
        words.add(new Word("france", "Fà guó\n" + "法国", R.drawable.france, R.raw.countries_france_chn));
        words.add(new Word("brazil", "Bā xī\n" + "巴西", R.drawable.brazil, R.raw.countries_brazil_chn));
        words.add(new Word("italy", "Yì dà lì\n" + "意大利", R.drawable.italy, R.raw.countries_italy_chn));
        words.add(new Word("canada", "Jiā ná dà\n" + "加拿大", R.drawable.canada, R.raw.countries_canada_chn));
        words.add(new Word("russia", "É guó\n" + "俄国", R.drawable.russia, R.raw.countries_russia_chn));
        words.add(new Word("south korea", "Hán guó\n" + "韩国", R.drawable.south_korea, R.raw.countries_korea_chn));
        words.add(new Word("australia", "Ào dà lì yǎ\n" + "澳大利亚", R.drawable.australia, R.raw.countries_australia_chn));
        /**
         * TBA
         * Mexico
         Turkey
         Netherlands
         Saudi Arabia
         Switzerland
         Argentina
         */
        words.add(new Word("taiwan", "Táiwān\n" + "台湾", R.drawable.taiwan, R.raw.countries_taiwan_chn));
        words.add(new Word("sweden", "Ruì diǎn\n" + "瑞典", R.drawable.sweden, R.raw.countries_sweden_chn));
        /*** TBA
         Poland
         Belgium
         Thailand
         United Arab Emirates
         Nigeria
         ***/
        words.add(new Word("norway", "Nuó wēi\n" + "挪威", R.drawable.norway, R.raw.countries_norway_chn));
        /***
         *
         Austria
         Islamic Republic of Iran
         Israel
         */
        words.add(new Word("hong kong", "Xiāng gǎng\n" + "香港", R.drawable.hong_kong, R.raw.countries_hongkong_chn));
        words.add(new Word("philippines", "Fēi lǜ bīn\n" + "菲律宾", R.drawable.philippines, R.raw.countries_philippines_chn));
//       // South Africa
        words.add(new Word("malaysia", "Mǎ lái xī yà\n" + "马来西亚", R.drawable.malaysia, R.raw.countries_malaysia_chn));
        // Colombia
        words.add(new Word("denmark", "Dān mài\n" + "丹麦", R.drawable.denmark, R.raw.countries_denmark_chn));
        //Ireland
//      //Egypt
        words.add(new Word("singapore", "Xīn jiā pō\n" + "新加坡", R.drawable.singapore, R.raw.countries_singapore_chn));
        words.add(new Word("vietnam", "Yuè nán\n" + "越南", R.drawable.vietnam, R.raw.countries_vietnam_chn));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_countries); // list of data + instruction to make list item view
        ListView listView = (ListView) findViewById(R.id.list); //reference listView in xml, listView -> 'empty container'
        listView.setAdapter(adapter);   //3.pass and display the list of 'rows' to word_list/
        // GridView gridview = (GridView) findViewById(R.id.grid_view);
//        gridview.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Release the media player if it currently exists because we are about to play a different sound file
                releaseMediaPlayer();

                /**Get the {@link Word} object from the words array at the given position the user clicked on**/
                Word word = words.get(position);

                /**create and setup {@link MediaPlayer} with audio res id from the current word object**/
                mMediaPlayer = MediaPlayer.create(CountriesActivity.this, word.getmAudioResourceId());
                mMediaPlayer.start();

                // Setup a listener on the media player that that releases the once once the sound has finished playing.
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



























