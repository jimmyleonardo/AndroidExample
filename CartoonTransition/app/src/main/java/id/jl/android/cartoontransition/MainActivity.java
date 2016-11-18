package id.jl.android.cartoontransition;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import id.jl.android.cartoontransition.adapter.CartoonsAdapter;
import id.jl.android.cartoontransition.model.DataModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = (ListView) findViewById(R.id.listView);
        CartoonsAdapter adapter = new CartoonsAdapter(MainActivity.this, DataModel.cartoons);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                View imageView = (ImageView) view.findViewById(R.id.img_cover_d);

                //We are passing Bundle to activity, these lines will animate when we laucnh activity
                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                        Pair.create(imageView, "selectedThumbCartoon"),
                        Pair.create(view,"selectedCartoon")
                ).toBundle();

                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("bg",DataModel.background[i]);
                intent.putExtra("cover",DataModel.cover[i]);
                intent.putExtra("title",DataModel.cartoons[i]);
                intent.putExtra("plot",DataModel.plot[i]);
                startActivity(intent,bundle);

            }
        });
    }
}
