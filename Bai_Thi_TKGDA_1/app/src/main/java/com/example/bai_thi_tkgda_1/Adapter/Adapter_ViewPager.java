package com.example.bai_thi_tkgda_1.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.bai_thi_tkgda_1.Fragment.Chuc_Nang_Fragment;
import com.example.bai_thi_tkgda_1.Fragment.List_DS_Fragment_Main2;

public class Adapter_ViewPager extends FragmentStatePagerAdapter {
    public Adapter_ViewPager(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position){

            case 0:
                fragment = new List_DS_Fragment_Main2();
                break;

            case 1:
                fragment = new Chuc_Nang_Fragment();
                break;
            default:
                return null;
        }
        return fragment;
    }


    @Override
    public int getCount() {
        return 2;
    }
}
