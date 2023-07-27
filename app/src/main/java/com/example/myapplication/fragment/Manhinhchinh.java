package com.example.myapplication.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.myapplication.Amthanh;
import com.example.myapplication.ChonCapDo;
import com.example.myapplication.DatabaseHandler;
import com.example.myapplication.MainActivity2;
import com.example.myapplication.MainActivity3;
import com.example.myapplication.R;

public class Manhinhchinh extends Fragment {
    Button Start,timhinh;
    TextView sosao;
    int i=1000000;
    private MainActivity2 mainActivity2;
    int a;
    public Manhinhchinh(int a){
        this.a=a;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.giaodienchinh,container,false);

        Start=view.findViewById(R.id.Batcap);
        sosao=view.findViewById(R.id.Sosao);
        sosao.setText("Sao của bạn: "+a);
        Animation animation = AnimationUtils.loadAnimation(getContext(),R.anim.lac);
        Start.setAnimation(animation);
        animation.start();

        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                       /* YoYo.with(Techniques.Swing)
                                .duration(10000)
                                .repeat(i)
                                .playOn(Start);
                  i++;*/
                startActivity(new Intent(getContext(), ChonCapDo.class));
                mainActivity2=(MainActivity2)getActivity();
                mainActivity2.Chamvao();
            }
        });

        return view;

    }
}
