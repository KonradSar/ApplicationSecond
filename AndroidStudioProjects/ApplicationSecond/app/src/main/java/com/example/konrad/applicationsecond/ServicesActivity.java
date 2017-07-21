package com.example.konrad.applicationsecond;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ServicesActivity extends AppCompatActivity {

    @BindView(R.id.btnStart) Button btnStart;
    @BindView(R.id.btnStop) Button btnStop;

    @OnClick(R.id.btnStart)
    public void start(){
        Intent i = new Intent(this, ServicesClass.class);
        this.startService(i);
    }
    @OnClick(R.id.btnStop)
    public void stop(){
        Intent i = new Intent(this, ServicesClass.class);
        this.stopService(i);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        ButterKnife.bind(this);
    }
}
