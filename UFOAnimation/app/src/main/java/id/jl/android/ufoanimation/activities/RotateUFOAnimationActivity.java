package id.jl.android.ufoanimation.activities;

import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;

/**
 * Created by user on 11/18/16.
 */

public class RotateUFOAnimationActivity extends BaseAnimationActivity {
    @Override
    protected void onStartAnimation() {
        ValueAnimator animator = ValueAnimator.ofFloat(0, 360);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                // 2
                mUFO.setRotation(value);
            }
        });

        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(DEFAULT_ANIMATION_DURATION);
        animator.start();
    }
}
