package com.example.admin.demomanagentthuchi.MyAdapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeErrorDialog;
import com.awesomedialog.blennersilva.awesomedialoglibrary.interfaces.Closure;
import com.example.admin.demomanagentthuchi.LoaiChiFragment;
import com.example.admin.demomanagentthuchi.Model.Management_loaiThu;
import com.example.admin.demomanagentthuchi.Model.Mangement_loaiChi;
import com.example.admin.demomanagentthuchi.R;
import com.example.admin.demomanagentthuchi.SQLite.loaiChiDAO;
import com.example.admin.demomanagentthuchi.SQLite.loaiThuDAO;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class AdapterLoaiChi extends RecyclerView.Adapter<AdapterLoaiChi.MyViewHolder> implements Filterable {
    ArrayList<Mangement_loaiChi> listLoaiChi = new ArrayList<Mangement_loaiChi>();
    ArrayList<Mangement_loaiChi> listsearch1;//search

    Context context;
    LoaiChiFragment loaiChiFragment;

    public AdapterLoaiChi(ArrayList<Mangement_loaiChi> listLoaiChi, Context context, LoaiChiFragment loaiChiFragment) {
        this.listLoaiChi = listLoaiChi;
        this.context = context;
        this.loaiChiFragment = loaiChiFragment;
        listsearch1=new ArrayList<>(listLoaiChi);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.one_item_for_loai_chi, parent, false);
        return new MyViewHolder(v);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Mangement_loaiChi loaiChi = listLoaiChi.get(position);
        holder.tv_EDC.setText(loaiChi.tenLoaiChi);
        holder.iv_EditLoaiChi.setImageResource(R.drawable.edit);
        holder.iv_DeleteLoaiChi.setImageResource(R.drawable.delete);

        holder.iv_DeleteLoaiChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AwesomeErrorDialog(loaiChiFragment.getContext())
                        .setTitle("B???n c?? ch???c mu???n x??a")
                        .setMessage(" D??? li???u s??? kh??ng th??? ph???c h???i!")
                        .setColoredCircle(R.color.dialogErrorBackgroundColor)
                        .setDialogIconAndColor(R.drawable.ic_dialog_error, R.color.white)
                        .setCancelable(true).setButtonText("OK")
                        .setButtonBackgroundColor(R.color.dialogErrorBackgroundColor)
                        .setCancelable(true)
                        .setErrorButtonClick(new Closure() {
                            @Override
                            public void exec() {
                                // click
                                Mangement_loaiChi loaiChi1 = listLoaiChi.get(position);
                                loaiChiDAO loaiChiDAO = new loaiChiDAO(context);
                                int _id = loaiChi1._id;
                                loaiChiDAO.DeleteLoaiChi(_id);
                                //CAP NHAT GIAO DIEN
                                loaiChiFragment.capnhatGiaodien();
                                Toasty.success(loaiChiFragment.getContext(), "???? x??a!", Toast.LENGTH_SHORT, true).show();
                                // click
                            }
                        })
                        .setCancelable(true)
                        .show();

            }
        });
        holder.iv_EditLoaiChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //.......dialog
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(loaiChiFragment.getContext());
                LayoutInflater inf = loaiChiFragment.getActivity().getLayoutInflater();
                View view1 = inf.inflate(R.layout.dialog_edit_loai_chi, null);

                ///Lay du lieu va setText
                Mangement_loaiChi loaiChi = listLoaiChi.get(position);
                final EditText et_EditLoaiChi = view1.findViewById(R.id.et_EditLoaiChi);
                et_EditLoaiChi.setText(loaiChi.tenLoaiChi);
                ///Lay du lieu va setText

                alertDialog.setView(view1);

                alertDialog.setNegativeButton("C???p nh???t", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String tenLoaiThu = et_EditLoaiChi.getText().toString();

                        //SQLite
                        Mangement_loaiChi loaiChi = listLoaiChi.get(position);
                        Mangement_loaiChi loaiChi1 = new Mangement_loaiChi(loaiChi._id, tenLoaiThu);
                        loaiChiDAO loaiChiDAO = new loaiChiDAO(loaiChiFragment.getContext());
                        loaiChiDAO.UpdateLoaiChi(loaiChi1);
                        //SQLite
                        loaiChiFragment.capnhatGiaodien();
                        Toasty.success(loaiChiFragment.getContext(), "???? c???p nh???t!", Toast.LENGTH_SHORT, true).show();

                    }
                });
                alertDialog.setPositiveButton("H???y", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toasty.error(loaiChiFragment.getContext(), "???? h???y", Toast.LENGTH_SHORT, true).show();
                    }
                });
                alertDialog.show();

                //.....dialog
            }
        });


    }

    @Override
    public int getItemCount() {
        return listLoaiChi.size();
    }

    @Override
    public Filter getFilter() {
        return filterList;
    }

    //.........search
    private Filter filterList = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Mangement_loaiChi> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(listsearch1);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Mangement_loaiChi item : listsearch1) {
                    if (item.tenLoaiChi.toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            listLoaiChi.clear();
            listLoaiChi.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
    //.......search


    //.......Class nay c?? th??? ????? b??n ngo??i
     class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_EDC;
        public ImageView iv_EditLoaiChi, iv_DeleteLoaiChi;

        public MyViewHolder(View view) {
            super(view);
            this.tv_EDC = view.findViewById(R.id.tv_EDC);
            this.iv_DeleteLoaiChi = view.findViewById(R.id.iv_DeleteLoaiChi);
            this.iv_EditLoaiChi = view.findViewById(R.id.iv_editLoaiChi);
        }
    }
    //.......Class could outside.
}


