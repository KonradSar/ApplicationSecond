package com.example.konrad.TODO;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.konrad.applicationsecond.NaszeMetody;
import com.example.konrad.applicationsecond.PanstwoAdapter;
import com.example.konrad.applicationsecond.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;



public class DutiesRecyclerView extends AppCompatActivity {
    DataBaseQueries2 polaczenieBazy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);
        polaczenieBazy = new DataBaseQueries2(DutiesRecyclerView.this);
        polaczenieBazy.otworzZapis();
        setContentView(R.layout.activity_duties_recycler_view);
        RecyclerView mojRecycler = (RecyclerView) findViewById(R.id.dutiesRecycler);
        List<Duties> lista = polaczenieBazy.zwrocListeFilmow();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        mojRecycler.setLayoutManager(linearLayoutManager);
        DutiesAdapter da = new DutiesAdapter(lista);
        mojRecycler.setAdapter(da);
    }
}
