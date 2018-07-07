package com.studio.ember.cryptobit.screens.coindetail;

import com.studio.ember.cryptobit.BasePresenter;
import com.studio.ember.cryptobit.BaseView;
import com.studio.ember.cryptobit.model.Coin;

public interface CoinDetailContract {
    interface View extends BaseView<CoinDetailContract.Presenter> {

        void showInfo(Coin coin);
    }

    interface Presenter extends BasePresenter {
        void setData(Coin coin);

        void changeMarketCoin(String coin);

        String getMarketCoin();
    }
}
