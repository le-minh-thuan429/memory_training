package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.fragment.Manhinhchinh;

public class MainActivity3 extends AppCompatActivity {

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
        setContentView(R.layout.activity_main3);

        imageViewsao=new ImageView[72];
        imageViewsao[0]=findViewById(R.id.Sao1_LV1_1);
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

        imageViewsao[24]=findViewById(R.id.Sao1_LV2_1);
        imageViewsao[25]=findViewById(R.id.Sao2_LV2_1);
        imageViewsao[26]=findViewById(R.id.Sao3_LV2_1);
        imageViewsao[27]=findViewById(R.id.Sao1_LV2_2);
        imageViewsao[28]=findViewById(R.id.Sao2_LV2_2);
        imageViewsao[29]=findViewById(R.id.Sao3_LV2_2);
        imageViewsao[30]=findViewById(R.id.Sao1_LV2_3);
        imageViewsao[31]=findViewById(R.id.Sao2_LV2_3);
        imageViewsao[32]=findViewById(R.id.Sao3_LV2_3);
        imageViewsao[33]=findViewById(R.id.Sao1_LV2_4);
        imageViewsao[34]=findViewById(R.id.Sao2_LV2_4);
        imageViewsao[35]=findViewById(R.id.Sao3_LV2_4);
        imageViewsao[36]=findViewById(R.id.Sao1_LV2_5);
        imageViewsao[37]=findViewById(R.id.Sao2_LV2_5);
        imageViewsao[38]=findViewById(R.id.Sao3_LV2_5);
        imageViewsao[39]=findViewById(R.id.Sao1_LV2_6);
        imageViewsao[40]=findViewById(R.id.Sao2_LV2_6);
        imageViewsao[41]=findViewById(R.id.Sao3_LV2_6);
        imageViewsao[42]=findViewById(R.id.Sao1_LV2_7);
        imageViewsao[43]=findViewById(R.id.Sao2_LV2_7);
        imageViewsao[44]=findViewById(R.id.Sao3_LV2_7);
        imageViewsao[45]=findViewById(R.id.Sao1_LV2_8);
        imageViewsao[46]=findViewById(R.id.Sao2_LV2_8);
        imageViewsao[47]=findViewById(R.id.Sao3_LV2_8);

        imageViewsao[48]=findViewById(R.id.Sao1_LV3_1);
        imageViewsao[49]=findViewById(R.id.Sao2_LV3_1);
        imageViewsao[50]=findViewById(R.id.Sao3_LV3_1);
        imageViewsao[51]=findViewById(R.id.Sao1_LV3_2);
        imageViewsao[52]=findViewById(R.id.Sao2_LV3_2);
        imageViewsao[53]=findViewById(R.id.Sao3_LV3_2);
        imageViewsao[54]=findViewById(R.id.Sao1_LV3_3);
        imageViewsao[55]=findViewById(R.id.Sao2_LV3_3);
        imageViewsao[56]=findViewById(R.id.Sao3_LV3_3);
        imageViewsao[57]=findViewById(R.id.Sao1_LV3_4);
        imageViewsao[58]=findViewById(R.id.Sao2_LV3_4);
        imageViewsao[59]=findViewById(R.id.Sao3_LV3_4);
        imageViewsao[60]=findViewById(R.id.Sao1_LV3_5);
        imageViewsao[61]=findViewById(R.id.Sao2_LV3_5);
        imageViewsao[62]=findViewById(R.id.Sao3_LV3_5);
        imageViewsao[63]=findViewById(R.id.Sao1_LV3_6);
        imageViewsao[64]=findViewById(R.id.Sao2_LV3_6);
        imageViewsao[65]=findViewById(R.id.Sao3_LV3_6);
        imageViewsao[66]=findViewById(R.id.Sao1_LV3_7);
        imageViewsao[67]=findViewById(R.id.Sao2_LV3_7);
        imageViewsao[68]=findViewById(R.id.Sao3_LV3_7);
        imageViewsao[69]=findViewById(R.id.Sao1_LV3_8);
        imageViewsao[70]=findViewById(R.id.Sao2_LV3_8);
        imageViewsao[71]=findViewById(R.id.Sao3_LV3_8);


        imageView=new ImageView[24];
        imageView[0]=findViewById(R.id.hinhLV1_1);
        imageView[1]=findViewById(R.id.hinhLV1_2);
        imageView[2]=findViewById(R.id.hinhLV1_3);
        imageView[3]=findViewById(R.id.hinhLV1_4);
        imageView[4]=findViewById(R.id.hinhLV1_5);
        imageView[5]=findViewById(R.id.hinhLV1_6);
        imageView[6]=findViewById(R.id.hinhLV1_7);
        imageView[7]=findViewById(R.id.hinhLV1_8);

        imageView[8]=findViewById(R.id.hinhLV2_1);
        imageView[9]=findViewById(R.id.hinhLV2_2);
        imageView[10]=findViewById(R.id.hinhLV2_3);
        imageView[11]=findViewById(R.id.hinhLV2_4);
        imageView[12]=findViewById(R.id.hinhLV2_5);
        imageView[13]=findViewById(R.id.hinhLV2_6);
        imageView[14]=findViewById(R.id.hinhLV2_7);
        imageView[15]=findViewById(R.id.hinhLV2_8);

