package com.example.groceteria.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groceteria.Adapters.OfferAdapter;
import com.example.groceteria.Constants.BaseActivity;
import com.example.groceteria.Modal.Offers;
import com.example.groceteria.R;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends BaseActivity {

    List<Offers> offerList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
                | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_order);

        initUI();


    }

    private void initUI() {
        Toolbar toolbar = findViewById(R.id.actionbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        toolbar.setNavigationIcon(R.drawable.back);
        TextView tv_title = toolbar.findViewById(R.id.tv_title);
        tv_title.setText("Offers");

        offerList.add(new Offers(R.drawable.apples, 38, false, "Apple", "1 kg", 80, 50));
        offerList.add(new Offers(R.drawable.aashirwaad_atta, 30, true, "Aashirwad Atta", "5 kg", 215, 151));
        offerList.add(new Offers(R.drawable.aerial, 16, false, "Aerial Detergent Top load", "2 kg", 395, 332));
        offerList.add(new Offers(R.drawable.bourbon_orginal, 10, true, "Bourbon Biscuits", "80 grams", 25, 23));
        offerList.add(new Offers(R.drawable.bournvita_biscuit, 10, false, "Bournvita Biscuits", "80 gms", 25, 23));
        offerList.add(new Offers(R.drawable.dettol, 22, true, "Dettol Smooth Bathing Soaps", "5*175gm", 150, 117));
        offerList.add(new Offers(R.drawable.dove, 18, false, "Dove Moisturing Soap", "115 gms", 80, 66));
        offerList.add(new Offers(R.drawable.maggi, 5, true, "Maggi Masala Noodles", "80 gms", 14, 13));
        offerList.add(new Offers(R.drawable.surf_excel, 39, false, "Surf Excel Quick Wash", "1 kg", 232, 141));

        RecyclerView rcv_offers = findViewById(R.id.rcv_offers);
        rcv_offers.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2, LinearLayoutManager.VERTICAL, false));
        rcv_offers.setAdapter(new OfferAdapter(getApplicationContext(), offerList));

    }
}
