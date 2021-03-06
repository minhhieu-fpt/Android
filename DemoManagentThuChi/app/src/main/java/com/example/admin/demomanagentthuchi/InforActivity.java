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
        ds.add(new information("T??n ph???n m???n", "Qu???n l?? thu chi"));
        ds.add(new information("Ng??y t???o", "01/08/2020"));
        ds.add(new information("Phi??n b???n", "X.5000"));
        ds.add(new information("Nh?? ph??t tri???n", "T??? Minh Hi???u"));
        ds.add(new information("L???p", "PT15355"));
        ds.add(new information("Chuy??n ng??nh", "L???p tr??nh mobile"));
        ds.add(new information("Kh??a", "K15.3.1"));
        ds.add(new information("N??i ????o t???o", "FPT Polytecnic - H?? N???i"));
        ds.add(new information("D??? ??n", "Assignment"));
    }
}
