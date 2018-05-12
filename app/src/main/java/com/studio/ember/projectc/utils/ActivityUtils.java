package com.studio.ember.projectc.utils;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;

public class ActivityUtils {

    static FragmentManager fragmentManager;

    public static void init(Activity activity){
        if(fragmentManager == null)
            fragmentManager = activity.getFragmentManager();
    }

    public static void replaceFragment(Fragment fragment, int container){
        fragmentManager.beginTransaction().replace(container,fragment).commit();
    }

    public static void addFragment(Fragment fragment, int container){
        //fragmentManager.beginTransaction().add(container, fragment).addToBackStack(Constants.RECIPE_FRAGMENT).commit();
        fragmentManager.beginTransaction().add(container,fragment, Constants.RECIPE_FRAGMENT).commit();
    }

}
