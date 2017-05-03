package com.github.angads25.naturedemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import com.github.angads25.nature.elements.LargeCloudView;
import com.github.angads25.nature.elements.MediumCloudView;
import com.github.angads25.nature.elements.MoonView;
import com.github.angads25.nature.elements.MountainView;
import com.github.angads25.nature.elements.SmallCloudView;
import com.github.angads25.nature.elements.SunView;
import com.github.angads25.nature.environment.MountainViewGroup;
import com.github.angads25.nature.environment.SceneryViewGroup;
import com.github.angads25.nature.scenes.SkyView;

import java.util.Random;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SceneryViewGroup view = new SceneryViewGroup(this);
        SkyView sky = new SkyView(this);
        sky.setSkyColor(Color.parseColor("#333333"));
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
            smallCloud[i].setCloudColor(Color.parseColor("#CCCDDD"));
            view.addView(smallCloud[i]);
        }

        Random rand = new Random();
        MountainViewGroup mountainViewGroup = new MountainViewGroup(this);
        MountainView mountain = new MountainView(this);
        MountainView mountain1 = new MountainView(this);
        MountainView mountain2 = new MountainView(this);
        mountain.setColor(Color.parseColor("#FF0000"));
        mountain1.setColor(Color.parseColor("#00FF00"));
        mountain2.setColor(Color.parseColor("#0000FF"));
        mountain.setPeakSize(rand.nextInt(50) + 50);
        mountain1.setPeakSize(rand.nextInt(50) + 50);
        mountain2.setPeakSize(rand.nextInt(50) + 50);
        mountainViewGroup.addView(mountain);
        mountainViewGroup.addView(mountain1);
        mountainViewGroup.addView(mountain2);
        view.addView(mountainViewGroup);

        MediumCloudView mediumView = new MediumCloudView(this);
        mediumView.setCloudColor(Color.parseColor("#DDDEEE"));
        view.addView(mediumView);

        LargeCloudView largeView = new LargeCloudView(this);
        largeView.setCloudColor(Color.parseColor("#EEEFFF"));
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
