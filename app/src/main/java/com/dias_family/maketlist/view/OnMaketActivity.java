package com.dias_family.maketlist.view;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.dias_family.maketlist.R;
import com.dias_family.maketlist.controle.OnMarket;
import com.dias_family.maketlist.controle.adapter.OnMarketAdapter;

public class OnMaketActivity extends AppCompatActivity {

    private ListView listViewItem;
    private EditText searchText;
    private OnMarketAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_maket);

        listViewItem = (ListView) findViewById(R.id.on_market_list_item);
        searchText = (EditText ) findViewById(R.id.on_market_search_text);

        listAdapter = new OnMarketAdapter(this, OnMarket.getListOnMarket());
        listViewItem.setAdapter(listAdapter);

        listViewItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listAdapter.onCheckItem(view,position);
            }
        });
        listViewItem.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                listAdapter.unCheckItem(view,position);
                return true;
            }
        });

        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                listAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }
}