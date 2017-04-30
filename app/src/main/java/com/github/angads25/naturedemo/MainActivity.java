package com.github.angads25.naturedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.angads25.nature.elements.SmallCloudView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SmallCloudView view = (SmallCloudView)findViewById(R.id.moon);
    }
}
