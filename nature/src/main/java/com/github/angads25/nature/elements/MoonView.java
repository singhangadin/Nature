package com.github.angads25.nature.elements;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.github.angads25.nature.model.ElevatedView;

/**
 * <p>
 * Created by Angad on 30-04-2017.
 * </p>
 */

public class MoonView extends ElevatedView {
    private float radius;
    private float eclipse = 1;
    private int visible = 0;
    private int skyColor = Color.BLACK;

    public MoonView(Context context) {
        super(context);
    }

    public MoonView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.WHITE);
        canvas.drawCircle(minDim/2, minDim/2, radius, paint);
        paint.setColor(skyColor);
        canvas.drawCircle((minDim/2)+((visible*(minDim/2))/100),(minDim/2)-((visible*(minDim/2))/100), radius  - ((radius*eclipse)/100),paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(minDim, minDim);
        radius = 0.48f * minDim;
    }

    public int getVisible() {
        return (visible*100)/140;
    }

    public void setVisible(int visible) {
        visible = (visible*140)/100;
        this.visible = visible;
        invalidate();
    }

    public int getSkyColor() {
        return skyColor;
    }

    public void setEclipse(float eclipse) {
        this.eclipse = eclipse;
    }

    public void setSkyColor(int skyColor) {
        this.skyColor = skyColor;
    }
}
