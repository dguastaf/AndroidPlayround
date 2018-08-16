package com.example.dguastaf.playground.Networking;

import com.example.dguastaf.playground.Models.FeedItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FeedApiInterface {
    @GET("posts")
    Call<List<FeedItem>> getFeedItems();
}
