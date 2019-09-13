package com.example.groceteria.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.groceteria.Adapters.ProdViewPager;
import com.example.groceteria.Adapters.ViewPagerAdapter;
import com.example.groceteria.Constants.BaseActivity;
import com.example.groceteria.Fragments.BenefitsFragment;
import com.example.groceteria.Fragments.DescriptionFragment;
import com.example.groceteria.Fragments.FeaturesFragment;
import com.example.groceteria.Fragments.ReviewsFragment;
import com.example.groceteria.R;
import com.google.android.material.tabs.TabLayout;
import com.like.LikeButton;
import com.like.OnLikeListener;
import com.travijuu.numberpicker.library.NumberPicker;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class ProdDetailsActivity extends BaseActivity {

    private ViewPager vpProdImage, vpProdDetails;
    private Toolbar toolbar;
    private LikeButton btnLike;
    private TextView prodName, prodRate, prodPreviousRate, prodRating, txtDisplay,tv_title;
    private TabLayout tabProdDetails;
    private Button btnBuyNow, btnAddtoCart, btnIncrement, btnDecrement;
    private ProdViewPager prodViewPager;
    private RelativeLayout relativeLayout;

    private List<Integer> imageList = new ArrayList<>();
    private int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prod_details);

        toolbar = findViewById(R.id.actionbar);
        tv_title = toolbar.findViewById(R.id.tv_title);
        btnLike = findViewById(R.id.btnLike);
        prodName = findViewById(R.id.prodName);
        prodRate = findViewById(R.id.txtprodRate);
        prodPreviousRate = findViewById(R.id.txtPreviousRate);
        btnBuyNow = findViewById(R.id.btnBuyNow);
        btnAddtoCart = findViewById(R.id.btnAddtoCart);
        txtDisplay = findViewById(R.id.display);
        btnIncrement = findViewById(R.id.increment);
        btnDecrement = findViewById(R.id.decrement);
        relativeLayout = findViewById(R.id.relativeLayout);
        vpProdImage = findViewById(R.id.vpProdImage);

        imageList.add(R.drawable.gapples);
        imageList.add(R.drawable.grapples);
        imageList.add(R.drawable.green);

        if (toolbar != null){
            setSupportActionBar(toolbar);
            tv_title.setText("Details");
            toolbar.setNavigationIcon(R.drawable.back);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }

        prodViewPager = new ProdViewPager(this, imageList);
        vpProdImage.setAdapter(prodViewPager);

        CirclePageIndicator circlePageIndicator = findViewById(R.id.titles);
        if (vpProdImage != null && circlePageIndicator != null) {
            vpProdImage.setAdapter(prodViewPager);
            circlePageIndicator.setViewPager(vpProdImage);
        }

        btnLike.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                btnLike.setLiked(true);
            }

            @Override
            public void unLiked(LikeButton likeButton) {
                btnLike.setLiked(false);
            }
        });

        prodName.setText("Green Apples (1 kg)");
        prodRate.setText("Rs. 25");
        prodPreviousRate.setText("40");
        prodPreviousRate.setPaintFlags(prodPreviousRate.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        vpProdDetails = findViewById(R.id.vpProdDetails);
        setupViewPager(vpProdDetails);


        tabProdDetails = findViewById(R.id.tabProdDetails);
        tabProdDetails.setupWithViewPager(vpProdDetails);

        txtDisplay.setText(String.valueOf(count));
        btnIncrement.setOnClickListener(v -> {
            count++;
            txtDisplay.setText(String.valueOf(count));
        });

        btnDecrement.setOnClickListener(v -> {
            if (count > 0) {
                count--;
                txtDisplay.setText(String.valueOf(count));
            }
        });


    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new DescriptionFragment(), "Description");
        adapter.addFrag(new ReviewsFragment(), "Reviews");
        adapter.addFrag(new BenefitsFragment(), "Benefits");
        viewPager.setAdapter(adapter);
    }
}
