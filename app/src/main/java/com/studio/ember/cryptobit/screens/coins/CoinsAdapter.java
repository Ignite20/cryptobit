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

public class CoinsAdapter extends RecyclerView.Adapter<CoinsAdapter.RecipeViewHolder> {

    private View view;
    private RecipeViewHolder vh;

    private List<Coin> mCoins;
    public CoinsAdapter(List<Coin> coins) {
        this.mCoins = coins;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_item, parent,false);
        vh = new RecipeViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        holder.setItem(mCoins.get(position));
    }

    @Override
    public int getItemCount() {
        return mCoins.size();
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder{

        ImageView ivRecipePhoto = view.findViewById(R.id.ivRecipePicture);
        TextView tvRecipeTitle = view.findViewById(R.id.tvRecipeName);
        TextView tvRecipeDescription = view.findViewById(R.id.tvRecipeDescription);

        public RecipeViewHolder(View itemView) {
            super(itemView);
        }

        public void setItem(Coin coin){
            tvRecipeTitle.setText(coin.getName());
            //tvRecipeDescription.setText(coin.);
        }
    }
}
