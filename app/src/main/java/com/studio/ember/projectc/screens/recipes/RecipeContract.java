package com.studio.ember.projectc.screens.recipes;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.studio.ember.projectc.BasePresenter;
import com.studio.ember.projectc.BaseView;

public interface RecipeContract {
    interface View extends BaseView<RecipeContract.Presenter> {
        void onRecipeClick(int position);
    }

    interface Presenter extends BasePresenter{
        void openRecipe();

        void LikeRecipe();

        void commentOnRecipe();

        void adaptRecyclerView(RecyclerView rv, LinearLayoutManager layoutManager);

    }


}
