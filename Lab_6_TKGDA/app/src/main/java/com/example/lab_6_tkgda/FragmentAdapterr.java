package com.example.lab_6_tkgda;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentAdapterr extends FragmentPagerAdapter {
    final List<Fragment> fragmentList = new ArrayList<>();
    final List<String> stringList = new ArrayList<>();
    public FragmentAdapterr(@NonNull FragmentManager fm, int cho) {
        super(fm, cho);
    }

//    @NonNull
//    @Override
//    public Fragment getItem(int position) {
//        switch (position){
//            case 0:
//                return new SecondFragment22();
//            case 1:
//                return new FirstFragment21();
//
//        }
//        return null;
//    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        return stringList.get(position);

    }

//    @Nullable
//    @Override
//    public CharSequence getPageTitle(int position) {
//        switch (position){
//            case 0:
//                return "Tab 1";
//
//            case 1:
//                return "TAB 2";
//        }
//        return super.getPageTitle(position);
//    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        ONE one = new ONE();
        Bundle bundle = new Bundle();
        bundle.putString("so", position + "");
        one.setArguments(bundle);

        return one;
//        return fragmentList.get(position);

    }

    @Override
    public int getCount() {
        return fragmentList.size();
//        return 0;
    }

    public void addfrag (Fragment fragment, String title){
        fragmentList.add(fragment);
        stringList.add(title);
    }
}
