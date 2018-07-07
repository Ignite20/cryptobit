package com.studio.ember.cryptobit.screens.coindetail;

import android.os.AsyncTask;
import android.util.Log;

import com.studio.ember.cryptobit.model.Coin;
import com.studio.ember.cryptobit.model.Data;
import com.studio.ember.cryptobit.webservice.currency.CurrencyProxy;

import java.io.IOException;

public class CoinDetailPresenter implements CoinDetailContract.Presenter {

    private CoinDetailContract.View mView;
    private Coin coin;
    private String marketCoin = "USD";
    private CurrencyProxy proxy;
    private CurrencyAsync currencyAsync;

    @Override
    public void changeMarketCoin(String marketCoin) {
        this.marketCoin = marketCoin;
        currencyAsync = new CurrencyAsync();
        currencyAsync.execute(this.coin);
    }

    @Override
    public String getMarketCoin() {
        return this.marketCoin;
    }

    public CoinDetailPresenter(CoinDetailContract.View mView) {
        this.mView = mView;
        this.mView.setPresenter(this);
        this.proxy = new CurrencyProxy();
    }

    @Override
    public void setData(Coin coin) {
        if(coin != null){
            Log.d("coin", coin.toString());
            this.coin = coin;

        }
    }

    @Override
    public void start() {
        mView.showInfo(this.coin);
    }

    @Override
    public void stop() {

    }

    class CurrencyAsync extends AsyncTask<Coin, Void, Data> {
        @Override
        protected Data doInBackground(Coin... coins) {

            try {
                return proxy.getMarketCoin(coins[0].getId(), marketCoin);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Data data) {
            // Save data to class variable
            coin = data.getData().get(0);
            Log.d("market_coin",coin.toString());
            mView.showInfo(coin);

        }
    }
}
