package com.example.konrad.applicationsecond;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AsyncTaskActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task2);
        ButterKnife.bind(this);
    }
    @BindView(R.id.drugi)
    TextView textView;

//    @OnClick(R.id.pierwszy)
//    public void show(){
//        new MojAsyncTaskClass2(textView).execute("Darek", "Przemek");
//    }


}
