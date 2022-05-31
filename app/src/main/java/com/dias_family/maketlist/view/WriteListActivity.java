package com.dias_family.maketlist.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.dias_family.maketlist.R;
import com.dias_family.maketlist.controle.ListCourse;
import com.dias_family.maketlist.controle.OnMarket;
import com.dias_family.maketlist.controle.adapter.MainViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class WriteListActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager2 pageView;
    private TabLayout tabLayout;
    private ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_list);

        pageView = (ViewPager2) findViewById(R.id.view_pager_write_list);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout_write_list);
        imgView = (ImageView) findViewById(R.id.image_view_write_list);

        imgView.setOnClickListener(this);

        MainViewPagerAdapter mainAdapter = new MainViewPagerAdapter(this);
        pageView.setAdapter(mainAdapter);
        pageView.setCurrentItem(1);

        new TabLayoutMediator(tabLayout,pageView,new TabLayoutMediator.TabConfigurationStrategy(){
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position){
                switch(position){
                    default:
                        tab.setText("Error");
                        break;
                    case 1 :
                        tab.setText("Liste");
                        break;
                    case 0 :
                        tab.setText("Produits");
                        break;

                }
            }
        }).attach();
    }

    @Override
    public void onClick(View v) {

        OnMarket.initList(ListCourse.getList());
        Intent mainIntent = new Intent(this, OnMaketActivity.class);
        startActivity(mainIntent);
    }
}