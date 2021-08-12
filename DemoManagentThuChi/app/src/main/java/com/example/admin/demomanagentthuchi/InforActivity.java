package com.example.admin.demomanagentthuchi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.admin.demomanagentthuchi.Model.information;
import com.example.admin.demomanagentthuchi.MyAdapter.Adapter_Informatio;

import java.util.ArrayList;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public class InforActivity extends SwipeBackActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    ArrayList<information> ds = new ArrayList<information>();
    SwipeBackLayout swipeBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor);

        //swipeBack have to add library and have to extend SwipeBackActivity
        swipeBackLayout = getSwipeBackLayout();
        int edgeFlag = 0;
        edgeFlag = swipeBackLayout.EDGE_LEFT; // at here you can choose as EDGE_BOTTOM TOP RIGHT etc.
        swipeBackLayout.setEdgeTrackingEnabled(edgeFlag);
        //swipeBack have to add library and have to extend SwipeBackActivity


        //even back for activity
        toolbar = (Toolbar) findViewById(R.id.allLayout);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_back);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //even back for activity

        //Goi Adapter qua
        recyclerView = (RecyclerView) findViewById(R.id.days_list);

        Adapter_Informatio adapter_informatio = new Adapter_Informatio(ds, InforActivity.this);
        LinearLayoutManager manager = new LinearLayoutManager(InforActivity.this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter_informatio);

        TaoDanhSach();
        //Goi Adapter qua

    }

    public void TaoDanhSach() {
        ds.add(new information("Tên phần mền", "Quản lý thu chi"));
        ds.add(new information("Ngày tạo", "01/08/2020"));
        ds.add(new information("Phiên bản", "X.5000"));
        ds.add(new information("Nhà phát triển", "Tạ Minh Hiếu"));
        ds.add(new information("Lớp", "PT15355"));
        ds.add(new information("Chuyên ngành", "Lập trình mobile"));
        ds.add(new information("Khóa", "K15.3.1"));
        ds.add(new information("Nơi đào tạo", "FPT Polytecnic - Hà Nội"));
        ds.add(new information("Dự Án", "Assignment"));
    }
}
