package com.example.groceteria.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groceteria.Adapters.CategoryAdapter;
import com.example.groceteria.Adapters.LastPurchaseAdapter;
import com.example.groceteria.Adapters.OfferAdapter;
import com.example.groceteria.Modal.Categories;
import com.example.groceteria.Modal.LastPurchase;
import com.example.groceteria.Modal.Offers;
import com.example.groceteria.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private View view;
    private AutoCompleteTextView searchBar;
    private RecyclerView rcv_LastPurchase, rcv_Categories, rcv_Offers;
    private List<LastPurchase> lpList = new ArrayList<>();
    private List<Categories> categoryList = new ArrayList<>();
    private List<Offers> offerList = new ArrayList<>();


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home_page, container,
                false);
        initUI();
        return view;
    }

    private void initUI() {
        searchBar = view.findViewById(R.id.searchbar);
        rcv_LastPurchase = view.findViewById(R.id.rcv_lp);
        rcv_Categories = view.findViewById(R.id.rcv_cat);
        rcv_Offers = view.findViewById(R.id.rcv_offers);


        lpList.add(new LastPurchase(R.drawable.apples, 38, false, "Apple", "1 kg", 80, 50));
        lpList.add(new LastPurchase(R.drawable.aashirwaad_atta, 30, true, "Aashirwad Atta", "5 kg", 215, 151));
        lpList.add(new LastPurchase(R.drawable.aerial, 16, false, "Aerial Detergent Top load", "2 kg", 395, 332));
        lpList.add(new LastPurchase(R.drawable.bourbon_orginal, 10, true, "Bourbon Biscuits", "80 grams", 25, 23));
        lpList.add(new LastPurchase(R.drawable.bournvita_biscuit, 10, false, "Bournvita Biscuits", "80 gms", 25, 23));
        lpList.add(new LastPurchase(R.drawable.dettol, 22, true, "Dettol Smooth Bathing Soaps", "5*175gm", 150, 117));
        lpList.add(new LastPurchase(R.drawable.dove, 18, false, "Dove Moisturing Soap", "115 gms", 80, 66));
        lpList.add(new LastPurchase(R.drawable.maggi, 5, true, "Maggi Masala Noodles", "80 gms", 14, 13));
        lpList.add(new LastPurchase(R.drawable.surf_excel, 39, false, "Surf Excel Quick Wash", "1 kg", 232, 141));

        rcv_LastPurchase.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rcv_LastPurchase.setAdapter(new LastPurchaseAdapter(getContext(), lpList));

        categoryList.add(new Categories(R.drawable.vegetables, "Vegetables"));
        categoryList.add(new Categories(R.drawable.fruits, "Fruits"));
        categoryList.add(new Categories(R.drawable.edible_oils, "Edible Oils"));
        categoryList.add(new Categories(R.drawable.bakery, "Bakery Products"));
        categoryList.add(new Categories(R.drawable.dairy_products, "Dairy Products"));
        categoryList.add(new Categories(R.drawable.pulses, "Pulses"));
        categoryList.add(new Categories(R.drawable.grains, "Grains"));

        rcv_Categories.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rcv_Categories.setAdapter(new CategoryAdapter(getContext(), categoryList));

        offerList.add(new Offers(R.drawable.apples, 38, false, "Apple", "1 kg", 80, 50));
        offerList.add(new Offers(R.drawable.aashirwaad_atta, 30, true, "Aashirwad Atta", "5 kg", 215, 151));
        offerList.add(new Offers(R.drawable.aerial, 16, false, "Aerial Detergent Top load", "2 kg", 395, 332));
        offerList.add(new Offers(R.drawable.bourbon_orginal, 10, true, "Bourbon Biscuits", "80 grams", 25, 23));
        offerList.add(new Offers(R.drawable.bournvita_biscuit, 10, false, "Bournvita Biscuits", "80 gms", 25, 23));
        offerList.add(new Offers(R.drawable.dettol, 22, true, "Dettol Smooth Bathing Soaps", "5*175gm", 150, 117));
        offerList.add(new Offers(R.drawable.dove, 18, false, "Dove Moisturing Soap", "115 gms", 80, 66));
        offerList.add(new Offers(R.drawable.maggi, 5, true, "Maggi Masala Noodles", "80 gms", 14, 13));
        offerList.add(new Offers(R.drawable.surf_excel, 39, false, "Surf Excel Quick Wash", "1 kg", 232, 141));

        rcv_Offers.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rcv_Offers.setAdapter(new OfferAdapter(getContext(), offerList));

    }
}