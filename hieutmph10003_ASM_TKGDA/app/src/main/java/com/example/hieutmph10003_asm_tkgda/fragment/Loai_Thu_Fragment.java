package com.example.hieutmph10003_asm_tkgda.fragment;

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

import com.example.hieutmph10003_asm_tkgda.R;
import com.example.hieutmph10003_asm_tkgda.model.Khoan_Thu;
import com.example.hieutmph10003_asm_tkgda.model.Loai_Thu;
import com.example.hieutmph10003_asm_tkgda.recycleview.Khoan_Thu_RecyclerView_Adapter;
import com.example.hieutmph10003_asm_tkgda.recycleview.Loai_Thu_RecyclerView_Adapter;
import com.example.hieutmph10003_asm_tkgda.sql.SQL_All;

import java.util.ArrayList;
import java.util.List;

public class Loai_Thu_Fragment extends Fragment {

    List<Loai_Thu> loai_thuList;
    int i = 0;
    Context context;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.loai_thu_fragment, container, false);
        context = view.getContext();
        recyclerView = view.findViewById(R.id.recyclerview_loai_thu);
        loai_thuList = new ArrayList<>();

        Loai_Thu loai_thuu = new Loai_Thu(1234,"Tiền thưởng");
        loai_thuList.add(loai_thuu);
        SQL_All sql_all = new SQL_All(context);

        for (i = 0; i > loai_thuList.size(); i++) {

            if(sql_all.get_list_loai_thu().get(i).getIdLoaiThu() != loai_thuList.get(i).getIdLoaiThu()){
                sql_all.add_loai_thu(loai_thuList.get(i));
            }
        }

        loadlist_loai_thu();
        return view;


    }

    public void loadlist_loai_thu(){
        SQL_All sql_all = new SQL_All(context);
        loai_thuList = sql_all.get_list_loai_thu();

        GridLayoutManager linearLayoutManager = new GridLayoutManager(context,1);
        recyclerView.setLayoutManager(linearLayoutManager);
        Loai_Thu_RecyclerView_Adapter loai_thu_recyclerView_adapter = new Loai_Thu_RecyclerView_Adapter(loai_thuList, context);
        loai_thu_recyclerView_adapter.notifyDataSetChanged();
        recyclerView.setAdapter(loai_thu_recyclerView_adapter);
    }
}
