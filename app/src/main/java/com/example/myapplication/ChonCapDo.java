package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChonCapDo extends AppCompatActivity {

    Button capdode,capdotrungbinh,capdokho;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_cap_do);
        capdode=findViewById(R.id.capdode);
        capdotrungbinh=findViewById(R.id.capdotrungbinh);
        capdokho=findViewById(R.id.capdokho);
        capdode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ChonCapDo.this, ChonCapDoDe.class);

                startActivity(intent1);
            }
        });
        capdotrungbinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ChonCapDo.this, ChonCapDoTrungBinh.class);

                startActivity(intent1);
            }
        });
        capdokho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ChonCapDo.this, ChonCapDoKho.class);

                startActivity(intent1);
            }
        });
    }
}