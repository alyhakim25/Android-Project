package com.example.mymoviewatchlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity{

    private ArrayList<HelperActivity1> list;
    public static RecyclerView watchListView;

    String[] watchList = {
            "On Going",
            "Up Coming",
            "Done",
            "Action",
            "US Region"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        watchListView = (RecyclerView) findViewById(R.id.watchList);

    }

    @Override
    protected void onStart() {
        super.onStart();
        list = new ArrayList<HelperActivity1>();
        for(int i = 0; i < watchList.length; i++)
        {
            HelperActivity1 helperActivity1 = new HelperActivity1(watchList[i]);
            list.add(helperActivity1);
        }
        AdapterClass_WatchList adapterClass_watchList = new AdapterClass_WatchList(list, MainActivity.this);
        watchListView.setAdapter(adapterClass_watchList);
    }

}