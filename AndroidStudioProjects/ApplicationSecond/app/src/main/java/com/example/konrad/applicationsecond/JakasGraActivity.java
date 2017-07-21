package com.example.konrad.applicationsecond;

import android.content.DialogInterface;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import android.media.MediaPlayer;

import static com.example.konrad.applicationsecond.R.id.imageView5;
import static com.example.konrad.applicationsecond.R.id.lwey;
import static com.example.konrad.applicationsecond.R.id.view;

public class JakasGraActivity extends AppCompatActivity {
    final String TAG = "KonradApp";
    MediaPlayer myFirstSound;


    @BindView(R.id.imageButton1)
    ImageButton papier;
    @BindView(R.id.imageButton2)
    ImageButton kamien;
    @BindView(R.id.imageButton3)
    ImageButton nozyce;
    @BindView(imageView5)
    ImageView mojRuch;
    @BindView(R.id.imageView6) ImageView komputerRuch;
    @BindView(R.id.finalpic) ImageView finalPicture;
    @BindView(R.id.dd2) LinearLayout buttonsContainer;

    @BindView(R.id.lwey) TextView lewyLabel;
    @BindView(R.id.prawy) TextView prawyLabel;
    static String SAVED_CLICK_COUNT = "wow";
    static final int PAPIER = 1;
    static final int KAMIEN = 2;
    static final int NOZYCE = 3;



    int computerResult;
    int playerResult;

    static String WYNIKKOMPUTERA = "WYNIKKOMPUTERA";
    static String WYNIKPLAYERA = "WYNIKPLAYERA";


    static String myPicture1 = "myPicture1";
    static String computerPicture = "computerPicture";


    static int zmiennaPomocnicza1 = 0;
    static int zmiennaPomocnicza2 = 0;
    int redColorForSnackBar = Color.parseColor("#ff0000");
    int greenColorForSnackBar = Color.parseColor("#66ff33");
    boolean undoComputerResult;


    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(WYNIKKOMPUTERA, computerResult);
        outState.putInt(WYNIKPLAYERA, playerResult);

        outState.putInt(myPicture1, zmiennaPomocnicza1);
        outState.putInt(computerPicture, zmiennaPomocnicza2);


    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int computerResultt = savedInstanceState.getInt(WYNIKKOMPUTERA);
        int mineResult = savedInstanceState.getInt(WYNIKPLAYERA);
        computerResult = computerResultt;
        playerResult = mineResult;

        lewyLabel.setText(String.valueOf(mineResult));
        prawyLabel.setText(String.valueOf(computerResult));

        int obrazek1 = savedInstanceState.getInt(myPicture1);
        int zmienna = zmiennaPomocnicza1;

        if (zmiennaPomocnicza1 == PAPIER) {
            mojRuch.setBackgroundResource(R.drawable.ee);
        } else if (zmiennaPomocnicza1 == NOZYCE) {
            mojRuch.setBackgroundResource(R.drawable.nozyczki);
        } else if (zmiennaPomocnicza1 == KAMIEN) {
            mojRuch.setBackgroundResource(R.drawable.ss);
        }

