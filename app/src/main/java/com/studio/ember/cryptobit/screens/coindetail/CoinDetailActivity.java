package com.studio.ember.cryptobit.screens.coindetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.studio.ember.cryptobit.R;

public class CoinDetailActivity extends AppCompatActivity {

    CoinDetailFragment coinDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_detail);
    }
}
