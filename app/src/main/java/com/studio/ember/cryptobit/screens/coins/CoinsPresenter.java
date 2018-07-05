package com.studio.ember.cryptobit.screens.coins;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.studio.ember.cryptobit.model.Coin;

import java.util.ArrayList;

public class CoinsPresenter implements CoinsContract.Presenter {

    private CoinsContract.View mView;
    private CoinsAdapter coinsAdapter;


    private ArrayList<Coin> coins;

    public CoinsPresenter(@NonNull CoinsContract.View recipeFragment) {
        this.mView = recipeFragment;
        this.mView.setPresenter(this);
        coins = new ArrayList<>();
    }

    private void fillRecipes() {
        coins.clear();
        Coin coin;
        for (int i = 0; i < 10; i++) {
            coin = new Coin(
                    i,
                    "User Name " + i,
                    "Awesome description " + i,
                    "",
                    3 * i);

            // Alternate favorite value
            coin.setFavorite(i % 2 == 0);

            coins.add(coin);

        }
    }

    @Override
    public void openCreateRecipe(Activity activity) {
        mView.showToastMessage("creating new recipe");
    }

    @Override
    public void start() {
        Log.d("presenter start", CoinsPresenter.class.getName() + " started");
        // Instantiate the adapter
        fillRecipes();

        coinsAdapter = new CoinsAdapter(coins);
    }

    @Override
    public void stop() {

    }

    @Override
    public void openRecipe() {

    }

    @Override
    public void LikeRecipe() {

    }

    @Override
    public void commentOnRecipe() {

    }

    @Override
    public void adaptRecyclerView(RecyclerView rv, LinearLayoutManager layoutManager) {
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(this.coinsAdapter);

        Log.d(CoinsPresenter.class.getName(), " recycler view adapted");
    }
}
