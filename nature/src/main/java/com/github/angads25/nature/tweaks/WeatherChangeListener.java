package com.github.angads25.nature.tweaks;

/**
 * <p>
 * Created by Angad on 30-04-2017.
 * </p>
 */

public interface WeatherChangeListener {
    void inSummers(int[] temp, long time);
    void inWinters(int[] temp, long time);
    void inAutumn(int[] wind, int direction, long time);
    void inRains(int[] wind, int direction, long time);
    void inSpring(long time);
}
