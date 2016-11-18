package id.jl.android.ufoanimation.activities;

import android.animation.ValueAnimator;
import android.view.animation.AccelerateInterpolator;

/**
 * Created by user on 11/18/16.
 */

public class AccelerateUFOAnimationActivity extends BaseAnimationActivity {
    @Override
    protected void onStartAnimation() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, -mScreenHeight);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                mUFO.setTranslationY(value);
            }
        });

        valueAnimator.setInterpolator(new AccelerateInterpolator(1.5f));
        valueAnimator.setDuration(DEFAULT_ANIMATION_DURATION);
        valueAnimator.start();
    }
}
