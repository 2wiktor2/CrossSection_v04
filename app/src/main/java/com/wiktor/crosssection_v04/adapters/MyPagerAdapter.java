package com.wiktor.crosssection_v04.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wiktor.crosssection_v04.Constants;
import com.wiktor.crosssection_v04.fragments.Fragment1;
import com.wiktor.crosssection_v04.fragments.Fragment2;
import com.wiktor.crosssection_v04.fragments.Fragment3;

public class MyPagerAdapter extends FragmentPagerAdapter {


    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return Fragment1.newInstance();
            case 1:
                return Fragment2.newInstance();
            case 2:
                return Fragment3.newInstance();
        }
        return null;
    }

    
    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }

    @Override
    public int getCount() {
        return Constants.NUM_ITEMS;
    }
}
