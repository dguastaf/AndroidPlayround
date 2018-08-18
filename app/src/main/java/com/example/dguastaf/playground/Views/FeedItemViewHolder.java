package com.example.dguastaf.playground.Views;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FeedItemViewHolder extends RecyclerView.ViewHolder {

    private TextView titleLabel;

    public FeedItemViewHolder(@NonNull View itemView) {
        super(itemView);
        titleLabel = (TextView) itemView;
    }

    public TextView getTitleLabel() {
        return titleLabel;
    }
}
