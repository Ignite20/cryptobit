package com.studio.ember.cryptobit.screens.coindetail;

import com.studio.ember.cryptobit.BasePresenter;
import com.studio.ember.cryptobit.BaseView;

public interface CoinDetailContract {
    interface View extends BaseView<CoinDetailContract.Presenter> {
        void changePicture();

        void setInfo(User user);
    }

    interface Presenter extends BasePresenter {
        void changeProfilePicture();


    }
}
