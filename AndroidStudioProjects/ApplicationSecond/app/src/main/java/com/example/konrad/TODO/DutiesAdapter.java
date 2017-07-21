package com.example.konrad.TODO;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.konrad.applicationsecond.R;
import com.example.konrad.applicationsecond.Shopping;
import com.example.konrad.applicationsecond.ShoppingAdapter1;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Konrad on 06.07.2017.
 */

public class DutiesAdapter extends RecyclerView.Adapter<DutiesAdapter.MyViewHolder> {
    private List<Duties> dutiesList;



// zwraca wyglad listy
    @Override
    public DutiesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.singledutyline, parent, false);
        return new MyViewHolder(v);
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Duties duties = dutiesList.get(position);
        holder.name.setText(duties.opisZdarzenia);
        holder.time.setText(duties.terminWykonania);

    }

    @Override
    public int getItemCount() {
        return dutiesList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView time;


        public MyViewHolder (View itemView) {
            super(itemView);
//            name = (TextView) itemView.findViewById(R.id.opisWydarzenia);
//            time = (TextView) itemView.findViewById(R.id.terminWykonania);

        }
    }
    public DutiesAdapter(List<Duties> dutiesList){
        this.dutiesList = dutiesList;
    }
}
