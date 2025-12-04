package com.sykmm.realestate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sykmm.realestate.ui.HomeFragment;
import com.sykmm.realestate.ui.ListingsFragment;
import com.sykmm.realestate.ui.AboutFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottom_navigation);

        // Load default fragment
        loadFragment(new HomeFragment());

        bottomNavigation.setOnNavigationItemSelectedListener(item -> {
            Fragment fragment;

            int id = item.getItemId();

            if (id == R.id.nav_home) {
                fragment = new HomeFragment();
            } else if (id == R.id.nav_listings) {
                fragment = new ListingsFragment();
            } else {
                fragment = new AboutFragment();
            }

            loadFragment(fragment);
            return true;
        });
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container, fragment)
                .commit();
    }
}