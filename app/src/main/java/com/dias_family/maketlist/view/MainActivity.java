package com.dias_family.maketlist.view;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import com.dias_family.maketlist.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("MarketList");

        //Intent mainIntent = new Intent(MainActivity.this, CourseListActivity.class);
        System.out.println("Befor Intent");
        Intent mainIntent = new Intent(MainActivity.this, WriteListActivity.class);
        System.out.println("After Adapter");
        startActivity(mainIntent);
        finish();
    }
}
