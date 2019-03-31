package com.humber.jobstart.Activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.humber.jobstart.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int all_permissions = 1;
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.CALL_PHONE,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.WRITE_CALENDAR,
                Manifest.permission.INTERNET,
                Manifest.permission.WRITE_EXTERNAL_STORAGE};

        if (!hasPermissions(this, permissions)) {
            ActivityCompat.requestPermissions(this, permissions, all_permissions);
        }

        ImageView mHomeImage = findViewById(R.id.xHomeScreen);
        mHomeImage.setScaleType(ImageView.ScaleType.FIT_XY);

        Button calendars = findViewById(R.id.xCalendars);
        calendars.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, CalendarsHome.class));
            //calendars.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        });


        Button jobPostings = findViewById(R.id.xJobPostings);
        jobPostings.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, JobsActivity.class)));

        Button findUs = findViewById(R.id.xFindUs);
        findUs.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, FindUsActivity.class)));

        Button donateUs = findViewById(R.id.xDonate);
        donateUs.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, DonateUs.class)));

        Button updates = findViewById(R.id.xUpdates);
        updates.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, UpdatesActivity.class)));

        Button contactUs = findViewById(R.id.xContactUs);
        contactUs.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ContactUsActivity.class)));
    }

    public static boolean hasPermissions(Context context, String... permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }
}
