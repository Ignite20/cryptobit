package com.studio.ember.cryptobit.screens.coins;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.studio.ember.cryptobit.R;
import com.studio.ember.cryptobit.utils.ActivityUtils;

public class CoinActivity extends AppCompatActivity {

    CoinsFragment coinsFragment;
    CoinsContract.Presenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // SETUP Fragment
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initPresenter();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initPresenter(){
        if(mPresenter == null){
            mPresenter = new CoinsPresenter(this, coinsFragment);
        }
    }

    private void init(){
        // Setup Coin Fragment

        if (coinsFragment == null) {
            coinsFragment = CoinsFragment.newInstance();
            initPresenter();
            coinsFragment.setPresenter(mPresenter);
        }
        // Attach fragment to activity
        ActivityUtils utils = new ActivityUtils();
        utils.init(this);
        utils.replaceFragment(coinsFragment, R.id.flContainer);

    }
}

