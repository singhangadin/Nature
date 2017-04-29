package com.github.angads25.naturedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.angads25.nature.elements.MoonView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MoonView view = (MoonView)findViewById(R.id.moon);
    }
}
