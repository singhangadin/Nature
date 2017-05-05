package com.github.angads25.nature.elements;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.github.angads25.nature.model.NatureView;

import java.util.Random;

/**
 * <p>
 * Created by Angad on 04-05-2017.
 * </p>
 */

public class SkyView extends NatureView {
    private int skyColor;
    private boolean showStars;
    private Random random;

    public SkyView(Context context) {
        super(context);
    }

    public SkyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void initView() {
        super.initView();
        random = new Random();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(skyColor);
        if(showStars) {
            paint.setColor(Color.WHITE);
            for(int i = 0; i < Math.min(width, height); i++) {
                canvas.drawPoint(random.nextInt(width), random.nextInt(height), paint);
            }
        }
    }

    public int getSkyColor() {
        return skyColor;
    }

    public void setSkyColor(int skyColor) {
        this.skyColor = skyColor;
    }

    public boolean isShowStars() {
        return showStars;
    }

    public void setShowStars(boolean showStars) {
        this.showStars = showStars;
    }
}
