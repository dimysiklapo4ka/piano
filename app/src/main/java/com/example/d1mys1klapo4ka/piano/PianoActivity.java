package com.example.d1mys1klapo4ka.piano;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

public class PianoActivity extends Activity implements SoundPool.OnLoadCompleteListener {

    final int MAX_STREAM = 7;

    SoundPool soundPool;

    int soundIDdo;
    int soundIDre;
    int soundIDmi;
    int soundIDfa;
    int soundIDsol;
    int soundIDla;
    int soundIDsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano);

        soundPool = new SoundPool(MAX_STREAM, AudioManager.STREAM_MUSIC, 0);
        soundPool.setOnLoadCompleteListener(this);

        //soundIDdo = soundPool.load(this, R.raw.do, 0);
        try {
            soundIDdo = soundPool.load(getAssets().openFd("do.wav"), 1);
            soundIDre = soundPool.load(getAssets().openFd("re.wav"), 1);
            soundIDmi = soundPool.load(getAssets().openFd("mi.wav"), 1);
            soundIDfa = soundPool.load(getAssets().openFd("fa.wav"), 1);
            soundIDsol = soundPool.load(getAssets().openFd("sol.wav"), 1);
            soundIDla = soundPool.load(getAssets().openFd("la.wav"), 1);
            soundIDsi = soundPool.load(getAssets().openFd("si.wav"), 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onClick(View view){
        int ID = view.getId();

        switch (ID){
            case R.id.bt_do:
                soundPool.play(soundIDdo,1,1,0,0,1);
                break;
            case R.id.bt_re:
                soundPool.play(soundIDre,1,1,0,0,1);
                break;
            case R.id.bt_mi:
                soundPool.play(soundIDmi,1,1,0,0,1);
                break;
            case R.id.bt_fa:
                soundPool.play(soundIDfa,1,1,0,0,1);
                break;
            case R.id.bt_sol:
                soundPool.play(soundIDsol,1,1,0,0,1);
                break;
            case R.id.bt_la:
                soundPool.play(soundIDla,1,1,0,0,1);
                break;
            case R.id.bt_si:
                soundPool.play(soundIDsi,1,1,0,0,1);
                break;
        }
    }

    @Override
    public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {

    }
}
