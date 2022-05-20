package com.dias_family.maketlist.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import com.dias_family.maketlist.R;

public class OnMaketActivity extends AppCompatActivity {

    private ListView listItem;
    private EditText searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_maket);

        listItem = (ListView) findViewById(R.id.on_market_list_item);
        searchText = (EditText ) findViewById(R.id.on_market_search_text);



    }
}