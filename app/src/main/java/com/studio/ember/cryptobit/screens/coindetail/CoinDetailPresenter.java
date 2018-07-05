package com.studio.ember.cryptobit.screens.coindetail;

public class CoinDetailPresenter implements CoinDetailContract.Presenter {

    private CoinDetailContract.View mView;

    public CoinDetailPresenter(CoinDetailContract.View mView) {
        this.mView = mView;
        this.mView.setPresenter(this);
    }

    @Override
    public void changeProfilePicture() {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
