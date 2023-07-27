package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ChonCapDoKho extends AppCompatActivity {

    ImageView[] imageView;
    ImageView[] imageViewsao;
    String lever;
    final String DATABASE_NAME = "TroChoiTriNho.db";
    SQLiteDatabase database;
    Amthanh amthanh;
    private MainActivity2 mainActivity2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_cap_do_kho);
        imageViewsao=new ImageView[24];
        imageViewsao[0]=findViewById(R.id.Sao1_LV3_1);
        imageViewsao[1]=findViewById(R.id.Sao2_LV3_1);
        imageViewsao[2]=findViewById(R.id.Sao3_LV3_1);
        imageViewsao[3]=findViewById(R.id.Sao1_LV3_2);
        imageViewsao[4]=findViewById(R.id.Sao2_LV3_2);
        imageViewsao[5]=findViewById(R.id.Sao3_LV3_2);
        imageViewsao[6]=findViewById(R.id.Sao1_LV3_3);
        imageViewsao[7]=findViewById(R.id.Sao2_LV3_3);
        imageViewsao[8]=findViewById(R.id.Sao3_LV3_3);
        imageViewsao[9]=findViewById(R.id.Sao1_LV3_4);
        imageViewsao[10]=findViewById(R.id.Sao2_LV3_4);
        imageViewsao[11]=findViewById(R.id.Sao3_LV3_4);
        imageViewsao[12]=findViewById(R.id.Sao1_LV3_5);
        imageViewsao[13]=findViewById(R.id.Sao2_LV3_5);
        imageViewsao[14]=findViewById(R.id.Sao3_LV3_5);
        imageViewsao[15]=findViewById(R.id.Sao1_LV3_6);
        imageViewsao[16]=findViewById(R.id.Sao2_LV3_6);
        imageViewsao[17]=findViewById(R.id.Sao3_LV3_6);
        imageViewsao[18]=findViewById(R.id.Sao1_LV3_7);
        imageViewsao[19]=findViewById(R.id.Sao2_LV3_7);
        imageViewsao[20]=findViewById(R.id.Sao3_LV3_7);
        imageViewsao[21]=findViewById(R.id.Sao1_LV3_8);
        imageViewsao[22]=findViewById(R.id.Sao2_LV3_8);
        imageViewsao[23]=findViewById(R.id.Sao3_LV3_8);

        imageView=new ImageView[8];
        imageView[0]=findViewById(R.id.hinhLV3_1);
        imageView[1]=findViewById(R.id.hinhLV3_2);
        imageView[2]=findViewById(R.id.hinhLV3_3);
        imageView[3]=findViewById(R.id.hinhLV3_4);
        imageView[4]=findViewById(R.id.hinhLV3_5);
        imageView[5]=findViewById(R.id.hinhLV3_6);
        imageView[6]=findViewById(R.id.hinhLV3_7);
        imageView[7]=findViewById(R.id.hinhLV3_8);

        for(int i=0;i<imageView.length;i++){
            imageView[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()){

                        case R.id.hinhLV3_1:
                            lever ="17";
                            Intent intent1 = new Intent(ChonCapDoKho.this, CapDoKho.class);
                            intent1.putExtra("abc", lever);
                            startActivity(intent1);
                            MainActivity2.amthanh.Chamvao();
                            finish();

                            break;
                        case R.id.hinhLV3_2:
                            lever ="18";
                            ClickCapDoKho(17,lever);

                            break;
                        case R.id.hinhLV3_3:
                            lever ="19";
                            ClickCapDoKho(18,lever);

                            break;
                        case R.id.hinhLV3_4:
                            lever ="20";
                            ClickCapDoKho(19,lever);

                            break;
                        case R.id.hinhLV3_5:
                            lever ="21";
                            ClickCapDoKho(20,lever);

                            break;
                        case R.id.hinhLV3_6:
                            lever ="22";
                            ClickCapDoKho(21,lever);

                            break;
                        case R.id.hinhLV3_7:
                            lever ="23";
                            ClickCapDoKho(22,lever);

                            break;
                        case R.id.hinhLV3_8:
                            lever ="24";
                            ClickCapDoKho(23,lever);

                            break;

                    }

                }
            });
        }
        Load(DATABASE_NAME);
    }
    private void ClickCapDoKho(int levertruoc,String lever){
        database=DatabaseHandler.initDatabase(ChonCapDoKho.this,DATABASE_NAME);
        Cursor cursor;
        cursor = database.rawQuery("select * from ChiTietTroChoi where CapDo="+levertruoc , null);
        int count = cursor.getCount();
        if (count == 1) {
            Intent intent2 = new Intent(ChonCapDoKho.this, CapDoKho.class);
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
                if (a == 17) {
                    imageView[1].setBackgroundResource(R.drawable.anhmodau3);
                    //0
                    LoadAnhSaoCDD(b,0);

                } else if (a == 18) {
                    imageView[2].setBackgroundResource(R.drawable.anhmodau3);
                    //3
                    LoadAnhSaoCDD(b,3);

                } else if (a == 19) {
                    imageView[3].setBackgroundResource(R.drawable.anhmodau3);
                    //6
                    LoadAnhSaoCDD(b,6);

                } else if (a == 20) {
                    imageView[4].setBackgroundResource(R.drawable.anhmodau3);
                    //9
                    LoadAnhSaoCDD(b,9);

                } else if (a == 21) {
                    imageView[5].setBackgroundResource(R.drawable.anhmodau3);
                    //12
                    LoadAnhSaoCDD(b,12);

                } else if (a == 22) {
                    imageView[6].setBackgroundResource(R.drawable.anhmodau3);
                    //15
                    LoadAnhSaoCDD(b,15);

                } else if (a == 23) {
                    imageView[7].setBackgroundResource(R.drawable.anhmodau3);
                    //18
                    LoadAnhSaoCDD(b,18);
                }
                else if (a == 24) {
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