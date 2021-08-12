package com.example.hieutmph10003_asm_tkgda.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hieutmph10003_asm_tkgda.R;
import com.example.hieutmph10003_asm_tkgda.model.Khoan_Thu;
import com.example.hieutmph10003_asm_tkgda.model.Loai_Thu;

import java.util.List;

public class Loai_Thu_RecyclerView_Adapter extends RecyclerView.Adapter<Loai_Thu_ViewHolder> {
    List<Loai_Thu> loai_thuList;
    Context context;

    public Loai_Thu_RecyclerView_Adapter(List<Loai_Thu> loai_thuList, Context context) {
        this.loai_thuList = loai_thuList;
        this.context = context;
    }

    @NonNull
    @Override
    public Loai_Thu_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.icon_loai_thu, parent, false);
        return new Loai_Thu_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Loai_Thu_ViewHolder holder, int position) {
        holder.ten_loaithu.setText(loai_thuList.get(position).getTenLoaiThu());
    }

    @Override
    public int getItemCount() {
        return loai_thuList.size();
    }
}
