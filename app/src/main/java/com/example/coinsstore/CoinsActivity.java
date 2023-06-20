package com.example.coinsstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.coinsstore.databinding.ActivityCoinsBinding;
import com.example.coinsstore.module.Coin;
import com.example.coinsstore.network.CoinService;
import com.example.coinsstore.network.CoinsApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoinsActivity extends AppCompatActivity {

    private ActivityCoinsBinding binding;
    private CoinsAdapter adapter;
    private List<Coin> coins = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCoinsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setUpAdapter();
        setUpRv();
        fetchData();
    }

    private void fetchData() {
        CoinService coinService = new CoinsApi().createCoinService();
        Call<List<Coin>> call = coinService.fetchCoins();
        call.enqueue(new Callback<List<Coin>>() {
            @Override
            public void onResponse(Call<List<Coin>> call, Response<List<Coin>> response) {
                Toast.makeText(CoinsActivity.this, "success", Toast.LENGTH_SHORT).show();
                coins = response.body();
                adapter.setData(coins);

            }

            @Override
            public void onFailure(Call<List<Coin>> call, Throwable t) {
                Toast.makeText(CoinsActivity.this, "failed", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void setUpAdapter() {
        adapter = new CoinsAdapter();
        adapter.setData(coins);
    }

    private void setUpRv() {
        binding.coinsRv.setLayoutManager(new LinearLayoutManager(this));
        binding.coinsRv.setAdapter(adapter);
    }
}