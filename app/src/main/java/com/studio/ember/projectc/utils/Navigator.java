package com.studio.ember.projectc.utils;

import android.app.Activity;

import com.studio.ember.projectc.screens.profile.ProfileFragment;
import com.studio.ember.projectc.screens.recipes.RecipeFragment;

public class Navigator {


    public static void goToRecipes(Activity activity, RecipeFragment recipeFragment, int container, boolean replace) {
        if (activity != null) {
            ActivityUtils.init(activity);
            if (!replace)
                ActivityUtils.addFragment(recipeFragment, container);
            else
                ActivityUtils.replaceFragment(recipeFragment, container);
        }
    }

    public static void goToProfile(Activity activity, ProfileFragment profileFragment, int container, boolean replace) {
        if (activity != null) {
            ActivityUtils.init(activity);
            if (!replace)
                ActivityUtils.addFragment(profileFragment, container);
            else
                ActivityUtils.replaceFragment(profileFragment, container);
        }
    }

    public static void goToHome(){

    }
}
