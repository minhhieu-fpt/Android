package com.example.hieutmph10003_asm_tkgda.recycleview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hieutmph10003_asm_tkgda.R;

public class Loai_Thu_ViewHolder extends RecyclerView.ViewHolder {

    TextView ten_loaithu;
    ImageView sua_loai_thu, xoa_loai_thu;
    public Loai_Thu_ViewHolder(@NonNull View itemView) {
        super(itemView);

        ten_loaithu = itemView.findViewById(R.id.ten_loaithu);
        sua_loai_thu = itemView.findViewById(R.id.sua_loai_thu);
        xoa_loai_thu = itemView.findViewById(R.id.xoa_loai_thu);
    }
}
