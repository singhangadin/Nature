package com.github.angads25.nature.environment;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.github.angads25.nature.elements.LargeCloudView;
import com.github.angads25.nature.elements.MediumCloudView;
import com.github.angads25.nature.elements.MoonView;
import com.github.angads25.nature.elements.SmallCloudView;
import com.github.angads25.nature.elements.SunView;
import com.github.angads25.nature.model.CloudView;
import com.github.angads25.nature.scenes.SkyView;

import java.util.Random;

/**
 * <p>
 * Created by Angad on 30-04-2017.
 * </p>
 */

public class SceneryViewGroup extends ViewGroup{
    private int width, height, minDim;
    private Random rand;
    private Rect mTmpChildRect;

    public SceneryViewGroup(Context context) {
        super(context);
        initViewGroup();
    }

    public SceneryViewGroup(Context context, AttributeSet attrs) {
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
                    child.measure(MeasureSpec.makeMeasureSpec(minDim/6,
                            MeasureSpec.EXACTLY),
                            MeasureSpec.makeMeasureSpec(minDim/6,
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
            else if (child instanceof MountainViewGroup) {
                child.measure(MeasureSpec.makeMeasureSpec(width,
                        MeasureSpec.EXACTLY),
                        MeasureSpec.makeMeasureSpec(height,
                                MeasureSpec.EXACTLY));
            }
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childs = getChildCount();
        for(int i = 0; i<childs; i++) {
            View child = getChildAt(i);
            if(child instanceof SkyView) {
                child.layout(l, t, r, b);
            }
            else if(child instanceof SunView) {
                mTmpChildRect.left = minDim/10;
                mTmpChildRect.right = mTmpChildRect.left + (minDim/5);
                mTmpChildRect.top = minDim/10;
                mTmpChildRect.bottom = mTmpChildRect.top + (minDim/5);
                child.layout(mTmpChildRect.left, mTmpChildRect.top, mTmpChildRect.right, mTmpChildRect.bottom);
            }
            else if (child instanceof CloudView) {
                int limit = (height/5);
                int top = rand.nextInt(limit);
                if(child instanceof SmallCloudView) {
                    int left = rand.nextInt(width - (minDim/10) - (minDim/6));
                    mTmpChildRect.left = left + (minDim/10);
                    mTmpChildRect.right = mTmpChildRect.left + (minDim/6);
                    mTmpChildRect.top = top + (minDim/10);
                    mTmpChildRect.bottom = mTmpChildRect.top + (minDim/6);
                    child.layout(mTmpChildRect.left, mTmpChildRect.top, mTmpChildRect.right, mTmpChildRect.bottom);
                }
                else if(child instanceof MediumCloudView) {
                    int left = rand.nextInt(width - (minDim/10) - (minDim/5));
                    mTmpChildRect.left = left + (minDim/10);
                    mTmpChildRect.right = mTmpChildRect.left + (minDim/5);
                    mTmpChildRect.top = top + (minDim/10);
                    mTmpChildRect.bottom = mTmpChildRect.top + (minDim/5);
                    child.layout(mTmpChildRect.left, mTmpChildRect.top, mTmpChildRect.right, mTmpChildRect.bottom);
                }
                else if(child instanceof LargeCloudView) {
                    int left = rand.nextInt(width - (minDim/10) - (minDim/3));
                    mTmpChildRect.left = left + (minDim/10);
                    mTmpChildRect.right = mTmpChildRect.left + (minDim/3);
                    mTmpChildRect.top = top + (minDim/10);
                    mTmpChildRect.bottom = mTmpChildRect.top + (minDim/3);
                    child.layout(mTmpChildRect.left, mTmpChildRect.top, mTmpChildRect.right, mTmpChildRect.bottom);
                }
            }
            else if (child instanceof MoonView) {
                mTmpChildRect.left = (minDim/2) - (minDim/10);
                mTmpChildRect.right = mTmpChildRect.left + (minDim/5);
                mTmpChildRect.top = minDim/10;
                mTmpChildRect.bottom = mTmpChildRect.top + (minDim/5);
                child.layout(mTmpChildRect.left, mTmpChildRect.top, mTmpChildRect.right, mTmpChildRect.bottom);
            }
            else if (child instanceof MountainViewGroup) {
                mTmpChildRect.left = getLeft();
                mTmpChildRect.right = getRight();
                mTmpChildRect.top = getTop();
                mTmpChildRect.bottom = (height/2) + (height/3);
                child.layout(mTmpChildRect.left, mTmpChildRect.top, mTmpChildRect.right, mTmpChildRect.bottom);
            }
        }
    }
}
