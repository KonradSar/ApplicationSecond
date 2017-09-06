package com.example.konrad.applicationsecond;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MineKalkulatore extends AppCompatActivity {
    MeineKalkulatoreMEthods meineKalkulatoreMEthods = new MeineKalkulatoreMEthods();
    String demand;
    double rownanie;
    String rownanie2;

//    public boolean isPresentFirstVariable(boolean condition){
//        if (firstVariablee!=0.00 || firstVariablee!=1.00 || firstVariablee!=2.00 ||
//                firstVariablee!=3.00 || firstVariablee!=4.00 || firstVariablee!=5.00 ||
//                firstVariablee!=6.00 || firstVariablee!=7.00 || firstVariablee!=8.00 || firstVariablee!=9.00){
//            condition = true;
//            return condition;
//        }
//        else {
//            condition = false;
//            return condition;
//        }
//    }
//    public boolean isEnd(boolean condition){
//        if (secondVariable!=0.00 || secondVariable!=1.00 || secondVariable!=2.00 ||
//                secondVariable!=3.00 || secondVariable!=4.00 || secondVariable!=5.00 ||
//                secondVariable!=6.00 || secondVariable!=7.00 || secondVariable!=8.00 || secondVariable!=9.00){
//            condition = true;
//            return true;
//        }
//        else {
//            condition = false;
//            return false;
//        }
//    }
//    public double count(){
//        double result;
//        if (isPresentFirstVariable(true) && isEnd(true)){
//            if (demand.matches("dziel")){
//                result = meineKalkulatoreMEthods.dodawaj(firstVariablee, secondVariable);
//                return result;
//            }
//            else if (demand.matches("pomnoz")){
//                result = meineKalkulatoreMEthods.pomnoz(firstVariablee, secondVariable);
//                return result;
//            }
//            else if (demand.matches("dodaj")){
//                result = meineKalkulatoreMEthods.dodawaj(firstVariablee, secondVariable);
//                return result;
//            }
//            else if (demand.matches("odejmij")){
//                result = meineKalkulatoreMEthods.odejmij(firstVariablee, secondVariable);
//                return result;
//            }
//        }
//        else {
//
//        }
//        return 0.00;
//    }

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
    double firstVariablee;
    double secondVariable;
    String previousVariable2;

    @OnClick(R.id.btn0)
    public void pressedBtn() {
        rownanie2 = String.valueOf(0.00);
        resultScreen.setText(rownanie2);
//        if (isPresentFirstVariable(true)){
//            secondVariable = 0.00;
//            auxiliaryVariable = 0.00;
//            resultScreen.setText(String.valueOf(auxiliaryVariable));
//            isPresentFirstVariable(true);
//            isEnd(true);
//        }
//        else{
//            firstVariablee = 0.00;
//            auxiliaryVariable = 0.00;
//            resultScreen.setText(String.valueOf(auxiliaryVariable));
//            isPresentFirstVariable(true);
//            isEnd(false);
//        }

    }

    @OnClick(R.id.btn1)
    public void pressedBtn1() {
        rownanie2 = String.valueOf(1.00);
        resultScreen.setText(rownanie2);
//        if (isPresentFirstVariable(true)){
//            secondVariable = 1.00;
//            auxiliaryVariable = 1.00;
//            resultScreen.setText(String.valueOf(auxiliaryVariable));
//            isPresentFirstVariable(true);
//            isEnd(true);
//        }
//        else{
//            firstVariablee = 1.00;
//            auxiliaryVariable = 1.00;
//            resultScreen.setText(String.valueOf(auxiliaryVariable));
//            isPresentFirstVariable(true);
//            isEnd(false);
//        }


    }

    @OnClick(R.id.btn2)
    public void pressedBtn2() {
        rownanie2 = String.valueOf(2.00);
        resultScreen.setText(rownanie2);
//        if (isPresentFirstVariable(true)){
//            secondVariable = 2.00;
//            auxiliaryVariable = 2.00;
//            resultScreen.setText(String.valueOf(auxiliaryVariable));
//            isPresentFirstVariable(true);
//            isEnd(true);
//        }
//        else{
//            firstVariablee = 2.00;
//            auxiliaryVariable = 2.00;
//            resultScreen.setText(String.valueOf(auxiliaryVariable));
//            isPresentFirstVariable(true);
//            isEnd(false);
//        }


    }

    @OnClick(R.id.btn3)
    public void pressedBtn3() {
        rownanie2 = String.valueOf(3.00);
        resultScreen.setText(rownanie2);
//        if (isPresentFirstVariable(true)){
//            secondVariable = 3.00;
//            auxiliaryVariable = 3.00;
//            resultScreen.setText(String.valueOf(auxiliaryVariable));
//            isPresentFirstVariable(true);
//            isEnd(true);
//        }
//        else{
//            firstVariablee = 3.00;
//            auxiliaryVariable = 3.00;
//            resultScreen.setText(String.valueOf(auxiliaryVariable));
//            isPresentFirstVariable(true);
//            isEnd(false);
//        }


    }

    @OnClick(R.id.btn4)
    public void pressedBtn4() {
        rownanie2 = String.valueOf(4.00);
        resultScreen.setText(rownanie2);
//        if (isPresentFirstVariable(true)){
//            secondVariable = 4.00;
//            auxiliaryVariable = 4.00;
//            resultScreen.setText(String.valueOf(auxiliaryVariable));
//            isPresentFirstVariable(true);
//            isEnd(true);
//        }
//        else{
//            firstVariablee = 4.00;
//            auxiliaryVariable = 4.00;
//            resultScreen.setText(String.valueOf(auxiliaryVariable));
//            isPresentFirstVariable(true);
//            isEnd(false);
//        }


    }

    @OnClick(R.id.btn5)
    public void pressedBtn5() {
        rownanie2 = String.valueOf(5.00);
        resultScreen.setText(rownanie2);
//        if (isPresentFirstVariable(true)){
//            secondVariable = 5.00;
//            auxiliaryVariable = 5.00;
//            resultScreen.setText(String.valueOf(auxiliaryVariable));
//            isPresentFirstVariable(true);
//            isEnd(true);
//        }
//        else{
//            firstVariablee = 5.00;
//            auxiliaryVariable = 5.00;
//            resultScreen.setText(String.valueOf(auxiliaryVariable));
//            isPresentFirstVariable(true);
//            isEnd(false);
//        }


    }

    @OnClick(R.id.btn6)
    public void pressedBtn6() {
        rownanie2 = String.valueOf(6.00);
        resultScreen.setText(rownanie2);
//        if (isPresentFirstVariable(true)){
//            secondVariable = 6.00;
//            auxiliaryVariable = 6.00;
//            resultScreen.setText(String.valueOf(auxiliaryVariable));
//            isPresentFirstVariable(true);
//            isEnd(true);
//        }
//        else{
//            firstVariablee = 6.00;
//            auxiliaryVariable = 6.00;
//            resultScreen.setText(String.valueOf(auxiliaryVariable));
//            isPresentFirstVariable(true);
//            isEnd(false);
//        }


    }

    @OnClick(R.id.btn7)
    public void pressedBtn7() {
        rownanie2 = String.valueOf(7.00);
        resultScreen.setText(rownanie2);
//        if (isPresentFirstVariable(true)){
//            secondVariable = 7.00;
//            auxiliaryVariable = 7.00;
//            resultScreen.setText(String.valueOf(auxiliaryVariable));
//            isPresentFirstVariable(true);
//            isEnd(true);
//        }
//        else{
//            firstVariablee = 7.00;
//            auxiliaryVariable = 7.00;
//            resultScreen.setText(String.valueOf(auxiliaryVariable));
//            isPresentFirstVariable(true);
//            isEnd(false);
//        }


    }

    @OnClick(R.id.btn8)
    public void pressedBtn8() {
        rownanie2 = String.valueOf(8.00);
        resultScreen.setText(rownanie2);
//        if (isPresentFirstVariable(true)){
//            secondVariable = 8.00;
//            auxiliaryVariable = 8.00;
//            resultScreen.setText(String.valueOf(auxiliaryVariable));
//            isPresentFirstVariable(true);
//            isEnd(true);
//        }
//        else{
//            firstVariablee = 8.00;
//            auxiliaryVariable = 8.00;
//            resultScreen.setText(String.valueOf(auxiliaryVariable));
//            isPresentFirstVariable(true);
//            isEnd(false);
//        }

    }

    @OnClick(R.id.btn9)
    public void pressedBtn9() {
        rownanie2 = String.valueOf(9.00);
        resultScreen.setText(rownanie2);
//        if (isPresentFirstVariable(true)){
//            secondVariable = 9.00;
//            auxiliaryVariable = 9.00;
//            resultScreen.setText(String.valueOf(auxiliaryVariable));
//            isPresentFirstVariable(true);
//            isEnd(true);
//        }
//        else{
//            firstVariablee = 9.00;
//            auxiliaryVariable = 9.00;
//            resultScreen.setText(String.valueOf(auxiliaryVariable));
//            isPresentFirstVariable(true);
//            isEnd(false);
//        }



    }

    @OnClick(R.id.btnClear)
    public void pressedBtn10() {
        auxiliaryVariable = 0.00;
        resultScreen.setText("Empty Memory");


    }

    @OnClick(R.id.btnWynik)
    public void pressedBtn11() {
        resultScreen.setText(String.valueOf(auxiliaryVariable));




    }

    @OnClick(R.id.btnMnozenie)
    public void pressedBtn12() {
//        String firstVariable = resultScreen.getText().toString();
//        double firstVariable2 = Double.parseDouble(firstVariable);
//        firstVariable2 = firstVariablee;
//        demand = "pomnoz";
//        resultScreen.setText("");
        resultScreen.setText("mnozenie");
    }

    @OnClick(R.id.btnDziel)
    public void pressedBtn13() {
//        String firstVariable = resultScreen.getText().toString();
//        double firstVariable2 = Double.parseDouble(firstVariable);
//        firstVariable2 = firstVariablee;
//        demand = "dziel";
//        resultScreen.setText("");
        resultScreen.setText("dzielenie");

    }

    @OnClick(R.id.btnDodawanie)
    public void pressedBtn14() {
//        String firstVariable = resultScreen.getText().toString();
//        double firstVariable2 = Double.parseDouble(firstVariable);
//        firstVariable2 = firstVariablee;
//        demand = "dodaj";
//        resultScreen.setText("");
        resultScreen.setText("dodawanie");

    }

    @OnClick(R.id.btnOdejmowanie)
    public void pressedBtn15() {
//        String firstVariable = resultScreen.getText().toString();
//        double firstVariable2 = Double.parseDouble(firstVariable);
//        firstVariable2 = firstVariablee;
//        demand = "odejmij";
//        resultScreen.setText("");
        resultScreen.setText("odejmowanie");

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
//        isPresentFirstVariable(false);
//        isEnd(false);






    }
}
