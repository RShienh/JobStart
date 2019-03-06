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
        mLakeShore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  startActivity(new Intent(CalendarsHome.this, CalendarLakeShore.class));
            }
        });

        CardView mDufferin = findViewById(R.id.xDufferinCalendar);
        mDufferin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(CalendarsHome.this, CalendarLakeShore.class));
            }
        });

        CardView mChauncey = findViewById(R.id.xChaunceyCalendar);
        mLakeShore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  startActivity(new Intent(CalendarsHome.this, CalendarLakeShore.class));
            }
        });
    }
}
