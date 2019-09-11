package com.example.groceteria.Activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.widget.SearchView;

import com.example.groceteria.Constants.BaseActivity;
import com.example.groceteria.Extras.DatabaseHelper;
import com.example.groceteria.R;

public class SearchActivity extends BaseActivity implements SearchView.OnQueryTextListener{

    private ListView list;
    private DatabaseHelper localDb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        list = findViewById(R.id.listview);
        SearchView editsearch = findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);
        localDb = new DatabaseHelper(this);


    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        localDb.seachData(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        localDb.seachData(newText);
        return false;
    }
}
