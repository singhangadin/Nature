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

public class NatureView extends View implements Comparable<NatureView>{
    protected Paint paint;
    protected int minDim, width, height;
    protected int zFactor, center;
    protected Context context;

    protected void initView() {
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    public NatureView(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    public NatureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();
    }

    @Override
    public int compareTo(@NonNull NatureView o) {
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
        center = minDim >>> 1;
    }
}
