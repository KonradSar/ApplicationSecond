package com.example.konrad.applicationsecond;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mylibrary.Photo;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.konrad.applicationsecond.R.id.imageView;

public class PhotoActivity extends Activity {
    @BindView(R.id.imageView) ImageView photoView;
    @BindView(R.id.button3) Button downloadPhotoButton;
    @BindView(R.id.floatingbtn) FloatingActionButton findImagebtn;

    @OnClick(R.id.floatingbtn)
    public void showPhoto2(){
        Photo photo = new Photo();
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(photo.getList(), photoView);
        Toast.makeText(getApplicationContext(), "WYBRANY OBRAZEK Z PLIKU PHOTO", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.button3)
    public void showPhoto(){

        Photo photo1 = new Photo();

        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(photo1.getList(), photoView);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        ButterKnife.bind(this);
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);
    }
}
