package id.jl.android.ufoanimation.activities;

import android.animation.ValueAnimator;

/**
 * Created by user on 11/18/16.
 */

public class FlyThereAndBackAnimationActivity extends BaseAnimationActivity {
    @Override
    protected void onStartAnimation() {
        ValueAnimator animator = ValueAnimator.ofFloat(0, -mScreenHeight);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                mUFO.setTranslationY(value);
                mAlien.setTranslationY(value);
            }
        });

        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(3);

        animator.setDuration(1500L);
        animator.start();
    }
}
