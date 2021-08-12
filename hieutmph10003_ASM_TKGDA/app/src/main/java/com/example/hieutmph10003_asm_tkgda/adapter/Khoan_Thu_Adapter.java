package com.example.hieutmph10003_asm_tkgda.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Khoan_Thu_Adapter extends FragmentPagerAdapter {

    final List<Fragment> fragmentList = new ArrayList<>();
    final List<String> stringList = new ArrayList<>();


    public Khoan_Thu_Adapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return stringList.get(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public void addfrag (Fragment fragment, String title){
        fragmentList.add(fragment);
        stringList.add(title);
    }
}
