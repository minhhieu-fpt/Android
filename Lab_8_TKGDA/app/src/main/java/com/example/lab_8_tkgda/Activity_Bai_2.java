package com.example.lab_8_tkgda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Activity_Bai_2 extends AppCompatActivity {

    List<View_Posts> view_postsList;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__bai_2);
        recyclerView = findViewById(R.id.recycler);

        view_postsList = new ArrayList<>();
        View_Posts view_posts = new View_Posts();
        view_posts.setImg(R.drawable.ahri);
        view_posts.setTen("Ahri");
        view_postsList.add(view_posts);

        view_posts = new View_Posts();
        view_posts.setImg(R.drawable.cassiopeia);
        view_posts.setTen("Cassiopeia");
        view_postsList.add(view_posts);

        view_posts = new View_Posts();
        view_posts.setImg(R.drawable.kindred);
        view_posts.setTen("Kindred");
        view_postsList.add(view_posts);

        view_posts = new View_Posts();
        view_posts.setImg(R.drawable.draven);
        view_posts.setTen("Draven");
        view_postsList.add(view_posts);

        view_posts = new View_Posts();
        view_posts.setImg(R.drawable.f3374ab8872dfaa9f94667f58812b070);
        view_posts.setTen("Azir");
        view_postsList.add(view_posts);

        GridLayoutManager linearLayoutManager = new GridLayoutManager(Activity_Bai_2.this,1);
        recyclerView.setLayoutManager(linearLayoutManager);

        Adapter_B2 adapter_b2 = new Adapter_B2(view_postsList, Activity_Bai_2.this);
        recyclerView.setAdapter(adapter_b2);

    }
}
