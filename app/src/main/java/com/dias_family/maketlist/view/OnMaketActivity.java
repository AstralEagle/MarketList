package com.dias_family.maketlist.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.dias_family.maketlist.R;
import com.dias_family.maketlist.controle.ListCourse;
import com.dias_family.maketlist.controle.OnMarket;
import com.dias_family.maketlist.controle.adapter.OnMarketAdapter;
import com.dias_family.maketlist.controle.data.ItemDao;
import com.dias_family.maketlist.controle.data.ListDao;
import com.dias_family.maketlist.controle.data.ListItemDataBase;
import com.dias_family.maketlist.model.Item;
import com.dias_family.maketlist.model.ItemList;
import com.dias_family.maketlist.model.OnMarketItem;

import java.util.ArrayList;

public class OnMaketActivity extends AppCompatActivity {

    private ListView listViewItem;
    private EditText searchText;
    private ImageView buttonBack;
    private CheckBox checkBox;

    private OnMarketAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_maket);

        listViewItem = (ListView) findViewById(R.id.on_market_list_item);
        searchText = (EditText ) findViewById(R.id.on_market_search_text);
        buttonBack = (ImageView) findViewById(R.id.on_market_button_back);
        checkBox = (CheckBox) findViewById(R.id.on_market_check_box);

        listAdapter = new OnMarketAdapter(this, OnMarket.getListOnMarket());
        listViewItem.setAdapter(listAdapter);

        listViewItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(!listAdapter.getItem(position).isOnPanner()){
                    listAdapter.onCheckItem(view,position);
                    if(checkBox.isChecked()){
                        listAdapter.getFilter().filter(searchText.getText());
                    }
                }
            }
        });
        listViewItem.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if(listAdapter.getItem(position).isOnPanner()){
                    listAdapter.unCheckItem(view,position);
                }
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

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                listAdapter.setTakingFiltre(isChecked);
                listAdapter.getFilter().filter(searchText.getText());
            }
        });
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }


    public void onBackPressed(){
        new AlertDialog.Builder(this)
                .setTitle(R.string.marketEnd)
                .setMessage(R.string.keep_item)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        saveItemList(listAdapter.getIsTakinItem());
                    }})
                .setNegativeButton(R.string.no,  new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        saveItemList(listAdapter.getStaticList());
                    }})
                .setNeutralButton(R.string.cancelar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();


    }

    // Fonction qui permet d'augmenter l'achat des objets et de mettre a jour la list de course selon une list
    private void saveItemList(ArrayList<OnMarketItem> list){
        for(OnMarketItem item : list){
            item.getItem().addUsation();
            new Thread(
                    ()->{
                        ListItemDataBase dataBase = ListItemDataBase.getDataBase(OnMaketActivity.this);
                        ItemDao itemDao = dataBase.itemDao();

                        itemDao.updateItem(item.getItem());

                        ListCourse.removeItem(item.getItem(),OnMaketActivity.this);
                    }
            ).start();
        }
        finish();
    }
}