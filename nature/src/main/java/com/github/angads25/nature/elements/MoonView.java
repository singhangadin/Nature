package com.github.angads25.nature.elements;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.github.angads25.nature.model.NatureView;

/**
 * <p>
 * Created by Angad on 30-04-2017.
 * </p>
 */

public class MoonView extends NatureView {
    private float radius;
    private int visible;
    private int skyColor, vmax = 140;

    public MoonView(Context context) {
        super(context);
    }

    public MoonView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setSkyColor(Color.parseColor("#333333"));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.WHITE);
        if(visible > 0) {
            canvas.drawCircle(center, center, radius, paint);
        }
        paint.setColor(skyColor);
        if(visible != 0 && visible!= vmax) {
            canvas.drawCircle(center + ((visible * center) / 100), center - ((visible * center) / 100), radius, paint);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(minDim, minDim);
        radius = 0.38f * minDim;
    }

    public int getVisible() {
        return (visible*100)/vmax;
    }

    public void setVisible(int visible) {
        visible = (visible * vmax)/100;
        this.visible = visible;
        invalidate();
    }

    public void setSkyColor(int skyColor) {
        this.skyColor = skyColor;
    }
}
