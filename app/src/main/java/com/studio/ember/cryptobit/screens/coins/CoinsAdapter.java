package com.studio.ember.cryptobit.screens.coins;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.studio.ember.cryptobit.R;
import com.studio.ember.cryptobit.model.Coin;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CoinsAdapter extends RecyclerView.Adapter<CoinsAdapter.CoinViewHolder> {

    private View view;
    private CoinViewHolder vh;
    private final OnItemClickListener listener;
    private List<Coin> mCoins;
    public CoinsAdapter(List<Coin> coins, OnItemClickListener listener) {
        this.listener = listener;
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
        holder.setItem(mCoins.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return mCoins.size();
    }


    public interface OnItemClickListener {
        void onItemClick(Coin item);
    }

    class CoinViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_name)
        TextView tv_name;

        @BindView(R.id.tv_coin)
        TextView tv_coin;

        @BindView(R.id.tv_1h_change)
        TextView tv_1h_change;

        @BindView(R.id.tv_24h_change)
        TextView tv_24h_change;

        CoinViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,view);
        }

        void setItem(final Coin coin, final OnItemClickListener listener){
            Log.d("object", coin.getQuotes().get("USD").getMarket_cap()+"");
            this.tv_name.setText(coin.getName());
            this.tv_coin.setText("USD");
            double value1h = coin.getQuotes().get("USD").getPercent_change_1h();
            double value24h = coin.getQuotes().get("USD").getPercent_change_24h();
            this.tv_1h_change.setText(String.valueOf(value1h));
            this.tv_24h_change.setText(String.valueOf(value24h));

            if (value1h > 0) {
                tv_1h_change.setTextColor(ContextCompat.getColor(view.getContext(), R.color.green));
            } else {
                tv_1h_change.setTextColor(ContextCompat.getColor(view.getContext(), R.color.red));
            }

            if (value24h > 0) {
                tv_24h_change.setTextColor(ContextCompat.getColor(view.getContext(), R.color.green));
            } else {
                tv_24h_change.setTextColor(ContextCompat.getColor(view.getContext(), R.color.red));
            }

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(coin);
                }
            });
        }
    }
}
