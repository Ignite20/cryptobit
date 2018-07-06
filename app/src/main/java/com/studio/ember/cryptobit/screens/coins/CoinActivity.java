package com.studio.ember.cryptobit.screens.coins;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.studio.ember.cryptobit.R;
import com.studio.ember.cryptobit.screens.coindetail.CoinDetailFragment;
import com.studio.ember.cryptobit.utils.Navigator;

public class CoinActivity extends AppCompatActivity {

    CoinsFragment coinsFragment;

    Toolbar mActionBarToolbar;

    void changeActionBarTitle(String title) {

        mActionBarToolbar.setTitle(title);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mActionBarToolbar = findViewById(R.id.action_bar_toolbar);
        changeActionBarTitle("Home");

        // SETUP
        init();


        Navigator.goToCoins(CoinActivity.this, coinsFragment, R.id.flContainer, false);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setSupportActionBar(mActionBarToolbar);


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

    }
}

