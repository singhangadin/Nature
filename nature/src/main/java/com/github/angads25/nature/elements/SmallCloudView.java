package com.github.angads25.nature.elements;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.github.angads25.nature.model.CloudView;

/**<p>
 * Created by Angad on 29-04-2017.
 * </p>
 */

public class SmallCloudView extends CloudView {

    public SmallCloudView(Context context) {
        super(context);
    }

    public SmallCloudView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //Draw Base Rectangle
        //TODO: Implement PorterDuff.Mode
        float radiusSmall = minDim / 6;
        float radiusMedium = minDim / 5;
        float radiusLarge = minDim / 4.5f;

        canvas.save();
        canvas.translate(minDim / 75, minDim / 75);

        //Cloud shadow
        paint.setColor(Color.parseColor("#444444"));
        canvas.drawRect((minDim / 2) - (minDim / 3.5f), minDim - (minDim/5) - (minDim / 4), (minDim /2) + (minDim / 5), (minDim - (minDim/5)), paint);
        //Draw big center bubble
        canvas.drawCircle((minDim / 2) - (minDim / 20), (minDim/2) - (minDim / 8f), radiusLarge, paint);
        //Draw small Left bubble
        canvas.drawCircle((minDim / 2) - (minDim / 3.5f), (minDim - (minDim/5)) - radiusSmall, radiusSmall, paint);
        //Draw medium right bubble
        canvas.drawCircle((minDim / 2) + (minDim / 5), (minDim - (minDim/5)) - radiusMedium, radiusMedium, paint);

        canvas.restore();

        paint.setColor(cloudColor);
        canvas.drawRect((minDim / 2) - (minDim / 3.5f), minDim - (minDim/5) - (minDim / 4), (minDim /2) + (minDim / 5), (minDim - (minDim/5)), paint);
        //Draw big center bubble
        canvas.drawCircle((minDim / 2) - (minDim / 20), (minDim/2) - (minDim / 8f), radiusLarge, paint);
        //Draw small Left bubble
        canvas.drawCircle((minDim / 2) - (minDim / 3.5f), (minDim - (minDim/5)) - radiusSmall, radiusSmall, paint);
        //Draw medium right bubble
        canvas.drawCircle((minDim / 2) + (minDim / 5), (minDim - (minDim/5)) - radiusMedium, radiusMedium, paint);
    }
}
