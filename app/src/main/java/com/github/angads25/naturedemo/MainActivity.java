package com.github.angads25.naturedemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Pair;

import com.github.angads25.nature.elements.LargeCloudView;
import com.github.angads25.nature.elements.MediumCloudView;
import com.github.angads25.nature.elements.MoonView;
import com.github.angads25.nature.elements.MountainView;
import com.github.angads25.nature.elements.SkyView;
import com.github.angads25.nature.elements.SmallCloudView;
import com.github.angads25.nature.elements.SunView;
import com.github.angads25.nature.elements.TreeView;
import com.github.angads25.nature.environment.ForestViewGroup;
import com.github.angads25.nature.environment.MountainViewGroup;
import com.github.angads25.nature.environment.SceneryViewGroup;
import com.github.angads25.nature.environment.SkyViewGroup;
import com.github.angads25.nature.utils.Utility;

import java.util.Random;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SceneryViewGroup view = new SceneryViewGroup(this);
        SkyViewGroup skyGroup = new SkyViewGroup(this);
        SkyView sky = new SkyView(this);
        sky.setSkyColor(Color.parseColor("#BCD4E6"));
        sky.setShowStars(false);
        skyGroup.addView(sky);

        SunView sun = new SunView(this);
        sun.setColorTheme(getResources().getStringArray(R.array.sun_normal));
        skyGroup.addView(sun);

        MoonView moon = new MoonView(this);
        moon.setSkyColor(sky.getSkyColor());
        moon.setVisible(0);
        skyGroup.addView(moon);

        SmallCloudView smallCloud[] = new SmallCloudView[1];
        for(int i=0;i<smallCloud.length;i++) {
            smallCloud[i] = new SmallCloudView(this);
            smallCloud[i].setCloudColor(Color.parseColor("#CCCDDD"));
            skyGroup.addView(smallCloud[i]);
        }
        view.addView(skyGroup);
        Random rand = new Random();

        MountainViewGroup mountainViewGroup = new MountainViewGroup(this);
        MountainView mountain = new MountainView(this);
        MountainView mountain1 = new MountainView(this);
        MountainView mountain2 = new MountainView(this);

        mountain.setColor(Color.parseColor("#968D99"));
        mountain1.setColor(Color.parseColor("#30BA8F"));
        mountain2.setColor(Color.parseColor("#8E794E"));

        mountain.setPeakSize(rand.nextInt(50) + 50);
        mountain1.setPeakSize(rand.nextInt(50) + 50);
        mountain2.setPeakSize(rand.nextInt(50) + 50);

        mountainViewGroup.addView(mountain);
        mountainViewGroup.addView(mountain1);
        mountainViewGroup.addView(mountain2);

        view.addView(mountainViewGroup);

        MediumCloudView mediumView = new MediumCloudView(this);
        mediumView.setCloudColor(Color.parseColor("#DDDEEE"));
        skyGroup.addView(mediumView);

        LargeCloudView largeView = new LargeCloudView(this);
        largeView.setCloudColor(Color.parseColor("#EEEFFF"));
        view.addView(largeView);

        ForestViewGroup forestViewGroup = new ForestViewGroup(this);
        Pair<Integer, Integer> specs = Utility.getDeviceWidthHeight(this);
        for(int i = 0 ; i < (500 * (specs.first / (float)specs.second)) / 2 ; i++) {
            forestViewGroup.addView(new TreeView(this));
        }

        view.addView(forestViewGroup);
        setContentView(view);
//        ViewCompat.animate(sun)
//                .translationX(700)
//                .withLayer()
//                .setDuration(10000)
//                .setInterpolator(new LinearInterpolator())
//                .start();
    }
}
