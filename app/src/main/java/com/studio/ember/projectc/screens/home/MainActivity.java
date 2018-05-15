package com.studio.ember.projectc.screens.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.studio.ember.projectc.R;
import com.studio.ember.projectc.screens.profile.ProfileFragment;
import com.studio.ember.projectc.screens.profile.ProfilePresenter;
import com.studio.ember.projectc.screens.recipes.RecipeFragment;
import com.studio.ember.projectc.screens.recipes.RecipePresenter;
import com.studio.ember.projectc.utils.Navigator;

public class MainActivity extends AppCompatActivity {

    RecipeFragment recipeFragment;
    ProfileFragment profileFragment;

    Toolbar mActionBarToolbar;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    changeActionBarTitle("Home");
                    return true;
                case R.id.navigation_recipes:
                    Navigator.goToRecipes(MainActivity.this, recipeFragment, R.id.flContainer, true);
                    changeActionBarTitle("Recipes");

                    return true;
                case R.id.navigation_profile:
                    Navigator.goToProfile(MainActivity.this, profileFragment, R.id.flContainer, true);
                    changeActionBarTitle("Profile");
                    return true;
            }
            return false;
        }
    };

    void changeActionBarTitle(String title) {

        mActionBarToolbar.setTitle(title);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        mActionBarToolbar = findViewById(R.id.action_bar_toolbar);
        changeActionBarTitle("Home");
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setSupportActionBar(mActionBarToolbar);

        // SETUP
        init();

        Navigator.goToRecipes(MainActivity.this, recipeFragment, R.id.flContainer, false);
    }

    @Override
    protected void onStop() {
        super.onStop();
        recipeFragment = null;
    }

    private void init(){

        // Setup Recipe Fragment
        if (recipeFragment == null) {
            recipeFragment = RecipeFragment.newInstance();
            recipeFragment.setPresenter(new RecipePresenter(recipeFragment));
        }

        // Setup Profile Fragment
        if (profileFragment == null) {
            profileFragment = ProfileFragment.newInstance();
            profileFragment.setPresenter(new ProfilePresenter(profileFragment));
        }
    }
}

