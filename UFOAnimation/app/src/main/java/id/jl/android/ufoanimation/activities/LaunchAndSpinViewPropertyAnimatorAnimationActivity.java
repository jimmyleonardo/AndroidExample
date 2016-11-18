package id.jl.android.ufoanimation.activities;

/**
 * Created by user on 11/18/16.
 */

public class LaunchAndSpinViewPropertyAnimatorAnimationActivity extends BaseAnimationActivity {
    @Override
    protected void onStartAnimation() {
        mUFO.animate().translationY(-mScreenHeight)
                .rotationBy(360f)
                .setDuration(DEFAULT_ANIMATION_DURATION)
                .start();
    }
}
