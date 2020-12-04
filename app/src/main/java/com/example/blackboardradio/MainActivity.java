package com.example.blackboardradio;

import android.os.Bundle;

import com.example.blackboardradio.adapter.FragmentAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), this);
        viewPager = findViewById(R.id.view_pager);

        TabLayout tabs = findViewById(R.id.tabs);

        tabs.setTabGravity(TabLayout.GRAVITY_FILL);

        tabs.setupWithViewPager(viewPager);

        viewPager.setAdapter(fragmentAdapter);

    }




}