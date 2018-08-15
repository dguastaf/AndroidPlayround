package com.example.dguastaf.playground;

import android.arch.lifecycle.ViewModel;

import com.example.dguastaf.playground.Models.User;

public class MainViewModel extends ViewModel {
    private User user;

    public MainViewModel() {
        user = new User("Doug");
    }

    public User getUser() {
        return user;
    }
}
