package com.example.konrad.applicationsecond;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MojPagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;
    public MojPagerAdapter(FragmentManager fm, int NumOfTabs){
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return  new MojTab1Fragment();
            case 1:
                return new MojTab2Fragment();
            case 2:
                return new MojTab3Fragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
