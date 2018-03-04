package com.github.angads25.nature.elements;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
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
        float radiusSmall = (minDim >>> 1) / 3;
        float radiusMedium = minDim / 5;
        float radiusLarge = minDim / 4.75f;

        canvas.save();
        canvas.translate(minDim / 75, minDim / 75);

        paint.setColor(Color.parseColor("#444444"));
        canvas.drawRect(center - (minDim / 3.5f), minDim - (minDim/5) - (minDim >>> 2), (minDim >>> 1) + (minDim / 5), (minDim - (minDim/5)), paint);
        //Draw big left bubble
        canvas.drawCircle(center - (minDim / 7.5f), center - (minDim/25), radiusLarge, paint);
        //Draw small Left bubble
        canvas.drawCircle(center - (minDim / 3.5f), (minDim - (minDim/5)) - radiusSmall, radiusSmall, paint);
        //Draw medium small bubble
        canvas.drawCircle(center + (minDim / 5), (minDim - (minDim/5)) - radiusMedium, radiusMedium, paint);
        //Draw medium right bubble
        canvas.drawCircle(center + ((minDim >>> 1) / 5), (minDim >>> 1) + ((minDim>>>1) / 5) - radiusSmaller, radiusSmaller, paint);

        canvas.restore();

        paint.setColor(cloudColor);
        canvas.drawRect(center - (minDim / 3.5f), minDim - (minDim/5) - (minDim >>> 2), (minDim >>> 1) + (minDim / 5), (minDim - (minDim/5)), paint);
        //Draw big left bubble
        canvas.drawCircle(center - (minDim / 7.5f), center - (minDim/25), radiusLarge, paint);
        //Draw small Left bubble
        canvas.drawCircle(center - (minDim / 3.5f), (minDim - (minDim/5)) - radiusSmall, radiusSmall, paint);
        //Draw medium small bubble
        canvas.drawCircle(center + (minDim / 5), (minDim - (minDim/5)) - radiusMedium, radiusMedium, paint);
        //Draw medium right bubble
        canvas.drawCircle(center + ((minDim >>> 1) / 5), (minDim >>> 1) + ((minDim >>> 1) / 5) - radiusSmaller, radiusSmaller, paint);
    }
}
