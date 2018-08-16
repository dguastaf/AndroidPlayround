package com.example.dguastaf.playground;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.dguastaf.playground.Models.FeedItem;
import com.example.dguastaf.playground.Networking.FeedDataManager;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
//
//        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        binding.setMainViewModel(mainViewModel);

        FeedDataManager feedDataManager = new FeedDataManager();

        feedDataManager.getFeed(new FeedDataManager.FeedDataManagerCallback<List<FeedItem>>() {
            @Override
            public void onCompletion(List<FeedItem> data) {
                Log.d(MainActivity.class.getCanonicalName(), String.valueOf(data.size()));
            }
        });
    }
}
