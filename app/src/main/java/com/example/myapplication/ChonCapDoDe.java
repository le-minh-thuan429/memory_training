package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ChonCapDoDe extends AppCompatActivity {

    ImageView[] imageView;
    ImageView[] imageViewsao;
    String lever;
    final String DATABASE_NAME = "TroChoiTriNho.db";
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_cap_do_de);
        imageViewsao=new ImageView[24];
        imageViewsao[0]=(ImageView)findViewById(R.id.Sao1_LV1_1);
        imageViewsao[1]=findViewById(R.id.Sao2_LV1_1);
        imageViewsao[2]=findViewById(R.id.Sao3_LV1_1);
        imageViewsao[3]=findViewById(R.id.Sao1_LV1_2);
        imageViewsao[4]=findViewById(R.id.Sao2_LV1_2);
        imageViewsao[5]=findViewById(R.id.Sao3_LV1_2);
        imageViewsao[6]=findViewById(R.id.Sao1_LV1_3);
        imageViewsao[7]=findViewById(R.id.Sao2_LV1_3);
        imageViewsao[8]=findViewById(R.id.Sao3_LV1_3);
        imageViewsao[9]=findViewById(R.id.Sao1_LV1_4);
        imageViewsao[10]=findViewById(R.id.Sao2_LV1_4);
        imageViewsao[11]=findViewById(R.id.Sao3_LV1_4);
        imageViewsao[12]=findViewById(R.id.Sao1_LV1_5);
        imageViewsao[13]=findViewById(R.id.Sao2_LV1_5);
        imageViewsao[14]=findViewById(R.id.Sao3_LV1_5);
        imageViewsao[15]=findViewById(R.id.Sao1_LV1_6);
        imageViewsao[16]=findViewById(R.id.Sao2_LV1_6);
        imageViewsao[17]=findViewById(R.id.Sao3_LV1_6);
        imageViewsao[18]=findViewById(R.id.Sao1_LV1_7);
        imageViewsao[19]=findViewById(R.id.Sao2_LV1_7);
        imageViewsao[20]=findViewById(R.id.Sao3_LV1_7);
        imageViewsao[21]=findViewById(R.id.Sao1_LV1_8);
        imageViewsao[22]=findViewById(R.id.Sao2_LV1_8);
        imageViewsao[23]=findViewById(R.id.Sao3_LV1_8);

        imageView=new ImageView[8];
        imageView[0]=findViewById(R.id.hinhLV1_1);
        imageView[1]=findViewById(R.id.hinhLV1_2);
        imageView[2]=findViewById(R.id.hinhLV1_3);
        imageView[3]=findViewById(R.id.hinhLV1_4);
        imageView[4]=findViewById(R.id.hinhLV1_5);
        imageView[5]=findViewById(R.id.hinhLV1_6);
        imageView[6]=findViewById(R.id.hinhLV1_7);
        imageView[7]=findViewById(R.id.hinhLV1_8);

        for(int i=0;i<imageView.length;i++){
            imageView[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()){
                        case R.id.hinhLV1_1:
                            lever="1";
                            Intent intent1 = new Intent(ChonCapDoDe.this, CapDoDe.class);
                            intent1.putExtra("abc", lever);
                            startActivity(intent1);
                            MainActivity2.amthanh.Chamvao();
                            finish();
                            break;
                        case R.id.hinhLV1_2:

                            lever="2";
                            ClickCapDoDe(1,lever);

                            break;
                        case R.id.hinhLV1_3:
                            lever="3";
                            ClickCapDoDe(2,lever);

                            break;
                        case R.id.hinhLV1_4:
                            lever ="4";
                            ClickCapDoDe(3,lever);

                            // database.execSQL("delete from ChiTietTroChoi ");
                            break;
                        case R.id.hinhLV1_5:

                            lever="5";
                            ClickCapDoDe(4,lever);

                            break;
                        case R.id.hinhLV1_6:
                            lever ="6";
                            ClickCapDoDe(5,lever);

                            break;
                        case R.id.hinhLV1_7:
                            lever ="7";
                            ClickCapDoDe(6,lever);

                            break;
                        case R.id.hinhLV1_8:
                            lever ="8";
                            ClickCapDoDe(7,lever);

                            break;

                    }

                }
            });
        }
        Load(DATABASE_NAME);

    }
    private void ClickCapDoDe(int levertruoc,String lever){
        database=DatabaseHandler.initDatabase(ChonCapDoDe.this,DATABASE_NAME);
        Cursor cursor;
        cursor = database.rawQuery("select * from ChiTietTroChoi where CapDo="+levertruoc , null);
        int count = cursor.getCount();
        if (count == 1) {
            Intent intent2 = new Intent(ChonCapDoDe.this, CapDoDe.class);
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
                int a = cursor.getInt(1);//lever
                int b = cursor.getInt(2);//số sao
                if (a == 1) {
                    imageView[1].setBackgroundResource(R.drawable.anhmodau2);
                    //0
                    LoadAnhSaoCDD(b,0);

                } else if (a == 2) {
                    imageView[2].setBackgroundResource(R.drawable.anhmodau2);
                    //3
                    LoadAnhSaoCDD(b,3);

                } else if (a == 3) {
                    imageView[3].setBackgroundResource(R.drawable.anhmodau2);
                    //6
                    LoadAnhSaoCDD(b,6);

                } else if (a == 4) {
                    imageView[4].setBackgroundResource(R.drawable.anhmodau2);
                    //9
                    LoadAnhSaoCDD(b,9);

                } else if (a == 5) {
                    imageView[5].setBackgroundResource(R.drawable.anhmodau2);
                    //12
                    LoadAnhSaoCDD(b,12);

                } else if (a == 6) {
                    imageView[6].setBackgroundResource(R.drawable.anhmodau2);
                    //15
                    LoadAnhSaoCDD(b,15);

                } else if (a == 7) {
                    imageView[7].setBackgroundResource(R.drawable.anhmodau2);
                    //18
                    LoadAnhSaoCDD(b,18);
                }
                else if (a == 8) {
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