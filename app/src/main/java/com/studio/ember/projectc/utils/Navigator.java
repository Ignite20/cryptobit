package com.studio.ember.projectc.utils;

import android.app.Activity;

import com.studio.ember.projectc.screens.recipes.RecipeFragment;

public class Navigator {



    public static void goToRecipes(Activity activity, RecipeFragment recipeFragment, int container){
        if (activity != null) {
            ActivityUtils.init(activity);
            if (!recipeFragment.isAdded())
                ActivityUtils.addFragment(recipeFragment, container);
            else
                ActivityUtils.replaceFragment(recipeFragment, container);
        }
    }

    public static void goToHome(){

    }
}
