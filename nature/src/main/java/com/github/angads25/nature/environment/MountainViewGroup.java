package com.github.angads25.nature.environment;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.github.angads25.nature.model.NatureViewGroup;

import java.util.ArrayList;
import java.util.Random;

/**
 * <p>
 * Created by Angad on 01-05-2017.
 * </p>
 */

public class MountainViewGroup extends NatureViewGroup {
    private Random rand;
    private Rect mTmpChildRect;
    private ArrayList<Integer> leftNoise, rightNoise;

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
        leftNoise = new ArrayList<>();
        rightNoise = new ArrayList<>();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int childs = getChildCount();
        int parts = width/childs;
        for(int i = 0; i < childs; i++) {
            View child = getChildAt(i);
            leftNoise.add(rand.nextInt(minDim/4));
            rightNoise.add(rand.nextInt(minDim/4));
            child.measure(MeasureSpec.makeMeasureSpec(parts + leftNoise.get(i) + rightNoise.get(i),
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
            mTmpChildRect.left = start - leftNoise.get(i);
            mTmpChildRect.right = mTmpChildRect.left + parts + leftNoise.get(i) + rightNoise.get(i);
            mTmpChildRect.top = height / 6;
            mTmpChildRect.bottom = bottom;
            child.layout(mTmpChildRect.left, mTmpChildRect.top, mTmpChildRect.right, mTmpChildRect.bottom);
            start += parts;
        }
    }
}
