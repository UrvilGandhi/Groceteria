package com.example.groceteria.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.groceteria.R;

public class BenefitsFragment extends Fragment {
    private View view;
    private TextView txtDescription;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_benefits, container,
                false);
        initUI();
        return view;
    }

    private void initUI() {
        txtDescription = view.findViewById(R.id.txtDescription);
    }
}
