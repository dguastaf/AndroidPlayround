package com.example.dguastaf.playground.ViewModels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.dguastaf.playground.Adapters.FeedAdapter;
import com.example.dguastaf.playground.Listeners.OnFeedItemClickListener;
import com.example.dguastaf.playground.Models.FeedItem;
import com.example.dguastaf.playground.Networking.FeedDataManager;

import java.util.List;

public class FeedViewModel extends ViewModel implements OnFeedItemClickListener {

    private LiveData<List<FeedItem>> feedItems;
    private MutableLiveData<Integer> selectedFeedItemIdx;


    public FeedViewModel() {
        FeedDataManager feedDataManager = new FeedDataManager();
        feedItems = feedDataManager.getFeed();
        selectedFeedItemIdx = new MutableLiveData<>();
        selectedFeedItemIdx.setValue(0);
    }

    public LiveData<List<FeedItem>> getFeed() {
        return feedItems;
    }

    public LiveData<Integer> getSelectedFeedItemIdx() {
        return selectedFeedItemIdx;
    }

    @Override
    public void onFeedItemClicked(int index) {
        selectedFeedItemIdx.setValue(index);
    }
}
