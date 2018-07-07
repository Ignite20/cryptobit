package com.studio.ember.cryptobit.screens.coindetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.studio.ember.cryptobit.R;
import com.studio.ember.cryptobit.utils.ActivityUtils;

public class CoinDetailActivity extends AppCompatActivity {

    CoinDetailFragment coinDetailFragment;
    CoinDetailContract.Presenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_detail);

        if(coinDetailFragment == null){
            coinDetailFragment = CoinDetailFragment.newInstance(getIntent().getExtras());
        }
        if(mPresenter == null){
            mPresenter = new CoinDetailPresenter(coinDetailFragment);
        }

        coinDetailFragment.setPresenter(mPresenter);

        ActivityUtils utils = new ActivityUtils();
        utils.init(this);
        utils.addFragment(coinDetailFragment, R.id.flContainer);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mPresenter == null){
            mPresenter = new CoinDetailPresenter(coinDetailFragment);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        coinDetailFragment = null;
    }
}
