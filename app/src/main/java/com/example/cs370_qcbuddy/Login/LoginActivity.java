package com.example.cs370_qcbuddy.Login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cs370_qcbuddy.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";

    //firebase
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private Context mContext = LoginActivity.this;
    private ProgressBar mProgressBar;
    private EditText mPhone;
    private TextView mPleaseWait;
    private TextView mLinkSignUp;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d(TAG, "onCreate: started");
        mProgressBar =  findViewById(R.id.progressbar1);
        mPleaseWait =  findViewById(R.id.pleaseWait1);
        mPhone = findViewById(R.id.input_phone1);
        mLinkSignUp = findViewById(R.id.linksignup);
        mProgressBar.setVisibility(View.GONE);
        mPleaseWait.setVisibility(View.GONE);
        setupFirebaseAuth();
        init();
        goToSignUp();
    }

    //go to Sign up page
    public void goToSignUp(){
        mLinkSignUp.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               Intent intent = new Intent(mContext,RegisterActivity.class);
                                               startActivity(intent);
                                           }
                                       }
        );

    }

    /*----------------------firebase--------------------------------------------------------

     */

    /*------------------------handles login--------------------------------------

     */

    //helper method check if email/password field is null
    private boolean isStringNull(String string){
        Log.d(TAG, "Checking if String is null");
        if(string.equals("")){
            return true;
        }else{
            return false;
        }
    }
    private void init(){
        //iniitialize the button for login
        Button btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(v -> {
            Log.d(TAG, "onClick: attempting to log in");
            String phone = mPhone.getText().toString();

            if(isStringNull(phone)){
                Toast.makeText(mContext, "You must fill out all the fields", Toast.LENGTH_SHORT).show();
            }else{
                //All the fields are filled out, attempt to login
                mProgressBar.setVisibility(View.VISIBLE);
                mPleaseWait.setVisibility(View.VISIBLE);

                /*-----------------from firebase sign in existing users-------------------------------

                 */




                /*----------------end-------------------------------------------------------------------

                 */
            }
        });
    }

    public void updateUI(FirebaseUser user){

    }







    /*----------------------------------handles login-----------------------------------

     */
    private void setupFirebaseAuth(){
        Log.d(TAG, "setupFirebaseAuth: setting up firebase auth");
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = firebaseAuth -> {
            FirebaseUser user = firebaseAuth.getCurrentUser();
            //check if user is logged in

            if(user != null){
                //User is signed in
                Log.d(TAG, "onAuthStateChanged:signed in:" + user.getUid());

            } else {
                //User is signed out
                Log.d(TAG, "onAuthStateChanged:signed out");
            }
        };
    }

    @Override
    public void onStart(){
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);


    }

    @Override
    public void onStop(){
        super.onStop();
        if(mAuthListener !=null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    /*-------------------------------------------Firebase -----------------------------------------

     */
}

