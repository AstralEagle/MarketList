package com.dias_family.maketlist.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.dias_family.maketlist.R;

public class WriteListActivity extends AppCompatActivity {

    private ViewPager2 pageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_list);

        pageView = (ViewPager2) findViewById(R.id.view_pager_write_list);
    }
}