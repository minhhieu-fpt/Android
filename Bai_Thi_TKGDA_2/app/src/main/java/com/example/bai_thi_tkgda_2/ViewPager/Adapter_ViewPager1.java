package com.example.bai_thi_tkgda_2.ViewPager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.bai_thi_tkgda_2.Fragment.Form_Chinh_Fragment;
import com.example.bai_thi_tkgda_2.ui.home.HomeFragment;

public class Adapter_ViewPager1 extends FragmentStatePagerAdapter {
    public Adapter_ViewPager1(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        Fragment fragment;
        switch (position){
            case 0:
                fragment = new Form_Chinh_Fragment();
                break;

            case 1:
                fragment = new HomeFragment();
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
