package com.github.angads25.nature.elements;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.github.angads25.nature.R;
import com.github.angads25.nature.model.ElevatedView;

/**
 * <p>
 * Created by Angad on 30-04-2017.
 * </p>
 */

public class SunView extends ElevatedView {
    private float radius;
    private String[] colorTheme;

    public SunView(Context context) {
        super(context);
    }

    public SunView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void initView() {
        super.initView();
        colorTheme = context.getResources().getStringArray(R.array.sun_normal);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float radii = radius;
        float diff = radii/(colorTheme.length + (colorTheme.length));
        for (String aColorTheme : colorTheme) {
            paint.setColor(Color.parseColor(aColorTheme));
            canvas.drawCircle(minDim / 2, minDim / 2, radii, paint);
            radii -= diff;
        }
    }

    public void setColorTheme(String[] colorTheme) {
        this.colorTheme = colorTheme;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(minDim, minDim);
        radius = 0.48f * minDim;
    }
}
