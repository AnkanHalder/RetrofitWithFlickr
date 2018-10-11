package com.example.jiraiya.retroflikerintern;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnv =(BottomNavigationView)findViewById(R.id.bottom_navigation);
        bnv.setOnNavigationItemSelectedListener(nav_listen);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,
                new GalleryFragment()).commit();
    }

   private BottomNavigationView.OnNavigationItemSelectedListener nav_listen = new BottomNavigationView.OnNavigationItemSelectedListener() {
       @Override
       public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

           Fragment selectedFragment = null;
           switch (menuItem.getItemId()){
               case R.id.gallery_item_menu:
                   selectedFragment = new GalleryFragment();
                   break;
               case R.id.search_item_menu:
                   selectedFragment = new SearchFragment();
                   break;
           }
           getSupportFragmentManager().beginTransaction().replace(R.id.frame,
                   selectedFragment).commit();

           return true;
       }
   };

}
