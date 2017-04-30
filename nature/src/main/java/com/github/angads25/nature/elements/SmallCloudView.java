package com.github.angads25.nature.elements;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.github.angads25.nature.model.ElevatedView;

/**<p>
 * Created by Angad on 29-04-2017.
 * </p>
 */

public class SmallCloudView extends ElevatedView {
    private int cloudColor = Color.WHITE;

    public SmallCloudView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Draw Base Rectangle
        //TODO: Implement PorterDuff.Mode
        float radiusSmall = minDim / 6;
        float radiusMedium = minDim / 5;
        float radiusLarge = minDim / 4.5f;

        canvas.save();
        canvas.translate(minDim / 75, minDim / 75);

        //Cloud shadow
        paint.setColor(Color.parseColor("#444444"));
        canvas.drawRect((minDim / 2) - (minDim / 3.5f), minDim - (minDim / 4), (minDim /2) + (minDim / 5), minDim, paint);
        //Draw big center bubble
        canvas.drawCircle((minDim / 2) - (minDim / 20), (minDim/2) + (minDim / 8f), radiusLarge, paint);
        //Draw small Left bubble
        canvas.drawCircle((minDim / 2) - (minDim / 3.5f), minDim - radiusSmall, radiusSmall, paint);
        //Draw medium right bubble
        canvas.drawCircle((minDim / 2) + (minDim / 5), minDim - radiusMedium, radiusMedium, paint);

        canvas.restore();

        paint.setColor(cloudColor);
        canvas.drawRect((minDim / 2) - (minDim / 3.5f), minDim - (minDim / 4), (minDim /2) + (minDim / 5), minDim, paint);
        //Draw big center bubble
        canvas.drawCircle((minDim / 2) - (minDim / 20), (minDim/2) + (minDim / 8f), radiusLarge, paint);
        //Draw small Left bubble
        canvas.drawCircle((minDim / 2) - (minDim / 3.5f), minDim - radiusSmall, radiusSmall, paint);
        //Draw medium right bubble
        canvas.drawCircle((minDim / 2) + (minDim / 5), minDim - radiusMedium, radiusMedium, paint);
    }

    public int getCloudColor() {
        return cloudColor;
    }

    public void setCloudColor(int cloudColor) {
        this.cloudColor = cloudColor;
    }
}
