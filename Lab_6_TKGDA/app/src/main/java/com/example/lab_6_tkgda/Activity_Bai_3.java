package com.example.lab_6_tkgda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class Activity_Bai_3 extends AppCompatActivity {

    ViewPager viewPager;
//    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__bai_3);

        viewPager = findViewById(R.id.viewpager3);
//        tabLayout = findViewById(R.id.tab3);
//        tabLayout.setupWithViewPager(viewPager);
        ((TabLayout)this.findViewById(R.id.tab3)).setupWithViewPager(viewPager);



        FragmentAdapterr fragmentAdapter = new FragmentAdapterr(getSupportFragmentManager(),3);
        fragmentAdapter.addfrag(new ONE(), "TAB 1");
        fragmentAdapter.addfrag(new ONE(), "TAB 2");
        fragmentAdapter.addfrag(new ONE(), "TAB 3");
        viewPager.setAdapter(fragmentAdapter);
    }

    @Override
    protected void onResume() {

        super.onResume();
    }
}
