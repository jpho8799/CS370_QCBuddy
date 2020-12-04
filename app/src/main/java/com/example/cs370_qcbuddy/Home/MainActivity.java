package com.example.cs370_qcbuddy.Home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.cs370_qcbuddy.Appointment.AppointmentActivity;
import com.example.cs370_qcbuddy.Login.LoginActivity;
import com.example.cs370_qcbuddy.R;
import com.example.cs370_qcbuddy.util.BottomNavigationViewHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
/*
Watch part 6 of the video on how to implement top tab if I still want to do it. Debating if it is
worth it right now
 */
public class MainActivity extends AppCompatActivity {

    private WebView webview;
    private static final String TAG = "HomeActivity";
    private static final int ACTIVITY_NUM =0;
    Context mContext = MainActivity.this;


    //firebase
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: starting");
        webview =(WebView)findViewById(R.id.webView);

        webview.setWebViewClient(new WebViewClient());
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setDomStorageEnabled(true);
        webview.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        webview.loadUrl("https://www.cs.qc.cuny.edu/");


        //setupFirebaseAuth();

        setupBottomNavigationView();
    }
    //Setting Up firebase login
    /*-------------------------------Firebase ------------------------------------------------------

     */

    //check to see if @param 'user' is logged in
//    private void checkCurrentUser(FirebaseUser user){
//        Log.d(TAG, "checkCurrentUser: checking if user is logged in");
//
//        if(user == null){
//            Intent intent = new Intent(mContext, LoginActivity.class);
//            startActivity(intent);
//        }
//    }
//    private void setupFirebaseAuth(){
//        Log.d(TAG, "setupFirebaseAuth: setting up firebase auth");
//        mAuth = FirebaseAuth.getInstance();
//        mAuthListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser user = firebaseAuth.getCurrentUser();
//                //check if user is logged in
//                checkCurrentUser(user);
//                if(user != null){
//                    //User is signed in
//                    Log.d(TAG, "onAuthStateChanged:signed in:" + user.getUid());
//
//                } else {
//                    //User is signed out
//                    Log.d(TAG, "onAuthStateChanged:signed out");
//                }
//            }
//        };
//    }
//
//    @Override
//    public void onStart(){
//        super.onStart();
//        mAuth.addAuthStateListener(mAuthListener);
//        checkCurrentUser(mAuth.getCurrentUser());
//    }
//
//    @Override
//    public void onStop(){
//        super.onStop();
//        if(mAuthListener !=null) {
//            mAuth.removeAuthStateListener(mAuthListener);
//        }
//    }

    /*-------------------------------------------Firebase -----------------------------------------

     */
    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.enableNavigation(MainActivity.this, bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}