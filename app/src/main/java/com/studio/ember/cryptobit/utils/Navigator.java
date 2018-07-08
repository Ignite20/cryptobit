package com.studio.ember.cryptobit.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.studio.ember.cryptobit.model.Coin;
import com.studio.ember.cryptobit.screens.coindetail.CoinDetailActivity;

import static com.studio.ember.cryptobit.utils.Constants.COIN_DETAILS;

public class Navigator {

    /**
     * Method to navigate to the details screen
     * @param activity
     * @param object object to be passed as an extra
     */
    public static void goToDetails(Activity activity, Coin object) {

        Bundle bundle = new Bundle();
        bundle.putSerializable(COIN_DETAILS, object);

        Intent mIntent = new Intent(activity, CoinDetailActivity.class);
        mIntent.putExtras(bundle);
        activity.startActivity(mIntent);

    }

}
