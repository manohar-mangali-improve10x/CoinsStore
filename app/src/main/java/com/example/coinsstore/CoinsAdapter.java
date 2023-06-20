package com.example.coinsstore;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.coinsstore.databinding.CoinItemBinding;
import com.example.coinsstore.module.Coin;

import java.util.List;

public class CoinsAdapter extends RecyclerView.Adapter<CoinsViewHolder> {
    private List<Coin> coinList;
    private Boolean isActive = false;


    public  void setData(List<Coin> coins){
        coinList = coins;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CoinsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CoinItemBinding coinItemBinding = CoinItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        CoinsViewHolder coinsViewHolder = new CoinsViewHolder(coinItemBinding);
        return coinsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CoinsViewHolder holder, int position) {
        Coin coin = coinList.get(position);
        holder.binding.setCoin(coin);
        holder.binding.setIsActive(true);
    }

    @Override
    public int getItemCount() {
        return coinList.size();
    }
}
