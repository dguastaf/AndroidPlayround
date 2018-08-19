package com.example.dguastaf.playground.ViewModels;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.example.dguastaf.playground.Models.FeedItem;

public class FeedItemViewModel extends ViewModel {

    private FeedItem feedItem;

    public FeedItemViewModel(@NonNull FeedItem feedItem) {
        this.feedItem = feedItem;
    }

    public String getTitle() {
        return feedItem.getTitle();
    }
}
