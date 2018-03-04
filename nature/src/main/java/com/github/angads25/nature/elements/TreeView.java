package com.github.angads25.nature.elements;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.github.angads25.nature.model.NatureView;

/**
 * <p>
 * Created by Angad on 29-04-2017.
 * </p>
 */

public class TreeView extends NatureView {
    private Point[] lower;
    private Path lowerLayer;

    public TreeView(Context context) {
        super(context);
    }

    public TreeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void initView() {
        super.initView();
        lower = new Point[3];
        for(int i = 0; i < 3; i++) {
            lower[i] = new Point();
        }
        lowerLayer = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //Stem
        int padding = (minDim >>> 1) / 5;

        paint.setColor(Color.parseColor("#663300"));
        canvas.drawRect(center - (padding >>> 1), (minDim / 1.5f), center + (padding >>> 1), minDim - padding, paint);

        //Tree Layer
        paint.setColor(Color.parseColor("#476A34"));
        lowerLayer.moveTo(lower[0].x, lower[0].y);
        lowerLayer.lineTo(lower[1].x, lower[1].y);
        lowerLayer.lineTo(lower[2].x, lower[2].y);
        canvas.drawPath(lowerLayer, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(minDim, minDim);
        lower[0].set(center - (int)(minDim / 3.5f), center + (int)(minDim / 4.5f));
        lower[1].set(center + (int)(minDim / 3.5f), center + (int)(minDim / 4.5f));
        lower[2].set(center, (minDim >>> 1) / 5);
    }
}
