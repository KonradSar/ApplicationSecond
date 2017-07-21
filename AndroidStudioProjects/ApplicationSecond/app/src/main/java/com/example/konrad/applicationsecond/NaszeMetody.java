package com.example.konrad.applicationsecond;

import android.content.Context;
import android.os.Environment;
import android.support.design.widget.Snackbar;
import android.text.Html;
import android.text.Spanned;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.example.konrad.TODO.Duties;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Konrad on 03.07.2017.
 */

public class NaszeMetody {

   // zainicjalizowanie klasy w pierwszym activity (w OnCreate), do ktorego wchodzimy
   public static Context AppContext;
   public static void InicjalizacjaNaszeMetody(Context appContext){
      AppContext = appContext;
   }

   public static List<Shopping> shoppingList = new ArrayList<>();
   public static List<ShoppingCart> shoppingCart = new ArrayList<>();
   public static List<Duties> dutiesList = new ArrayList<>();
   public static double counterHelper = 0.00;
   public static double finalResult = 0.00;
   public static String kurwajegomac;
    public static final String LOG_TAG = "KonradApp";
   public static int position;



//    public void SaveToExternalMEmory(List<Shopping> shoppingList){
//        String lokalizacjFolderu = Environment.getExternalStorageDirectory().toString();
//        File file = new File(lokalizacjFolderu, "ShoppingList");
//        Gson gson = new Gson();
//        String jsonShoppingList =  gson.toJson(shoppingList);
//
//        try {
//            FileOutputStream outputStream = new FileOutputStream(file);
//            outputStream.write(jsonShoppingList.getBytes());
//            outputStream.close();
//
//            Snackbar.make(restLay, "Zapisane", Snackbar.LENGTH_SHORT).show();
//        } catch (Exception e) {
//            e.printStackTrace();
//            Snackbar.make(restLay, "Wystąpił błąd zapisu", Snackbar.LENGTH_SHORT).show();
//        }
//
//    }






//   }












   @SuppressWarnings("deprecation")
   public static Spanned fromHtml(String html){
      Spanned result;
      if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
         result = Html.fromHtml(html,Html.FROM_HTML_MODE_LEGACY);
      } else {
         result = Html.fromHtml(html);
      }
      return result;
   }
}
