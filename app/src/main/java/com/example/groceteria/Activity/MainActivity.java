package com.example.groceteria.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groceteria.Adapters.DrawerAdapter;
import com.example.groceteria.Constants.BaseActivity;
import com.example.groceteria.Fragments.FavouritesFragment;
import com.example.groceteria.Fragments.HomeFragment;
import com.example.groceteria.Fragments.OfferFragment;
import com.example.groceteria.Fragments.ProfileFragment;
import com.example.groceteria.Modal.DrawerItem;
import com.example.groceteria.Modal.SimpleItem;
import com.example.groceteria.R;
import com.gauravk.bubblenavigation.BubbleNavigationConstraintView;
import com.gauravk.bubblenavigation.listener.BubbleNavigationChangeListener;
import com.yarolegovich.slidingrootnav.SlidingRootNav;

import java.util.Arrays;

public
class MainActivity extends BaseActivity implements
        DrawerAdapter.OnItemSelectedListener {
    // Drawer
    private static final int POS_home = 0;
    private static final int POS_orders = 1;
    private static final int POS_favourites = 2;
    private static final int POS_cart = 3;
    private static final int POS_wallet = 4;
    private static final int POS_discounts = 5;
    private static final int POS_notifications = 6;
    private static final int POS_rate_us = 7;
    private static final int POS_terms_conditions = 8;
    private static final int POS_help_support = 9;
    private static final int POS_settings = 10;

    public static SlidingRootNav slidingRootNav;
    private Fragment fr = null;
    private Toolbar toolbar;
    private String[] screenTitles;
    private Drawable[] screenIcons;
    private TextView tv_title;

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
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_home);

        initUI();

        com.yarolegovich.slidingrootnav.SlidingRootNavBuilder slidingRootNavBuilder = new com.yarolegovich.slidingrootnav.SlidingRootNavBuilder(this);
        slidingRootNav = slidingRootNavBuilder.withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withDragDistance(150)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.menu_left_drawer)
                .inject();
        toolbar.setNavigationIcon(R.drawable.menu);

        setMenu();
    }

    private void initUI() {
        toolbar = findViewById(R.id.actionbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        tv_title = toolbar.findViewById(R.id.tv_title);
        ImageView btnSearch = toolbar.findViewById(R.id.search);
        fr = new HomeFragment();
        FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fr);
        fragmentTransaction.commit();
        BubbleNavigationConstraintView bubbleNavigation = findViewById(R.id.top_navigation_constraint);

        bubbleNavigation.setNavigationChangeListener(new BubbleNavigationChangeListener() {
            @Override
            public void onNavigationChanged(View view, int position) {
                if (position == 0) {
                    fr = new HomeFragment();
                    FragmentTransaction fragmentTransaction =
                            getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.container, fr);
                    fragmentTransaction.commit();
                    tv_title.setText("Groceteria");
                } else if (position == 2) {
                    fr = new OfferFragment();
                    FragmentTransaction fragmentTransaction =
                            getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.container, fr);
                    fragmentTransaction.commit();
                    tv_title.setText("Offers");
                } else if (position == 1) {
                    fr = new FavouritesFragment();
                    FragmentTransaction fragmentTransaction =
                            getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.container, fr);
                    fragmentTransaction.commit();
                    tv_title.setText("Favourites");
                } else if (position == 3) {
                    fr = new ProfileFragment();
                    FragmentTransaction fragmentTransaction =
                            getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.container, fr);
                    fragmentTransaction.commit();
                    tv_title.setText("Profile");
                }
            }
        });

//        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container);
//        if (fragment instanceof HomeFragment) {
//            bubbleNavigation.setCurrentActiveItem(0);
//        } else if (fragment instanceof OfferFragment) {
//            bubbleNavigation.setCurrentActiveItem(2);
//        } else if (fragment instanceof FavouritesFragment) {
//            bubbleNavigation.setCurrentActiveItem(1);
//        } else if (fragment instanceof ProfileFragment) {
//            bubbleNavigation.setCurrentActiveItem(3);
//        }

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SearchActivity.class));
            }
        });
    }

    public void setMenu() {
        screenIcons = loadScreenIcons();
        screenTitles = loadScreenTitles();

        DrawerAdapter adapter = new DrawerAdapter(Arrays.asList(
                createItemFor(POS_home),
                createItemFor(POS_orders),
                createItemFor(POS_favourites),
                createItemFor(POS_cart),
                createItemFor(POS_wallet),
                createItemFor(POS_discounts),
                createItemFor(POS_notifications),
                createItemFor(POS_rate_us),
                createItemFor(POS_terms_conditions),
                createItemFor(POS_help_support),
                createItemFor(POS_settings)));
        adapter.setListener(this);

        RecyclerView list = findViewById(R.id.list);
        list.setNestedScrollingEnabled(false);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);
    }

    private DrawerItem createItemFor(int position) {
        return new SimpleItem(screenIcons[position], screenTitles[position])
                .withIconTint(color(R.color.yellow))
                .withTextTint(color(R.color.green))
                .withSelectedIconTint(color(R.color.green))
                .withSelectedTextTint(color(R.color.yellow));
    }

    @ColorInt
    private int color(@ColorRes int res) {
        return ContextCompat.getColor(this, res);
    }

    private String[] loadScreenTitles() {
        return getResources().getStringArray(R.array.ld_activityScreenTitles);
    }

    private Drawable[] loadScreenIcons() {
        TypedArray ta = getResources().obtainTypedArray(R.array.ld_activityScreenIcons);
        Drawable[] icons = new Drawable[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            int id = ta.getResourceId(i, 0);
            if (id != 0) {
                icons[i] = ContextCompat.getDrawable(this, id);
            }
        }
        ta.recycle();
        return icons;
    }

    @Override
    public void onItemSelected(int position) {
        if (position == POS_home) {
            fr = new HomeFragment();
            FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, fr);
            fragmentTransaction.commit();
            tv_title.setText("Groceteria");
        } else if (position == POS_discounts) {
            fr = new OfferFragment();
            FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, fr);
            fragmentTransaction.commit();
            tv_title.setText("Offers");
        } else if (position == POS_favourites) {
            fr = new FavouritesFragment();
            FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, fr);
            fragmentTransaction.commit();
            tv_title.setText("Favourites");
        }
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        immersiveMode();
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(visibility -> immersiveMode());
    }

    private void immersiveMode() {
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION

                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }

    }


}

