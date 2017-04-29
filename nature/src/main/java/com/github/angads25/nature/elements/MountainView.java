package com.github.angads25.nature.elements;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;

import com.github.angads25.nature.model.ElevatedView;

/**<p>
 * Created by Angad on 1/3/17.
 * </p>
 */

public class MountainView extends ElevatedView {

    private Point a,b,c;
    private Path path;
    private float peakSize;

    public MountainView(Context context) {
        super(context);
        initView();
    }

    public MountainView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    protected void initView() {
        super.initView();
        a = new Point();
        b = new Point();
        c = new Point();
        path = new Path();
        setPeakSize(80);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        path.reset();
        canvas.drawColor(Color.WHITE);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        path.moveTo(b.x, b.y);
        path.lineTo(c.x, c.y);
        path.lineTo(a.x, a.y);
        path.close();
        canvas.drawPath(path, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        a.set((width/2)-(minDim/2), (height));
        b.set((width/2)+(minDim/2), (height));
        c.set((width/2), (int)((minDim==height?minDim:height)*(peakSize/100)));
    }

    public float getPeakSize() {
        return peakSize;
    }

    public void setPeakSize(float peakSize) {
        peakSize = 100 - peakSize;
        this.peakSize = peakSize;
        c.set((width/2), (int)((minDim==height?minDim:height)*(peakSize/100)));
    }
}
