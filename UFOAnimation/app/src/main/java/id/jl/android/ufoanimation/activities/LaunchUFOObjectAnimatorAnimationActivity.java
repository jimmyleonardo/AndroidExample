package id.jl.android.ufoanimation.activities;

import android.animation.ObjectAnimator;

/**
 * Created by user on 11/18/16.
 */

public class LaunchUFOObjectAnimatorAnimationActivity extends BaseAnimationActivity {
    @Override
    protected void onStartAnimation() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mUFO, "translationY",
                0, -mScreenHeight);
        objectAnimator.setDuration(DEFAULT_ANIMATION_DURATION);
        objectAnimator.start();
    }
}
