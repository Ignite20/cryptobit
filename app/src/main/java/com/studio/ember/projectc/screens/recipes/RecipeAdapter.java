package com.studio.ember.projectc.screens.recipes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.studio.ember.projectc.R;
import com.studio.ember.projectc.model.Recipe;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    private View view;
    private RecipeViewHolder vh;

    private List<Recipe> mRecipes;
    public RecipeAdapter(List<Recipe> recipes) {
        this.mRecipes = recipes;
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
        holder.setItem(mRecipes.get(position));
    }

    @Override
    public int getItemCount() {
        return mRecipes.size();
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder{

        ImageView ivRecipePhoto = view.findViewById(R.id.ivRecipePicture);
        TextView tvRecipeTitle = view.findViewById(R.id.tvRecipeName);
        TextView tvRecipeDescription = view.findViewById(R.id.tvRecipeDescription);

        public RecipeViewHolder(View itemView) {
            super(itemView);
        }

        public void setItem(Recipe recipe){
            tvRecipeTitle.setText(recipe.getName());
            tvRecipeDescription.setText(recipe.getDescription());
        }
    }
}
