package com.example.android.otherLang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;


public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//add a return button back to parent activity

        //create a list of words
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "Yī\n" + "一", R.drawable.number_one));
        words.add(new Word("two", "Èr\n" + "二", R.drawable.number_two));
        words.add(new Word("three", "Sān\n" + "三", R.drawable.number_three));
        words.add(new Word("four", "Sì\n" + "四", R.drawable.number_four));
        words.add(new Word("five", "Wǔ\n" + "五", R.drawable.number_five));
        words.add(new Word("six", "Liù\n" + "六", R.drawable.number_six));
        words.add(new Word("seven", "Qī\n" + "七", R.drawable.number_seven));
        words.add(new Word("eight", "Bā\n" + "八", R.drawable.number_eight));
        words.add(new Word("nine", "Jiǔ\n" + "九", R.drawable.number_nine));
        words.add(new Word("ten", "Shí\n" + "十", R.drawable.number_ten));

        //find LinearLayout called root_view
//        LinearLayout rootView = (LinearLayout) findViewById(R.id.root_view);
//        for(int i=0; i<words.size();i++){
//            TextView wordView = new TextView(this); //create a new child text view in java
//            wordView.setText(words.get(i)); //set text at current index
//            rootView.addView(wordView); //add the child view to root view
//        }

        //need custom arrayAdapter to provide View obj to ListView

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers); // list of data + instruction to make list item view
        ListView listView = (ListView) findViewById(R.id.list); //reference listView in xml, listView -> 'empty container'
        listView.setAdapter(adapter);   //3.pass and display the list of 'rows' to word_list/        GridView gridview = (GridView) findViewById(R.id.grid_view);
//        gridview.setAdapter(adapter);
    }
}
