package com.example.cs370_qcbuddy.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.cs370_qcbuddy.R;
import com.example.cs370_qcbuddy.util.BottomNavigationViewHelper;
import com.example.cs370_qcbuddy.util.SectionPagerAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "ProfileActivity";
    private static final int ACTIVITY_NUM =4;


    //testing delete later
    EditText mUserID;
    EditText mName;
    EditText mEmail;
    EditText mStanding;
    String URL = "http://localhost:8080/CS370_QCBuddy/EditProfileServlet";

    private ProgressBar mProgressBar;

    Context mContext = ProfileActivity.this;


    //tab layout portion
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private AppBarLayout mAppBarLayout;
    private SectionPagerAdapter pagerAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: start");
        mProgressBar = findViewById(R.id.profileProgressBar);
        mProgressBar.setVisibility(View.GONE);
        setupToolbar();
        //tablayout section
        mViewPager = findViewById(R.id.profile_viewpager);
        mTabLayout = findViewById(R.id.profile_tablayout);
        setupFragment();
        //adapter setup
        mViewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);



        setupBottomNavigationView();

    }


    //set up top tool bar
    private void setupToolbar(){
        Toolbar toolbar =  findViewById(R.id.profileToolbar);
        setSupportActionBar(toolbar);

        ImageView profileMenu = findViewById(R.id.profile_menu);
        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: navigating to account settings.");
                Intent intent = new Intent(mContext, AccountSettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    //set up tablayout fragments
    private void setupFragment(){
        pagerAdapter = new SectionPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        pagerAdapter.addFragment(new ProfileInfoFragment(), getString(R.string.basic_info_fragment)); //fragment 0
        pagerAdapter.addFragment(new ReviewFragment(), getString(R.string.reviews_fragment)); //fragment 1

    }

    //helps navigate to fragment
    private void setViewPager(int fragmentNumber){
        Log.d(TAG, "setViewPager: navigating to fragment#" + fragmentNumber);
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.setCurrentItem(fragmentNumber);
    }

    //bottom navigation
    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }


}
