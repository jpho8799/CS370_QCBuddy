package com.example.cs370_qcbuddy.util;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class SectionStatePagerAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final HashMap<Fragment, Integer> mFragment = new HashMap<>();
    private final HashMap<String, Integer> mFragmentNumbers = new HashMap<>();
    private final HashMap<Integer, String> mFragmentNames = new HashMap<>();


    public SectionStatePagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();

    }


    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    public void addFragment(Fragment fragment, String fragmentName){
        mFragmentList.add(fragment);
        mFragment.put(fragment, mFragmentList.size()-1);
        mFragmentNumbers.put(fragmentName, mFragmentList.size()-1);
        mFragmentNames.put(mFragment.size()-1, fragmentName);
    }

    /*
    Overloaded Method: returns the fragment with the name @param
     */
    public Integer getFragmentNumber(String fragmentName){
        if(mFragmentNumbers.containsKey(fragmentName)){
            return mFragmentNumbers.get(fragmentName);
        }else{
            return null;
        }
    }

     /*
    Overloaded Method: returns the fragment with the fragment @param
     */

    public Integer getFragmentNumber(Fragment fragment){
        if(mFragmentNumbers.containsKey(fragment)){
            return mFragmentNumbers.get(fragment);
        }else{
            return null;
        }
    }

      /*
    returns the fragment with the Integer @param
     */

    public String getFragmentName(Integer fragmentNumber){
        if(mFragmentNames.containsKey(fragmentNumber)){
            return mFragmentNames.get(fragmentNumber);
        }else{
            return null;
        }
    }


}
