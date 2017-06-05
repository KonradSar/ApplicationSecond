package com.example.konrad.applicationsecond;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PanstwaActivity extends AppCompatActivity {

    final String TAG = "KonradApp";
    @BindView(R.id.list1) ListView nationsList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panstwa);
        ButterKnife.bind(this);


        String[] nations = {"Poland", "Germany", "RPA", "Bytom" , "Sosnowiec", "Dąbrowa Górnicza", "Italy", "France", "Portugal", "Switzerland", "America", "Australia", "New Zeland", "Egypt", "Somalia", "Monako", "Watykan"};
        ArrayList<String> natio = new ArrayList<String>();
        natio.addAll(Arrays.asList(nations));
        ArrayAdapter<String>  adapter = new ArrayAdapter<String>(this, R.layout.row, natio);
        nationsList.setAdapter(adapter);

        nationsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // kod
                String coKlikniete =  (String)parent.getItemAtPosition(position);
                Log.d(TAG, coKlikniete);

            }
        });

    }
}
