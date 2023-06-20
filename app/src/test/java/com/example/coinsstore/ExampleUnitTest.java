package com.example.coinsstore;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.coinsstore.module.Coin;
import com.example.coinsstore.network.CoinService;
import com.example.coinsstore.network.CoinsApi;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void getCoins() throws IOException {
        CoinService randomPeopleService = new CoinsApi().createCoinService();
        Call<List<Coin>> call = randomPeopleService.fetchCoins();
        List<Coin> users = call.execute().body();
        assertNotNull(users);
        assertFalse(users.isEmpty());
        System.out.println(new Gson().toJson(users));
    }
}