package com.example.lab_5_tkgda;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class AdapterCauHoi extends BaseAdapter {

    List<Cauhoi> cauhois;
    ViewHolder viewHolder;
    Context context;
    String[] tuoi = new String[80];

    int tuoii = 18;


    public AdapterCauHoi(List<Cauhoi> cauhois, Context context) {
        this.cauhois = cauhois;
        this.context = context;
    }

    @Override
    public int getCount() {
        return cauhois.size();
    }

    @Override
    public Object getItem(int position) {
        return cauhois.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int a = position;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.layout1, parent, false);
            viewHolder.stt = convertView.findViewById(R.id.stt);
            viewHolder.cauhoi = convertView.findViewById(R.id.cauhoi);
            viewHolder.cautraloi = convertView.findViewById(R.id.cautraloi);
            viewHolder.btntraloi = convertView.findViewById(R.id.btn_traloi);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.stt.setText(String.valueOf(position + 1));
        viewHolder.cauhoi.setText(cauhois.get(position).getCauhoi());
        viewHolder.cautraloi.setText(cauhois.get(position).getCautraloi());
        viewHolder.btntraloi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context = v.getContext();

//                AlertDialog.Builder builder = new AlertDialog.Builder(context);
//                View view = LayoutInflater.from(context).inflate(R.layout.layout2, null, false);
//                TextView textView = view.findViewById(R.id.text1);
//                textView.setText(cauhois.get(position).getCauhoi());
//                builder.setView(view);
//                builder.create().show();


                AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                int tuoiii = 16;

                for (int i = 0; i < tuoi.length; i++) {
                    tuoi[i] = String.valueOf(tuoiii);
                    tuoiii ++;
                }


//                builder1.setTitle(cauhois.get(position).getCauhoi());
//                builder1.setItems(tuoi, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
                builder1.setTitle(cauhois.get(a).getCauhoi());

                builder1.setSingleChoiceItems(tuoi, 2, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        cauhois.get(a).setCautraloi("Bạn đã chọn: " + tuoi[which]);
                    }

                });



                builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        viewHolder.cautraloi.setText(cauhois.get(a).getCautraloi());

                        Intent intent =  new Intent(context, Layout2.class);
//                        Bundle bundle = new Bundle();
//                        bundle.putString("cauhoi", cauhois.get(a).getCauhoi());
//                        intent.putExtras(bundle);
                        context.startActivity(intent);



                    }
                });

                builder1.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder1.show();
            }

        });


        return convertView;
    }



    public class ViewHolder{
        TextView stt, cauhoi, cautraloi;
        Button btntraloi;

    }

}
