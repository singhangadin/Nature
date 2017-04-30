package com.github.angads25.naturedemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import com.github.angads25.nature.elements.LargeCloudView;
import com.github.angads25.nature.elements.MediumCloudView;
import com.github.angads25.nature.elements.MoonView;
import com.github.angads25.nature.elements.SmallCloudView;
import com.github.angads25.nature.elements.SunView;
import com.github.angads25.nature.environment.SceneryViewGroup;
import com.github.angads25.nature.scenes.SkyView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SceneryViewGroup view = new SceneryViewGroup(this);
        SkyView sky = new SkyView(this);
        sky.setSkyColor(Color.parseColor("#BAE1FF"));
        view.addView(sky);

        SunView sun = new SunView(this);
        sun.setColorTheme(getResources().getStringArray(R.array.sun_normal));
        view.addView(sun);

        MoonView moon = new MoonView(this);
        moon.setSkyColor(sky.getSkyColor());
        moon.setVisible(30);
        view.addView(moon);

        SmallCloudView smallCloud[] = new SmallCloudView[1];
        for(int i=0;i<smallCloud.length;i++) {
            smallCloud[i] = new SmallCloudView(this);
            smallCloud[i].setCloudColor(Color.WHITE);
            view.addView(smallCloud[i]);
        }
        MediumCloudView mediumView = new MediumCloudView(this);
        mediumView.setCloudColor(Color.WHITE);
        view.addView(mediumView);

        LargeCloudView largeView = new LargeCloudView(this);
        largeView.setCloudColor(Color.WHITE);
        view.addView(largeView);
        setContentView(view);
//        ViewCompat.animate(sun)
//                .translationX(700)
//                .withLayer()
//                .setDuration(10000)
//                .setInterpolator(new LinearInterpolator())
//                .start();
    }
}
