package com.example.konrad.applicationsecond;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Environment;
import android.provider.ContactsContract;
import android.support.constraint.solver.SolverVariable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.konrad.applicationsecond.R.id.toolbar;

public class ShopRecyclerView extends AppCompatActivity {
    android.support.design.widget.CoordinatorLayout coordinator;
    final String TAG = "KonradApp";
    private Context context1;
    public static double counter;
    List<Shopping> shoppingList = NaszeMetody.shoppingList;
    String phone_number = "";
public static final int REQUEST_CODE = 1;
    private static String odbiorcaSMS;
//    RelativeLayout relativeLay = (RelativeLayout) findViewById(R.id.recyclerViewLay);






    @Override
    public boolean onContextItemSelected(MenuItem item){
        AdapterView.AdapterContextMenuInfo info = (AdapterView .AdapterContextMenuInfo) item.getMenuInfo();
        super.onContextItemSelected(item);
        switch (item.getItemId()) {
            case R.id.additionalInfo:
                return false;
            case R.id.goShopping:
                shoppingList.get(NaszeMetody.position).setRedBackgroundColor(false);
                shoppingAdapter1.notifyDataSetChanged();
//                Shopping shoppingOne = shoppingList.get(NaszeMetody.position);
//                shoppingOne.setRedBackgroundColor(true);
//                updateBackground(shoppingOne);
                return true;
            default:
                return super.onContextItemSelected(item);

        }

    }

//    public void updateBackground(Shopping shopping) {
//        if (shopping.isRedBackgroundColor){
//            relativeLay.setBackgroundResource(R.drawable.but3);
//        }
//        else if (!shopping.isRedBackgroundColor){
//            relativeLay.setBackgroundResource(R.drawable.but2);
//        }
//    }

    ShoppingAdapter1 shoppingAdapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_recycler_view);
        ButterKnife.bind(this);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingbtn);


        final TextView summary = (TextView) findViewById(R.id.shoppingsummary);

        final ImageButton trolley = (ImageButton) findViewById(R.id.trolleybtn);

        final ImageButton clearTrolley = (ImageButton) findViewById(R.id.cleartrolleybtn);

        final ImageButton downloadFromExternalMemory = (ImageButton) findViewById(R.id.readExternalDatabtn);

        final ImageButton sendMessageWithCreatedShoppingList = (ImageButton) findViewById(R.id.sendMessageBtn);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarView);


        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);


        final RecyclerView mojRecycler = (RecyclerView) findViewById(R.id.mojRecyclerView2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mojRecycler.setLayoutManager(linearLayoutManager);
          shoppingAdapter1 = new ShoppingAdapter1(NaszeMetody.shoppingList, ShopRecyclerView.this);
        mojRecycler.setAdapter(shoppingAdapter1);



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "You are going to add a new product", Toast.LENGTH_SHORT).show();
                NaszeMetody.finalResult = 0.00;
                Intent intent = new Intent(ShopRecyclerView.this, AddProduct.class);
                startActivity(intent);
            }
        });

        trolley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast.makeText(getApplicationContext(), "Dodałem produkt staly", Toast.LENGTH_SHORT).show();
                summary.setText(String.format("%.2f", NaszeMetody.finalResult));

            }
        });
        clearTrolley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NaszeMetody.finalResult = 0.00;
                summary.setText(String.valueOf(0.00));
            }
        });
        downloadFromExternalMemory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (readFromExternalMemory() != null) {
                    readFromExternalMemory();
                    downloadDataForAdapter();
                } else if (readFromExternalMemory() == null) {
                    Toast.makeText(getApplicationContext(), "There is no saved data", Toast.LENGTH_SHORT).show();
                }

            }
        });

        Toolbar myToolBar = (Toolbar) findViewById(R.id.toolbarView);
        setSupportActionBar(myToolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        toolbar.inflateMenu(R.menu.moj_toolbar);
//        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                if(item.getItemId() == R.id.trolleybtn2){
//
//                }
//                if(item.getItemId() == R.id.cleartrolleybtn){
//                    wyslijMailem();
//                }
//                if(item.getItemId() == R.id.readExternalDatabtn){
//                    pobierz();
//                }
//                if(item.getItemId() == R.id.sendMessageBtn){
//
//                }
//                return false;
//            }
//        });


        sendMessageWithCreatedShoppingList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(ShopRecyclerView.this).setTitle("Your Alert")
                        .setMessage("Do you want to send shopping list by sms?")
                        .setCancelable(true)
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Uri uri2 = Uri.parse("content://contacts");
                                Intent intent2 = new Intent(Intent.ACTION_PICK, uri2);
                                intent2.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                                startActivityForResult(intent2, REQUEST_CODE);



                            }
                        }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setIcon(R.drawable.alert).setNeutralButton("fjf", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(Intent.ACTION_SEND);
                        i.setType("message/rfc822");
                        i.putExtra(Intent.EXTRA_EMAIL, "konradsar2015@gmail.com");
                        i.putExtra(Intent.EXTRA_TEXT, "dupa");
                        startActivity(Intent.createChooser(i, "teraz wslemy ..."));


                    }
                }).show();

            }


