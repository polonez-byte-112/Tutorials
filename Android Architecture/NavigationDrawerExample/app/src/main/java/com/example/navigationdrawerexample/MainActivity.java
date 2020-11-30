package com.example.navigationdrawerexample;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.LifecycleOwner;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements LifecycleOwner, NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);

        //syncstate jest od obracania hamburgera
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.home);
        }
    }


    //Funkcja nizej sprawia ze jak wcisniesz esc to najpierw zamyka rozwijane okienko jak jest otwarte
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    //Dajemy na true by dzialalo
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                break;

            case R.id.login:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoginFragment()).commit();
                break;


            case R.id.register:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new RegisterFragment()).commit();
                break;

            case R.id.email:
                openEmailApp();
                break;

            case R.id.rate:
                rateApp();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    void openEmailApp() {
        Toast.makeText(this, "Open Email", Toast.LENGTH_SHORT).show();
    }

    void rateApp() {
        Toast.makeText(this, "Rating app", Toast.LENGTH_SHORT).show();
    }
}