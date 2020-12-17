package com.example.cs370_qcbuddy.Profile;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.cs370_qcbuddy.R;

public class EditProfileFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "EditProfileFragment";

    //testing delete later
    Context mContext;
    String userID = "dummyvalue";
    EditText mName, mEmail, mStanding, mPrice;
    TextView mSaveChanges1, mSaveChanges2;
    ImageView mBackArrow, mTutorArrow, mClassArrow;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editprofile, container, false);

        mSaveChanges1 = view.findViewById(R.id.save_changes1);
        mSaveChanges2 = view.findViewById(R.id.save_changes2);
        mBackArrow = view.findViewById(R.id.editprofile_backArrow);

        mContext = container.getContext();
        mName = view.findViewById(R.id.username);
        mEmail = view.findViewById(R.id.email);
        mStanding = view.findViewById(R.id.standing);
        mTutorArrow = view.findViewById(R.id.edittutoring_arrow);
        mClassArrow = view.findViewById(R.id.editcurrentclass_arrow);

        //Set up onClickListener
        mSaveChanges1.setOnClickListener(this);
        mSaveChanges2.setOnClickListener(this);
        mBackArrow.setOnClickListener(this);
        mTutorArrow.setOnClickListener(this);
        mClassArrow.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.editprofile_backArrow:
                Log.d(TAG, "onClick: navigating back to AccountSettingsActivity");
                getActivity().finish();
                break;


            case R.id.save_changes1:
                boolean servletConnection;
                Log.d(TAG, "Reached on click");
                String name, email, standing;
                name = mName.getText().toString();
                email = mEmail.getText().toString();
                standing = mStanding.getText().toString();
                servletConnection = ServletConnection.editBasicProfile(mContext, userID, name, email, standing);
                if(servletConnection == true){
                    Toast.makeText(mContext, "Your information has been saved", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(mContext, "Error", Toast.LENGTH_LONG).show();
                }


                break;




        }
    }
}



