package com.example.hieutmph10003_asm_tkgda.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hieutmph10003_asm_tkgda.R;
import com.example.hieutmph10003_asm_tkgda.model.Khoan_Thu;
import com.example.hieutmph10003_asm_tkgda.recycleview.Khoan_Thu_RecyclerView_Adapter;
import com.example.hieutmph10003_asm_tkgda.sql.SQL_All;

import java.util.ArrayList;
import java.util.List;

public class Khoan_Thu_Fragment extends Fragment {
//    List<Khoan_Thu> khoan_thuList;
    int i = 0;
    Context context;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.khoan_thu_fragment, container, false);
        context = view.getContext();
        recyclerView = view.findViewById(R.id.recyclerview_khoan_thu);
//        khoan_thuList = new ArrayList<>();

        Khoan_Thu khoan_thuu = new Khoan_Thu(123,"Tiền thưởng",5000000,"Công việc", "20/8/2020", 123);
//        khoan_thuList.add(khoan_thuu);
        SQL_All sql_all = new SQL_All(context);
//        khoan_thuList = sql_all.get_list_khoan_thu();

//        for (i = 0; i > khoan_thuList.size(); i++) {
//            Log.e(""+khoan_thuList.get(i).getId(), "ten");
//            if(sql_all.get_list_khoan_thu().get(i).getId() != khoan_thuList.get(i).getId()){
//            sql_all.add_khoan_thu(khoan_thuList.get(i));
//            }
//        }

        loadlist();
        return view;
    }

    public void loadlist(){
        SQL_All sql_all = new SQL_All(context);
//        khoan_thuList = sql_all.get_list_khoan_thu();

        GridLayoutManager linearLayoutManager = new GridLayoutManager(context,1);
        recyclerView.setLayoutManager(linearLayoutManager);
        Khoan_Thu_RecyclerView_Adapter khoan_thu_recyclerView_adapter = new Khoan_Thu_RecyclerView_Adapter(sql_all.get_list_khoan_thu(), context);
        khoan_thu_recyclerView_adapter.notifyDataSetChanged();
        recyclerView.setAdapter(khoan_thu_recyclerView_adapter);
    }

    @Override
    public void onResume() {
        loadlist();
        super.onResume();
    }
}
