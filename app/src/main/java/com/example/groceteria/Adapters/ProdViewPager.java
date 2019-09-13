package com.example.groceteria.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.groceteria.Activity.ProdDetailsActivity;
import com.example.groceteria.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProdViewPager extends PagerAdapter{
    Context context;
    List<Integer>bannerList;
    LayoutInflater layoutInflater;


    public ProdViewPager(Context context, List<Integer>bannerList) {
        this.context = context;
        this.bannerList = bannerList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return bannerList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = layoutInflater.inflate(R.layout.detail_viewpager, container, false);

        ImageView imageView = itemView.findViewById(R.id.imageView);
        imageView.setImageResource(bannerList.get(position));

        container.addView(itemView);

        //listening to image click
        imageView.setOnClickListener(v -> Toast.makeText(context, "you clicked image " + (position + 1), Toast.LENGTH_LONG).show());

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}