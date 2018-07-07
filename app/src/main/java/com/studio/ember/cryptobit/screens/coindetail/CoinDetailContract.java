package com.studio.ember.cryptobit.screens.coindetail;

import com.studio.ember.cryptobit.BasePresenter;
import com.studio.ember.cryptobit.BaseView;
import com.studio.ember.cryptobit.model.Coin;

public interface CoinDetailContract {
    interface View extends BaseView<CoinDetailContract.Presenter> {

        /**
         * method to show info from the coin object in the UI
         * @param coin
         */
        void showInfo(Coin coin);
    }

    interface Presenter extends BasePresenter {
        /**
         * Set data sent by Coin Screen
         * @param coin The coin object to be set
         */
        void setData(Coin coin);

        /**
         * Change market coin to update info in the details screen
         * @param coin the market coin to be updated
         */
        void changeMarketCoin(String coin);

        /**
         * Returns the market coin string
         */
        String getMarketCoin();
    }
}
