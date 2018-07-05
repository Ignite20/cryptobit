package com.studio.ember.cryptobit.screens.coins;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.studio.ember.cryptobit.R;
import com.studio.ember.cryptobit.model.Coin;

import java.util.List;

public class CoinsAdapter extends RecyclerView.Adapter<CoinsAdapter.CoinViewHolder> {

    private View view;
    private CoinViewHolder vh;

    private List<Coin> mCoins;
    public CoinsAdapter(List<Coin> coins) {
        this.mCoins = coins;
    }

    @NonNull
    @Override
    public CoinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coin_item, parent,false);
        vh = new CoinViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CoinViewHolder holder, int position) {
        holder.setItem(mCoins.get(position));
    }

    @Override
    public int getItemCount() {
        return mCoins.size();
    }

    class CoinViewHolder extends RecyclerView.ViewHolder{


        public CoinViewHolder(View itemView) {
            super(itemView);
        }

        public void setItem(Coin coin){
        }
    }
}
