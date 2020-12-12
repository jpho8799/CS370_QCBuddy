package com.example.cs370_qcbuddy.Login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cs370_qcbuddy.Home.MainActivity;
import com.example.cs370_qcbuddy.R;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private FirebaseAuth mAuth;
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
        mProgressBar =  findViewById(R.id.progressbar2);
        mPleaseWait =  findViewById(R.id.pleaseWait2);
        mPhone = findViewById(R.id.input_phone2);
        mProgressBar.setVisibility(View.GONE);
        mPleaseWait.setVisibility(View.GONE);

        init();

    }

    public void init(){
        mPhone= findViewById(R.id.input_phone2);
        Button btn_signUp = findViewById(R.id.btn_register);
        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.getInstance().getFirebaseAuthSettings().forceRecaptchaFlowForTesting(true);
                String code = "1";
                String number = mPhone.getText().toString();
                if(number.isEmpty() || number.length() <10){
                    mPhone.setText("");
                    mPhone.setError("Valid Number is Required");
                    mPleaseWait.setVisibility(View.GONE);
                    mProgressBar.setVisibility(View.GONE);
                    Toast.makeText(mContext, "Please enter a valid phone number", Toast.LENGTH_SHORT).show();
                    mPhone.requestFocus();
                    return;
                }
                String phoneNumber = "+" + code + number;

                Intent intent = new Intent(mContext, VerificationActivity.class);
                intent.putExtra("phonenumber", phoneNumber);
                startActivity(intent);
            }
        });
       
    }




}
