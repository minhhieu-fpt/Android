package com.example.lab_8_tkgda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_B2 extends RecyclerView.Adapter<ViewHolder_B2> {

    List<View_Posts> view_postss;
    Context context;

    public Adapter_B2(List<View_Posts> view_posts, Context context) {
        this.view_postss = view_posts;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder_B2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.icon_bai_2, parent, false);
        return new ViewHolder_B2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_B2 holder, int position) {
        View_Posts view_posts = view_postss.get(position);

        holder.anh_b2.setImageResource(view_posts.getImg());
        holder.ten_b2.setText(view_posts.getTen());

    }

    @Override
    public int getItemCount() {
        return view_postss.size();
    }
}
