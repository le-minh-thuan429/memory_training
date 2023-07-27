package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.MainActivity2;
import com.example.myapplication.R;

public class QuyTac extends Fragment {
    Button trolai;
    private MainActivity2 mainActivity2;
    int sao;
    public QuyTac(int sao){
        this.sao=sao;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.quytac,container,false);

        mainActivity2=(MainActivity2)getActivity();
        trolai=view.findViewById(R.id.trolai);
        trolai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity2.replaceFragment(new Manhinhchinh(sao));
            }
        });

        return view;
    }
}
