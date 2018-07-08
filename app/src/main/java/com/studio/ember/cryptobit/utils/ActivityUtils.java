package com.studio.ember.cryptobit.utils;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;

public class ActivityUtils {

    FragmentManager fragmentManager;

    /**
     * Initialize the fragment manager
     * @param activity activity context
     */
    public void init(Activity activity){
        fragmentManager = activity.getFragmentManager();
        fragmentManager.popBackStackImmediate();
    }

    /**
     * Replaces the fragment in its specific container
     * @param fragment
     * @param container Activity container
     */
    public void replaceFragment(Fragment fragment, int container){
        fragmentManager.beginTransaction().replace(container,fragment).commit();
    }

    /**
     * Adds the fragment to its specific container
     * @param fragment
     * @param container
     */
    public void addFragment(Fragment fragment, int container){
        fragmentManager.beginTransaction().add(container, fragment).commit();
    }

}
