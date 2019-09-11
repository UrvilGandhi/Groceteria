package com.example.groceteria.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groceteria.Adapters.OfferAdapter;
import com.example.groceteria.Modal.Offers;
import com.example.groceteria.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {

    private View view;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container,
                false);
        initUI();
        return view;
    }

    private void initUI() {
        ImageView profImage = view.findViewById(R.id.profImage);
        Picasso.get().load(R.drawable.profile_pic).into(profImage);
    }
}
