package com.studio.ember.cryptobit.screens.coins;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.studio.ember.cryptobit.R;
import com.studio.ember.cryptobit.model.Coin;
import com.studio.ember.cryptobit.utils.StringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * This is the Coins Adapter class
 * It's in charge of adapting the items to the item view in the recycler view
 * It extends the Recycler view adapter incorporating a custom ViewHolder
 * to show the info coming from the list of Coin Objects
 *
 * Also implements the Filterable interface to filter the data by the name or symbol.
 * This is Coin Object specific.
 */
public class CoinsAdapter extends RecyclerView.Adapter<CoinsAdapter.CoinViewHolder> implements Filterable{

    private View view;
    private CoinViewHolder vh;
    private final OnItemClickListener listener;
    private List<Coin> mCoins;  // the one showed to the user
    private List<Coin> originalList;    // the original one for filtering purposes
    private List<Coin> mFilteredList;
    private String coinMark = "USD";
    public CoinsAdapter(List<Coin> coins, OnItemClickListener listener) {
        this.listener = listener;
        this.mCoins = coins;
        this.originalList = coins;
        this.mFilteredList = new ArrayList<>();
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

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults results = new FilterResults();
                mCoins = originalList;
                mFilteredList = new ArrayList<>();
                if(!charSequence.toString().isEmpty() || charSequence.toString().length() > 0){
                    for (Coin coin : mCoins) {
                        // Break variables into scope variables to ease of use
                        String lowerName = coin.getName().toLowerCase();
                        String lowerSymbol = coin.getSymbol().toLowerCase();
                        String lowerFilterSearch = charSequence.toString().toLowerCase();
                        // Check the start of the name or symbol
                        if(lowerName.contains(lowerFilterSearch) || lowerSymbol.contains(lowerFilterSearch)){
                            // Add the item to the filtered list
                            mFilteredList.add(coin);
                        }
                    }
                    // return the filtered values
                    results.values = mFilteredList;
                    results.count = mFilteredList.size();
                }
                else{
                    // Return the original list if the search sequence is an empty string
                    results.values = originalList;
                    results.count = originalList.size();
                }
                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                // Set the filtered list to the one references to the adapter
                mCoins = (List<Coin>) filterResults.values;
                // Refresh the list
                notifyDataSetChanged();
            }
        };
    }


    /**
     * Listener for the click event on recycler view item
     */
    public interface OnItemClickListener {
        void onItemClick(Coin item);
    }




    class CoinViewHolder extends RecyclerView.ViewHolder{

        View view;
        @BindView(R.id.tv_name)
        TextView tv_name;

        @BindView(R.id.tv_coin)
        TextView tv_coin;

        @BindView(R.id.tv_1h_change)
        TextView tv_1h_change;

        @BindView(R.id.tv_24h_change)
        TextView tv_24h_change;

        @BindView(R.id.tv_price)
        TextView tv_price;

        CoinViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, this.view);
        }

        void setItem(final Coin coin, final OnItemClickListener listener){
            Log.d("object", coin.getQuotes().get(coinMark).getMarket_cap()+"");
            this.tv_name.setText(coin.getName());
            this.tv_coin.setText(coinMark);
            this.tv_price.setText(StringUtils.formatFloat(coin.getQuotes().get(coinMark).getPrice()));
            double value1h = coin.getQuotes().get(coinMark).getPercent_change_1h();
            double value24h = coin.getQuotes().get(coinMark).getPercent_change_24h();
            this.tv_1h_change.setText(String.valueOf(value1h));
            this.tv_24h_change.setText(String.valueOf(value24h));

            if (value1h > 0) {
                tv_1h_change.setTextColor(ContextCompat.getColor(this.view.getContext(), R.color.green));
            } else {
                tv_1h_change.setTextColor(ContextCompat.getColor(this.view.getContext(), R.color.red));
            }

            if (value24h > 0) {
                tv_24h_change.setTextColor(ContextCompat.getColor(this.view.getContext(), R.color.green));
            } else {
                tv_24h_change.setTextColor(ContextCompat.getColor(this.view.getContext(), R.color.red));
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(coin);
                }
            });
        }
    }
}
