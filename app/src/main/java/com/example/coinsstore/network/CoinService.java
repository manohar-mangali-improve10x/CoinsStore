package com.example.coinsstore.network;

import com.example.coinsstore.Constants;
import com.example.coinsstore.module.Coin;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CoinService {
    @GET(Constants.COIN_END_POINT)
    Call<List<Coin>> fetchCoins();
}
