package id.jl.android.ufoanimation;

import android.content.Intent;

/**
 * Created by user on 11/18/16.
 */

public class UFOAnimationItem {
    private final String mTitle;
    private final Intent mIntent;

    public UFOAnimationItem(String title, android.content.Intent intent) {
        mTitle = title;
        mIntent = intent;
    }

    public android.content.Intent getIntent() {
        return mIntent;
    }

    public String getTitle() {
        return mTitle;
    }
}

