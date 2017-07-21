package com.example.konrad.applicationsecond;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class ShopMainView extends AppCompatActivity {
    final String TAG = "KonradApp";
    RelativeLayout relativeLay = (RelativeLayout) findViewById(R.id.recyclerViewLay);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_main_view);
    }


        public void updateBackground(Shopping shopping) {
            if (shopping.isRedBackgroundColor){
                relativeLay.setBackgroundResource(R.drawable.but3);
            }
            else if (!shopping.isRedBackgroundColor){
                relativeLay.setBackgroundResource(R.drawable.but2);
            }
        }
    }

