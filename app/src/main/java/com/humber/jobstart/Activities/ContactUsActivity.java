package com.humber.jobstart.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.humber.jobstart.R;

import es.dmoral.toasty.Toasty;

public class ContactUsActivity extends AppCompatActivity {

    private CardView mLake, mDuff, mChaun, mLakeHide, mDuffHide, mChauHide;
    private Button mLakeCall, mDuffCall, mChaunCall;
    private AlertDialog.Builder builder;
    private LinearLayout.LayoutParams lakeLayoutParams, duffLayoutParams, chaunLayoutParams;
    private float major = 5, minor = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        mLake = findViewById(R.id.xLakeShoreView);
        mDuff = findViewById(R.id.xDufferinView);
        mChaun = findViewById(R.id.xChaunceyView);

        mLakeHide = findViewById(R.id.xLakeHide);
        mDuffHide = findViewById(R.id.xDufferinHide);
        mChauHide = findViewById(R.id.xChaunceyHide);

        mLakeCall = findViewById(R.id.xLakeCall);
        mDuffCall = findViewById(R.id.xDuffCall);
        mChaunCall = findViewById(R.id.xChaunCall);

        builder = new AlertDialog.Builder(this);

        mLakeCall.setOnClickListener(v -> {
            builder.setMessage("Do you want to call Lakeshore number of JobStart?").setTitle("Calling?").setCancelable(true)
                    .setPositiveButton("Yes", (dialog, which) -> {
                        Intent i = new Intent(Intent.ACTION_CALL);
                        i.setData(Uri.parse("tel:4162312295"));
                        startActivity(i);
                    }).setNegativeButton("No", (dialog, which) -> dialog.cancel());
            AlertDialog alert = builder.create();
            alert.show();
        });

        mDuffCall.setOnClickListener(v -> {
            builder.setMessage("Do you want to call Dufferin number of JobStart?").setTitle("Calling?").setCancelable(true)
                    .setPositiveButton("Yes", (dialog, which) -> {
                        Intent i = new Intent(Intent.ACTION_CALL);
                        i.setData(Uri.parse("tel:4162312295"));
                        startActivity(i);
                        Toasty.info(getApplicationContext(), "The extension is 5721", Toasty.LENGTH_LONG).show();
                    }).setNegativeButton("No", (dialog, which) -> dialog.cancel());
            AlertDialog alert = builder.create();
            alert.show();
        });

        mChaunCall.setOnClickListener(v -> {
            builder.setMessage("Do you want to call Chauncey number of JobStart?").setTitle("Calling?").setCancelable(true)
                    .setPositiveButton("Yes", (dialog, which) -> {
                        Intent i = new Intent(Intent.ACTION_CALL);
                        i.setData(Uri.parse("tel:4162312295"));
                        startActivity(i);
                    }).setNegativeButton("No", (dialog, which) -> dialog.cancel());
            AlertDialog alert = builder.create();
            alert.show();
        });


        lakeLayoutParams = (LinearLayout.LayoutParams) mLake.getLayoutParams();
        duffLayoutParams = (LinearLayout.LayoutParams) mDuff.getLayoutParams();
        chaunLayoutParams = (LinearLayout.LayoutParams) mChaun.getLayoutParams();

        {
            mLake.setVisibility(View.VISIBLE);
            setWeights(major, minor, minor);
            mDuff.setVisibility(View.GONE);
            mChaun.setVisibility(View.GONE);
            mDuffHide.setVisibility(View.VISIBLE);
            mChauHide.setVisibility(View.VISIBLE);
        }

        mLakeHide.setOnClickListener(v -> {
            setWeights(major, minor, minor);
            mLakeHide.setVisibility(View.GONE);
            mLake.setVisibility(View.VISIBLE);
            mDuff.setVisibility(View.GONE);
            mChaun.setVisibility(View.GONE);
            mDuffHide.setVisibility(View.VISIBLE);
            mChauHide.setVisibility(View.VISIBLE);
        });

        mDuffHide.setOnClickListener(v -> {
            setWeights(minor, major, minor);
            mDuff.setVisibility(View.VISIBLE);
            mLakeHide.setVisibility(View.VISIBLE);
            mDuffHide.setVisibility(View.GONE);
            mLake.setVisibility(View.GONE);
            mChaun.setVisibility(View.GONE);
            mChauHide.setVisibility(View.VISIBLE);
        });

        mChauHide.setOnClickListener(v -> {
            setWeights(minor, minor, major);
            mChaun.setVisibility(View.VISIBLE);
            mLakeHide.setVisibility(View.VISIBLE);
            mDuffHide.setVisibility(View.VISIBLE);
            mChauHide.setVisibility(View.GONE);
            mLake.setVisibility(View.GONE);
            mDuff.setVisibility(View.GONE);
        });
    }

    private void setWeights(float lake, float duff, float chaun) {
        lakeLayoutParams.weight = lake;
        duffLayoutParams.weight = duff;
        chaunLayoutParams.weight = chaun;
        mLake.setLayoutParams(lakeLayoutParams);
        mDuff.setLayoutParams(duffLayoutParams);
        mChaun.setLayoutParams(chaunLayoutParams);
    }

}
