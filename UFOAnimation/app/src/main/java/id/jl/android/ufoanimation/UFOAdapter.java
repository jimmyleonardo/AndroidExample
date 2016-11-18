package id.jl.android.ufoanimation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.List;

/**
 * Created by user on 11/18/16.
 */


public class UFOAdapter extends RecyclerView.Adapter<UFOAdapter.UFOViewHolder> {

    private final List<UFOAnimationItem> mItems;
    private final Context mContext;

    public UFOAdapter(Context context, List<UFOAnimationItem> items) {
        super();
        mContext = context;
        mItems = items;
    }

    @Override
    public UFOViewHolder onCreateViewHolder(android.view.ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new UFOViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UFOAdapter.UFOViewHolder holder, int position) {
        holder.mTitle.setText(mItems.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }

    class UFOViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        public final TextView mTitle;

        public UFOViewHolder(android.view.View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(android.R.id.text1);
            mTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContext.startActivity(mItems.get(getAdapterPosition()).getIntent());
                }
            });
        }
    }
}

