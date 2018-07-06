package com.studio.ember.cryptobit.screens.coins;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.studio.ember.cryptobit.BasePresenter;
import com.studio.ember.cryptobit.BaseView;

public interface CoinsContract {
    interface View extends BaseView<CoinsContract.Presenter> {
        void onCoinClick(int position);

        void terminateUpdate();

    }

    interface Presenter extends BasePresenter{


        void adaptRecyclerView(RecyclerView rv, LinearLayoutManager layoutManager);

        void updateData();
    }


}
