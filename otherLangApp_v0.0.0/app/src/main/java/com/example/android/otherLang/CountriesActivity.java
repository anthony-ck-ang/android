package com.example.android.otherLang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class CountriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//add a return button back to parent activity

        //create a list of words
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("australia", "Ào dà lì yǎ\n" + "澳大利亚", R.drawable.australia));
        words.add(new Word("brazil", "Bā xī\n" + "巴西", R.drawable.brazil));
        words.add(new Word("canada", "Jiā ná dà\n" + "加拿大", R.drawable.canada));
        words.add(new Word("china", "Zhōng guó\n" + "中国", R.drawable.china));
        words.add(new Word("denmark", "Dān mài\n" + "丹麦", R.drawable.denmark));
        words.add(new Word("france", "Fà guó\n" + "法国", R.drawable.france));
        words.add(new Word("germany", "Dé guó\n" + "德国", R.drawable.germany));
        words.add(new Word("hong kong", "Xiāng gǎng\n" + "香港", R.drawable.hong_kong));
        words.add(new Word("italy", "Yì dà lì\n" + "意大利", R.drawable.italy));
        words.add(new Word("japan", "Rì běn\n" + "日本", R.drawable.japan));
        words.add(new Word("malaysia", "Mǎ lái xī yà\n" + "马来西亚", R.drawable.malaysia));
        words.add(new Word("norway", "Nuó wēi\n" + "挪威", R.drawable.norway));
        words.add(new Word("philippines", "Fēi lǜ bīn\n" + "菲律宾", R.drawable.philippines));
        words.add(new Word("russia", "É guó\n" + "俄国", R.drawable.russia));
        words.add(new Word("singapore", "Xīn jiā pō\n" + "新加坡", R.drawable.singapore));
        words.add(new Word("south korea", "Hán guó\n" + "韩国", R.drawable.south_korea));
        words.add(new Word("sweden", "Ruì diǎn\n" + "瑞典", R.drawable.sweden));
        words.add(new Word("taiwan", "Táiwān\n" + "台湾", R.drawable.taiwan));
        words.add(new Word("united kingdom", "Yīng guó\n" + "英国", R.drawable.united_kingdom));
        words.add(new Word("united states", "Měi guó\n" + "美国", R.drawable.united_states));
        words.add(new Word("vietnam", "Yuè nán\n" + "越南", R.drawable.vietnam));

        WordAdapter adapter = new WordAdapter(this, words,R.color.category_countries); // list of data + instruction to make list item view
        ListView listView = (ListView) findViewById(R.id.list); //reference listView in xml, listView -> 'empty container'
        listView.setAdapter(adapter);   //3.pass and display the list of 'rows' to word_list/
        // GridView gridview = (GridView) findViewById(R.id.grid_view);
//        gridview.setAdapter(adapter);
    }
}



























