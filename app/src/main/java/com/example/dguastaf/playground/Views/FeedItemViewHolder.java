package com.example.dguastaf.playground.Views;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.dguastaf.playground.Listeners.OnFeedItemClickListener;
import com.example.dguastaf.playground.Models.FeedItem;
import com.example.dguastaf.playground.databinding.FeedItemBinding;

import org.w3c.dom.Text;

public class FeedItemViewHolder extends RecyclerView.ViewHolder {
    private final OnFeedItemClickListener listener;
    private FeedItemBinding binding;

    public FeedItemViewHolder(@NonNull FeedItemBinding binding, OnFeedItemClickListener listener) {
        super(binding.getRoot());
        this.binding = binding;
        this.listener = listener;
    }

    public void bind(FeedItem item, final int index) {
        binding.feedItemTitle.setText(item.getTitle());
        binding.feedItemContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onFeedItemClicked(index);
            }
        });

        // This forces the bindings to run immediately instead of delaying them until the next frame.
        // RecyclerView will measure the view immediately after onBindViewHolder. If the wrong data
        // is in the views because the binding is waiting until the next frame,
        // it will be measured improperly.
        //
        // https://medium.com/google-developers/android-data-binding-recyclerview-db7c40d9f0e4

        binding.executePendingBindings();
    }
}
