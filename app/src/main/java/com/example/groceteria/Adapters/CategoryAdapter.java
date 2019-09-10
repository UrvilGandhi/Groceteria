package com.example.groceteria.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groceteria.Modal.Categories;
import com.example.groceteria.R;
import com.like.LikeButton;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private Context mContext;
    private List<Categories> categoriesList;

    public CategoryAdapter(Context context, List<Categories> categoryList) {
        this.mContext = context;
        this.categoriesList = categoryList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rcv_category_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Categories categories = categoriesList.get(position);

        holder.catName.setText(categories.getProdName());
        Picasso.get().load(categories.getDrawable()).into(holder.catImage);
//        holder.btnAdd.setVisibility(View.GONE);
//        holder.btnLike.setVisibility(View.GONE);
//        holder.currentRate.setVisibility(View.GONE);
//        holder.offerRate.setVisibility(View.GONE);
//        holder.previousRate.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView catImage;
        TextView catName;


        MyViewHolder(View view) {
            super(view);
            catImage = view.findViewById(R.id.catImage);
            catName = view.findViewById(R.id.catName);
        }
    }
}
