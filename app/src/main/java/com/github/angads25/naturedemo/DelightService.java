package com.github.angads25.naturedemo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.ViewGroup;

import com.github.angads25.nature.elements.LargeCloudView;
import com.github.angads25.nature.elements.MediumCloudView;
import com.github.angads25.nature.elements.MoonView;
import com.github.angads25.nature.elements.MountainView;
import com.github.angads25.nature.elements.SkyView;
import com.github.angads25.nature.elements.SmallCloudView;
import com.github.angads25.nature.elements.SunView;
import com.github.angads25.nature.elements.TreeView;
import com.github.angads25.nature.environment.ForestViewGroup;
import com.github.angads25.nature.environment.MountainViewGroup;
import com.github.angads25.nature.environment.SceneryViewGroup;
import com.github.angads25.nature.environment.SkyViewGroup;

import java.util.Random;

/**<p>
 * Created by Angad on 22/10/2015.
 * </p>
 */

public class DelightService extends WallpaperService
{   @Override
    public Engine onCreateEngine()
    {   return new ELiteClockWallpaperEngine();
    }

    private class ELiteClockWallpaperEngine extends Engine {
        private int width,height;
        private boolean visible=true;
        private SceneryViewGroup scenery;
        private final Handler handler=new Handler();
        private final Runnable runnable=new Runnable()
        {   @Override
            public void run()
            {   draw();
            }
        };

        private ELiteClockWallpaperEngine()
        {
        }

        @Override
        public void onCreate(SurfaceHolder surfaceHolder) {
            super.onCreate(surfaceHolder);
            scenery = new SceneryViewGroup(getApplicationContext());
            scenery.setLayoutParams(
                    new ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT ) );
            scenery.setAddStatesFromChildren(true);
            SkyViewGroup skyGroup = new SkyViewGroup(getApplicationContext());
            SkyView sky = new SkyView(getApplicationContext());
            sky.setSkyColor(Color.parseColor("#BCD4E6"));
            sky.setShowStars(false);
            skyGroup.addView(sky);

            SunView sun = new SunView(getApplicationContext());
            sun.setColorTheme(getResources().getStringArray(R.array.sun_normal));
            skyGroup.addView(sun);

            MoonView moon = new MoonView(getApplicationContext());
            moon.setSkyColor(sky.getSkyColor());
            moon.setVisible(0);
            skyGroup.addView(moon);

            SmallCloudView smallCloud[] = new SmallCloudView[6];
            for(int i=0;i<smallCloud.length;i++) {
                smallCloud[i] = new SmallCloudView(getApplicationContext());
                smallCloud[i].setCloudColor(Color.parseColor("#EEEFFF"));
                skyGroup.addView(smallCloud[i]);
            }
            scenery.addView(skyGroup);
            Random rand = new Random();

            MountainViewGroup mountainViewGroup = new MountainViewGroup(getApplicationContext());
            MountainView mountain = new MountainView(getApplicationContext());
            MountainView mountain1 = new MountainView(getApplicationContext());
            MountainView mountain2 = new MountainView(getApplicationContext());

            mountain.setColor(Color.parseColor("#968D99"));
            mountain1.setColor(Color.parseColor("#30BA8F"));
            mountain2.setColor(Color.parseColor("#8E794E"));

            mountain.setPeakSize(rand.nextInt(50) + 50);
            mountain1.setPeakSize(rand.nextInt(50) + 50);
            mountain2.setPeakSize(rand.nextInt(50) + 50);

            mountainViewGroup.addView(mountain);
            mountainViewGroup.addView(mountain1);
            mountainViewGroup.addView(mountain2);

            scenery.addView(mountainViewGroup);

            MediumCloudView mediumView = new MediumCloudView(getApplicationContext());
            mediumView.setCloudColor(Color.parseColor("#EEEFFF"));
            skyGroup.addView(mediumView);

            LargeCloudView largeView = new LargeCloudView(getApplicationContext());
            largeView.setCloudColor(Color.parseColor("#EEEFFF"));
            scenery.addView(largeView);

            ForestViewGroup forestViewGroup = new ForestViewGroup(getApplicationContext());
            for(int i = 0 ; i < (500 * (width / (float)height)) / 2 ; i++) {
                forestViewGroup.addView(new TreeView(getApplicationContext()));
            }
            scenery.addView(forestViewGroup);

            handler.postDelayed(runnable, 2000);
        }

        @Override
        public void onVisibilityChanged(boolean visible)
        {    super.onVisibilityChanged(visible);
            this.visible=visible;
            if(visible)
            {   handler.postDelayed(runnable, 2000);
            }
            else
            {   handler.removeCallbacks(runnable);
            }
        }

        @Override
        public void onSurfaceChanged(SurfaceHolder holder, int format, int width, int height)
        {   super.onSurfaceChanged(holder, format, width, height);
            this.width=width;
            this.height=height;
            if(width!=0&&height!=0) {
                Log.e("MEASURE", width+":"+height);
//                scenery.layout(0, 0, width, height);
            }
        }

        @Override
        public void onSurfaceDestroyed(SurfaceHolder holder)
        {   super.onSurfaceDestroyed(holder);
            this.visible=false;
            handler.removeCallbacks(runnable);
        }

        private void draw()
        {   SurfaceHolder holder=getSurfaceHolder();
            Canvas canvas=null;
            try
            {   canvas=holder.lockCanvas();
                if(canvas!=null)
                {   draw(canvas);
                }
            }
            finally
            {   if(canvas!=null)
                {   holder.unlockCanvasAndPost(canvas);
                }
            }
            handler.removeCallbacks(runnable);
            if(visible)
            {   handler.postDelayed(runnable,200);
            }
        }

        private void draw(Canvas canvas) {
//            scenery.setTime(System.currentTimeMillis());
            scenery.layout(0,0,width,height);
            scenery.draw(canvas);
        }
    }
}
