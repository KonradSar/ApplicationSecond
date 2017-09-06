package com.example.konrad.applicationsecond;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import static com.example.konrad.applicationsecond.R.id.toolbar;

public class ToolbarTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_test);


        Toolbar myToolBar = (Toolbar) findViewById(R.id.toolbarView2);

        myToolBar.inflateMenu(R.menu.moj_toolbar);
        myToolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId() == R.id.trolleybtn2){

                }
                if(item.getItemId() == R.id.cleartrolleybtn){
//                    wyslijMailem();
                }
                if(item.getItemId() == R.id.readExternalDatabtn){
//                    pobierz();
                }
                if(item.getItemId() == R.id.sendMessageBtn){

                }
                return false;
            }
        });
    }
}
