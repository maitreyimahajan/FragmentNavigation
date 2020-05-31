package com.example;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.MenuItem;

import androidx.fragment.app.Fragment;

import com.example.bottomnavigationprep2.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
           Fragment selectedFragment = null;

           switch(menuItem.getItemId()){
               case R.id.nav_home:
                   selectedFragment = new HomeFragment();
                   break;
               case R.id.nav_favorites:
                   selectedFragment = new FavoritesFragment();
                   break;
               case R.id.nav_search:
                   selectedFragment = new Search();
                   break;
           }


           getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();



           return true;
        }
    };
}
