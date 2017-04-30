package com.github.angads25.nature.environment;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.Random;

/**
 * <p>
 * Created by Angad on 01-05-2017.
 * </p>
 */

public class MountainViewGroup extends ViewGroup {
    private int width, height, minDim;
    private Random rand;
    private Rect mTmpChildRect;

    public MountainViewGroup(Context context) {
        super(context);
        initViewGroup();
    }

    public MountainViewGroup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initViewGroup();
    }

    private void initViewGroup() {
        rand = new Random();
        mTmpChildRect = new Rect();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
        minDim = Math.min(width, height);
        setMeasuredDimension(width, height);
        int childs = getChildCount();
        int parts = width/childs;
        for(int i = 0; i < childs; i++) {
            View child = getChildAt(i);
            child.measure(MeasureSpec.makeMeasureSpec(parts,
                    MeasureSpec.EXACTLY),
                    MeasureSpec.makeMeasureSpec(height,
                            MeasureSpec.EXACTLY));
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int childs = getChildCount();
        int parts = width/childs;
        int start = getLeft();
        for(int i = 0; i < childs; i++) {
            View child = getChildAt(i);
            mTmpChildRect.left = start ;
            mTmpChildRect.right = mTmpChildRect.left + parts;
            mTmpChildRect.top = getTop();
            mTmpChildRect.bottom = (height/2) + (height/3);
            child.layout(mTmpChildRect.left, mTmpChildRect.top, mTmpChildRect.right, mTmpChildRect.bottom);
            start += parts;
        }
    }
}