        int obrazekKomputera = savedInstanceState.getInt(computerPicture);
        int zmienna2 = zmiennaPomocnicza2;
        if (zmiennaPomocnicza2 == PAPIER) {
            komputerRuch.setBackgroundResource(R.drawable.ee);
        } else if (zmiennaPomocnicza2 == NOZYCE) {
            komputerRuch.setBackgroundResource(R.drawable.nozyczki);
        } else if (zmiennaPomocnicza2 == KAMIEN) {
            komputerRuch.setBackgroundResource(R.drawable.ss);
        }


    }

    private int drawRandomly(){
        Random myRandom = new Random();
        String pictureOne = "img_" + myRandom.nextInt(3);
        int coZwroci = 0;
       // Log.d(TAG, pictureOne);
        switch (pictureOne){
            case "img_0":
                komputerRuch.setBackgroundResource(R.drawable.ee);
                coZwroci = PAPIER;
                break;
            case "img_1":
                komputerRuch.setBackgroundResource(R.drawable.ss);
                coZwroci = KAMIEN;
                break;
            case "img_2":
                komputerRuch.setBackgroundResource(R.drawable.nozyczki);
                coZwroci = NOZYCE;
                break;
            default:
                break;
        }
        return coZwroci;
    }


    private View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.imageButton1:
                    myFirstSound.start();
                    mojRuch.setBackgroundResource(R.drawable.ee);
                    int zwrcone = drawRandomly();
                    finalResult(PAPIER, zwrcone);
                    whoIsTheWinner();
                    checkIfStopGame();
                    break;
                case R.id.imageButton2:
                    myFirstSound.start();
                    mojRuch.setBackgroundResource(R.drawable.ss);
                    int zwrocone2 = drawRandomly();
                    finalResult(KAMIEN, zwrocone2);
                    whoIsTheWinner();
                    checkIfStopGame();
                    break;
                case R.id.imageButton3:
                    myFirstSound.start();
                    mojRuch.setBackgroundResource(R.drawable.nozyczki);
                    int zwrocone3 = drawRandomly();
                    finalResult(NOZYCE, zwrocone3);
                    whoIsTheWinner();
                    checkIfStopGame();
                    break;
                default:
                    break;
            }
        }
    };
    public int generateResultForFinalScore(){
        // ta funkcja losuje co wybiera komputer
        Random rand = new Random();
        int result = rand.nextInt(3)+1;
        return result;
    }


    public void finalResult(int clickedOne, int wybraneKomputer){

        if(clickedOne == PAPIER) {
            if (wybraneKomputer == PAPIER) {
                Toast.makeText(getApplicationContext(), "DRAW", Toast.LENGTH_SHORT).show();
                zmiennaPomocnicza1 = clickedOne;
                zmiennaPomocnicza2 = wybraneKomputer;

            } else if (wybraneKomputer == NOZYCE) {
                computerResult++;
                zmiennaPomocnicza2 = wybraneKomputer;
                undoComputerResult = true;

                Snackbar mySnackBar = Snackbar.make(buttonsContainer, "Punkt dla Komputera", Snackbar.LENGTH_SHORT);
                View view = mySnackBar.getView();
                TextView tv = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
                tv.setTextColor(getResources().getColor(R.color.yellowish));
                mySnackBar.getView().setBackgroundColor(redColorForSnackBar);
                mySnackBar.setAction("COFNIJ WYNIK", new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        if(undoComputerResult==true){
                            computerResult -= 1;
                            updateResults();
                        }
                        else{
                            playerResult -= 1;
                            updateResults();
                        }

                    }
                });
                mySnackBar.show();

            } else if (wybraneKomputer == KAMIEN) {
                playerResult++;
                zmiennaPomocnicza2 = wybraneKomputer;
                undoComputerResult = false;
                Snackbar mySnackBar = Snackbar.make(buttonsContainer, "Punkt dla Ciebie", Snackbar.LENGTH_SHORT);
                View view = mySnackBar.getView();
                TextView tv = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
                tv.setTextColor(getResources().getColor(R.color.yellowish));
                mySnackBar.getView().setBackgroundColor(greenColorForSnackBar);
                mySnackBar.setAction("COFNIJ WYNIK", new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        if(undoComputerResult==true){
                            computerResult -= 1;
                            updateResults();
                        }
                        else{
                            playerResult -= 1;
                            updateResults();
                        }

                    }
                });
                mySnackBar.show();

            }
        }
        else if(clickedOne == NOZYCE) {
            if (wybraneKomputer == NOZYCE) {
                Toast.makeText(getApplicationContext(), "DRAW", Toast.LENGTH_SHORT).show();
                zmiennaPomocnicza1 = clickedOne;
                zmiennaPomocnicza2 = wybraneKomputer;


            } else if (wybraneKomputer == PAPIER) {
                playerResult++;
                zmiennaPomocnicza2 = wybraneKomputer;
                undoComputerResult = false;
                Snackbar mySnackBar = Snackbar.make(buttonsContainer, "Punkt dla Ciebie", Snackbar.LENGTH_SHORT);
                View view = mySnackBar.getView();
                TextView tv = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
                tv.setTextColor(getResources().getColor(R.color.yellowish));
                mySnackBar.getView().setBackgroundColor(greenColorForSnackBar);
                mySnackBar.setAction("COFNIJ WYNIK", new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        if(undoComputerResult==true){
                            computerResult -= 1;
                            updateResults();
                        }
                        else{
                            playerResult -= 1;
                            updateResults();
                        }

                    }
                });
                mySnackBar.show();

            } else if (wybraneKomputer == KAMIEN) {

                computerResult++;
                zmiennaPomocnicza2 = wybraneKomputer;
                undoComputerResult = true;
                Snackbar mySnackBar = Snackbar.make(buttonsContainer, "Punkt dla Komputera", Snackbar.LENGTH_SHORT);
                View view = mySnackBar.getView();
                TextView tv = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
                tv.setTextColor(getResources().getColor(R.color.yellowish));
                mySnackBar.getView().setBackgroundColor(redColorForSnackBar);
                mySnackBar.setAction("COFNIJ WYNIK", new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        if(undoComputerResult==true){
                            computerResult -= 1;
                            updateResults();
                        }
                        else{
                            playerResult -= 1;
                            updateResults();
                        }

                    }
                });
                mySnackBar.show();

            }
        }
        else if(clickedOne == KAMIEN){
                    if(wybraneKomputer == KAMIEN){
                        Toast.makeText(getApplicationContext(), "DRAW", Toast.LENGTH_SHORT).show();
                        zmiennaPomocnicza1 = clickedOne;
                        zmiennaPomocnicza2 = wybraneKomputer;

                    }
                    else if(wybraneKomputer == PAPIER){
                        computerResult++;
                        zmiennaPomocnicza2 = wybraneKomputer;
                        undoComputerResult = true;
                        Snackbar mySnackBar = Snackbar.make(buttonsContainer, "Punkt dla Komputera", Snackbar.LENGTH_SHORT);
                        View view = mySnackBar.getView();
                        TextView tv = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
                        tv.setTextColor(getResources().getColor(R.color.yellowish));
                        mySnackBar.getView().setBackgroundColor(redColorForSnackBar);
                        mySnackBar.setAction("COFNIJ WYNIK", new View.OnClickListener(){

                            @Override
                            public void onClick(View v) {
                                if(undoComputerResult==true){
                                    computerResult -= 1;
                                    updateResults();
                                }
                                else{
                                    playerResult -= 1;
                                    updateResults();
                                }

                            }
                        });
                        mySnackBar.show();
                        ;
                    }
                    else if(wybraneKomputer == NOZYCE){
                        playerResult++;
                        zmiennaPomocnicza2 = wybraneKomputer;
                        undoComputerResult = false;
                        Snackbar mySnackBar = Snackbar.make(buttonsContainer, "Punkt dla Ciebie", Snackbar.LENGTH_SHORT);
                        View view = mySnackBar.getView();
                        TextView tv = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
                        tv.setTextColor(getResources().getColor(R.color.yellowish));
                        mySnackBar.getView().setBackgroundColor(greenColorForSnackBar);
                        mySnackBar.setAction("COFNIJ WYNIK", new View.OnClickListener(){

                            @Override
                            public void onClick(View v) {
                                if(undoComputerResult==true){
                                    computerResult -= 1;
                                    updateResults();
                                }
                                else{
                                    playerResult -= 1;
                                    updateResults();
                                }

                            }
                        });
                        mySnackBar.show();

                    }
                }


        updateResults();
        checkIfStopGame();
    }
    public void whoIsTheWinner(){
        if(computerResult==5){
            finalPicture.setBackgroundResource(R.drawable.looser);
        }
        else if(playerResult==5){
            finalPicture.setBackgroundResource(R.drawable.winner);
        }
        else{

        }
    }


    public void checkIfStopGame( ){
            if(computerResult==5 || playerResult==5){


                AlertDialog.Builder builder = new AlertDialog.Builder(JakasGraActivity.this, android.R.style.Theme_Material_Dialog_Alert);
                builder.setTitle("Koniec gry")
                        .setMessage("Czy chcesz zagrać jeszcze raz?")
                        .setPositiveButton("Tak", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                clearGame();
                            }
                        })
                        .setNegativeButton("Nie", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .create()
                        .show();
            }
            else{

            }
        }




        public void updateResults(){
            lewyLabel.setText(String.valueOf(playerResult));
            prawyLabel.setText(String.valueOf(computerResult));

        }
        public void clearGame(){
            lewyLabel.setText("");
            prawyLabel.setText("");
            mojRuch.setBackgroundResource(R.drawable.drogi);
            komputerRuch.setBackgroundResource(R.drawable.drogi);
            finalPicture.setBackgroundResource(0);
            computerResult = 0;
            playerResult = 0;

        }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jakas_gra);
        ButterKnife.bind(this);
        papier.setOnClickListener(myListener);
        kamien.setOnClickListener(myListener);
        nozyce.setOnClickListener(myListener);
        myFirstSound = MediaPlayer.create(this, R.raw.gun);

    }
}
