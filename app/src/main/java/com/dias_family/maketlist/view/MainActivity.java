package com.dias_family.maketlist.view;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dias_family.maketlist.R;

public class MainActivity extends AppCompatActivity {

    private TextView textViewNameApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent mainIntent = new Intent(MainActivity.this, CourseListActivity.class);
        startActivity(mainIntent);
    }
}
