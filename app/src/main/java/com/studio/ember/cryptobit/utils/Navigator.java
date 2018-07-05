package com.studio.ember.cryptobit.utils;

import android.app.Activity;

import com.studio.ember.cryptobit.screens.coindetail.CoinDetailFragment;
import com.studio.ember.cryptobit.screens.coins.CoinsFragment;

public class Navigator {


    public static void goToRecipes(Activity activity, CoinsFragment coinsFragment, int container, boolean replace) {
        if (activity != null) {
            ActivityUtils.init(activity);
            if (!replace)
                ActivityUtils.addFragment(coinsFragment, container);
            else
                ActivityUtils.replaceFragment(coinsFragment, container);
        }
    }

    public static void goToDetails(Activity activity, CoinDetailFragment coinDetailFragment, int container, boolean replace) {
        if (activity != null) {
            ActivityUtils.init(activity);
            if (!replace)
                ActivityUtils.addFragment(coinDetailFragment, container);
            else
                ActivityUtils.replaceFragment(coinDetailFragment, container);
        }
    }

    public static void goToHome(){

    }
}