        imageView[16]=findViewById(R.id.hinhLV3_1);
        imageView[17]=findViewById(R.id.hinhLV3_2);
        imageView[18]=findViewById(R.id.hinhLV3_3);
        imageView[19]=findViewById(R.id.hinhLV3_4);
        imageView[20]=findViewById(R.id.hinhLV3_5);
        imageView[21]=findViewById(R.id.hinhLV3_6);
        imageView[22]=findViewById(R.id.hinhLV3_7);
        imageView[23]=findViewById(R.id.hinhLV3_8);
        //amthanh=new Amthanh(MainActivity3.this);

        for(int i=0;i<imageView.length;i++){
            imageView[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()){
                        case R.id.hinhLV1_1:
                            lever="1";
                            Intent intent1 = new Intent(MainActivity3.this, CapDoDe.class);
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
                        case R.id.hinhLV2_1:
                            lever="9";
                           ClickCapDoTrungBinh(8,lever);

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
                        case R.id.hinhLV3_1:
                            lever ="17";
                            ClickCapDoKho(16,lever);

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
    private void ClickCapDoDe(int capdo,String lever){
        database=DatabaseHandler.initDatabase(MainActivity3.this,DATABASE_NAME);
        Cursor cursor;
        cursor = database.rawQuery("select * from ChiTietTroChoi where CapDo="+capdo , null);
        int count = cursor.getCount();
        if (count == 1) {
            Intent intent2 = new Intent(MainActivity3.this, CapDoDe.class);
            intent2.putExtra("abc", lever);
            startActivity(intent2);
            MainActivity2.amthanh.Chamvao();
            finish();
        }
    }
    private void ClickCapDoTrungBinh(int capdo,String lever){
        database=DatabaseHandler.initDatabase(MainActivity3.this,DATABASE_NAME);
        Cursor cursor;
        cursor = database.rawQuery("select * from ChiTietTroChoi where CapDo="+capdo , null);
        int count = cursor.getCount();
        if (count == 1) {
            Intent intent2 = new Intent(MainActivity3.this, CapDoTrungBinh.class);
            intent2.putExtra("abc", lever);
            startActivity(intent2);
            MainActivity2.amthanh.Chamvao();
            finish();
        }
    }
    private void ClickCapDoKho(int capdo,String lever){
        database=DatabaseHandler.initDatabase(MainActivity3.this,DATABASE_NAME);
        Cursor cursor;
        cursor = database.rawQuery("select * from ChiTietTroChoi where CapDo="+capdo , null);
        int count = cursor.getCount();
        if (count == 1) {
            Intent intent2 = new Intent(MainActivity3.this, CapDoKho.class);
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
                } else if (a == 8) {
                    imageView[8].setBackgroundResource(R.drawable.anhmodau);
                    //21
                    LoadAnhSaoCDD(b,21);
                }else if (a == 9) {
                    imageView[9].setBackgroundResource(R.drawable.anhmodau);
                    //24
                    LoadAnhSaoCDD(b,24);
                }else if (a == 10) {
                    imageView[10].setBackgroundResource(R.drawable.anhmodau);
                    //27
                    LoadAnhSaoCDD(b,27);
                }else if (a == 11) {
                    imageView[11].setBackgroundResource(R.drawable.anhmodau);
                    //30
                    LoadAnhSaoCDD(b,30);
                } else if (a == 12) {
                    imageView[12].setBackgroundResource(R.drawable.anhmodau);
                    //33
                    LoadAnhSaoCDD(b,33);
                } else if (a == 13) {
                    imageView[13].setBackgroundResource(R.drawable.anhmodau);
                    //36
                    LoadAnhSaoCDD(b,36);
                }else if (a == 14) {
                    imageView[14].setBackgroundResource(R.drawable.anhmodau);
                    //39
                    LoadAnhSaoCDD(b,39);
                }else if (a == 15) {
                    imageView[15].setBackgroundResource(R.drawable.anhmodau);
                    //42
                    LoadAnhSaoCDD(b,42);
                }else if (a == 16) {
                    imageView[16].setBackgroundResource(R.drawable.anhmodau3);
                    //45
                    LoadAnhSaoCDD(b,45);
                } else if (a == 17) {
                    imageView[17].setBackgroundResource(R.drawable.anhmodau3);
                    //48
                    LoadAnhSaoCDD(b,48);
                }else if (a == 18) {
                    imageView[18].setBackgroundResource(R.drawable.anhmodau3);
                    //51
                    LoadAnhSaoCDD(b,51);
                }else if (a == 19) {
                    imageView[19].setBackgroundResource(R.drawable.anhmodau3);
                    //54
                    LoadAnhSaoCDD(b,54);
                }else if (a == 20) {
                    imageView[20].setBackgroundResource(R.drawable.anhmodau3);
                    //57
                    LoadAnhSaoCDD(b,57);
                }else if (a == 21) {
                    imageView[21].setBackgroundResource(R.drawable.anhmodau3);
                    //60
                    LoadAnhSaoCDD(b,60);
                }else if (a == 22) {
                    imageView[22].setBackgroundResource(R.drawable.anhmodau3);
                    //63
                    LoadAnhSaoCDD(b,63);
                }else if (a == 23) {
                    imageView[23].setBackgroundResource(R.drawable.anhmodau3);
                    //66
                    LoadAnhSaoCDD(b,66);
                }else if (a == 24) {
                    //69
                    LoadAnhSaoCDD(b,69);
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


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this,"hello",Toast.LENGTH_SHORT).show();

    }
}