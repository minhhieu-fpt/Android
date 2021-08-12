package com.example.bai_thi_tkgda_1.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bai_thi_tkgda_1.Adapter.Adapter_RecyclerView;
import com.example.bai_thi_tkgda_1.Model.Use;
import com.example.bai_thi_tkgda_1.R;
import com.example.bai_thi_tkgda_1.SQLite.MySQLite;

import java.util.ArrayList;
import java.util.List;

public class List_DS_Fragment_Main2 extends Fragment {
    List<Use> useList;
    RecyclerView recyclerview_user;
    MySQLite mySQLite;
    Context context;

    Chuc_Nang_Fragment chuc_nang_fragment;

    public List_DS_Fragment_Main2() {
    }

    public List_DS_Fragment_Main2(Chuc_Nang_Fragment chuc_nang_fragment) {
        this.chuc_nang_fragment = chuc_nang_fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_ds_fragment_main2, container, false);
        recyclerview_user = view.findViewById(R.id.recyclerview_user);
        context = view.getContext();
        useList = new ArrayList<>();
        mySQLite = new MySQLite(view.getContext());


        loadlist();
        return view;

    }

    public void loadlist () {
        useList = mySQLite.get_list_user();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 1);
        recyclerview_user.setLayoutManager(gridLayoutManager);

        Adapter_RecyclerView adapter_recyclerView = new Adapter_RecyclerView(useList,context,List_DS_Fragment_Main2.this);
        recyclerview_user.setAdapter(adapter_recyclerView);
    }

    @Override
    public void onResume() {
        loadlist();
        super.onResume();
    }
}
