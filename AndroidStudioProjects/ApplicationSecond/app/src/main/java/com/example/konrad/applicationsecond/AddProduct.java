package com.example.konrad.applicationsecond;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddProduct extends AppCompatActivity {
    android.support.design.widget.CoordinatorLayout coordinator;
    final String TAG = "KonradApp";
    @BindView(R.id.nameOfProductsEditText) EditText nameOfProduct;
    @BindView(R.id.numberOfProductsEditText) EditText numberOfProducts;
    @BindView(R.id.priceEditText) EditText priceOfProduct;
    @BindView(R.id.weightOfProductEditText) EditText weightOfProduct;
    @BindView(R.id.priceFor100gramsOfProductEditText) EditText priceOf100grams;
    @BindView(R.id.btnSwitch) Switch choiceBtn;
    @BindView(R.id.btnRegister) Button registerBtn;
    @BindView(R.id.gotoListBtn) Button goToListBtn;
    private Context context;


//    public void SaveToExternalMEmory(List<Shopping> shoppingList) {
//        String lokalizacjFolderu = Environment.getExternalStorageDirectory().toString();
//        File file = new File(lokalizacjFolderu, "ShoppingList");
//        Gson gson = new Gson();
//        String jsonShoppingList = gson.toJson(shoppingList);
//
//        try {
//            FileOutputStream outputStream = new FileOutputStream(file);
//            outputStream.write(jsonShoppingList.getBytes());
//            outputStream.close();
//            Toast.makeText(getApplicationContext(), "Zapisane", Toast.LENGTH_SHORT).show();
////            Snackbar.make(coordinator, "Zapisane", Snackbar.LENGTH_SHORT).show();
//        } catch (Exception e) {
//            e.printStackTrace();
//            Toast.makeText(getApplicationContext(), "Blad zapisu do internal Memory", Toast.LENGTH_SHORT).show();
////            Snackbar.make(coordinator, "Wystąpił błąd zapisu", Snackbar.LENGTH_SHORT).show();
//        }
//
//    }

    @OnClick(R.id.btnRegister)
    public void show() {
        if (choiceBtn.isChecked()){
            NaszeMetody.kurwajegomac = "bbbbbb";
            if (nameOfProduct.getText().toString().matches("")){
                Toast.makeText(getApplicationContext(), "PLEASE FILL IN EACH LINE", Toast.LENGTH_SHORT).show();
            }
            else if (weightOfProduct.getText().toString().matches("")){
                Toast.makeText(getApplicationContext(), "PLEASE FILL IN EACH LINE", Toast.LENGTH_SHORT).show();
            }
            else if (priceOf100grams.getText().toString().matches("")){
                Toast.makeText(getApplicationContext(), "PLEASE FILL IN EACH LINE", Toast.LENGTH_SHORT).show();
            }

            if (!nameOfProduct.getText().toString().matches("") && !weightOfProduct.getText().toString().matches("") && !priceOf100grams.getText().toString().matches("")){
                NaszeMetody.shoppingList.add(new Shopping(nameOfProduct.getText().toString(), Double.valueOf(weightOfProduct.getText().toString()), Double.valueOf(priceOf100grams.getText().toString()), choiceBtn.isChecked(), true));
                sprawdzCzyJestDostep();
                SaveToExternalMEmory(NaszeMetody.shoppingList);
//                Intent intent = new Intent(AddProduct.this, ShopRecyclerView.class);
//                startActivity(intent);
            }
        }
        else if (!choiceBtn.isChecked()){
            NaszeMetody.kurwajegomac = "aaaaa";
            if (nameOfProduct.getText().toString().matches("")){
                Toast.makeText(getApplicationContext(), "PLEASE FILL IN EACH LINE", Toast.LENGTH_SHORT).show();
            }
            else if (numberOfProducts.getText().toString().matches("")){

                Toast.makeText(getApplicationContext(), "PLEASE FILL IN EACH LINE", Toast.LENGTH_SHORT).show();
            }
            else if (priceOfProduct.getText().toString().matches("")){
                Toast.makeText(getApplicationContext(), "PLEASE FILL IN EACH LINE", Toast.LENGTH_SHORT).show();
            }

            if (!nameOfProduct.getText().toString().matches("") && !numberOfProducts.getText().toString().matches("") && !priceOfProduct.getText().toString().matches("")){
                NaszeMetody.shoppingList.add(new Shopping(nameOfProduct.getText().toString(), Integer.valueOf(numberOfProducts.getText().toString()), Double.valueOf(priceOfProduct.getText().toString()), choiceBtn.isChecked(), true));
                sprawdzCzyJestDostep();
                SaveToExternalMEmory(NaszeMetody.shoppingList);
//                Intent intent = new Intent(AddProduct.this, ShopRecyclerView.class);
//                startActivity(intent);
            }
        }
    }
    @OnClick(R.id.btnSwitch)
    public void select(){
        if(choiceBtn.isChecked()){
            numberOfProducts.setVisibility(View.INVISIBLE);
            priceOfProduct.setVisibility(View.INVISIBLE);
            weightOfProduct.setVisibility(View.VISIBLE);
            priceOf100grams.setVisibility(View.VISIBLE);
            nameOfProduct.setVisibility(View.VISIBLE);
        }else if (!choiceBtn.isChecked()){
            weightOfProduct.setVisibility(View.INVISIBLE);
            priceOf100grams.setVisibility(View.INVISIBLE);
            numberOfProducts.setVisibility(View.VISIBLE);
            nameOfProduct.setVisibility(View.VISIBLE);
            priceOfProduct.setVisibility(View.VISIBLE);

        }
    }
    @OnClick(R.id.gotoListBtn)
    public void goToListOnly(){
        Intent intent = new Intent(AddProduct.this, ShopRecyclerView.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        ButterKnife.bind(this);
        NaszeMetody.InicjalizacjaNaszeMetody(context);

        if (choiceBtn.isChecked()) {
            numberOfProducts.setVisibility(View.INVISIBLE);
            priceOfProduct.setVisibility(View.INVISIBLE);
            weightOfProduct.setVisibility(View.VISIBLE);
            priceOf100grams.setVisibility(View.VISIBLE);
            nameOfProduct.setVisibility(View.VISIBLE);
        } else if (!choiceBtn.isChecked()) {
            weightOfProduct.setVisibility(View.INVISIBLE);
            priceOf100grams.setVisibility(View.INVISIBLE);
            numberOfProducts.setVisibility(View.VISIBLE);
            nameOfProduct.setVisibility(View.VISIBLE);
            priceOfProduct.setVisibility(View.VISIBLE);

        }
    }
//        coordinator = (android.support.design.widget.CoordinatorLayout) findViewById(R.id.addView);





    final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 1;

    public void sprawdzCzyJestDostep(){
            // sprawdzamy czy jest przyznay dostep
            if(android.support.v4.app.ActivityCompat.checkSelfPermission(AddProduct.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED){

                // za pomoca tej funkcji sprawdzamy czy uzytkownik po raz pierwszy juz blokowal dostep do sms
                if (ActivityCompat.shouldShowRequestPermissionRationale(AddProduct.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)){
                    // jesli dostep blokowal pokazujemy po co nam to potrzebne
                    showExplanation("Potrzebujemy pozwolenia", "Chcemy zapisać w pamięci zewnętrznej menu",
                            Manifest.permission.WRITE_EXTERNAL_STORAGE, MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
                }else{
                    // pokazujemy okienko z prosba za pierwszym razem odrazu systemowe
                    requestPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
                }
            }
        }

        // funkcja ktora pokazuje okienko systemowe z prosba o dany kod
        private void requestPermissions(String permissionName, int permissionRequestCode){
            ActivityCompat.requestPermissions(this, new String[]{permissionName} , permissionRequestCode);
        }

        // wlasna funkcja ktora pokazuje okienko z wyjasnieniem prosby o dostep
        private void showExplanation(String title, String message, final String permission, final int permissionRequestCode){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(title);
            builder.setMessage(message);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    requestPermissions(permission, permissionRequestCode);
                }
            });
            builder.show();
        }

        // metoda wywolywana za kazdym razem gdy uzytkownik podejmie decyzje o dostepie
        @Override
        public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
            switch (requestCode) {
                case MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE: {
                    // jesli uzytkownik dal anuluj to dlugosc listy bedzie pusta
                    if (grantResults.length > 0
                            && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        SaveToExternalMEmory(NaszeMetody.shoppingList); // dostep przyznany - mozemy zrobic co chcemy
                        Log.d(NaszeMetody.LOG_TAG, "Dostęp przyznany");
                    } else {
                        Log.d(NaszeMetody.LOG_TAG, "Dostęp nie przyznany");
                        //  dostep nie przyznany ! musimy obsluzyc ten problem w aplikacji
                        // ponizej dodatkowo sprawdzamy czy zaznaczyl never ask again
                        if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                            // user rejected the permission
                            boolean showRationale = ActivityCompat.shouldShowRequestPermissionRationale(AddProduct.this,
                                    Manifest.permission.WRITE_EXTERNAL_STORAGE);
                            if (!showRationale) {
                                Log.d(NaszeMetody.LOG_TAG, "Uzytkownik zaznaczyl never ask again");
                            }
                        }
                    }
                    return;
                }

                // za pomoca swticha mozna przejrzec czasmi wiele prosb
            }
        }
    public List<Shopping> readFromExternalMemory(){
        File plik = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "ShoppingList");
        StringBuilder sb = new StringBuilder();
        try {
            FileInputStream fis =  new FileInputStream(plik);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            sb = new StringBuilder();
            String line;
            while((line = br.readLine()) != null){
                sb.append(line);
            }
            Toast.makeText(getApplicationContext(), "Odczytane", Toast.LENGTH_SHORT).show();
//            coordinator = (android.support.design.widget.CoordinatorLayout) findViewById(R.id.coordinator);
//            Snackbar.make(coordinator, "Odczytane", Snackbar.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Blad odczytu", Toast.LENGTH_SHORT).show();
//            Snackbar.make(coordinator, "Wystąpił błąd odczytu", Snackbar.LENGTH_SHORT).show();
        }
        Type type = new TypeToken<List<Shopping>>(){}.getType();

        List<Shopping> odczytaneProdukty;

        Gson gson = new Gson();
        odczytaneProdukty = gson.fromJson(sb.toString(), type);


        return odczytaneProdukty;

    }
    public void SaveToExternalMEmory(List<Shopping> shoppingList) {
        String lokalizacjFolderu = Environment.getExternalStorageDirectory().toString();
        File file = new File(lokalizacjFolderu, "ShoppingList");
        Gson gson = new Gson();
        String jsonShoppingList = gson.toJson(shoppingList);

        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(jsonShoppingList.getBytes());
            outputStream.close();
            Toast.makeText(getApplicationContext(), "Zapisane", Toast.LENGTH_SHORT).show();
//            Snackbar.make(coordinator, "Zapisane", Snackbar.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Blad zapisu do internal Memory", Toast.LENGTH_SHORT).show();
//            Snackbar.make(coordinator, "Wystąpił błąd zapisu", Snackbar.LENGTH_SHORT).show();
        }

    }

    }


