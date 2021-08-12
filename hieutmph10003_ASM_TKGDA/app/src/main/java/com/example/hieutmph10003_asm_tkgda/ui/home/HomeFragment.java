package com.example.hieutmph10003_asm_tkgda.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.hieutmph10003_asm_tkgda.R;
import com.example.hieutmph10003_asm_tkgda.adapter.Khoan_Thu_Adapter;
import com.example.hieutmph10003_asm_tkgda.fragment.Khoan_Thu_Fragment;
import com.example.hieutmph10003_asm_tkgda.fragment.Loai_Thu_Fragment;
import com.google.android.material.tabs.TabLayout;

public class HomeFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        viewPager = view.findViewById(R.id.view_pager_khoan_thu);
        tabLayout = view.findViewById(R.id.tab_khoan_thu);
        tabLayout.setupWithViewPager(viewPager);

        Khoan_Thu_Adapter khoan_thu_adapter = new Khoan_Thu_Adapter(getFragmentManager());
        khoan_thu_adapter.addfrag(new Khoan_Thu_Fragment(), "Khoản thu");
        khoan_thu_adapter.addfrag(new Loai_Thu_Fragment(), "Loại thu");

        viewPager.setAdapter(khoan_thu_adapter);
        return view;
    }
}
