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

public class LargeCloudView extends CloudView {

    public LargeCloudView(Context context) {
        super(context);
    }

    public LargeCloudView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //Draw Base Rectangle
        //TODO: Implement PorterDuff.Mode

        float radiusSmall = minDim / 8.5f;
        float radiusMedium = minDim / 7;
        float radiusLarge = minDim / 5.5f;

        canvas.save();
        canvas.translate(minDim / 75, minDim / 75);

        paint.setColor(Color.parseColor("#444444"));
        canvas.drawCircle(center - radiusSmall - (radiusMedium / 4) - radiusLarge, center + radiusLarge - radiusSmall, radiusSmall, paint);
        canvas.drawCircle(center - radiusLarge - (radiusMedium / 8), center + radiusLarge - radiusMedium, radiusMedium, paint);
        canvas.drawCircle(center, center, radiusLarge, paint);
        canvas.drawCircle(center + radiusLarge + (radiusMedium / 8), center + radiusLarge - radiusMedium, radiusMedium, paint);
        canvas.drawCircle(center + radiusSmall + (radiusMedium / 4) + (radiusLarge), center + radiusLarge - radiusSmall, radiusSmall, paint);

        canvas.restore();

        paint.setColor(cloudColor);
        canvas.drawCircle(center - radiusSmall - (radiusMedium / 4) - radiusLarge, center + radiusLarge - radiusSmall, radiusSmall, paint);
        canvas.drawCircle(center - radiusLarge - (radiusMedium / 8), center + radiusLarge - radiusMedium, radiusMedium, paint);
        canvas.drawCircle(center, center, radiusLarge, paint);
        canvas.drawCircle(center + radiusLarge + (radiusMedium / 8), center + radiusLarge - radiusMedium, radiusMedium, paint);
        canvas.drawCircle(center + radiusSmall + (radiusMedium / 4) + radiusLarge, center + radiusLarge - radiusSmall, radiusSmall, paint);
    }
}
