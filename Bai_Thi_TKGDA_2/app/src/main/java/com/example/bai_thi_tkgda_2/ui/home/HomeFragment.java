package com.example.bai_thi_tkgda_2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.bai_thi_tkgda_2.R;
import com.example.bai_thi_tkgda_2.ViewPager.Adapter_ViewPager1;
import com.google.android.material.tabs.TabLayout;

public class HomeFragment extends Fragment {

    public TabLayout tablayout1;
    public ViewPager viewpager1;




    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        tablayout1 = view.findViewById(R.id.tablayout1);
        viewpager1 = view.findViewById(R.id.viewpager1);

        tablayout1.addTab(tablayout1.newTab().setText("FORM CHÍNH"));
        tablayout1.addTab(tablayout1.newTab().setText("ĐĂNG NHẬP"));
        tablayout1.setTabGravity(TabLayout.GRAVITY_FILL);

        viewpager1.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout1));
        tablayout1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager1.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        Adapter_ViewPager1 adapter_viewPager1 = new Adapter_ViewPager1(getActivity().getSupportFragmentManager());
        viewpager1.setAdapter(adapter_viewPager1);
        return view;
    }
}