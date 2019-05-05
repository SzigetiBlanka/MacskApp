package com.example.macskapp.ui.macsklist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.macskapp.R;
import com.example.macskapp.model.Cat;

import java.util.List;


class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private Context context;
    private List<Cat> catsList;

    public ListAdapter(Context context, List<Cat> catsList) {
        this.context = context;
        this.catsList = catsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_cat, parent, false);
        return new ViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Cat cat= catsList.get(position);

        CardView cardView = holder.itemView.findViewById(R.id.cardCat);

        if(cat == null){
            Log.v("errorCat", "no cat at pos: " + position);
        }


        if(cat != null && cat.getCatName() != null) {
            holder.catName.setText(cat.getCatName());
            holder.catCategory.setText(cat.getCategoryName());
            holder.catDesc.setText(cat.getDescription());
            holder.image.setImageURI(Uri.parse(cat.getUrl()));

        }else{
            holder.catName.setText("No cat");
            holder.catCategory.setText("");
            holder.catDesc.setText("");
        }
    }

    @Override
    public int getItemCount() {
        return catsList.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView catName;
        public TextView catCategory;
        public TextView catDesc;
        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            catName = itemView.findViewById(R.id.CatName);
            catCategory = itemView.findViewById(R.id.catCategory);
            catDesc = itemView.findViewById(R.id.catDesc);
            image = itemView.findViewById(R.id.catPicture);
            itemView.setOnClickListener( new View.OnClickListener(){

                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
