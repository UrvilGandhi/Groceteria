package com.example.groceteria.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.widget.TextView;

import com.example.groceteria.R;
import com.google.android.material.navigation.NavigationView;

public class HomePageActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView toolbar_title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        toolbar = findViewById(R.id.toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        toolbar_title = toolbar.findViewById(R.id.toolbar_title);
        NavigationView navigationView = findViewById(R.id.nav_view);

    }
}
