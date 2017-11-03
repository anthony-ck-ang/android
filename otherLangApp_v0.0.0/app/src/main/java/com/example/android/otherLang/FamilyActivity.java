package com.example.android.otherLang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//add a return button back to parent activity

        //create a list of words
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("grandfather", "Zǔ fù\n" + "祖父", R.drawable.family_grandfather));
        words.add(new Word("grandmother", "Zǔ mǔ\n" + "祖母", R.drawable.family_grandmother));
        words.add(new Word("father", "Fù qīn\n" + "父亲", R.drawable.family_father));
        words.add(new Word("mother", "Mǔ qīn\n" + "母亲", R.drawable.family_mother));
        words.add(new Word("elder brother", "Gē gē\n" + "哥哥", R.drawable.family_older_brother));
        words.add(new Word("elder sister", "jiě jiě\n" + "姐姐", R.drawable.family_older_sister));
        words.add(new Word("younger brother", "dì dì\n" + "弟弟", R.drawable.family_younger_brother));
        words.add(new Word("younger sister", "Mèi mei\n" + "妹妹", R.drawable.family_younger_sister));
        words.add(new Word("younger brother", "Ér zi\n" + "儿子", R.drawable.family_son));
        words.add(new Word("younger sister", " Nǚ'ér\n" + "女儿", R.drawable.family_daughter));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family); // list of data + instruction to make list item view
        ListView listView = (ListView) findViewById(R.id.list); //reference listView in xml, listView -> 'empty container'
        listView.setAdapter(adapter);   //3.pass and display the list of 'rows' to word_list/        GridView gridview = (GridView) findViewById(R.id.grid_view);
//        gridview.setAdapter(adapter);
    }
}



