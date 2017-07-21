package com.example.konrad.applicationsecond;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;


/**
 * A simple {@link Fragment} subclass.
 */
public class MojTab1Fragment extends Fragment {


    public MojTab1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_moj_tab1, container, false);

          ImageView zdj = (ImageView) v.findViewById(R.id.ff22);

                // utworzenie instancji

                       ImageLoader imageLoader = ImageLoader.getInstance();

                String url = "http://x.wpimg.pl/i/ivar/layout/201201/logo_wppl_1200x630.png";

               imageLoader.displayImage(url, zdj);

                return v;
    }

}
