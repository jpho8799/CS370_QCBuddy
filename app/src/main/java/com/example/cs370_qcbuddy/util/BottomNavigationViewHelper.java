package com.example.cs370_qcbuddy.util;

import android.content.Intent;
import android.util.Log;
import android.content.Context;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.example.cs370_qcbuddy.Appointment.AppointmentActivity;
import com.example.cs370_qcbuddy.Home.MainActivity;
import com.example.cs370_qcbuddy.Message.MessageActivity;
import com.example.cs370_qcbuddy.Profile.ProfileActivity;
import com.example.cs370_qcbuddy.R;
import com.example.cs370_qcbuddy.Search.SearchActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigationViewHelper {
    private static final String TAG = "BottomNavigationViewHel";

    public static void setupBottomNavigationView(BottomNavigationView bottomNavigationView){
        Log.d(TAG, "setupBottomNavigationView: Setting up BottomNavigationView");
    }

    public static void enableNavigation(final Context context, BottomNavigationView view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.ic_house:
                        Intent intent1 = new Intent(context, MainActivity.class);
                        context.startActivity(intent1);
                        break;

                    case R.id.ic_search:
                        Intent intent2 = new Intent(context, SearchActivity.class);
                        context.startActivity(intent2);
                        break;
                    case R.id.ic_appointment:
                        Intent intent3 = new Intent(context, MessageActivity.class);
                        context.startActivity(intent3);
                        break;
                    case R.id.ic_message:
                        Intent intent4 = new Intent(context, AppointmentActivity.class);
                        context.startActivity(intent4);
                        break;
                    case R.id.ic_profile:
                        Intent intent5 = new Intent(context, ProfileActivity.class);
                        context.startActivity(intent5);
                        break;
                }
                return false;
            }
        });

    }


}
