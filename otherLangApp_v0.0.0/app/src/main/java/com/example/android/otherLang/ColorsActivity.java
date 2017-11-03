package com.example.android.otherLang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//add a return button back to parent activity

        //create a list of words
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("red", "Hóng sè\n" + "红色", R.drawable.color_red));
        words.add(new Word("yellow", "Huáng sè\n" + "黄色", R.drawable.color_mustard_yellow));
        words.add(new Word("green", "Lǜ sè\n" + "绿色", R.drawable.color_green));
        words.add(new Word("brown", "Zōng sè\n" + "棕色", R.drawable.color_brown));
        words.add(new Word("black", "Hēi sè\n" + "黑色", R.drawable.color_black));
        words.add(new Word("grey", "Huī sè\n" + "灰色", R.drawable.color_gray));
        words.add(new Word("white", "Bái sè\n" + "白色", R.drawable.color_white));

        WordAdapter adapter = new WordAdapter(this, words,R.color.category_colors); // list of data + instruction to make list item view
        ListView listView = (ListView) findViewById(R.id.list); //reference listView in xml, listView -> 'empty container'
        listView.setAdapter(adapter);   //3.pass and display the list of 'rows' to word_list/        GridView gridview = (GridView) findViewById(R.id.grid_view);
//        gridview.setAdapter(adapter);
    }
}


