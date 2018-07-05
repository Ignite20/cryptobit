package com.studio.ember.cryptobit.screens.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.studio.ember.cryptobit.R;
import com.studio.ember.cryptobit.screens.coindetail.CoinDetailFragment;
import com.studio.ember.cryptobit.screens.coindetail.CoinDetailPresenter;
import com.studio.ember.cryptobit.screens.coins.CoinsFragment;
import com.studio.ember.cryptobit.screens.coins.CoinsPresenter;
import com.studio.ember.cryptobit.utils.Navigator;

public class MainActivity extends AppCompatActivity {

    CoinsFragment coinsFragment;
    CoinDetailFragment coinDetailFragment;

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
    }

    @Override
    protected void onStart() {
        super.onStart();
        setSupportActionBar(mActionBarToolbar);

        // SETUP
        init();

        Navigator.goToRecipes(MainActivity.this, coinsFragment, R.id.flContainer, false);
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
            coinsFragment.setPresenter(new CoinsPresenter(coinsFragment));
        }

        // Setup Profile Fragment
        if (coinDetailFragment == null) {
            coinDetailFragment = CoinDetailFragment.newInstance();
            coinDetailFragment.setPresenter(new CoinDetailPresenter(coinDetailFragment));
        }
    }
}

