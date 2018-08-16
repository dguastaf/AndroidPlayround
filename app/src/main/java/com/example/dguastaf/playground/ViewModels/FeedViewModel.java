package com.example.dguastaf.playground.ViewModels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.dguastaf.playground.Models.FeedItem;
import com.example.dguastaf.playground.Networking.FeedDataManager;

import java.util.List;

public class FeedViewModel extends ViewModel {

    private final FeedDataManager feedDataManager;
    private LiveData<List<FeedItem>> feedItems;


    public FeedViewModel() {
        feedDataManager = new FeedDataManager();
        feedItems = feedDataManager.getFeed();
    }

    public LiveData<List<FeedItem>> getFeed() {
        return feedItems;
    }

}
