package id.jl.android.ufoanimation.activities;

import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;

/**
 * Created by user on 11/18/16.
 */

public class LaunchUFOValueAnimatorAnimationActivity extends BaseAnimationActivity {
    @Override
    protected void onStartAnimation() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, -mScreenHeight);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //3
                float value = (float) animation.getAnimatedValue();
                //4
                mUFO.setTranslationY(value);
            }
        });

        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setDuration(DEFAULT_ANIMATION_DURATION);
        valueAnimator.start();
    }
}
