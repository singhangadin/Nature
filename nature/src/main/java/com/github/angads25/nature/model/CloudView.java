package com.github.angads25.nature.model;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * <p>
 * Created by Angad on 30-04-2017.
 * </p>
 */

public class CloudView extends NatureView {
    protected int cloudColor;

    public CloudView(Context context) {
        super(context);
    }

    public CloudView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public int getCloudColor() {
        return cloudColor;
    }

    public void setCloudColor(int cloudColor) {
        this.cloudColor = cloudColor;
    }
}
