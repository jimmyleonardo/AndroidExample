package id.jl.android.ufoanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.jl.android.ufoanimation.activities.AccelerateUFOAnimationActivity;
import id.jl.android.ufoanimation.activities.ColorAnimationActivity;
import id.jl.android.ufoanimation.activities.FlyThereAndBackAnimationActivity;
import id.jl.android.ufoanimation.activities.FlyWithAlienAnimationActivity;
import id.jl.android.ufoanimation.activities.LaunchAndSpinAnimatorSetAnimatorActivity;
import id.jl.android.ufoanimation.activities.LaunchAndSpinViewPropertyAnimatorAnimationActivity;
import id.jl.android.ufoanimation.activities.LaunchUFOObjectAnimatorAnimationActivity;
import id.jl.android.ufoanimation.activities.LaunchUFOValueAnimatorAnimationActivity;
import id.jl.android.ufoanimation.activities.NoAnimationActivity;
import id.jl.android.ufoanimation.activities.RotateUFOAnimationActivity;
import id.jl.android.ufoanimation.activities.WithListenerAnimationActivity;
import id.jl.android.ufoanimation.activities.XmlAnimationActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        List<UFOAnimationItem> items = new ArrayList<>();

        items.add(new UFOAnimationItem(getString(R.string.title_no_animation),
                new Intent(this, NoAnimationActivity.class)));

        items.add(new UFOAnimationItem(getString(R.string.title_launch_ufo),
                new Intent(this, LaunchUFOValueAnimatorAnimationActivity.class)));

        items.add(new UFOAnimationItem(getString(R.string.title_spin_ufo),
                new Intent(this, RotateUFOAnimationActivity.class)));

        items.add(new UFOAnimationItem(getString(R.string.title_accelerate_ufo),
                new Intent(this, AccelerateUFOAnimationActivity.class)));

        items.add(new UFOAnimationItem(getString(R.string.title_launch_ufo_objectanimator),
                new Intent(this, LaunchUFOObjectAnimatorAnimationActivity.class)));

        items.add(new UFOAnimationItem(getString(R.string.title_color_animation),
                new Intent(this, ColorAnimationActivity.class)));

        items.add(new UFOAnimationItem(getString(R.string.launch_spin),
                new Intent(this, LaunchAndSpinAnimatorSetAnimatorActivity.class)));

        items.add(new UFOAnimationItem(getString(R.string.launch_spin_viewpropertyanimator),
                new Intent(this, LaunchAndSpinViewPropertyAnimatorAnimationActivity.class)));

        items.add(new UFOAnimationItem(getString(R.string.title_with_alien),
                new Intent(this, FlyWithAlienAnimationActivity.class)));

        items.add(new UFOAnimationItem(getString(R.string.title_animation_events),
                new Intent(this, WithListenerAnimationActivity.class)));

        items.add(new UFOAnimationItem(getString(R.string.title_there_and_back),
                new Intent(this, FlyThereAndBackAnimationActivity.class)));

        items.add(new UFOAnimationItem(getString(R.string.title_jump_and_blink),
                new Intent(this, XmlAnimationActivity.class)));

        recyclerView.setAdapter(new UFOAdapter(this, items));
    }
}
