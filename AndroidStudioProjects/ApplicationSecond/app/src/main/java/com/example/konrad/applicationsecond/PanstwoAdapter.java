package com.example.konrad.applicationsecond;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import org.w3c.dom.Text;

import java.util.List;

public class PanstwoAdapter extends RecyclerView.Adapter<PanstwoAdapter.MyViewHolder> {

    private List<Panstwo> panstwoLista;
    ImageLoader imageLoader;


    // zwraca nam wyglad listy + tutaj definiujemy do ktorego XML z wygladem pojedynczego wiersza sie odnosimy
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.wiersz,parent,false);
        return new MyViewHolder(v);

    }




    // tutaj laczymy kontrolki z danymi

    public static String returnImageURI(int link){
        // aby otworzyc z resource bitmapy za pomoca ImageLoadera korzystam z wlasnej funkcji
        // ktora do nazwy zasobow dodaje przedrostek drawable://
        String imageUri = "drawable://" + link;
        return imageUri;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // obiekt do ktorego jest przypisywany obiekt na odpowiedniej pozycji
        Panstwo obiektPanstwo = panstwoLista.get(position);

        // dokonujemy operacji na konkretnyhc kontrolkach
        holder.pan.setText(obiektPanstwo.nazwaPanstwa);
        holder.st.setText(obiektPanstwo.stolica);
        imageLoader.displayImage(returnImageURI(obiektPanstwo.flaga), holder.zdjFl);
        // imageLoader.displayImage("drawable://R.drawable.br, holder.zdjFl);
    }

    // zwrac wielkosc listy
    @Override
    public int getItemCount() {
        return panstwoLista.size();
    }


    // tutaj odnajdujemy kontrolki po id okreslonym w naszym XML
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView st;
        public TextView pan;
        public ImageView zdjFl;

        public MyViewHolder(View itemView) {
            super(itemView);
            pan = (TextView) itemView.findViewById(R.id.nazwaPanstwa);
            st = (TextView) itemView.findViewById(R.id.nazwaStolicy);
            zdjFl = (ImageView) itemView.findViewById(R.id.zdjecieFlagi);
        }
    }

    // konstuktor przyjmujacy liste panstw wywolywany w activity
    public PanstwoAdapter(List<Panstwo> panstwaLista){
        this.panstwoLista = panstwaLista;
        imageLoader = ImageLoader.getInstance();
    }
}