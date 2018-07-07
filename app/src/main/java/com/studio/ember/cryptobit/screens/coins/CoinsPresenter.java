package com.studio.ember.cryptobit.screens.coins;


import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.studio.ember.cryptobit.model.Coin;
import com.studio.ember.cryptobit.model.Data;
import com.studio.ember.cryptobit.utils.Navigator;
import com.studio.ember.cryptobit.webservice.currency.CurrencyProxy;

import java.io.IOException;
import java.util.ArrayList;

public class CoinsPresenter implements CoinsContract.Presenter, CoinsAdapter.OnItemClickListener {

    private Activity activity;
    private CoinsContract.View mView;
    private CoinsAdapter coinsAdapter;
    private CurrencyProxy proxy;
    private CurrencyAsync async;

    private RecyclerView mRecView;

    private ArrayList<Coin> coins;

    public CoinsPresenter(Activity activity, @NonNull CoinsContract.View recipeFragment) {
        this.activity = activity;
        this.mView = recipeFragment;
        this.mView.setPresenter(this);

    }


    @Override
    public void start() {
        try {
            Log.d("presenter start", CoinsPresenter.class.getName() + " started");
            // Instantiate the adapter
            coins = new ArrayList<>();
            proxy = new CurrencyProxy();
            async = new CurrencyAsync();
            async.execute();
            Log.d("presenter_coins start", this.coins.toString());

        } catch (Exception e){
            Log.d("Coint Presenter", e.getMessage());
        }
    }

    @Override
    public void stop() {
    }


    @Override
    public void adaptRecyclerView(RecyclerView rv, LinearLayoutManager layoutManager) {
        this.mRecView = rv;
        rv.addItemDecoration(new DividerItemDecoration(rv.getContext(),layoutManager.getOrientation()));
        rv.setLayoutManager(layoutManager);

        Log.d("presenter_coins adapt", this.coins.toString());
        Log.d(CoinsPresenter.class.getName(), " recycler view adapted");
    }

    @Override
    public void updateData() {
        async = null;
        async = new CurrencyAsync();
        async.execute();
    }

    @Override
    public void filterData(String filterText) {
        coinsAdapter.getFilter().filter(filterText);
    }

    @Override
    public void onItemClick(Coin item) {
        Log.d("item clicked", item.toString());
        Navigator.goToDetails(activity, item);
    }

    class CurrencyAsync extends AsyncTask<Void, Void, Data> {
        @Override
        protected Data doInBackground(Void... voids) {

            try {
                return proxy.getCurrencies();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Data data) {
            // Save data to class variable
            coins = data.getData();
            // restart the adapter
            coinsAdapter = null;
            coinsAdapter = new CoinsAdapter(coins, CoinsPresenter.this);
            // attach it to the recycler view
            mRecView.setAdapter(coinsAdapter);
            Log.d("presenter_coins post", coins.toString());
            mView.terminateUpdate();


        }
    }
}
