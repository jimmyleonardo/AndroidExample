package id.jl.android.ufoanimation.activities;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;

/**
 * Created by user on 11/18/16.
 */

public class FlyWithAlienAnimationActivity extends BaseAnimationActivity {
    @Override
    protected void onStartAnimation() {
        ValueAnimator positionAnimator = ValueAnimator.ofFloat(0, -mScreenHeight);
        positionAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                // You can use value to set properties of many objects
                mUFO.setTranslationY(value);
                mAlien.setTranslationY(value);
            }
        });

        ValueAnimator rotationAnimator = ValueAnimator.ofFloat(0, 360);
        rotationAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                mAlien.setRotation(value);
            }
        });

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(positionAnimator).with(rotationAnimator);
        animatorSet.setDuration(DEFAULT_ANIMATION_DURATION);
        animatorSet.start();
    }
}
