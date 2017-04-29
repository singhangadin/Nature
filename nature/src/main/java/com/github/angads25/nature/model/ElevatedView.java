package com.github.angads25.nature.model;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * <p>
 * Created by Angad on 29-04-2017.
 * </p>
 */

public class ElevatedView extends View implements Comparable<ElevatedView>{
    protected Paint paint;
    protected int minDim, width, height;
    protected int zFactor;

    protected void initView() {
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    public ElevatedView(Context context) {
        super(context);
    }

    public ElevatedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public int compareTo(@NonNull ElevatedView o) {
        return Integer.valueOf(zFactor).compareTo(o.zFactor);
    }

    public int getzFactor() {
        return zFactor;
    }

    public void setzFactor(int zFactor) {
        this.zFactor = zFactor;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getMeasuredWidth();
        height = getMeasuredHeight();
        minDim = Math.min(getMeasuredHeight(),getMeasuredWidth());
    }
}
