package com.example.hieutmph10003_asm_tkgda.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hieutmph10003_asm_tkgda.R;
import com.example.hieutmph10003_asm_tkgda.model.Khoan_Thu;
import com.example.hieutmph10003_asm_tkgda.recycleview.Khoan_Thu_ViewHolder;
import com.example.hieutmph10003_asm_tkgda.sql.SQL_All;

import java.util.List;

public class Khoan_Thu_RecyclerView_Adapter extends RecyclerView.Adapter<Khoan_Thu_ViewHolder> {

    List<Khoan_Thu> khoan_thuList;
    Context context;

    public Khoan_Thu_RecyclerView_Adapter(List<Khoan_Thu> khoan_thuList, Context context) {
        this.khoan_thuList = khoan_thuList;
        this.context = context;
    }

    @NonNull
    @Override
    public Khoan_Thu_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.icon_khoan_thu_fragment, parent, false);
        return new Khoan_Thu_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Khoan_Thu_ViewHolder holder, int position) {
    Khoan_Thu khoan_thu = khoan_thuList.get(position);
    holder.title_khoan_thu.setText(khoan_thu.getTenKhoanThu());
    holder.sotienthu_khoanthu.setText(String.valueOf(khoan_thu.getSoTienThu()));
    holder.loaithu_khoanthu.setText(khoan_thu.getLoaiThu());
    holder.ngaythu_khoanthu.setText(khoan_thu.getNgayThu());

    }

    @Override
    public int getItemCount() {
        return khoan_thuList.size();
    }
}
