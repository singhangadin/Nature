package com.github.angads25.nature.environment;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Random;

/**
 * <p>
 * Created by Angad on 04-05-2017.
 * </p>
 */

public class ForestViewGroup extends ViewGroup  {
    private Random rand;
    private Rect mTmpChildRect;
    private ArrayList<Integer> leftNoise, rightNoise;

    public ForestViewGroup(Context context) {
        super(context);
        initViewGroup();
    }

    public ForestViewGroup(Context context, AttributeSet attrs) {
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
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childs = getChildCount();
    }
}
