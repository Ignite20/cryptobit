package com.studio.ember.cryptobit.utils;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;

public class ActivityUtils {

    static FragmentManager fragmentManager;

    public static void init(Activity activity){
        fragmentManager = activity.getFragmentManager();
    }

    public static void replaceFragment(Fragment fragment, int container){
        fragmentManager.beginTransaction().replace(container,fragment).commit();
    }

    public static void addFragment(Fragment fragment, int container){
        fragmentManager.beginTransaction().add(container, fragment).commit();
    }

}
