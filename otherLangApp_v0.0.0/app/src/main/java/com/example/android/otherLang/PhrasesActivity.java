package com.example.android.otherLang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//add a return button back to parent activity

        //create a list of words
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you going?", "你要去哪里？\n" + "Nǐ yào qù nǎlǐ?"));
        words.add(new Word("What is your name?", "你叫什么名字？\n" + "Nǐ jiào shénme míngzì?"));
        words.add(new Word("My name is...", "我的名字是...\n" + "Wǒ de míngzì shì..."));
        words.add(new Word("How are you feeling?", "你感觉怎么样？\n" + "Nǐ gǎnjué zěnme yàng?"));
        words.add(new Word("I am feeling good.", "我感觉很好。\n" + "Wǒ gǎnjué hěn hǎo."));
        words.add(new Word("Are you coming?", "你来吗？\n" + "Nǐ lái ma?"));
        words.add(new Word("Yes I am coming.", "是的，我来了。\n" + "Shì de, wǒ láile."));
        words.add(new Word("Let's go.", "我们走吧。\n" + "Wǒmen zǒu ba."));
        words.add(new Word("Come here.", "过来。\n" + "Guòlái."));
        words.add(new Word("Thank you.", "谢谢。\n" + "Xièxiè."));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases); // list of data + instruction to make list item view
        ListView listView = (ListView) findViewById(R.id.list); //reference listView in xml, listView -> 'empty container'
        listView.setAdapter(adapter);   //3.pass and display the list of 'rows' to word_list

    }
}
