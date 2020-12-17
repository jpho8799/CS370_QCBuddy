package com.example.cs370_qcbuddy.Profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.cs370_qcbuddy.R;
import com.google.firebase.auth.FirebaseAuth;

public class SignOutFragment extends Fragment {
    private static final String TAG = "SignOutFragment";
    //firebase
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private ProgressBar mProgressBar;
    private TextView tvSignout, tvSigningOut;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signout, container, false);
        mProgressBar = view.findViewById(R.id.progressbarSignout);
        tvSignout = view.findViewById(R.id.tvConfirmSignout);
        tvSigningOut = view.findViewById(R.id.tvSigningOut);

        mProgressBar.setVisibility(View.GONE);
        tvSigningOut.setVisibility(View.GONE);
        Button btnConfirmSignout = view.findViewById(R.id.btnConfirmSignout);
        //setupFirebaseAuth();

        btnConfirmSignout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: attempting to sign out");
                mAuth.getInstance().signOut();
                getActivity().finish();
            }
        });

        return view;
    }

    //-------------------------------Firebase ------------------------------------------------------

//    private void setupFirebaseAuth() {
//        Log.d(TAG, "setupFirebaseAuth: setting up firebase auth");
//        mAuth = FirebaseAuth.getInstance();
//        mAuthListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser user = firebaseAuth.getCurrentUser();
//                //check if user is logged in
//                if (user != null) {
//                    //User is signed in
//                    Log.d(TAG, "onAuthStateChanged:signed in:" + user.getUid());
//
//                } else {
//                    //User is signed out
//                    Log.d(TAG, "onAuthStateChanged:signed out");
//                    Log.d(TAG, "navigating back to login screen");
//                    Intent intent = new Intent(getActivity(), LoginActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                    startActivity(intent);
//                }
//            }
//        };
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        mAuth.addAuthStateListener(mAuthListener);
//
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        if (mAuthListener != null) {
//            mAuth.removeAuthStateListener(mAuthListener);
//        }
//    }
    /*-------------------------------------------Firebase -----------------------------------------
     */
}

