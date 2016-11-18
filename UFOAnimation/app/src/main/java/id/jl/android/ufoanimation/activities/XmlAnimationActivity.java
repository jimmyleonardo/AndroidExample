package id.jl.android.ufoanimation.activities;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;

import id.jl.android.ufoanimation.R;

/**
 * Created by user on 11/18/16.
 */

public class XmlAnimationActivity extends BaseAnimationActivity {
    @Override
    protected void onStartAnimation() {
        AnimatorSet UFOAnimatorSet =
                (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.jump_and_blink);
        UFOAnimatorSet.setTarget(mUFO);

        AnimatorSet alienAnimatorSet =
                (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.jump_and_blink);
        alienAnimatorSet.setTarget(mAlien);

        AnimatorSet bothAnimatorSet = new AnimatorSet();
        bothAnimatorSet.playTogether(UFOAnimatorSet, alienAnimatorSet);
        // 6
        bothAnimatorSet.setDuration(DEFAULT_ANIMATION_DURATION);
        bothAnimatorSet.start();
    }
}
