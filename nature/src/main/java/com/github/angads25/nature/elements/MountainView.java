package com.github.angads25.nature.elements;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;

import com.github.angads25.nature.model.ElevatedView;

/**<p>
 * Created by Angad on 1/3/17.
 * </p>
 */

//Add Shadow
public class MountainView extends ElevatedView {
    private Point a,b,c;
    private Path path;
    private float peakSize;
    private int color;

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
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        path.reset();
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);
        path.moveTo(a.x, a.y);
        path.lineTo(b.x, b.y);
        path.lineTo(c.x, c.y);
        path.close();
        canvas.drawPath(path, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //Left
        a.set((width/2)-(minDim/2), (height/2) + (height/3));
        //Right
        b.set((width/2)+(minDim/2), (height/2) + (height/3));
//        c.set((width/2), (int)((minDim==height?minDim:height)*(peakSize/100)));
        //Top
        c.set((width/2), (height/2) - (int)(minDim*(peakSize/100)));
    }

    public void setPeakSize(float peakSize) {
        peakSize = 100 - peakSize;
        this.peakSize = peakSize;
        c.set((width/2), getBottom() - (int)(minDim*(peakSize/100)));
    }

    public void setColor(int color) {
        this.color = color;
    }
}
