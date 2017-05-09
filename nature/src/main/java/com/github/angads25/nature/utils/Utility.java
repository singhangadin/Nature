package com.github.angads25.nature.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.Pair;
import android.view.Display;

/**
 * <p>
 * Created by Angad on 09-05-2017.
 * </p>
 */

public class Utility {

    public static Pair<Integer, Integer> getDeviceWidthHeight(Context context) {
        int width = 0, height = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            Display display = ((Activity)context).getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            width = size.x;
            height = size.y;
        }
        return new Pair<>(width, height);
    }
}
