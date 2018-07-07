package com.studio.ember.cryptobit.utils;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;

public class ActivityUtils {

    FragmentManager fragmentManager;

    public void init(Activity activity){
        fragmentManager = activity.getFragmentManager();
        fragmentManager.popBackStackImmediate();
    }

    public void replaceFragment(Fragment fragment, int container){
        fragmentManager.beginTransaction().replace(container,fragment).commit();
    }

    public void addFragment(Fragment fragment, int container){
        fragmentManager.beginTransaction().add(container, fragment).commit();
    }

}
