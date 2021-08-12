package com.example.hieutmph10003_asm_tkgda.recycleview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hieutmph10003_asm_tkgda.R;

public class Khoan_Thu_ViewHolder extends RecyclerView.ViewHolder {

    TextView title_khoan_thu, sotienthu_khoanthu, loaithu_khoanthu, ngaythu_khoanthu;
    ImageView sua_khoan_thu, xoa_khoan_thu;
    public Khoan_Thu_ViewHolder(@NonNull View itemView) {
        super(itemView);

        title_khoan_thu = itemView.findViewById(R.id.title_khoan_thu);
        sotienthu_khoanthu = itemView.findViewById(R.id.sotienthu_khoanthu);
        loaithu_khoanthu = itemView.findViewById(R.id.loaithu_khoanthu);
        ngaythu_khoanthu = itemView.findViewById(R.id.ngaythu_khoanthu);
        sua_khoan_thu = itemView.findViewById(R.id.sua_khoan_thu);
        xoa_khoan_thu = itemView.findViewById(R.id.xoa_khoan_thu);

    }
}
