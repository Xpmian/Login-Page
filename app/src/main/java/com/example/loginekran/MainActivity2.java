package com.example.loginekran;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity2 extends AppCompatActivity
{
    BottomNavigationView bottomNavi;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bottomNavi=findViewById(R.id.navi);


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentler,new Evfrag()).commit();
        String gelenTc=getIntent().getStringExtra("gidentc");
        String gelenSifre=getIntent().getStringExtra("gidensifre");
        bottomNavi.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                switch (item.getItemId())
                {
                    case R.id.ev:
                    {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new Evfrag()).commit();
                        break;
                    }
                    case R.id.arama:
                    {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new Aramafrag()).commit();
                        break;
                    }
                    case R.id.profil:
                    {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new Profilfrag()).commit();
                        break;
                    }
                }
                return true;
            }
        });

    }
    public void backOnpressed()
    {
        Intent geriIntent = new Intent(MainActivity2.this,MainActivity.class);
        finish();
        startActivity(geriIntent);
    }
}



