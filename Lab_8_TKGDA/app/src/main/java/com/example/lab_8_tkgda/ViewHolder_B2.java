package com.example.lab_8_tkgda;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder_B2 extends RecyclerView.ViewHolder {

    ImageView anh_b2, favourite, share;
    TextView ten_b2;
    View backop;

    public ViewHolder_B2(@NonNull View itemView) {
        super(itemView);

        anh_b2 = itemView.findViewById(R.id.anh_b2);
        favourite = itemView.findViewById(R.id.favourite_b2);
        share = itemView.findViewById(R.id.share_b2);
        ten_b2 = itemView.findViewById(R.id.ten_b2);
        backop = itemView.findViewById(R.id.backgop);

        anh_b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), ten_b2.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });

        backop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), ten_b2.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });


        ten_b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), ten_b2.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });

        favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Bạn đã thích " + ten_b2.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Cảm ơn bạn đã share " + ten_b2.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
