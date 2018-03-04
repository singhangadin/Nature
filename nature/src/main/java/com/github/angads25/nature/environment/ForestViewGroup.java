package com.github.angads25.nature.environment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.github.angads25.nature.model.NatureViewGroup;

import java.util.ArrayList;
import java.util.Random;

/**
 * <p>
 * Created by Angad on 04-05-2017.
 * </p>
 */

public class ForestViewGroup extends NatureViewGroup {
    private Random rand;
    private Rect mTmpChildRect;
    private ArrayList<Integer> x, y;
    private Context context;

    public ForestViewGroup(Context context) {
        super(context);
        this.context = context;
        initViewGroup();
    }

    public ForestViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initViewGroup();
    }

    private void initViewGroup() {
        rand = new Random();
        mTmpChildRect = new Rect();
        x = new ArrayList<>();
        y = new ArrayList<>();
        setBackgroundColor(Color.parseColor("#93DB70"));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int childs = getChildCount();
        for(int i = 0; i < childs; i++) {
            View child = getChildAt(i);
            child.measure(MeasureSpec.makeMeasureSpec(minDim>>>2,
                    MeasureSpec.EXACTLY),
                    MeasureSpec.makeMeasureSpec(minDim>>>2,
                            MeasureSpec.EXACTLY));
            x.add(rand.nextInt(width));
            y.add(rand.nextInt(height));
        }
        Log.e("MEASURE","Forest Measured");
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childs = getChildCount();
        for(int i = 0; i < childs; i++) {
            View child = getChildAt(i);
            mTmpChildRect.left = x.get(i);
            mTmpChildRect.right = x.get(i) + (minDim>>>2);
            mTmpChildRect.top = y.get(i);
            mTmpChildRect.bottom = y.get(i) + (minDim>>>2);
            child.layout(mTmpChildRect.left, mTmpChildRect.top, mTmpChildRect.right, mTmpChildRect.bottom);
        }
    }
}
