package com.github.angads25.nature.scenes;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.github.angads25.nature.model.ElevatedView;

/**
 * <p>
 * Created by Angad on 30-04-2017.
 * </p>
 */

public class SkyView extends ElevatedView {
    private int skyColor;

    public SkyView(Context context) {
        super(context);
    }

    public SkyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(skyColor);
    }

    public int getSkyColor() {
        return skyColor;
    }

    public void setSkyColor(int skyColor) {
        this.skyColor = skyColor;
    }
}
