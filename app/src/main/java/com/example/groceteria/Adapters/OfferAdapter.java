package com.example.groceteria.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groceteria.Fragments.HomeFragment;
import com.example.groceteria.Modal.LastPurchase;
import com.example.groceteria.Modal.Offers;
import com.example.groceteria.R;
import com.like.LikeButton;
import com.squareup.picasso.Picasso;

import java.util.List;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.MyViewHolder> {

    private List<Offers> offerList;

    public OfferAdapter(Context homeFragment, List<Offers> offerList) {
        this.offerList = offerList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rcv_home_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Offers offer = offerList.get(position);

        holder.offerRate.setText(String.format("%d%%", offer.getDiscount()));
        Picasso.get().load(offer.getDrawable()).into(holder.prodImage);
        holder.prodName.setText(offer.getName());
        holder.currentRate.setText(String.format("Rs %d", offer.getCurrentPrice()));
        holder.previousRate.setText(String.valueOf(offer.getPreviousRate()));
        holder.previousRate.setPaintFlags(holder.previousRate.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        if (offer.isLiked()) {
            holder.btnLike.setLiked(true);
        } else {
            holder.btnLike.setLiked(false);
        }

    }

    @Override
    public int getItemCount() {
        return offerList.size();
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
