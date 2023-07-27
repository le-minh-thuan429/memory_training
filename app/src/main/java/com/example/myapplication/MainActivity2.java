package com.example.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.airbnb.lottie.LottieAnimationView;
import com.example.myapplication.fragment.Gioithieu;
import com.example.myapplication.fragment.Manhinhchinh;
import com.example.myapplication.fragment.QuyTac;
import com.google.android.material.navigation.NavigationView;


public class MainActivity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Button button;
    LottieAnimationView lottieAnimationView;

    private DrawerLayout mDrawerLayout;
    private static final int FRAGMENT_HOME=0;
    private static final int FRAGMENT_FAVORITE=0;
    private static final int FRAGMENT_HISTORY=0;
    private int mCurrentFragment=1;
    int sao;
    boolean a=true,b=true;
    final String DATABASE_NAME = "TroChoiTriNho.db";
    SQLiteDatabase database;
    FragmentTransaction transaction;

    boolean nn=false,at=false;
    public static Amthanh amthanh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        amthanh=new Amthanh(MainActivity2.this);
        amthanh.StartNhacnen();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); //thêm toolbar

        //Thiết lập sự kiện đóng mở Navigation Drawer
        mDrawerLayout=findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,
                R.string.Open,R.string.Close);//Chuyển đổi ngăn thanh tác vụ
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //bắt sự kiện
        NavigationView navigationView=findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        LoadSao();

        replaceFragment(new Manhinhchinh(sao));
        //navigationView.getMenu().findItem(R.id.nav_home).setCheckable(true);//Thiết lập cho Navigation màn hình chính được check
    }
    
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_home) {
                LoadSao();
                replaceFragment(new Manhinhchinh(sao));


        } else if (id == R.id.Gioithieu){
                LoadSao();
                replaceFragment(new Gioithieu(sao));


        } else if (id == R.id.Quytac){

                replaceFragment(new QuyTac(sao));

        }
        else if (id == R.id.Reset){

                Reset(Gravity.CENTER);

        }else if (id == R.id.Amthanh){

                AmThanh(Gravity.CENTER);

        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
    public void replaceFragment(Fragment fragment){
        transaction= getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame,fragment);
        transaction.commit();

    }
    public void Chamvao(){
        amthanh.Chamvao();
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
                String string = cursor.getString(1);
                sao=Integer.parseInt(string);
                database.close();
            } while (cursor.moveToNext());

        } else if (count == 0) {
            database.close();
        }
    }
    private void Reset(int gravity){

        final Dialog dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.reset);

        Window window=dialog.getWindow();
        if(window==null){
            return;
        }
        //widle,hight
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes=window.getAttributes();
        windowAttributes.gravity=gravity; //Xác định vị trí của dialoc
        window.setAttributes(windowAttributes);

        if(Gravity.CENTER==gravity){
            dialog.setCancelable(false);
        }

        String MaTC="TC01";
        Button cancel=dialog.findViewById(R.id.cancel);
        Button ok=dialog.findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database=DatabaseHandler.initDatabase(MainActivity2.this,DATABASE_NAME);
                database.execSQL("delete from ChiTietTroChoi ");
                database.execSQL("update TinhNangHoTro set TongSoSao=" + 0 + "  where MaTroChoi = '" + MaTC + "'");
                database.close();
                Toast.makeText(MainActivity2.this,"Đã Reset thành công",Toast.LENGTH_SHORT).show();
                LoadSao();
                replaceFragment(new Manhinhchinh(sao));
                dialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    private void AmThanh(int gravity){

        final Dialog dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.amthanh);

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
        Button ok=dialog.findViewById(R.id.ok);
        Button nhacnen=dialog.findViewById(R.id.nhacnen);
        Button amthanhh=dialog.findViewById(R.id.amthanh);
        if(a) {
            nhacnen.setText("Tắt");
        }else {
            nhacnen.setText("Bật");
        }
        if(b){
            amthanhh.setText("Tắt");
        }else {
            amthanhh.setText("Bật");
        }
            nhacnen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nn){
                    amthanh.StartNhacnen();
                    nhacnen.setText("Tắt");
                    a=true;
                    nn=false;
                }else {
                    amthanh.StopNhacNen();
                    nhacnen.setText("Bật");
                    a=false;
                    nn=true;

                }
            }
        });
        amthanhh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(at){
                    amthanh.KhoiTao();
                    amthanhh.setText("Tắt");
                    b=true;
                    at=false;
                }else {
                    amthanh.reset();
                    amthanhh.setText("Bật");
                    b=false;
                    at=true;

                }
            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });
        dialog.show();
    }

}