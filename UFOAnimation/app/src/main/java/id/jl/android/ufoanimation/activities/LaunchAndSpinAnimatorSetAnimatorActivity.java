package id.jl.android.ufoanimation.activities;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;

/**
 * Created by user on 11/18/16.
 */

public class LaunchAndSpinAnimatorSetAnimatorActivity extends BaseAnimationActivity {
    @Override
    protected void onStartAnimation() {
        ValueAnimator positionAnimator = ValueAnimator.ofFloat(0, -mScreenHeight);

        positionAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                mUFO.setTranslationY(value);
            }
        });

        ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(mUFO, "rotation", 0, 180f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(positionAnimator).with(rotationAnimator);
        animatorSet.setDuration(DEFAULT_ANIMATION_DURATION);
        animatorSet.start();
    }
}