//                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(ShopRecyclerView.this);
//                alertDialog.setTitle("Enter Data");
//
//                LinearLayout.LayoutParams doTextu = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
//                        LinearLayout.LayoutParams.WRAP_CONTENT);
//
//                LinearLayout view = new LinearLayout(ShopRecyclerView.this);
//
//                final EditText nowyText = new EditText(ShopRecyclerView.this);
//                nowyText.setHint("Wpisz numer telefonu");
//                nowyText.setLayoutParams(doTextu);
//                view.addView(nowyText);
//
//                alertDialog.setView(v);
//
//                alertDialog.setNegativeButton("Anuluj", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
//
//                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        phone_number = nowyText.getText().toString();
//                    }
//
//                });
//                alertDialog.show();

//            Uri uri = Uri.parse(phone_number);
        });



    }

    private void sendSMS(String phone) {
        Uri uri = Uri.parse("smsto:" + phone);
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        List<Shopping> my_list = readFromExternalMemory();
        List<String> listForSms = new ArrayList<String>();
        for (int i = 0; i < my_list.size(); i++){
            Shopping shopping = my_list.get(i);
            String name = shopping.getProductName();
            int numberOfProd = shopping.getNumberOfProducts();
            double priceOfSingleProd = shopping.getPriceOfASingleProduct();
            double weightOfDustProd = shopping.getWeightOfProduct();
            double priceOf100grams = shopping.getPriceOf100grams();
            boolean dustProd = shopping.isDustProductOn();
            double finalPriceWholeProd = priceOfSingleProd*numberOfProd;
            double finalPriceDustProd = weightOfDustProd*priceOf100grams;
            if (dustProd){
                String singleLine = "Nr."+(i+1)+" "+name+","+'\n'+"masa produktu [kg] "+String.valueOf(weightOfDustProd)+","+'\n'+"cena produktu za [kg] "+String.valueOf(priceOf100grams)+","+'\n'+"cena calkowita "+finalPriceDustProd+" złotych"+'\n';
                listForSms.add(singleLine);
            }
            else if (dustProd==false){
                String singleLine = "Nr."+(i+1)+" "+name+","+'\n'+"liczba sztuk "+String.valueOf(numberOfProd)+","+'\n'+"cena jednostkowa "+String.valueOf(priceOfSingleProd)+","+'\n'+"cena calkowita "+finalPriceWholeProd+" złotych"+'\n';
                listForSms.add(singleLine);
            }
        }
        intent.putExtra("sms_body", String.valueOf(listForSms));
        startActivity(intent);
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
            Toast.makeText(getApplicationContext(), "Odczytane z External Memory", Toast.LENGTH_SHORT).show();
//            coordinator = (android.support.design.widget.CoordinatorLayout) findViewById(R.id.coordinator);
//            Snackbar.make(coordinator, "Odczytane", Snackbar.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Blad odczytu z External Memory", Toast.LENGTH_SHORT).show();
//            Snackbar.make(coordinator, "Wystąpił błąd odczytu", Snackbar.LENGTH_SHORT).show();
        }
        Type type = new TypeToken<List<Shopping>>(){}.getType();

        List<Shopping> odczytaneProdukty;

        Gson gson = new Gson();
        odczytaneProdukty = gson.fromJson(sb.toString(), type);


        return odczytaneProdukty;

    }
    public void downloadDataForAdapter(){
        RecyclerView mojRecycler = (RecyclerView) findViewById(R.id.mojRecyclerView2);
        shoppingList = readFromExternalMemory();
        ShoppingAdapter1 shoppingAdapter2 = new ShoppingAdapter1(shoppingList, ShopRecyclerView.this);
        mojRecycler.setAdapter(shoppingAdapter2);
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent intent) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Uri uri = intent.getData();
                String[] projection = { ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME };

                Cursor cursor = getContentResolver().query(uri, projection,
                        null, null, null);
                cursor.moveToFirst();

                int numberColumnIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                odbiorcaSMS = cursor.getString(numberColumnIndex);

                sendSMS(odbiorcaSMS);

//                Log.d(TAG, "ZZZ number : " + number +" , name : "+name);





            }}}

}
