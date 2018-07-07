package com.studio.ember.cryptobit.screens.coins;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.studio.ember.cryptobit.BasePresenter;
import com.studio.ember.cryptobit.BaseView;

public interface CoinsContract {
    interface View extends BaseView<CoinsContract.Presenter> {

        /**
         * Terminates the update UI indicator
         */
        void terminateUpdate();

    }

    interface Presenter extends BasePresenter{

        /**
         * Adapts the items in the recyclerview
         * @param rv the recyclerview in which to see the items
         * @param layoutManager layout manager to apply the layout inside recyclerview
         */
        void adaptRecyclerView(RecyclerView rv, LinearLayoutManager layoutManager);

        /**
         * Updates data
         */
        void updateData();
    }


}
