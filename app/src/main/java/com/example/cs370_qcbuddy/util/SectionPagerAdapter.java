package com.example.cs370_qcbuddy.util;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/*Class that stores fragment for top? tab
there is a high chance that I might not need this
Need to decide what I want on my top tab first or if I even need it
This class is deprecated, might not even need this
Decide if you want to delete it later

 */

public class SectionPagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = "SectionPagerAdapter";

    private final List<Fragment> mFragmentList = new ArrayList<>();

    public SectionPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment){
        mFragmentList.add(fragment);
    }
}
