package com.example.konrad.applicationsecond;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class BatteryLevel extends BroadcastReceiver {
    final String TAG = "KonradApp";


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "Niski poziom baterii");
        if(intent.getAction() == Intent.ACTION_POWER_CONNECTED){
            Toast.makeText(context, "Battery is being charged", Toast.LENGTH_SHORT).show();
        }
        else if(intent.getAction()==Intent.ACTION_POWER_DISCONNECTED){
            Toast.makeText(context, "Battery charging has been already finished", Toast.LENGTH_SHORT).show();
        }
    }



}
