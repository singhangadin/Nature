package com.github.angads25.nature.model;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * <p>
 * Created by Angad on 05-05-2017.
 * </p>
 */

public class NatureViewGroup extends ViewGroup {
    protected int width, height, minDim;

    public NatureViewGroup(Context context) {
        super(context);
    }

    public NatureViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
        minDim = Math.min(width, height);
        setMeasuredDimension(width, height);
    }
}
