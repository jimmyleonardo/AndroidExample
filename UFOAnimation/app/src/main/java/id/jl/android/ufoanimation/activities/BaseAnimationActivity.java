package id.jl.android.ufoanimation.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Toast;

import id.jl.android.ufoanimation.R;

/**
 * Created by user on 11/18/16.
 */


public abstract class BaseAnimationActivity extends AppCompatActivity {
    public static final long DEFAULT_ANIMATION_DURATION = 2500L;
    protected View mUFO;
    protected View mAlien;
    protected View mFrameLayout;
    protected float mScreenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_base_animation);

        mUFO = findViewById(R.id.ufo);
        mAlien = findViewById(R.id.alien);

        mFrameLayout = findViewById(R.id.container);
        mFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStartAnimation();
            }
        });

        Toast.makeText(this, getString(R.string.touch_the_alien), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        mScreenHeight = displaymetrics.heightPixels;
    }

    protected abstract void onStartAnimation();
}