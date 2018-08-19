package com.example.dguastaf.playground;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.dguastaf.playground.Adapters.FeedAdapter;
import com.example.dguastaf.playground.Models.FeedItem;
import com.example.dguastaf.playground.ViewModels.FeedViewModel;
import com.example.dguastaf.playground.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FeedViewModel feedViewModel = ViewModelProviders.of(this).get(FeedViewModel.class);

        FeedAdapter feedAdapter = new FeedAdapter(this, feedViewModel);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setVariable(BR.myadapter, feedAdapter);
        feedViewModel.getSelectedFeedItemIdx().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                Log.d(getLocalClassName(), "Selected " + integer);
            }
        });
    }
}
