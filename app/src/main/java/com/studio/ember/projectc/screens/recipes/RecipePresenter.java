package com.studio.ember.projectc.screens.recipes;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.studio.ember.projectc.model.Recipe;

import java.util.ArrayList;

public class RecipePresenter implements RecipeContract.Presenter {

    private RecipeContract.View mView;
    private RecipeAdapter recipeAdapter;


    private ArrayList<Recipe> recipes;

    public RecipePresenter(@NonNull RecipeContract.View recipeFragment) {
        this.mView = recipeFragment;
        this.mView.setPresenter(this);
        recipes = new ArrayList<>();
    }

    private void fillRecipes() {
        recipes.clear();
        Recipe recipe;
        for (int i = 0; i < 10; i++) {
            recipe = new Recipe(
                    i,
                    "User Name " + i,
                    "Awesome description " + i,
                    "",
                    3 * i);

            // Alternate favorite value
            recipe.setFavorite(i % 2 == 0);

            recipes.add(recipe);

        }
    }

    @Override
    public void openCreateRecipe(Activity activity) {
        mView.showToastMessage("creating new recipe");
    }

    @Override
    public void start() {
        Log.d("presenter start", RecipePresenter.class.getName() + " started");
        // Instantiate the adapter
        fillRecipes();

        recipeAdapter = new RecipeAdapter(recipes);
    }

    @Override
    public void stop() {

    }

    @Override
    public void openRecipe() {

    }

    @Override
    public void LikeRecipe() {

    }

    @Override
    public void commentOnRecipe() {

    }

    @Override
    public void adaptRecyclerView(RecyclerView rv, LinearLayoutManager layoutManager) {
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(this.recipeAdapter);

        Log.d(RecipePresenter.class.getName(), " recycler view adapted");
    }
}
