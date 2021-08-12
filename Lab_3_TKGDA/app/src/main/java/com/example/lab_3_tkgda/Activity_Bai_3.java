package com.example.lab_3_tkgda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class Activity_Bai_3 extends AppCompatActivity {
    GridView gridView;
    List<GridVieww> gridViewws;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__bai_3);
        gridView = findViewById(R.id.gridlayout3);
        gridViewws = new ArrayList<>();
        gridView = findViewById(R.id.gridlayout3);

        GridVieww gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.android);
        gridVieww.setName("Android");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.apple);
        gridVieww.setName("Apple");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.blogger);
        gridVieww.setName("Blogger");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.chrome);
        gridVieww.setName("Chrome");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.dell);
        gridVieww.setName("Dell");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.facebookkk);
        gridVieww.setName("Facebook");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.firefox);
        gridVieww.setName("Firefox");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.hp);
        gridVieww.setName("Hp");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.ie);
        gridVieww.setName("Ie");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.microsoft);
        gridVieww.setName("Microsoft");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.twitter);
        gridVieww.setName("Twitter");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.xbox);
        gridVieww.setName("Xbox");
        gridViewws.add(gridVieww);


        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.android);
        gridVieww.setName("Android");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.apple);
        gridVieww.setName("Apple");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.blogger);
        gridVieww.setName("Blogger");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.chrome);
        gridVieww.setName("Chrome");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.dell);
        gridVieww.setName("Dell");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.facebookkk);
        gridVieww.setName("Facebook");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.firefox);
        gridVieww.setName("Firefox");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.hp);
        gridVieww.setName("Hp");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.ie);
        gridVieww.setName("Ie");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.microsoft);
        gridVieww.setName("Microsoft");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.twitter);
        gridVieww.setName("Twitter");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.xbox);
        gridVieww.setName("Xbox");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.android);
        gridVieww.setName("Android");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.apple);
        gridVieww.setName("Apple");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.blogger);
        gridVieww.setName("Blogger");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.chrome);
        gridVieww.setName("Chrome");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.dell);
        gridVieww.setName("Dell");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.facebookkk);
        gridVieww.setName("Facebook");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.firefox);
        gridVieww.setName("Firefox");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.hp);
        gridVieww.setName("Hp");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.ie);
        gridVieww.setName("Ie");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.microsoft);
        gridVieww.setName("Microsoft");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.twitter);
        gridVieww.setName("Twitter");
        gridViewws.add(gridVieww);

        gridVieww = new GridVieww();
        gridVieww.setImg(R.drawable.xbox);
        gridVieww.setName("Xbox");
        gridViewws.add(gridVieww);

        Grid_Adapter grid_adapter = new Grid_Adapter(gridViewws);
        gridView.setAdapter(grid_adapter);

    }
}
