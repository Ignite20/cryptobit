package com.studio.ember.cryptobit.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.studio.ember.cryptobit.model.Coin;
import com.studio.ember.cryptobit.screens.coindetail.CoinDetailActivity;
import com.studio.ember.cryptobit.screens.coindetail.CoinDetailFragment;
import com.studio.ember.cryptobit.screens.coins.CoinsFragment;

import java.io.Serializable;

import static com.studio.ember.cryptobit.utils.Constants.COIN_DETAILS;

public class Navigator {

    public static void goToDetails(Activity activity, Coin object) {

        Bundle bundle = new Bundle();
        bundle.putSerializable(COIN_DETAILS, object);

        Intent mIntent = new Intent(activity, CoinDetailActivity.class);
        mIntent.putExtras(bundle);
        activity.startActivity(mIntent);

    }

}
