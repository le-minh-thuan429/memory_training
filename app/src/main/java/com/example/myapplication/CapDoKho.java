package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Random;

public class CapDoKho extends AppCompatActivity {
    ImageButton[] bt;
    int[] imgsID;

    Integer number;
    int[] TTAnh;

    int a=0,b=0,c=0,d=0,e=0,f=0;

    boolean chon1=false,chon2=false,chon3=false,chon4=false,chon5=false,chon6=false,chon7=false,chon8=false,chon9=false,chon10=false,chon11=false,chon12=false;
    boolean trogiup1,trogiup2,trogiup3,trogiup4,trogiup5,trogiup6,trogiup7,trogiup8,trogiup9,trogiup10,trogiup11,trogiup12;
    int click1=0,click2=0,click3=0,click4=0,click5=0,click6=0,click7=0,click8=0,click9=0,click10=0,click11=0,click12=0;
    TextView thoigian;
    TextView Sosao,LV;

    int phut=0,giay=0,sao=0;
    boolean time=true;
    CountDownTimer countDownTime;

    int thoigianGiay=0;
    ImageButton SaoAnim;

    int Lever;

    LottieAnimationView lottieAnimationView,start;

    final String DATABASE_NAME = "TroChoiTriNho.db";
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.capdokho);

        thoigian=findViewById(R.id.Thoigian);
        start=findViewById(R.id.start);
        Sosao=findViewById(R.id.sao1);
        LV=findViewById(R.id.Lever);

        lottieAnimationView=findViewById(R.id.trogiup);

        String lever = getIntent().getStringExtra("abc").trim();
        Lever =Integer.parseInt(lever);
        LV.setText("LV"+Lever);
        SaoAnim=findViewById(R.id.sao);

        bt = new ImageButton[12];
        bt[0] = (ImageButton) findViewById(R.id.hinh1);
        bt[1] = (ImageButton) findViewById(R.id.hinh2);
        bt[2] = (ImageButton) findViewById(R.id.hinh3);
        bt[3] = (ImageButton) findViewById(R.id.hinh4);
        bt[4] = (ImageButton) findViewById(R.id.hinh5);
        bt[5] = (ImageButton) findViewById(R.id.hinh6);
        bt[6] = (ImageButton) findViewById(R.id.hinh7);
        bt[7] = (ImageButton) findViewById(R.id.hinh8);
        bt[8] = (ImageButton) findViewById(R.id.hinh9);
        bt[9] = (ImageButton) findViewById(R.id.hinh10);
        bt[10] = (ImageButton) findViewById(R.id.hinh11);
        bt[11] = (ImageButton) findViewById(R.id.hinh12);
        TTAnh=new int[12];
        RanDomAnh(17,Lever);
        LoadSao();
        MangAnh();
        BatDau();
        HieuUng();
    }
    private void HieuUng(){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.lac);
        SaoAnim.setAnimation(animation);
        animation.start();
        Animation animFade = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.dichuyentutrai);
        bt[0].startAnimation(animFade);
        bt[1].startAnimation(animFade);
        bt[2].startAnimation(animFade);
        bt[4].startAnimation(animFade);
        bt[5].startAnimation(animFade);
        bt[8].startAnimation(animFade);
        Animation animFade1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.dichuyentuphai);
        bt[6].startAnimation(animFade1);
        bt[3].startAnimation(animFade1);
        bt[9].startAnimation(animFade1);
        bt[7].startAnimation(animFade1);
        bt[10].startAnimation(animFade1);
        bt[11].startAnimation(animFade1);
    }

    private void RanDomAnh(int min,int max){
        Random random=new Random();
        int a= random.nextInt((max-min)+1)+min;
        switch (a){
            case 17:
                imgsID = new int[]{R.drawable.anh8, R.drawable.anh2, R.drawable.anh5,R.drawable.anh6,R.drawable.anh11,R.drawable.anh12};
                break;
            case 18:
                imgsID = new int[]{R.drawable.anh1, R.drawable.anh5, R.drawable.anh6,R.drawable.anh9,R.drawable.anh13,R.drawable.anh12};
                break;
            case 19:
                imgsID = new int[]{R.drawable.anh4, R.drawable.anh7, R.drawable.anh10,R.drawable.anh5,R.drawable.anh11,R.drawable.anh13};
                break;
            case 20:
                imgsID = new int[]{R.drawable.anh5, R.drawable.anh9, R.drawable.anh8,R.drawable.anh2,R.drawable.anh11,R.drawable.anh12};
                break;
            case 21:
                imgsID = new int[]{R.drawable.anh4, R.drawable.anh9, R.drawable.anh1,R.drawable.anh6,R.drawable.anh13,R.drawable.anh12};
                break;
            case 22:
                imgsID = new int[]{R.drawable.anh1, R.drawable.anh9, R.drawable.anh5,R.drawable.anh3,R.drawable.anh7,R.drawable.anh12};
                break;
            case 23:
                imgsID = new int[]{R.drawable.anh5, R.drawable.anh2, R.drawable.anh10,R.drawable.anh4,R.drawable.anh9,R.drawable.anh13};
                break;
            case 24:
                imgsID = new int[]{R.drawable.anh7, R.drawable.anh8, R.drawable.anh9,R.drawable.anh1,R.drawable.anh3,R.drawable.anh12};
                break;
        }
    }
    private void abc(){
        chon1 = false;
        chon2 = false;
        chon3 = false;
        chon4 = false;
        chon5 = false;
        chon6 = false;
        chon7=false;
        chon8=false;
        chon9=false;
        chon10=false;
        chon11=false;
        chon12=false;
    }
    private void Donglai(){
        if (chon1) {
            abc();
        }
        if (chon2) {
            abc();

        }
        if (chon3) {
            abc();

        }
        if (chon4) {
            abc();

        }
        if (chon5) {
            abc();

        }
        if (chon6) {
            abc();

        }
        if (chon7) {
            abc();

        }
        if (chon8) {
            abc();

        }
        if (chon9) {
            abc();

        }
        if (chon10) {
            abc();

        }
        if (chon11) {
            abc();

        }
        if (chon12) {
            abc();

        }
    }
    private void opent(int z){
        switch (z){
            case 0:
                trogiup1=true;
                break;
            case 1:
                trogiup2=true;
                break;
            case 2:
                trogiup3=true;
                break;
            case 3:
                trogiup4=true;
                break;
            case 4:
                trogiup5=true;
                break;
            case 5:
                trogiup6=true;
                break;
            case 6:
                trogiup7=true;
                break;
            case 7:
                trogiup8=true;
                break;
            case 8:
                trogiup9=true;
                break;
            case 9:
                trogiup10=true;
                break;
            case 10:
                trogiup11=true;
                break;
            case 11:
                trogiup12=true;
                break;
        }
    }
    private void close(int z){
        switch (z){
            case 0:
                trogiup1=false;
                break;
            case 1:
                trogiup2=false;
                break;
            case 2:
                trogiup3=false;
                break;
            case 3:
                trogiup4=false;
                break;
            case 4:
                trogiup5=false;
                break;
            case 5:
                trogiup6=false;
                break;
            case 6:
                trogiup7=false;
                break;
            case 7:
                trogiup8=false;
                break;
            case 8:
                trogiup9=false;
                break;
            case 9:
                trogiup10=false;
                break;
            case 10:
                trogiup11=false;
                break;
            case 11:
                trogiup12=false;
                break;
        }
    }
    private void Click(int z){
        switch (z){
            case 0:
                click1=1;
                break;
            case 1:
                click2=1;
                break;
            case 2:
                click3=1;
                break;
            case 3:
                click4=1;
                break;
            case 4:
                click5=1;
                break;
            case 5:
                click6=1;
                break;
            case 6:
                click7=1;
                break;
            case 7:
                click8=1;
                break;
            case 8:
                click9=1;
                break;
            case 9:
                click10=1;
                break;
            case 10:
                click11=1;
                break;
            case 11:
                click12=1;
                break;
        }
    }
    private void DieuKien(int z){

        if(chon1==true ) {
            if (TTAnh[z] == TTAnh[0]) {
                if(chon1==true  && z==0){
                    chon1=true;
                    opent(z);
                }if(chon1==true && z!=0){
                    opent(z);
                    Donglai();
                    click1=1;
                    Click(z);
                }
            } else {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bt[0].setBackgroundResource(R.drawable.bg_cd3);
                        bt[z].setBackgroundResource(R.drawable.bg_cd3);
                    }
                }, 500);

                abc();
                trogiup1=false;
                close(z);
            }
        }
        if(chon2==true ) {

            if (TTAnh[z] == TTAnh[1]) {

                if(chon2==true  &&z==1){
                    chon2=true;
                    opent(z);
                } if(chon2==true  && z!=1){
                    opent(z);
                    Donglai();
                    click2=1;
                    Click(z);
                }
            } else {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bt[1].setBackgroundResource(R.drawable.bg_cd3);
                        bt[z].setBackgroundResource(R.drawable.bg_cd3);
                    }
                }, 500);
                abc();
                trogiup2=false;
                close(z);
            }
        }

        if(chon3==true) {

            if (TTAnh[z] == TTAnh[2]) {
                if(chon3==true && z==2){
                    chon3=true;
                    opent(z);
                }
                if(chon3==true && z!=2) {
                    opent(z);
                    Donglai();
                    click3=1;
                    Click(z);
                }
            } else {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bt[2].setBackgroundResource(R.drawable.bg_cd3);
                        bt[z].setBackgroundResource(R.drawable.bg_cd3);
                    }
                }, 500);
                abc();
                trogiup3=false;
                close(z);
            }
        }


        if (chon4 == true) {

            if (TTAnh[z] == TTAnh[3]) {
                if(chon4==true && z==3){
                    chon4=true;
                    opent(z);
                }
                if(chon4==true && z!=3) {
                    opent(z);
                    Donglai();
                    click4=1;
                    Click(z);
                }
            } else {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bt[3].setBackgroundResource(R.drawable.bg_cd3);
                        bt[z].setBackgroundResource(R.drawable.bg_cd3);
                    }
                }, 500);
                abc();
                trogiup4=false;
                close(z);
            }
        }

        if (chon5 == true) {

            if (TTAnh[z] == TTAnh[4]) {
                if(chon5==true  && z==4){
                    chon5=true;
                    opent(z);
                }
                if(chon5==true && z!=4){
                    opent(z);
                    Donglai();
                    click5=1;
                    Click(z);
                }
            } else {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bt[4].setBackgroundResource(R.drawable.bg_cd3);
                        bt[z].setBackgroundResource(R.drawable.bg_cd3);
                    }
                }, 500);

                abc();
                trogiup5=false;
                close(z);
            }
        }

        if (chon6 == true) {

            if (TTAnh[z] == TTAnh[5]) {
                if(chon6==true && z==5){
                    chon6=true;
                    opent(z);
                }
                if(chon6==true && z!=5){
                    opent(z);
                    Donglai();
                    click6=1;
                    Click(z);
                }
            } else {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bt[5].setBackgroundResource(R.drawable.bg_cd3);
                        bt[z].setBackgroundResource(R.drawable.bg_cd3);
                    }
                }, 500);

                abc();
                trogiup6=false;
                close(z);
            }
        }
        if (chon7 == true) {

            if (TTAnh[z] == TTAnh[6]) {
                if (chon7 == true && z == 6) {
                    chon7 = true;
                    opent(z);
                }
                if (chon7 == true && z != 6) {
                    opent(z);
                    Donglai();
                    click7=1;
                    Click(z);
                    ;
                }
            } else {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bt[6].setBackgroundResource(R.drawable.bg_cd3);
                        bt[z].setBackgroundResource(R.drawable.bg_cd3);
                    }
                }, 500);

                abc();
                trogiup7 = false;
                close(z);
            }
        }
        if (chon8 == true) {

            if (TTAnh[z] == TTAnh[7]) {
                if (chon8 == true && z == 7) {
                    chon8 = true;
                    opent(z);
                }
                if (chon8 == true && z != 7) {
                    opent(z);
                    Donglai();
                    click8=1;
                    Click(z);
                    ;
                }
            } else {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bt[7].setBackgroundResource(R.drawable.bg_cd3);
                        bt[z].setBackgroundResource(R.drawable.bg_cd3);
                    }
                }, 500);

                abc();
                trogiup8 = false;
                close(z);
            }
        }
        if (chon9 == true) {

            if (TTAnh[z] == TTAnh[8]) {
                if (chon9 == true && z == 8) {
                    chon9 = true;
                    opent(z);
                }
                if (chon9 == true && z != 8) {
                    opent(z);
                    Donglai();
                    click9=1;
                    Click(z);
                    ;
                }
            } else {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bt[8].setBackgroundResource(R.drawable.bg_cd3);
                        bt[z].setBackgroundResource(R.drawable.bg_cd3);
                    }
                }, 500);

                abc();
                trogiup9 = false;
                close(z);
            }
        }
        if (chon10 == true) {

            if (TTAnh[z] == TTAnh[9]) {
                if (chon10 == true && z == 9) {
                    chon10 = true;
                    opent(z);
                }
                if (chon10 == true && z != 9) {
                    opent(z);
                    Donglai();
                    click10=1;
                    Click(z);

                }
            } else {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bt[9].setBackgroundResource(R.drawable.bg_cd3);
                        bt[z].setBackgroundResource(R.drawable.bg_cd3);
                    }
                }, 500);

                abc();
                trogiup10 = false;
                close(z);
            }
        }
        if (chon11 == true) {

            if (TTAnh[z] == TTAnh[10]) {
                if (chon11 == true && z == 10) {
                    chon11 = true;
                    opent(z);
                }
                if (chon11 == true && z != 10) {
                    opent(z);
                    Donglai();
                    click11=1;
                    Click(z);
                    ;
                }
            } else {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bt[10].setBackgroundResource(R.drawable.bg_cd3);
                        bt[z].setBackgroundResource(R.drawable.bg_cd3);
                    }
                }, 500);

                abc();
                trogiup11 = false;
                close(z);
            }
        }
        if (chon12 == true) {

            if (TTAnh[z] == TTAnh[11]) {
                if (chon12 == true && z == 11) {
                    chon12 = true;
                    opent(z);
                }
                if (chon12 == true && z != 11) {
                    opent(z);
                    Donglai();
                    click12=1;
                    Click(z);
                    ;
                }
            } else {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bt[11].setBackgroundResource(R.drawable.bg_cd3);
                        bt[z].setBackgroundResource(R.drawable.bg_cd3);
                    }
                }, 500);

                abc();
                trogiup12 = false;
                close(z);
            }
        }
    }
    private int RanDom(int min,int max) {
        Random random=new Random();
        return random.nextInt((max-min)+1)+min;
    }
    private void MangAnh() {

        for (int i = 0; i < 12; i++) {
            number = RanDom(0,5);
            if (number == 0) {
                a++;
                if (a < 3) {
                    TTAnh[i] = number;
                } else {
                    while (number == 0) {
                        number = RanDom(0, 5);
                    }

                }
            }
            if (number == 1) {
                b++;
                if (b < 3) {
                    TTAnh[i] = number;
                } else {
                    while (number == 1) {
                        number = RanDom(0, 5);
                    }
                    if (number == 0) {
                        a++;
                        if (a < 3) {
                            TTAnh[i] = number;
                        } else {
                            while (number == 0 || number == 1) {
                                number = RanDom(0, 5);
                            }

                        }
                    }

                }
            }
            if (number == 2) {
                c++;
                if (c < 3) {
                    TTAnh[i] = number;
                } else {
                    while (number == 2) {
                        number = RanDom(0, 5);
                    }
                    if (number == 0) {
                        a++;
                        if (a < 3) {
                            TTAnh[i] = number;
                        } else {
                            while (number == 0 || number == 2) {
                                number = RanDom(0, 5);
                            }

                        }
                    }
                    if (number == 1) {
                        b++;
                        if (b < 3) {
                            TTAnh[i] = number;
                        } else {
                            while (number == 1 || number == 2) {
                                number = RanDom(0, 5);
                            }
                            if (number == 0) {
                                a++;
                                if (a < 3) {
                                    TTAnh[i] = number;
                                } else {
                                    while (number == 0 || number == 2 || number == 1) {
                                        number = RanDom(0, 5);
                                    }

                                }
                            }

                        }
                    }
                }
            }
            if (number == 3) {
                d++;
                if (d < 3) {
                    TTAnh[i] = number;
                } else {
                    while (number == 3) {
                        number = RanDom(0, 5);
                    }
                    if (number == 0) {
                        a++;
                        if (a < 3) {
                            TTAnh[i] = number;
                        } else {
                            while (number == 0 || number == 3) {
                                number = RanDom(0, 5);
                            }

                        }
                    }
                    if (number == 1) {
                        b++;
                        if (b < 3) {
                            TTAnh[i] = number;
                        } else {
                            while (number == 1 || number == 3) {
                                number = RanDom(0, 5);
                            }
                            if (number == 0) {
                                a++;
                                if (a < 3) {
                                    TTAnh[i] = number;
                                } else {
                                    while (number == 0 || number == 1 || number == 3) {
                                        number = RanDom(0, 5);
                                    }

                                }
                            }

                        }
                    }
                    if (number == 2) {
                        c++;
                        if (c < 3) {
                            TTAnh[i] = number;
                        } else {
                            while (number == 2 || number == 3) {
                                number = RanDom(0, 5);
                            }
                            if (number == 0) {
                                a++;
                                if (a < 3) {
                                    TTAnh[i] = number;
                                } else {
                                    while (number == 0 || number == 2 || number == 3) {
                                        number = RanDom(0, 5);
                                    }

                                }
                            }
                            if (number == 1) {
                                b++;
                                if (b < 3) {
                                    TTAnh[i] = number;
                                } else {
                                    while (number == 1 || number == 3 || number == 2) {
                                        number = RanDom(0, 5);
                                    }
                                    if (number == 0) {
                                        a++;
                                        if (a < 3) {
                                            TTAnh[i] = number;
                                        } else {
                                            while (number == 0 || number == 2 || number == 1||number==3) {
                                                number = RanDom(0, 5);
                                            }

                                        }
                                    }

                                }
                            }
                        }
                    }

                }
            }
            if (number == 4) {
                e++;
                if (e < 3) {
                    TTAnh[i] = number;
                } else {
                    while (number == 4) {
                        number = RanDom(0, 5);
                    }
                    if (number == 0) {
                        a++;
                        if (a < 3) {
                            TTAnh[i] = number;
                        } else {
                            while (number == 0 || number == 4) {
                                number = RanDom(0, 5);
                            }

                        }
                    }
                    if (number == 1) {
                        b++;
                        if (b < 3) {
                            TTAnh[i] = number;
                        } else {
                            while (number == 1 || number == 4) {
                                number = RanDom(0, 5);
                            }
                            if (number == 0) {
                                a++;
                                if (a < 3) {
                                    TTAnh[i] = number;
                                } else {
                                    while (number == 0 || number == 1 || number == 4) {
                                        number = RanDom(0, 5);
                                    }

                                }
                            }

                        }
                    }
                    if (number == 2) {
                        c++;
                        if (c < 3) {
                            TTAnh[i] = number;
                        } else {
                            while (number == 2 || number == 4) {
                                number = RanDom(0, 5);
                            }
                            if (number == 0) {
                                a++;
                                if (a < 3) {
                                    TTAnh[i] = number;
                                } else {
                                    while (number == 0 || number == 2 || number == 4) {
                                        number = RanDom(0, 5);
                                    }

                                }
                            }
                            if (number == 1) {
                                b++;
                                if (b < 3) {
                                    TTAnh[i] = number;
                                } else {
                                    while (number == 1 || number == 4 || number == 2) {
                                        number = RanDom(0, 5);
                                    }
                                    if (number == 0) {
                                        a++;
                                        if (a < 3) {
                                            TTAnh[i] = number;
                                        } else {
                                            while (number == 0 || number == 2 || number == 1||number==4) {
                                                number = RanDom(0, 5);
                                            }

                                        }
                                    }

                                }
                            }
                        }
                    }
                    if (number == 3) {
                        d++;
                        if (d < 3) {
                            TTAnh[i] = number;
                        } else {
                            while (number == 3||number==4) {
                                number = RanDom(0, 5);
                            }
                            if (number == 0) {
                                a++;
                                if (a < 3) {
                                    TTAnh[i] = number;
                                } else {
                                    while (number == 0 || number == 3||number==4) {
                                        number = RanDom(0, 5);
                                    }

                                }
                            }
                            if (number == 1) {
                                b++;
                                if (b < 3) {
                                    TTAnh[i] = number;
                                } else {
                                    while (number == 1 || number == 3||number==4) {
                                        number = RanDom(0, 5);
                                    }
                                    if (number == 0) {
                                        a++;
                                        if (a < 3) {
                                            TTAnh[i] = number;
                                        } else {
                                            while (number == 0 || number == 1 || number == 3||number==4) {
                                                number = RanDom(0, 5);
                                            }

                                        }
                                    }

                                }
                            }
                            if (number == 2) {
                                c++;
                                if (c < 3) {
                                    TTAnh[i] = number;
                                } else {
                                    while (number == 2 || number == 3||number==4) {
                                        number = RanDom(0, 5);
                                    }
                                    if (number == 0) {
                                        a++;
                                        if (a < 3) {
                                            TTAnh[i] = number;
                                        } else {
                                            while (number == 0 || number == 2 || number == 3||number==4) {
                                                number = RanDom(0, 5);
                                            }

                                        }
                                    }
                                    if (number == 1) {
                                        b++;
                                        if (b < 3) {
                                            TTAnh[i] = number;
                                        } else {
                                            while (number == 1 || number == 3 || number == 2||number==4) {
                                                number = RanDom(0, 5);
                                            }
                                            if (number == 0) {
                                                a++;
                                                if (a < 3) {
                                                    TTAnh[i] = number;
                                                } else {
                                                    while (number == 0 || number == 2 || number == 1||number==3||number==4) {
                                                        number = RanDom(0, 5);
                                                    }

                                                }
                                            }

                                        }
                                    }
                                }
                            }

                        }
                    }

                }
            }
            if (number == 5) {
                f++;
                if (f < 3) {
                    TTAnh[i] = number;
                } else {
                    while (number == 5) {
                        number = RanDom(0, 5);
                    }
                    if (number == 0) {
                        a++;
                        if (a < 3) {
                            TTAnh[i] = number;
                        } else {
                            while (number == 0 || number == 5) {
                                number = RanDom(0, 5);
                            }

                        }
                    }
                    if (number == 1) {
                        b++;
                        if (b < 3) {
                            TTAnh[i] = number;
                        } else {
                            while (number == 1 || number == 5) {
                                number = RanDom(0, 5);
                            }
                            if (number == 0) {
                                a++;
                                if (a < 3) {
                                    TTAnh[i] = number;
                                } else {
                                    while (number == 0 || number == 1 || number == 5) {
                                        number = RanDom(0, 5);
                                    }

                                }
                            }

                        }
                    }
                    if (number == 2) {
                        c++;
                        if (c < 3) {
                            TTAnh[i] = number;
                        } else {
                            while (number == 2 || number == 5) {
                                number = RanDom(0, 5);
                            }
                            if (number == 0) {
                                a++;
                                if (a < 3) {
                                    TTAnh[i] = number;
                                } else {
                                    while (number == 0 || number == 2 || number == 5) {
                                        number = RanDom(0, 5);
                                    }

                                }
                            }
                            if (number == 1) {
                                b++;
                                if (b < 3) {
                                    TTAnh[i] = number;
                                } else {
                                    while (number == 1 || number == 5 || number == 2) {
                                        number = RanDom(0, 5);
                                    }
                                    if (number == 0) {
                                        a++;
                                        if (a < 3) {
                                            TTAnh[i] = number;
                                        } else {
                                            while (number == 0 || number == 2 || number == 1||number==5) {
                                                number = RanDom(0, 5);
                                            }

                                        }
                                    }

                                }
                            }
                        }
                    }
                    if (number == 3) {
                        d++;
                        if (d < 3) {
                            TTAnh[i] = number;
                        } else {
                            while (number == 3||number==5) {
                                number = RanDom(0, 5);
                            }
                            if (number == 0) {
                                a++;
                                if (a < 3) {
                                    TTAnh[i] = number;
                                } else {
                                    while (number == 0 || number == 3||number==5) {
                                        number = RanDom(0, 5);
                                    }

                                }
                            }
                            if (number == 1) {
                                b++;
                                if (b < 3) {
                                    TTAnh[i] = number;
                                } else {
                                    while (number == 1 || number == 3||number==5) {
                                        number = RanDom(0, 5);
                                    }
                                    if (number == 0) {
                                        a++;
                                        if (a < 3) {
                                            TTAnh[i] = number;
                                        } else {
                                            while (number == 0 || number == 1 || number == 3||number==5) {
                                                number = RanDom(0, 5);
                                            }

                                        }
                                    }

                                }
                            }
                            if (number == 2) {
                                c++;
                                if (c < 3) {
                                    TTAnh[i] = number;
                                } else {
                                    while (number == 2 || number == 3||number==5) {
                                        number = RanDom(0, 5);
                                    }
                                    if (number == 0) {
                                        a++;
                                        if (a < 3) {
                                            TTAnh[i] = number;
                                        } else {
                                            while (number == 0 || number == 2 || number == 3||number==5) {
                                                number = RanDom(0, 5);
                                            }

                                        }
                                    }
                                    if (number == 1) {
                                        b++;
                                        if (b < 3) {
                                            TTAnh[i] = number;
                                        } else {
                                            while (number == 1 || number == 3 || number == 2||number==5) {
                                                number = RanDom(0, 5);
                                            }
                                            if (number == 0) {
                                                a++;
                                                if (a < 3) {
                                                    TTAnh[i] = number;
                                                } else {
                                                    while (number == 0 || number == 2 || number == 1||number==3||number==5) {
                                                        number = RanDom(0, 5);
                                                    }

                                                }
                                            }

                                        }
                                    }
                                }
                            }

                        }
                    }
                    if (number == 4) {
                        e++;
                        if (e < 3) {
                            TTAnh[i] = number;
                        } else {
                            while (number == 4||number==5) {
                                number = RanDom(0, 5);
                            }
                            if (number == 0) {
                                a++;
                                if (a < 3) {
                                    TTAnh[i] = number;
                                } else {
                                    while (number == 0 || number == 4||number==5) {
                                        number = RanDom(0, 5);
                                    }

                                }
                            }
                            if (number == 1) {
                                b++;
                                if (b < 3) {
                                    TTAnh[i] = number;
                                } else {
                                    while (number == 1 || number == 4||number==5) {
                                        number = RanDom(0, 5);
                                    }
                                    if (number == 0) {
                                        a++;
                                        if (a < 3) {
                                            TTAnh[i] = number;
                                        } else {
                                            while (number == 0 || number == 1 || number == 4||number==5) {
                                                number = RanDom(0, 5);
                                            }

                                        }
                                    }

                                }
                            }
                            if (number == 2) {
                                c++;
                                if (c < 3) {
                                    TTAnh[i] = number;
                                } else {
                                    while (number == 2 || number == 4||number==5) {
                                        number = RanDom(0, 5);
                                    }
                                    if (number == 0) {
                                        a++;
                                        if (a < 3) {
                                            TTAnh[i] = number;
                                        } else {
                                            while (number == 0 || number == 2 || number == 4||number==5) {
                                                number = RanDom(0, 5);
                                            }

                                        }
                                    }
                                    if (number == 1) {
                                        b++;
                                        if (b < 3) {
                                            TTAnh[i] = number;
                                        } else {
                                            while (number == 1 || number == 4 || number == 2||number==5) {
                                                number = RanDom(0, 5);
                                            }
                                            if (number == 0) {
                                                a++;
                                                if (a < 3) {
                                                    TTAnh[i] = number;
                                                } else {
                                                    while (number == 0 || number == 2 || number == 1||number==4||number==5) {
                                                        number = RanDom(0, 5);
                                                    }

                                                }
                                            }

                                        }
                                    }
                                }
                            }
                            if (number == 3) {
                                d++;
                                if (d < 3) {
                                    TTAnh[i] = number;
                                } else {
                                    while (number == 3||number==4||number==5) {
                                        number = RanDom(0, 5);
                                    }
                                    if (number == 0) {
                                        a++;
                                        if (a < 3) {
                                            TTAnh[i] = number;
                                        } else {
                                            while (number == 0 || number == 3||number==4||number==5) {
                                                number = RanDom(0, 5);
                                            }

                                        }
                                    }
                                    if (number == 1) {
                                        b++;
                                        if (b < 3) {
                                            TTAnh[i] = number;
                                        } else {
                                            while (number == 1 || number == 3||number==4||number==5) {
                                                number = RanDom(0, 5);
                                            }
                                            if (number == 0) {
                                                a++;
                                                if (a < 3) {
                                                    TTAnh[i] = number;
                                                } else {
                                                    while (number == 0 || number == 1 || number == 3||number==4||number==5) {
                                                        number = RanDom(0, 5);
                                                    }

                                                }
                                            }

                                        }
                                    }
                                    if (number == 2) {
                                        c++;
                                        if (c < 3) {
                                            TTAnh[i] = number;
                                        } else {
                                            while (number == 2 || number == 3||number==4||number==5) {
                                                number = RanDom(0, 5);
                                            }
                                            if (number == 0) {
                                                a++;
                                                if (a < 3) {
                                                    TTAnh[i] = number;
                                                } else {
                                                    while (number == 0 || number == 2 || number == 3||number==4||number==5) {
                                                        number = RanDom(0, 5);
                                                    }

                                                }
                                            }
                                            if (number == 1) {
                                                b++;
                                                if (b < 3) {
                                                    TTAnh[i] = number;
                                                } else {
                                                    while (number == 1 || number == 3 || number == 2||number==4||number==5) {
                                                        number = RanDom(0, 5);
                                                    }
                                                    if (number == 0) {
                                                        a++;
                                                        if (a < 3) {
                                                            TTAnh[i] = number;
                                                        } else {
                                                            while (number == 0 || number == 2 || number == 1||number==3||number==4) {
                                                                number = RanDom(0, 5);
                                                            }

                                                        }
                                                    }

                                                }
                                            }
                                        }
                                    }

                                }
                            }

                        }
                    }

                }
            }
        }

        for (int i = 0; i < bt.length; i++) {
            bt[i].setBackgroundResource(R.drawable.bg_cd3);
        }

    }

    private void SaoTroGiup(){
        String MaTC="TC01";
        database=DatabaseHandler.initDatabase(this,DATABASE_NAME);
        String getsao=Sosao.getText().toString().trim();
        int number=Integer.parseInt(getsao);
        number=number-2;
        if(number>=0) {
            Sosao.setText(number + "");
            database.execSQL("update TinhNangHoTro set TongSoSao=" + number + "  where MaTroChoi = '" + MaTC + "'");
            database.close();
            for (int i = 0; i < bt.length; i++) {
                bt[i].setBackgroundResource(imgsID[TTAnh[i]]);
            }
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (!trogiup1) {
                        bt[0].setBackgroundResource(R.drawable.bg_cd3);
                    }
                    if (!trogiup2) {
                        bt[1].setBackgroundResource(R.drawable.bg_cd3);
                    }
                    if (!trogiup3) {
                        bt[2].setBackgroundResource(R.drawable.bg_cd3);
                    }
                    if (!trogiup4) {
                        bt[3].setBackgroundResource(R.drawable.bg_cd3);
                    }
                    if (!trogiup5) {
                        bt[4].setBackgroundResource(R.drawable.bg_cd3);
                    }
                    if (!trogiup6) {
                        bt[5].setBackgroundResource(R.drawable.bg_cd3);
                    }
                    if (!trogiup7) {
                        bt[6].setBackgroundResource(R.drawable.bg_cd3);
                    }
                    if (!trogiup8) {
                        bt[7].setBackgroundResource(R.drawable.bg_cd3);
                    }
                    if (!trogiup9) {
                        bt[8].setBackgroundResource(R.drawable.bg_cd3);
                    }
                    if (!trogiup10) {
                        bt[9].setBackgroundResource(R.drawable.bg_cd3);
                    }
                    if (!trogiup11) {
                        bt[10].setBackgroundResource(R.drawable.bg_cd3);
                    }
                    if (!trogiup12) {
                        bt[11].setBackgroundResource(R.drawable.bg_cd3);
                    }

                }
            }, 2000);
        }else{
            AlertDialog.Builder al = new AlertDialog.Builder(CapDoKho.this);
            al.setTitle("Database Demo");
            al.setMessage("Bạn không đủ sao để thực hiện trợ giúp");
            al.create().show();
        }
    }
    private void TroGiup(){

        lottieAnimationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity2.amthanh.StartTroGiup();
                SaoTroGiup();

            }

        });

    }
    private void sao(){

        thoigianGiay=phut*60+giay;
        if(thoigianGiay<15){
            sao=3;
        }else if(thoigianGiay>=15&&thoigianGiay<=25){
            sao=2;
        }else {
            sao=1;
        }
    }
    private void LoadSao(){
        database=DatabaseHandler.initDatabase(this,DATABASE_NAME);
        String MaTC="TC01";
        Cursor cursor;
        cursor = database.rawQuery("select * from TinhNangHoTro " , null);
        int count = cursor.getCount();
        if (count == 1) {
            cursor.moveToFirst();
            do {
                int string = cursor.getInt(1);
                Sosao.setText(string+"");
                database.close();
            } while (cursor.moveToNext());

        } else if (count == 0) {
            database.execSQL("insert into TinhNangHoTro values('" + MaTC + "'," + sao + ")");
            database.close();
        }

    }
    private void LuuSao(){
        String MaTC="TC01";
        String getsao=Sosao.getText().toString().trim();
        int number=Integer.parseInt(getsao);
        int numbersao=number+sao;
        database=DatabaseHandler.initDatabase(this,DATABASE_NAME);
        database.execSQL("update TinhNangHoTro set TongSoSao=" + numbersao + "  where MaTroChoi = '" + MaTC + "'");
        database.close();
    }
    private void LuuDatabase(){
        database=DatabaseHandler.initDatabase(this,DATABASE_NAME);
        String MaTC="TC01";
        Cursor cursor;
        cursor = database.rawQuery("select * from ChiTietTroChoi where CapDo = "+ Lever , null);
        int count = cursor.getCount();
        if (count == 1) {
            database.execSQL("update ChiTietTroChoi set Sao = " + sao + ",ThoiGian = " + thoigianGiay + " where CapDo = "+ Lever );
            database.close();
          //  Toast.makeText(CapDoKho.this,"database",Toast.LENGTH_SHORT).show();
        } else if (count == 0) {
            database.execSQL("insert into ChiTietTroChoi values('" + MaTC + "'," +  Lever + "," + sao + "," + thoigianGiay + ")");
            database.close();

        }

    }
    private void KetThuc(int gravity){

        if(trogiup1==true && trogiup2==true&&trogiup3==true&&trogiup4==true&&trogiup5==true&&trogiup6==true&&trogiup7==true&&trogiup8==true&&trogiup9==true&&trogiup10==true&&trogiup11==true&&trogiup12==true) {
            MainActivity2.amthanh.StartChienThang();
            countDownTime.cancel();
            sao();
            LuuSao();
            LuuDatabase();
            if (Lever == 24) {
                Chienthang(Gravity.CENTER);
                Toast.makeText(CapDoKho.this,"hello",Toast.LENGTH_SHORT).show();
            }else {

                final Dialog dialog = new Dialog(this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.ketthuc);

                Window window = dialog.getWindow();
                if (window == null) {
                    return;
                }
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                WindowManager.LayoutParams windowAttributes = window.getAttributes();
                windowAttributes.gravity = gravity;
                window.setAttributes(windowAttributes);
                if (Gravity.CENTER == gravity) {
                    dialog.setCancelable(false);
                }
                ImageButton sao1 = dialog.findViewById(R.id.Sao1);
                ImageButton sao2 = dialog.findViewById(R.id.Sao2);
                ImageButton sao3 = dialog.findViewById(R.id.Sao3);

                if (sao == 1) {
                    sao1.setBackgroundResource(R.drawable.sao);
                } else if (sao == 2) {
                    sao1.setBackgroundResource(R.drawable.sao);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            sao2.setBackgroundResource(R.drawable.sao);

                        }
                    }, 1000);

                } else if (sao == 3) {
                    sao1.setBackgroundResource(R.drawable.sao);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            sao2.setBackgroundResource(R.drawable.sao);
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    sao3.setBackgroundResource(R.drawable.sao);

                                }
                            }, 1000);

                        }
                    }, 1000);
                }

                Button trolai = dialog.findViewById(R.id.trolai);
                Button tieptuc = dialog.findViewById(R.id.tieptuc);
                trolai.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        Intent intent3 = new Intent(CapDoKho.this, ChonCapDoKho.class);
                        startActivity(intent3);
                        finish();
                        dialog.dismiss();
                    }
                });
                tieptuc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //  Toast.makeText(CapDoKho.this,"hello",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                        phut = 0;
                        giay = 0;
                        thoigian.setText("00:00");
                        click1 = 0;
                        click2 = 0;
                        click3 = 0;
                        click4 = 0;
                        click5 = 0;
                        click6 = 0;
                        click7 = 0;
                        click8 = 0;
                        click9 = 0;
                        click10 = 0;
                        click11 = 0;
                        click12 = 0;
                        trogiup1 = false;
                        trogiup2 = false;
                        trogiup3 = false;
                        trogiup4 = false;
                        trogiup5 = false;
                        trogiup6 = false;
                        trogiup7 = false;
                        trogiup8 = false;
                        trogiup9=false;
                                trogiup10=false;
                                trogiup11=false;
                                trogiup12=false;

                        time = true;
                        thoigianGiay = 0;
                        a = 0;
                        b = 0;
                        c = 0;
                        d = 0;
                        e = 0;
                        f = 0;
                        sao = 0;
                        Lever++;

                        setContentView(R.layout.capdokho);

                       // Toast.makeText(CapDoKho.this, "hello " + Lever, Toast.LENGTH_SHORT).show();
                        // imgsID = new int[]{R.drawable.anh1, R.drawable.anh2, R.drawable.anh3};
                        thoigian = findViewById(R.id.Thoigian);
                        start = findViewById(R.id.start);
                        Sosao = findViewById(R.id.sao1);
                        LV = findViewById(R.id.Lever);

                        lottieAnimationView = findViewById(R.id.trogiup);
                        LV.setText("LV" + Lever);

                        bt = new ImageButton[12];
                        bt[0] = (ImageButton) findViewById(R.id.hinh1);
                        bt[1] = (ImageButton) findViewById(R.id.hinh2);
                        bt[2] = (ImageButton) findViewById(R.id.hinh3);
                        bt[3] = (ImageButton) findViewById(R.id.hinh4);
                        bt[4] = (ImageButton) findViewById(R.id.hinh5);
                        bt[5] = (ImageButton) findViewById(R.id.hinh6);
                        bt[6] = (ImageButton) findViewById(R.id.hinh7);
                        bt[7] = (ImageButton) findViewById(R.id.hinh8);
                        bt[8] = (ImageButton) findViewById(R.id.hinh9);
                        bt[9] = (ImageButton) findViewById(R.id.hinh10);
                        bt[10] = (ImageButton) findViewById(R.id.hinh11);
                        bt[11] = (ImageButton) findViewById(R.id.hinh12);
                        TTAnh = new int[12];

                        RanDomAnh(17, Lever);
                        LoadSao();
                        MangAnh();
                        BatDau();
                    }

                });
                dialog.show();
            }
        }

    }
    private void Chon(){

        for (int i = 0; i < bt.length; i++) {
            bt[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()) {
                        case R.id.hinh1:

                            if(click1==0){
                                chon1 = true; MainActivity2.amthanh.StartBip();
                                bt[0].setBackgroundResource(imgsID[TTAnh[0]]);
                                DieuKien(0);
                                KetThuc(Gravity.CENTER);
                            }

                            break;
                        case R.id.hinh2:

                            if(click2==0){
                                chon2 = true; MainActivity2.amthanh.StartBip();
                                bt[1].setBackgroundResource(imgsID[TTAnh[1]]);
                                DieuKien(1);
                                KetThuc(Gravity.CENTER);
                            }


                            break;
                        case R.id.hinh3:

                            if(click3==0){
                                chon3 = true; MainActivity2.amthanh.StartBip();
                                bt[2].setBackgroundResource(imgsID[TTAnh[2]]);
                                DieuKien(2);
                                KetThuc(Gravity.CENTER);
                            }

                            break;
                        case R.id.hinh4:

                            if(click4==0){
                                chon4 = true; MainActivity2.amthanh.StartBip();
                                bt[3].setBackgroundResource(imgsID[TTAnh[3]]);
                                DieuKien(3);
                                KetThuc(Gravity.CENTER);
                            }


                            break;
                        case R.id.hinh5:

                            if(click5==0){
                                chon5 = true; MainActivity2.amthanh.StartBip();
                                bt[4].setBackgroundResource(imgsID[TTAnh[4]]);
                                DieuKien(4);
                                KetThuc(Gravity.CENTER);
                            }


                            break;
                        case R.id.hinh6:

                            if(click6==0){
                                chon6 = true; MainActivity2.amthanh.StartBip();
                                bt[5].setBackgroundResource(imgsID[TTAnh[5]]);
                                DieuKien(5);
                                KetThuc(Gravity.CENTER);
                            }


                            break;
                        case R.id.hinh7:

                            if(click7==0){
                                chon7 = true; MainActivity2.amthanh.StartBip();
                                bt[6].setBackgroundResource(imgsID[TTAnh[6]]);
                                DieuKien(6);
                                KetThuc(Gravity.CENTER);
                            }


                            break;
                        case R.id.hinh8:

                            if(click8==0){
                                chon8 = true; MainActivity2.amthanh.StartBip();
                                bt[7].setBackgroundResource(imgsID[TTAnh[7]]);
                                DieuKien(7);
                                KetThuc(Gravity.CENTER);
                            }
                            break;
                        case R.id.hinh9:

                            if(click9==0){
                                chon9 = true; MainActivity2.amthanh.StartBip();
                                bt[8].setBackgroundResource(imgsID[TTAnh[8]]);
                                DieuKien(8);
                                KetThuc(Gravity.CENTER);
                            }
                            break;
                        case R.id.hinh10:

                            if(click10==0){
                                chon10 = true; MainActivity2.amthanh.StartBip();
                                bt[9].setBackgroundResource(imgsID[TTAnh[9]]);
                                DieuKien(9);
                                KetThuc(Gravity.CENTER);
                            }
                            break;
                        case R.id.hinh11:

                            if(click11==0){
                                chon11 = true; MainActivity2.amthanh.StartBip();
                                bt[10].setBackgroundResource(imgsID[TTAnh[10]]);
                                DieuKien(10);
                                KetThuc(Gravity.CENTER);
                            }
                            break;
                        case R.id.hinh12:

                            if(click12==0){
                                chon12 = true; MainActivity2.amthanh.StartBip();
                                bt[11].setBackgroundResource(imgsID[TTAnh[11]]);
                                DieuKien(11);
                                KetThuc(Gravity.CENTER);
                            }
                            break;
                    }
                }

            });

        }

    }

    private void BatDau(){

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(time) {
                    MainActivity2.amthanh.StartBatDau();
                    countDownTime = new CountDownTimer(20000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            giay++;
                            if(giay<10&&phut<10){
                                thoigian.setText("0" + phut + ":0" + giay);
                            }
                            if(giay>=10&&phut<10){
                                thoigian.setText("0"+phut + ":" + giay);
                            }
                            if (giay == 60&&phut<10) {
                                phut++;
                                giay = 0;
                                if(giay<10&&phut<10){
                                    thoigian.setText("0" + phut + ":0" + giay);
                                } if(giay>10&&phut<10){
                                    thoigian.setText("0"+phut + ":" + giay);
                                }
                            } if(phut>=10&&giay<10){
                                thoigian.setText(phut + ":0" + giay);
                            }if(phut>=10&&giay>=10){
                                thoigian.setText(phut + ":" + giay);
                            }
                            if (giay == 60&&phut>=10) {
                                phut++;
                                giay = 0;
                                if(phut>=10&&giay<10){
                                    thoigian.setText(phut + ":0" + giay);
                                }if(phut>=10&&giay>=10){
                                    thoigian.setText(phut + ":" + giay);
                                }
                            }

                        }

                        @Override
                        public void onFinish() {

                            this.start();
                        }
                    }.start();
                    Chon();
                    TroGiup();
                    time=false;
                }


            }
        });

    }

    private void Chienthang(int gravity){

        final Dialog dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.chienthang);

        Window window=dialog.getWindow();
        if(window==null){
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowAttributes=window.getAttributes();
        windowAttributes.gravity=gravity;
        window.setAttributes(windowAttributes);
        if(Gravity.CENTER==gravity){
            dialog.setCancelable(false);
        }
        ImageButton sao1 = dialog.findViewById(R.id.Sao1);
        ImageButton sao2 = dialog.findViewById(R.id.Sao2);
        ImageButton sao3 = dialog.findViewById(R.id.Sao3);
        if (sao == 1) {
            sao1.setBackgroundResource(R.drawable.sao);
        } else if (sao == 2) {
            sao1.setBackgroundResource(R.drawable.sao);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    sao2.setBackgroundResource(R.drawable.sao);

                }
            }, 1000);

        } else if (sao == 3) {
            sao1.setBackgroundResource(R.drawable.sao);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    sao2.setBackgroundResource(R.drawable.sao);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            sao3.setBackgroundResource(R.drawable.sao);

                        }
                    }, 1000);

                }
            }, 1000);
        }
        Button trolai=dialog.findViewById(R.id.trolai);
        trolai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(CapDoKho.this, MainActivity3.class);
                startActivity(intent3);
                finish();
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    @Override
    public void onBackPressed() {
        Intent intent2 = new Intent(CapDoKho.this, ChonCapDoKho.class);
        startActivity(intent2);
        super.onBackPressed();

    }

}