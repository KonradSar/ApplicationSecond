package com.example.konrad.applicationsecond;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);

        setContentView(R.layout.activity_recycler_view);

        List<Panstwo> listaPanstw = new ArrayList<>();

        Panstwo wielkanrytania = new Panstwo(R.drawable.gb, "Londyn", "WielkaBrytania");

        listaPanstw.add(wielkanrytania);

        RecyclerView mojRecycler = (RecyclerView) findViewById(R.id.mojRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        mojRecycler.setLayoutManager(linearLayoutManager);

//        RecyclerView llm = new LinearLayoutManager(this);


        PanstwoAdapter pa = new PanstwoAdapter(listaPanstw);
        mojRecycler.setAdapter(pa);


    }
}
