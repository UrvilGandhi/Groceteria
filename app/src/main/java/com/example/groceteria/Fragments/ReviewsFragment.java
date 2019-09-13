package com.example.groceteria.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groceteria.Adapters.ReviewsAdapter;
import com.example.groceteria.R;

public class ReviewsFragment extends Fragment {
    private View view;
    private RecyclerView rcv_reviews;

    private int[] reviewList = {1,2,3,4,5};

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_reviews, container,
                false);
        initUI();
        return view;
    }

    private void initUI() {
        rcv_reviews = view.findViewById(R.id.rcv_reviews);
        rcv_reviews.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        rcv_reviews.setAdapter(new ReviewsAdapter(getContext(),reviewList));
        rcv_reviews.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
    }
}
