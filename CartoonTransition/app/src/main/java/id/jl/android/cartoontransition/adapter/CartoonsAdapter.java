package id.jl.android.cartoontransition.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import id.jl.android.cartoontransition.R;
import id.jl.android.cartoontransition.model.DataModel;

/**
 * Created by user on 11/18/16.
 */

public class CartoonsAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater = null;


    public CartoonsAdapter(Context con, String[] list) {
        this.context = con;
        DataModel.cartoons = list;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return DataModel.cartoons.length;
    }

    @Override
    public Object getItem(int i) {
        return DataModel.cartoons.length;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertview, ViewGroup viewGroup) {
        ViewHolder holder;
        if (convertview == null) {

            convertview = inflater.inflate(R.layout.card_item_template, null);
            holder = new ViewHolder();

            holder._cover = (ImageView) convertview.findViewById(R.id.img_cover_d);
            holder._background = (ImageView) convertview.findViewById(R.id.img_background);
            holder._cartoons = (TextView) convertview.findViewById(R.id.txt_cartoon_details);
            holder._plot = (TextView) convertview.findViewById(R.id.txt_plot_d);
            holder._releaseDate = (TextView) convertview.findViewById(R.id.txt_release_d);
            holder._vw_blayer = convertview.findViewById(R.id.vw_blacklayer);

            convertview.setTag(holder);

        } else {
            holder = (ViewHolder) convertview.getTag();
        }

        holder._cartoons.setText(DataModel.cartoons[i]);
        holder._plot.setText(DataModel.plot[i]);
        holder._releaseDate.setText("o " + DataModel.releaseDate[i]);
        //holder._cover.setImageResource(cover[i]);
        Picasso.with(context).load(DataModel.cover[i]).into(holder._cover);
        // holder._background.setImageResource(background[i]);
        Picasso.with(context).load(DataModel.background[i]).into(holder._background);

        ObjectAnimator fade = ObjectAnimator.ofFloat(holder._vw_blayer, View.ALPHA, 1f, .3f);
        fade.setDuration(1500);
        fade.setInterpolator(new LinearInterpolator());
        fade.start();

        return convertview;
    }

    public class ViewHolder {
        ImageView _cover;
        ImageView _background;
        TextView _cartoons;
        TextView _plot;
        TextView _releaseDate;
        View _vw_blayer;
    }
}
