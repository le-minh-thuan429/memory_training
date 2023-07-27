package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.text.NoCopySpan;

public class Amthanh<onCompletion> {

    MediaPlayer mediaPlayer,mediaPlayer1,mediaPlayer2,mediaPlayer3,mediaPlayer4,mediaPlayer5,mediaPlayer6;
    Context context;
    public Amthanh(Context context){
        this.context=context;
        mediaPlayer1 = MediaPlayer.create(context, R.raw.nhacnen1);
        mediaPlayer2 = MediaPlayer.create(context, R.raw.anvaodechon);
        mediaPlayer3 = MediaPlayer.create(context, R.raw.hoanthanh);
        mediaPlayer4 = MediaPlayer.create(context, R.raw.anvao);
        mediaPlayer5 = MediaPlayer.create(context, R.raw.go);
        mediaPlayer6 = MediaPlayer.create(context, R.raw.trogiup);
    }

    public void StartNhacnen(){
      //  mediaPlayer1 = MediaPlayer.create(context, R.raw.nhacnen1);
        if(!mediaPlayer1.isPlaying()){ //nếu media không ở trạng thái phát
            mediaPlayer1.start(); //bắt đầu phát media
            mediaPlayer1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { //sự kiện thực hiện khi media chạy hết
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer1.start();//bắt đầu phát lại, tạo vòng lặp
                }
            });
        }
    }
    public void StartBip(){
            mediaPlayer2. seekTo(800);// dịch chuyển đến vị trí phát 800
            if(mediaPlayer2.getCurrentPosition()==800) {// media đi đến đúng vị trí phát 800
                mediaPlayer2.start();// bắt đầu phát
            }
            else if(mediaPlayer2.getCurrentPosition()>=807){ // media đi đến đúng vị trí phát >=807
                mediaPlayer2.pause();// dừng phát
            }

    }
    public void StartChienThang(){

        if(!mediaPlayer3.isPlaying()){
            mediaPlayer3.start();
        }
    }
    public void StartBatDau(){

        if(!mediaPlayer5.isPlaying()){
            mediaPlayer5.start();
        }
    }
    public void StartTroGiup(){

        if(!mediaPlayer6.isPlaying()){
            mediaPlayer6.start();
        }
    }
    public void StopNhacNen(){
        if(mediaPlayer1.isPlaying()){
            mediaPlayer1.pause();
        }

    }
    public void StopChienThang(){
        if(mediaPlayer3.isPlaying()){
            mediaPlayer3.stop();
        }

    }
    public void Chamvao(){
        mediaPlayer4. seekTo(3500);// dịch chuyển đến vị trí phát 3500
        mediaPlayer4.start();
        //mediaPlayer4.setVolume(0,100000);
        new Handler().postDelayed(new Runnable() { // thực hiện dừng lại sau 500 mili giây
            @Override
            public void run() {
                mediaPlayer4.pause();
            }
        }, 500);

    }
    public void KhoiTao(){
        mediaPlayer2 = MediaPlayer.create(context, R.raw.anvaodechon);
        mediaPlayer3 = MediaPlayer.create(context, R.raw.hoanthanh);
        mediaPlayer4 = MediaPlayer.create(context, R.raw.anvao);
        mediaPlayer5 = MediaPlayer.create(context, R.raw.go);
    }
    public void reset(){
        mediaPlayer2.reset();
        mediaPlayer3.reset();
        mediaPlayer4.reset();
        mediaPlayer5.reset();
    }
}
