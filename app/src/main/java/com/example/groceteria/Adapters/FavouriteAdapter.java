package com.example.groceteria.Adapters;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groceteria.Modal.Favourites;
import com.example.groceteria.Modal.Offers;
import com.example.groceteria.R;
import com.like.LikeButton;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.MyViewHolder> {

    private Context context;
    private List<Favourites>favouritesList;

    public FavouriteAdapter(Context context, List<Favourites> favouritesList) {

        this.context = context;
        this.favouritesList = favouritesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rcv_home_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Favourites favourites = favouritesList.get(position);

        holder.offerRate.setText(String.format("%d%%", favourites.getDiscount()));
        Picasso.get().load(favourites.getDrawable()).into(holder.prodImage);
        holder.prodName.setText(favourites.getName());
        holder.currentRate.setText(String.format("Rs %d", favourites.getCurrentPrice()));
        holder.previousRate.setText(String.valueOf(favourites.getPreviousRate()));
        holder.previousRate.setPaintFlags(holder.previousRate.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        if (favourites.isLiked()) {
            holder.btnLike.setLiked(true);
        } else {
            holder.btnLike.setLiked(false);
        }
    }

    @Override
    public int getItemCount() {
        return favouritesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView prodImage;
        TextView prodName, offerRate, previousRate, currentRate;
        LikeButton btnLike;
        Button btnAdd;


        public MyViewHolder(View view) {
            super(view);
            prodImage = view.findViewById(R.id.prodImage);
            prodName = view.findViewById(R.id.prodName);
            offerRate = view.findViewById(R.id.offer);
            previousRate = view.findViewById(R.id.previousRate);
            currentRate = view.findViewById(R.id.currentRate);
            btnLike = view.findViewById(R.id.btnLike);
            btnAdd = view.findViewById(R.id.btnAdd);
        }
    }
}
