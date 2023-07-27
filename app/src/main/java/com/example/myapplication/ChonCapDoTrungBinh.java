package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ChonCapDoTrungBinh extends AppCompatActivity {

    ImageView[] imageView;
    ImageView[] imageViewsao;
    String lever;
    final String DATABASE_NAME = "TroChoiTriNho.db";
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_cap_do_trung_binh);
        imageViewsao=new ImageView[24];
        imageViewsao[0]=findViewById(R.id.Sao1_LV2_1);
        imageViewsao[1]=findViewById(R.id.Sao2_LV2_1);
        imageViewsao[2]=findViewById(R.id.Sao3_LV2_1);
        imageViewsao[3]=findViewById(R.id.Sao1_LV2_2);
        imageViewsao[4]=findViewById(R.id.Sao2_LV2_2);
        imageViewsao[5]=findViewById(R.id.Sao3_LV2_2);
        imageViewsao[6]=findViewById(R.id.Sao1_LV2_3);
        imageViewsao[7]=findViewById(R.id.Sao2_LV2_3);
        imageViewsao[8]=findViewById(R.id.Sao3_LV2_3);
        imageViewsao[9]=findViewById(R.id.Sao1_LV2_4);
        imageViewsao[10]=findViewById(R.id.Sao2_LV2_4);
        imageViewsao[11]=findViewById(R.id.Sao3_LV2_4);
        imageViewsao[12]=findViewById(R.id.Sao1_LV2_5);
        imageViewsao[13]=findViewById(R.id.Sao2_LV2_5);
        imageViewsao[14]=findViewById(R.id.Sao3_LV2_5);
        imageViewsao[15]=findViewById(R.id.Sao1_LV2_6);
        imageViewsao[16]=findViewById(R.id.Sao2_LV2_6);
        imageViewsao[17]=findViewById(R.id.Sao3_LV2_6);
        imageViewsao[18]=findViewById(R.id.Sao1_LV2_7);
        imageViewsao[19]=findViewById(R.id.Sao2_LV2_7);
        imageViewsao[20]=findViewById(R.id.Sao3_LV2_7);
        imageViewsao[21]=findViewById(R.id.Sao1_LV2_8);
        imageViewsao[22]=findViewById(R.id.Sao2_LV2_8);
        imageViewsao[23]=findViewById(R.id.Sao3_LV2_8);

        imageView=new ImageView[8];
        imageView[0]=findViewById(R.id.hinhLV2_1);
        imageView[1]=findViewById(R.id.hinhLV2_2);
        imageView[2]=findViewById(R.id.hinhLV2_3);
        imageView[3]=findViewById(R.id.hinhLV2_4);
        imageView[4]=findViewById(R.id.hinhLV2_5);
        imageView[5]=findViewById(R.id.hinhLV2_6);
        imageView[6]=findViewById(R.id.hinhLV2_7);
        imageView[7]=findViewById(R.id.hinhLV2_8);
        for(int i=0;i<imageView.length;i++){
            imageView[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()){

                        case R.id.hinhLV2_1:
                            lever="9";
                            Intent intent1 = new Intent(ChonCapDoTrungBinh.this, CapDoTrungBinh.class);
                            intent1.putExtra("abc", lever);
                            startActivity(intent1);
                            MainActivity2.amthanh.Chamvao();
                            finish();

                            break;
                        case R.id.hinhLV2_2:
                            lever ="10";
                            ClickCapDoTrungBinh(9,lever);

                            break;
                        case R.id.hinhLV2_3:
                            lever ="11";
                            ClickCapDoTrungBinh(10,lever);

                            break;
                        case R.id.hinhLV2_4:
                            lever ="12";
                            ClickCapDoTrungBinh(11,lever);

                            break;
                        case R.id.hinhLV2_5:

                            lever="13";
                            ClickCapDoTrungBinh(12,lever);

                            break;
                        case R.id.hinhLV2_6:
                            lever ="14";
                            ClickCapDoTrungBinh(13,lever);

                            break;
                        case R.id.hinhLV2_7:
                            lever ="15";
                            ClickCapDoTrungBinh(14,lever);

                            break;
                        case R.id.hinhLV2_8:
                            lever ="16";
                            ClickCapDoTrungBinh(15,lever);

                            break;


                    }

                }
            });
        }
        Load(DATABASE_NAME);
    }
    private void ClickCapDoTrungBinh(int levertruoc,String lever){
        database=DatabaseHandler.initDatabase(ChonCapDoTrungBinh.this,DATABASE_NAME);
        Cursor cursor;
        cursor = database.rawQuery("select * from ChiTietTroChoi where CapDo="+levertruoc , null);
        int count = cursor.getCount();
        if (count == 1) {
            Intent intent2 = new Intent(ChonCapDoTrungBinh.this, CapDoTrungBinh.class);
            intent2.putExtra("abc", lever);
            startActivity(intent2);
            MainActivity2.amthanh.Chamvao();
            finish();
        }
    }
    private void Load(String DATABASE_NAME){
        database=DatabaseHandler.initDatabase(this,DATABASE_NAME);
        String MaTC="TC01";
        Cursor cursor;
        cursor = database.rawQuery("select * from ChiTietTroChoi " , null);
        int count = cursor.getCount();
        if(count>=1) {
            cursor.moveToFirst();
            do {
                int a = cursor.getInt(1);
                int b = cursor.getInt(2);
                if (a == 9) {
                    imageView[1].setBackgroundResource(R.drawable.anhmodau);
                    //0
                    LoadAnhSaoCDD(b,0);

                } else if (a == 10) {
                    imageView[2].setBackgroundResource(R.drawable.anhmodau);
                    //3
                    LoadAnhSaoCDD(b,3);

                } else if (a == 11) {
                    imageView[3].setBackgroundResource(R.drawable.anhmodau);
                    //6
                    LoadAnhSaoCDD(b,6);

                } else if (a == 12) {
                    imageView[4].setBackgroundResource(R.drawable.anhmodau);
                    //9
                    LoadAnhSaoCDD(b,9);

                } else if (a == 13) {
                    imageView[5].setBackgroundResource(R.drawable.anhmodau);
                    //12
                    LoadAnhSaoCDD(b,12);

                } else if (a == 14) {
                    imageView[6].setBackgroundResource(R.drawable.anhmodau);
                    //15
                    LoadAnhSaoCDD(b,15);

                } else if (a == 15) {
                    imageView[7].setBackgroundResource(R.drawable.anhmodau);
                    //18
                    LoadAnhSaoCDD(b,18);
                }
                else if (a == 16) {
                    //imageView[7].setBackgroundResource(R.drawable.anhmodau2);
                    //18
                    LoadAnhSaoCDD(b,21);
                }
            } while (cursor.moveToNext());
        }
        if(count==0){

        }

    }
    private void LoadAnhSaoCDD(int b,int i){
        if (b == 1) {
            imageViewsao[i].setBackgroundResource(R.drawable.sao);
        } else if (b == 2) {
            imageViewsao[i].setBackgroundResource(R.drawable.sao);
            imageViewsao[i+1].setBackgroundResource(R.drawable.sao);
        } else if (b == 3) {
            imageViewsao[i].setBackgroundResource(R.drawable.sao);
            imageViewsao[i+1].setBackgroundResource(R.drawable.sao);
            imageViewsao[i+2].setBackgroundResource(R.drawable.sao);
        }
    }
}