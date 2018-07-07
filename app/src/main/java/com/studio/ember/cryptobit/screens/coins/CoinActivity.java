package com.studio.ember.cryptobit.screens.coins;

import android.app.Application;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.studio.ember.cryptobit.R;
import com.studio.ember.cryptobit.screens.coindetail.CoinDetailFragment;
import com.studio.ember.cryptobit.utils.ActivityUtils;
import com.studio.ember.cryptobit.utils.Navigator;

public class CoinActivity extends AppCompatActivity {

    CoinsFragment coinsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // SETUP
        init();
    }


    @Override
    protected void onStop() {
        super.onStop();
        coinsFragment = null;
    }

    private void init(){
        // Setup Coin Fragment
        if (coinsFragment == null) {
            coinsFragment = CoinsFragment.newInstance();
            coinsFragment.setPresenter(new CoinsPresenter(this, coinsFragment));
        }
        // Attach fragment to activity
        ActivityUtils utils = new ActivityUtils();
        utils.init(this);
        utils.replaceFragment(coinsFragment, R.id.flContainer);

    }
}

