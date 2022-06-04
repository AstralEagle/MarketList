package com.dias_family.maketlist.view;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import com.dias_family.maketlist.R;
import com.dias_family.maketlist.controle.ListCourse;
import com.dias_family.maketlist.controle.data.ItemDao;
import com.dias_family.maketlist.controle.data.ListDao;
import com.dias_family.maketlist.controle.data.ListItemDataBase;
import com.dias_family.maketlist.model.Item;

public class MainActivity extends AppCompatActivity {

    private ListItemDataBase itemDataBase;
    private ItemDao itemDao;
    private ListDao listDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getAllItems();
    }

    private void getAllItems(){
        new Thread(
                ()->{
                    itemDataBase = ListItemDataBase.getDataBase(MainActivity.this);
                    itemDao = itemDataBase.itemDao();
                    Item.initListItem(itemDao.getAllItems());

                    listDao = itemDataBase.listDao();
                    ListCourse.initList(listDao.initList());

                    //courseDataBase.close();

                    goOtherActivity();
                }
        ).start();
    }

    private void goOtherActivity(){
        Intent mainIntent = new Intent(MainActivity.this, WriteListActivity.class);
        startActivity(mainIntent);
        finish();
    }
}
