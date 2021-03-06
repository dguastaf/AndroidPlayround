package com.example.dguastaf.playground.Networking;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.dguastaf.playground.Models.FeedItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FeedDataManager {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private final FeedApiInterface feedApi;

    public FeedDataManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        feedApi = retrofit.create(FeedApiInterface.class);
    }

    public LiveData<List<FeedItem>> getFeed() {

        final MutableLiveData<List<FeedItem>> liveData = new MutableLiveData<>();

        feedApi.getFeedItems().enqueue(new Callback<List<FeedItem>>() {
            @Override
            public void onResponse(Call<List<FeedItem>> call, Response<List<FeedItem>> response) {
                // Write to DB, cache, etc
                liveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<FeedItem>> call, Throwable t) {
                Log.e(FeedDataManager.class.getSimpleName(), t.toString());
            }
        });

        return liveData;
    }
}

