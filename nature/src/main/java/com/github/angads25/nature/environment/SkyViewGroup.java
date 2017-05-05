package com.github.angads25.nature.environment;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.github.angads25.nature.elements.LargeCloudView;
import com.github.angads25.nature.elements.MediumCloudView;
import com.github.angads25.nature.elements.MoonView;
import com.github.angads25.nature.elements.SkyView;
import com.github.angads25.nature.elements.SmallCloudView;
import com.github.angads25.nature.elements.SunView;
import com.github.angads25.nature.model.CloudView;
import com.github.angads25.nature.model.NatureViewGroup;

import java.util.Random;

/**
 * <p>
 * Created by Angad on 30-04-2017.
 * </p>
 */

public class SkyViewGroup extends NatureViewGroup {
    private Random rand;
    private Rect mTmpChildRect;

    public SkyViewGroup(Context context) {
        super(context);
        initViewGroup();
    }

    public SkyViewGroup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initViewGroup();
    }

    private void initViewGroup() {
        rand = new Random();
        mTmpChildRect = new Rect();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int childs = getChildCount();
        for(int i = 0; i < childs; i++) {
            View child = getChildAt(i);
            if(child instanceof SkyView) {
                child.measure(MeasureSpec.makeMeasureSpec(width,
                        MeasureSpec.EXACTLY),
                        MeasureSpec.makeMeasureSpec(height,
                                MeasureSpec.EXACTLY));
            }
            else if(child instanceof SunView) {
                child.measure(MeasureSpec.makeMeasureSpec(minDim/5,
                        MeasureSpec.EXACTLY),
                        MeasureSpec.makeMeasureSpec(minDim/5,
                                MeasureSpec.EXACTLY));
            }
            else if (child instanceof CloudView) {
                if(child instanceof SmallCloudView) {
                    child.measure(MeasureSpec.makeMeasureSpec((minDim >>> 1) / 3,
                            MeasureSpec.EXACTLY),
                            MeasureSpec.makeMeasureSpec((minDim >>> 1) / 3,
                                    MeasureSpec.EXACTLY));
                }
                else if(child instanceof MediumCloudView) {
                    child.measure(MeasureSpec.makeMeasureSpec(minDim/5,
                            MeasureSpec.EXACTLY),
                            MeasureSpec.makeMeasureSpec(minDim/5,
                                    MeasureSpec.EXACTLY));
                }
                else if(child instanceof LargeCloudView) {
                    child.measure(MeasureSpec.makeMeasureSpec(minDim/3,
                            MeasureSpec.EXACTLY),
                            MeasureSpec.makeMeasureSpec(minDim/3,
                                    MeasureSpec.EXACTLY));
                }
            }
            else if (child instanceof MoonView) {
                child.measure(MeasureSpec.makeMeasureSpec(minDim/5,
                        MeasureSpec.EXACTLY),
                        MeasureSpec.makeMeasureSpec(minDim/5,
                                MeasureSpec.EXACTLY));
            }
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childs = getChildCount();
        int widgetPadding = (minDim >>> 1) / 5;
        for(int i = 0; i<childs; i++) {
            View child = getChildAt(i);
            if(child instanceof SkyView) {
                child.layout(l, t, r, b);
            }
            else if(child instanceof SunView) {
                int sunSize = minDim/5;
                mTmpChildRect.left = widgetPadding;
                mTmpChildRect.right = mTmpChildRect.left + sunSize;
                mTmpChildRect.top = widgetPadding;
                mTmpChildRect.bottom = mTmpChildRect.top + sunSize;
                child.layout(mTmpChildRect.left, mTmpChildRect.top, mTmpChildRect.right, mTmpChildRect.bottom);
            }
            else if (child instanceof CloudView) {
                int limit = (height >>> 1) / 5;
                int top = rand.nextInt(limit);
                if(child instanceof SmallCloudView) {
                    int smallCloudSize = (minDim >>> 1) / 3;
                    int left = rand.nextInt(width - widgetPadding - smallCloudSize);
                    mTmpChildRect.left = left + widgetPadding;
                    mTmpChildRect.right = mTmpChildRect.left + smallCloudSize;
                    mTmpChildRect.top = top + widgetPadding;
                    mTmpChildRect.bottom = mTmpChildRect.top + smallCloudSize;
                    child.layout(mTmpChildRect.left, mTmpChildRect.top, mTmpChildRect.right, mTmpChildRect.bottom);
                }
                else if(child instanceof MediumCloudView) {
                    int mediumCloudSize = minDim / 5;
                    int left = rand.nextInt(width - widgetPadding - mediumCloudSize);
                    mTmpChildRect.left = left + widgetPadding;
                    mTmpChildRect.right = mTmpChildRect.left + mediumCloudSize;
                    mTmpChildRect.top = top + widgetPadding;
                    mTmpChildRect.bottom = mTmpChildRect.top + mediumCloudSize;
                    child.layout(mTmpChildRect.left, mTmpChildRect.top, mTmpChildRect.right, mTmpChildRect.bottom);
                }
                else if(child instanceof LargeCloudView) {
                    int largeCloudSize = minDim / 3;
                    int left = rand.nextInt(width - widgetPadding - largeCloudSize);
                    mTmpChildRect.left = left + widgetPadding;
                    mTmpChildRect.right = mTmpChildRect.left + largeCloudSize;
                    mTmpChildRect.top = top + widgetPadding;
                    mTmpChildRect.bottom = mTmpChildRect.top + largeCloudSize;
                    child.layout(mTmpChildRect.left, mTmpChildRect.top, mTmpChildRect.right, mTmpChildRect.bottom);
                }
            }
            else if (child instanceof MoonView) {
                int moonSize = minDim / 5;
                mTmpChildRect.left = (minDim >>> 1) - widgetPadding;
                mTmpChildRect.right = mTmpChildRect.left + moonSize;
                mTmpChildRect.top = widgetPadding;
                mTmpChildRect.bottom = mTmpChildRect.top + moonSize;
                child.layout(mTmpChildRect.left, mTmpChildRect.top, mTmpChildRect.right, mTmpChildRect.bottom);
            }
        }
    }
}
