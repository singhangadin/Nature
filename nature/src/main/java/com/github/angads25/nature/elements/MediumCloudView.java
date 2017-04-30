package com.github.angads25.nature.elements;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.github.angads25.nature.model.CloudView;

/**
 * <p>
 * Created by Angad on 30-04-2017.
 * </p>
 */

public class MediumCloudView extends CloudView {

    public MediumCloudView(Context context) {
        super(context);
    }

    public MediumCloudView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //Draw Base Rectangle
        //TODO: Implement PorterDuff.Mode
        float radiusSmaller = minDim / 5;
        float radiusSmall = minDim / 6;
        float radiusMedium = minDim / 5;
        float radiusLarge = minDim / 4.75f;

        paint.setColor(cloudColor);
        canvas.drawRect((minDim / 2) - (minDim / 3.5f), minDim - (minDim/5) - (minDim / 4), (minDim /2) + (minDim / 5), (minDim - (minDim/5)), paint);
        //Draw big left bubble
        canvas.drawCircle((minDim / 2) - (minDim / 7.5f), (minDim / 2) - (minDim/25), radiusLarge, paint);
        //Draw small Left bubble
        canvas.drawCircle((minDim / 2) - (minDim / 3.5f), (minDim - (minDim/5)) - radiusSmall, radiusSmall, paint);
        //Draw medium small bubble
        canvas.drawCircle((minDim / 2) + (minDim / 5), (minDim - (minDim/5)) - radiusMedium, radiusMedium, paint);
        //Draw medium right bubble
        canvas.drawCircle((minDim / 2) + (minDim / 10), (minDim/2) + (minDim/10) - radiusSmaller, radiusSmaller, paint);
    }
}
