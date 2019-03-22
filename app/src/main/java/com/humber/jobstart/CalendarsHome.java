package com.humber.jobstart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class CalendarsHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendars_home);

        CardView mLakeShore = findViewById(R.id.xLakeShoreCalendar);
        mLakeShore.setOnClickListener(v -> {
            startActivity(new Intent(CalendarsHome.this, LakeCalendarActivity.class));
        });

        CardView mDufferin = findViewById(R.id.xDufferinCalendar);
        mDufferin.setOnClickListener(v -> {
           startActivity(new Intent(CalendarsHome.this, DufferinCalendarActivity.class));
        });

        CardView mChauncey = findViewById(R.id.xChaunceyCalendar);
        mChauncey.setOnClickListener(v -> {
            startActivity(new Intent(CalendarsHome.this, ChaunceyCalendarActivity.class));
        });
    }
}
