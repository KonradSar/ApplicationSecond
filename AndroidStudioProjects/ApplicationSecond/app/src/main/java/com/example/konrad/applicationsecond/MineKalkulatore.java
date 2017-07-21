package com.example.konrad.applicationsecond;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MineKalkulatore extends AppCompatActivity {
    final String TAG = "KonradApp";
    @BindView(R.id.btn0)
    Button zeroBtn;
    @BindView(R.id.btn1)
    Button jedenBtn;
    @BindView(R.id.btn2)
    Button dwaBtn;
    @BindView(R.id.btn3)
    Button threeBtn;
    @BindView(R.id.btn4)
    Button fourBtn;
    @BindView(R.id.btn5)
    Button fiveBtn;
    @BindView(R.id.btn6)
    Button sixBtn;
    @BindView(R.id.btn7)
    Button sevenBtn;
    @BindView(R.id.btn8)
    Button eightBtn;
    @BindView(R.id.btn9)
    Button nineBtn;
    @BindView(R.id.btnMnozenie)
    Button mnozenieBtn;
    @BindView(R.id.btnDziel)
    Button dzielenieBtn;
    @BindView(R.id.btnDodawanie)
    Button dodawanieBtn;
    @BindView(R.id.btnOdejmowanie)
    Button odejmowanieBtn;
    @BindView(R.id.btnLewyNawias)
    Button nawiasLewyBtn;
    @BindView(R.id.btnPrawyNawias)
    Button nawiasPrawyBtn;
    @BindView(R.id.btnWynik)
    Button pokazWynikBtn;
    @BindView(R.id.btnClear)
    Button wyczyscBtn;
    @BindView(R.id.mainConsole)
    TextView resultScreen;

    double auxiliaryVariable = 0.00;
    double finalResult = 0.00;
    double previousVariable1;
    String previousVariable2;

    @OnClick(R.id.btn0)
    public void pressedBtn() {
        auxiliaryVariable = 0.00;
        resultScreen.setText(String.valueOf(auxiliaryVariable));
    }

    @OnClick(R.id.btn1)
    public void pressedBtn1() {
        auxiliaryVariable = 1.00;
        resultScreen.setText(String.valueOf(auxiliaryVariable));

    }

    @OnClick(R.id.btn2)
    public void pressedBtn2() {
        auxiliaryVariable = 2.00;
        resultScreen.setText(String.valueOf(auxiliaryVariable));

    }

    @OnClick(R.id.btn3)
    public void pressedBtn3() {
        auxiliaryVariable = 3.00;
        resultScreen.setText(String.valueOf(auxiliaryVariable));

    }

    @OnClick(R.id.btn4)
    public void pressedBtn4() {
        auxiliaryVariable = 4.00;
        resultScreen.setText(String.valueOf(auxiliaryVariable));

    }

    @OnClick(R.id.btn5)
    public void pressedBtn5() {
        auxiliaryVariable = 5.00;
        resultScreen.setText(String.valueOf(auxiliaryVariable));

    }

    @OnClick(R.id.btn6)
    public void pressedBtn6() {
        auxiliaryVariable = 6.00;
        resultScreen.setText(String.valueOf(auxiliaryVariable));

    }

    @OnClick(R.id.btn7)
    public void pressedBtn7() {
        auxiliaryVariable = 7.00;
        resultScreen.setText(String.valueOf(auxiliaryVariable));

    }

    @OnClick(R.id.btn8)
    public void pressedBtn8() {
        auxiliaryVariable = 8.00;
        resultScreen.setText(String.valueOf(auxiliaryVariable));

    }

    @OnClick(R.id.btn9)
    public void pressedBtn9() {
        auxiliaryVariable = 9.00;
        resultScreen.setText(String.valueOf(auxiliaryVariable));

    }

    @OnClick(R.id.btnClear)
    public void pressedBtn10() {
        auxiliaryVariable = 0.00;

    }

    @OnClick(R.id.btnWynik)
    public void pressedBtn11() {
        resultScreen.setText(String.valueOf(auxiliaryVariable));


    }

    @OnClick(R.id.btnMnozenie)
    public void pressedBtn12() {


    }

    @OnClick(R.id.btnDziel)
    public void pressedBtn13() {

    }

    @OnClick(R.id.btnDodawanie)
    public void pressedBtn14() {

    }

    @OnClick(R.id.btnOdejmowanie)
    public void pressedBtn15() {

    }

    @OnClick(R.id.btnLewyNawias)
    public void pressedBtn16() {

    }

    @OnClick(R.id.btnPrawyNawias)
    public void pressedBtn17() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_kalkulatore);
        ButterKnife.bind(this);

    }
}
