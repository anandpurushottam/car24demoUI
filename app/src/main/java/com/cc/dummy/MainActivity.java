package com.cc.dummy;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(getSupportFragmentManager(), R.id.container, HomeFragment.newInstance());
    }

    public void loadFragment(FragmentManager fm, int container, Fragment fragment) {
        FragmentTransaction transaction = fm.beginTransaction();
        String fragmentSimpleName = fragment.getClass().getSimpleName();
        transaction.replace(container, fragment, fragmentSimpleName);
        transaction.addToBackStack(fragmentSimpleName);
        transaction.commit();
    }
}
