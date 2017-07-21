package com.example.konrad.applicationsecond;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class ServicesClass extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    Timer timer;
    Toast toast;
    TimerTask timerTask;
    int counter;

    private class MojTimerTask extends TimerTask{
        @Override
        public void run(){
            counter++;
            toast.setText("Witaj po raz: "+counter);
            toast.show();
        }

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        timer = new Timer();
        timerTask = new MojTimerTask();
        timer.scheduleAtFixedRate(timerTask, 1000, 5*1000);
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        timer.purge();
        timerTask.cancel();

    }
}
