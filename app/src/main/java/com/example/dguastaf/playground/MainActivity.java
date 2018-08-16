package com.example.dguastaf.playground;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.dguastaf.playground.Models.FeedItem;
import com.example.dguastaf.playground.ViewModels.FeedViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FeedViewModel feedViewModel = ViewModelProviders.of(this).get(FeedViewModel.class);
        feedViewModel.getFeed().observe(this, new Observer<List<FeedItem>>() {
            @Override
            public void onChanged(@Nullable List<FeedItem> feedItems) {
                Log.d(MainActivity.class.getCanonicalName(), String.valueOf(feedItems.size()));
            }
        });


    }
}
