package com.example.coinsstore;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coinsstore.databinding.CoinItemBinding;

public class CoinsViewHolder extends RecyclerView.ViewHolder {
    CoinItemBinding binding;
    public CoinsViewHolder(CoinItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
