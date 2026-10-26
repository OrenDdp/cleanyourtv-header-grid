package com.gathin.tvhome;

import android.service.dreams.DreamService;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Screensaver: the launcher's thin clock and date on black, over a slow ambient glow (ClockScene).
 * No network, no images: cheap enough for a 1 GB TV.
 */
public class ClockDream extends DreamService {

    private ClockScene scene;

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setInteractive(false);   // any key wakes the TV back to where it was
        setFullscreen(true);
        setScreenBright(false);
        setContentView(R.layout.dream_clock);
        Config cfg = Config.load(this);
        TextView clock = findViewById(R.id.dreamClock);
        TextView date = findViewById(R.id.dreamDate);
        int clockFont = Config.fontRes(cfg.dreamClockFont), dateFont = Config.fontRes(cfg.dreamDateFont);
        if (clockFont != 0) clock.setTypeface(getResources().getFont(clockFont));
        if (dateFont != 0) date.setTypeface(getResources().getFont(dateFont));
        if (cfg.dreamCentered) {
            // dream_centered: the clock row centred over the date (the date's start margin only lined it up with the digits).
            ((LinearLayout) findViewById(R.id.dreamContent)).setGravity(Gravity.CENTER_HORIZONTAL);
            ((LinearLayout.LayoutParams) date.getLayoutParams()).setMarginStart(0);
        }
        scene = new ClockScene(getWindow().getDecorView());
        scene.useHomeWallpaper(this);
    }

    @Override
    public void onDreamingStarted() {
        super.onDreamingStarted();
        scene.start();
    }

    @Override
    public void onDreamingStopped() {
        scene.stop();
        super.onDreamingStopped();
    }

    @Override
    public void onDetachedFromWindow() {
        if (scene != null) scene.stop();
        super.onDetachedFromWindow();
    }
}
