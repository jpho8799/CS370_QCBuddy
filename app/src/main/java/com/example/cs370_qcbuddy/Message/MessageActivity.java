package com.example.cs370_qcbuddy.Message;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cs370_qcbuddy.Appointment.AppointmentActivity;
import com.example.cs370_qcbuddy.R;
import com.example.cs370_qcbuddy.util.BottomNavigationViewHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MessageActivity extends AppCompatActivity {
    private static final String TAG = "MessageActivity";
    private static final int ACTIVITY_NUM =2;
    Context mContext = MessageActivity.this;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: start");
        setupBottomNavigationView();
    }
    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}
