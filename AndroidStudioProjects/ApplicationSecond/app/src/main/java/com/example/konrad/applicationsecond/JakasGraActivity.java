package com.example.konrad.applicationsecond;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.konrad.applicationsecond.R.id.imageView5;
import static com.example.konrad.applicationsecond.R.id.lwey;

public class JakasGraActivity extends AppCompatActivity {
    final String TAG = "KonradApps";
    int clickCount = 0;
    @BindView(R.id.imageButton1)
    ImageButton papier;
    @BindView(R.id.imageButton2)
    ImageButton kamien;
    @BindView(R.id.imageButton3)
    ImageButton nozyce;
    @BindView(imageView5)
    ImageView mojRuch;
    @BindView(R.id.imageView6) ImageView komputerRuch;
    @BindView(R.id.textView2)
    TextView licznik;
    @BindView(R.id.lwey) TextView lewyLabel;
    @BindView(R.id.prawy) TextView prawyLabel;
    String papier1 = "papier";
    String nozyce1 = "nozyce";
    String wegiel1 = "wegiel";
    String papier2 = "papier";
    String nozyce2 = "nozyce";
    String wegiel2 = "wegiel";

    private void drawRandomly(){
        Random myRandom = new Random();
        final String img_0 = "ee";
        final String img_1 = "ss";
        final String img_2 = "sss";
        String pictureOne = "img_" + myRandom.nextInt(3);
        switch (pictureOne){
            case "img_0":
                komputerRuch.setBackgroundResource(R.drawable.ee);
                papier1 = komputerRuch.toString();

                break;
            case "img_1":
                komputerRuch.setBackgroundResource(R.drawable.ss);
                wegiel1 = komputerRuch.toString();

                break;
            case "img_2":
                komputerRuch.setBackgroundResource(R.drawable.sss);
                nozyce1 = komputerRuch.toString();


                break;
            default:
                break;
        }

    }
//fgf
    private View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.imageButton1:
                    mojRuch.setBackgroundResource(R.drawable.ee);
                    papier2 = mojRuch.toString();
                    drawRandomly();
                    finalResult();
                    stopGame();
                    break;
                case R.id.imageButton2:
                    mojRuch.setBackgroundResource(R.drawable.ss);
                    wegiel2 = mojRuch.toString();
                    drawRandomly();
                    finalResult();
                    stopGame();
                    break;
                case R.id.imageButton3:
                    mojRuch.setBackgroundResource(R.drawable.sss);
                    nozyce2 = mojRuch.toString();
                    drawRandomly();
                    finalResult();
                    stopGame();
                    break;
                default:
                    break;
            }
        }
    };


    public void finalResult(){
        if(mojRuch.toString().equals("papier") && komputerRuch.toString().equals("papier")){
            licznik.setText("Draw");
        }
        else if(mojRuch.toString().equals("nozyce") && komputerRuch.toString().equals("nozyce")){
            licznik.setText("Draw");
        }
        else if(mojRuch.toString().equals("wegiel") && komputerRuch.toString().equals("wegiel")){
            licznik.setText("Draw");
        }
        else if((mojRuch.toString().equals("papier")) && komputerRuch.toString().equals("nozyce")){
            licznik.setText("1:0");
            clickCount = clickCount+1;
            int lewy = 0;
            int prawy = 0;
//            for(clickCount = 1; clickCount <=5; clickCount++){
                if(licznik.getText()=="0:1"){
                    prawy += 1;
                    prawyLabel.setText("ss"+prawy);
                }
                else if(licznik.getText()=="1:0"){
                    lewy += 1;
                    lewyLabel.setText("ss"+lewy);
                }
                else{

                }
//            }
        }
        else if((mojRuch.toString().equals("papier")) && komputerRuch.toString().equals("wegiel")){
            licznik.setText("1:0");
            clickCount = clickCount+1;
            int lewy = 0;
            int prawy = 0;
//            for(clickCount = 1; clickCount <=5; clickCount++){
                if(licznik.getText()=="0:1"){
                    prawy += 1;
                    prawyLabel.setText("ss"+prawy);
                }
                else if(licznik.getText()=="1:0"){
                    lewy += 1;
                    lewyLabel.setText("ss"+lewy);
                }
                else{

                }
//            }

        }
        else if((mojRuch.toString().equals("nozyce")) && komputerRuch.toString().equals("papier")){
            licznik.setText("1:0");
            clickCount = clickCount+1;
            int lewy = 0;
            int prawy = 0;
//            for(clickCount = 1; clickCount <=5; clickCount++){
                if(licznik.getText()=="0:1"){
                    prawy += 1;
                    prawyLabel.setText("ss"+prawy);
                }
                else if(licznik.getText()=="1:0"){
                    lewy += 1;
                    lewyLabel.setText("ss"+lewy);
                }
                else{

                }
//            }
        }
        else if((mojRuch.toString().equals("nozyce")) && komputerRuch.toString().equals("wegiel")){
            licznik.setText("0:1");
            clickCount = clickCount+1;
            int lewy = 0;
            int prawy = 0;
//            for(clickCount = 1; clickCount <=5; clickCount++){
                if(licznik.getText()=="0:1"){
                    prawy += 1;
                    prawyLabel.setText("ss"+prawy);
                }
                else if(licznik.getText()=="1:0"){
                    lewy += 1;
                    lewyLabel.setText("ss"+lewy);
                }
                else{

                }
//            }
        }
        else if((mojRuch.toString().equals("wegiel")) && komputerRuch.toString().equals("papier")){
            licznik.setText("0:1");
            clickCount = clickCount+1;
            int lewy = 0;
            int prawy = 0;
//            for(clickCount = 1; clickCount <=5; clickCount++){
                if(licznik.getText()=="0:1"){
                    prawy += 1;
                    prawyLabel.setText("ss"+prawy);
                }
                else if(licznik.getText()=="1:0"){
                    lewy += 1;
                    lewyLabel.setText("ss"+lewy);
                }
                else{

                }
//            }
        }
        else if((mojRuch.toString().equals("wegiel")) && komputerRuch.toString().equals("nozyce")){
            licznik.setText("1:0");
            clickCount = clickCount+1;
            int lewy = 0;
            int prawy = 0;
//            for(clickCount = 1; clickCount <=5; clickCount++){
                if(licznik.getText()=="0:1"){
                    prawy += 1;
                    prawyLabel.setText("ss"+prawy);
                }
                else if(licznik.getText()=="1:0"){
                    lewy += 1;
                    lewyLabel.setText("ss"+lewy);
                }
                else{

                }
//            }
        }
    }

        public void stopGame( ){
            if(clickCount==6){
                lewyLabel.setText("");
                prawyLabel.setText("");
                mojRuch.setBackgroundResource(R.drawable.serce);
                komputerRuch.setBackgroundResource(R.drawable.serce);
                licznik.setText("");
            }
        }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jakas_gra);
        ButterKnife.bind(this);
        papier.setOnClickListener(myListener);
        kamien.setOnClickListener(myListener);
        nozyce.setOnClickListener(myListener);

    }
}
