package com.example.konrad.applicationsecond;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Environment;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

import butterknife.OnClick;

import static com.example.konrad.applicationsecond.R.id.button;
import static com.example.konrad.applicationsecond.R.id.checkbox;
import static com.example.konrad.applicationsecond.R.id.nameOfProductsEditText;
import static com.example.konrad.applicationsecond.R.id.view;

/**
 * Created by Konrad on 17.06.2017.
 */

public class ShoppingAdapter1 extends RecyclerView.Adapter<ShoppingAdapter1.MyViewHolder> {
    private List<Shopping> shoppingList;
//    private List<ShoppingCart> shoppingCart;
    ImageLoader imageLoader;
    private Context context1;
    public static boolean isCheckBoxInAdapterChecked(Boolean condition){
        return condition;
    }
    public static boolean permission;
    public static double result = 0.00;
    public int position1;

    public static int positionForRecycler(int condition){
        return condition;
    }
    public int getPosition1() {
        return position;
    }

    public void setPosition1(int position) {
        this.position = position;

    }


    private int position;


    public int getPosition() {
        return position;
    }

    public int setPosition(int position) {
        this.position = position;
        return position;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.singleline, parent, false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {



        final Shopping shopping = shoppingList.get(position);



        if (shopping.isDustProductOn==false){
            holder.name.setText(shopping.productName);
            holder.price.setText(String.valueOf(shopping.priceOfASingleProduct*shopping.numberOfProducts));
            double variable2 = (shopping.priceOfASingleProduct*shopping.numberOfProducts);
            holder.price.setText( String.format( "%.2f", variable2 ));
            holder.numberOfProduct.setText(String.valueOf(shopping.numberOfProducts));
//            holder.relativeLay.setBackgroundResource(R.drawable.but2);
//            shopping.isRedBackgroundColor = true;


        }
        else if (shopping.isDustProductOn){
            holder.name.setText(shopping.productName);
            holder.price.setText(String.valueOf(shopping.priceOf100grams*shopping.weightOfProduct));
            double variable1 = (shopping.priceOf100grams*shopping.weightOfProduct);
            holder.price.setText(String.format("%.2f", variable1));
            holder.numberOfProduct.setText(String.valueOf(shopping.weightOfProduct));
//            holder.relativeLay.setBackgroundResource(R.drawable.but2);
//            shopping.isRedBackgroundColor = true;


        }

        if (shopping.isRedBackgroundColor){
            holder.relativeLay.setBackgroundResource(R.drawable.but2);
        }
        else {
            holder.relativeLay.setBackgroundResource(R.drawable.but3);
        }


        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()) {
                    Toast.makeText(context1, "Product added to cart", Toast.LENGTH_LONG).show();
                    isCheckBoxInAdapterChecked(true);

                    String priceOfProductFromHolderForTrolley = String.valueOf(holder.price.getText());
                    Double przeliczonaCena = Double.parseDouble(priceOfProductFromHolderForTrolley);
                    Double resultForTrolley = przeliczonaCena;
                    NaszeMetody.counterHelper = przeliczonaCena;
                    if (NaszeMetody.finalResult==0.00){
                        NaszeMetody.finalResult=NaszeMetody.counterHelper;
                    }
                    else if (NaszeMetody.finalResult!=0.00){
                        NaszeMetody.finalResult = NaszeMetody.finalResult + NaszeMetody.counterHelper;
                    }
                }
                else if (!buttonView.isChecked()){
                    Toast.makeText(context1, "Product removed from cart", Toast.LENGTH_LONG).show();

                    isCheckBoxInAdapterChecked(false);


                }
            }
        });

        holder.deleteimagebtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                shoppingList.remove(position);
                notifyItemRemoved(position);

            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                setPosition(holder.getAdapterPosition());
                NaszeMetody.position = setPosition(holder.getAdapterPosition());
                positionForRecycler(position);
//                RelativeLayout relativeLay = (RelativeLayout) v.findViewById(R.id.recyclerViewLay);
//                relativeLay.setBackgroundResource(R.drawable.but3);
                return false;
            }
        });

    }



    // 1. w onContextItemSelected odczytac na ktorej pozycji zostalo klikniete cos w stylu getAdapter().getPosition()
    // 2. do Shopping dodac zmienna ktora przechowuje kolor i ustawic w zaleznosci od niej w BindView kolor kontrolki
    // 3. zrobic jakas metode w Adapterze ktora na danej pozyycji uaktualnia
    // 3. z onContextItemSelected wywolywac ta metode w adpaterze i odswiezyc dane

    @Override
    public int getItemCount() {
        return shoppingList.size();
    }




    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{
        public TextView name;
        public TextView price;
        public CheckBox checkBox;
        public ImageButton deleteimagebtn;
        public TextView numberOfProduct;
        public RelativeLayout relativeLay;


        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.nazwaZakupu);
            price = (TextView) itemView.findViewById(R.id.cena2);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkbox2);
            deleteimagebtn = (ImageButton) itemView.findViewById(R.id.deletebtn);
            numberOfProduct = (TextView) itemView.findViewById(R.id.cena);
            itemView.setOnCreateContextMenuListener(this);
            relativeLay = (RelativeLayout) itemView.findViewById(R.id.recyclerViewLay);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.menu_shoppinglist, menu);
            RelativeLayout relativeLay = (RelativeLayout) v.findViewById(R.id.recyclerViewLay);


        }

        private MenuInflater getMenuInflater() {
            return new MenuInflater(context1);
        }


    }
    public ShoppingAdapter1(List<Shopping> shoppingList, Context context){
        this.shoppingList = shoppingList;
        this.context1 = context;

    }


}

