package com.example.groceteria.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groceteria.R;
import com.like.LikeButton;
import com.squareup.picasso.Picasso;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.MyViewHolder> {

    private Context context;
    private int[] reviewList;

    public ReviewsAdapter(Context context, int[] reviewList) {
        this.context = context;
        this.reviewList = reviewList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.review_list_item, null);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Picasso.get().load(R.drawable.profile_pic).into(holder.personImage);
        holder.personName.setText("Natasha Romanoff");
        holder.reviewDate.setText("16/07/2019");
        holder.reviewDescription.setText("This is a great Apple; I like them best in pies, especially Apple Betty pies. they are a little tart so if using them for sauce, I always needed to add sweetener. I like to peel and dice them and then dip them in lemon juice and freeze them, then all set for making pies!");
        holder.reviewRating.setRating(4.8f);
    }

    @Override
    public int getItemCount() {
        return reviewList.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView personImage;
        TextView personName, reviewDate, reviewDescription;
        RatingBar reviewRating;


        MyViewHolder(View view) {
            super(view);
            personImage = view.findViewById(R.id.personImage);
            personName = view.findViewById(R.id.txtPersonName);
            reviewDate = view.findViewById(R.id.txtDate);
            reviewDescription = view.findViewById(R.id.txtReview);
            reviewRating = view.findViewById(R.id.reviewRate);
        }
    }
}
