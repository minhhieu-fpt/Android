package com.example.lab_6_tkgda;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ONE extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.one, container, false);
        if(getArguments() != null){
            TextView textView = view.findViewById(R.id.textView2);
            String chuoi = getArguments().get("so").toString();
            textView.setText(chuoi);
        }
        return view;
    }
}
