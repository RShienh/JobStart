package com.humber.jobstart.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.widget.Button;

import com.humber.jobstart.Activities.Calendars.ChaunceyCalendarActivity;
import com.humber.jobstart.Activities.Calendars.DufferinCalendarActivity;
import com.humber.jobstart.Activities.Calendars.LakeCalendarActivity;
import com.humber.jobstart.R;

/**
 * The type Calendars home.
 * This is just an activity which points to Calendars in three locations of JobStart
 */
public class CalendarsHome extends AppCompatActivity {

    /**
     * The L title.
     */
    String lTitle = "JobStart at Lakeshore\n";
    /**
     * The L addr.
     */
    String lAddr = "2930 Lake Shore Blvd. West\n" +
            "(Islington Avenue & Lake Shore Blvd. West)";
    /**
     * The D title.
     */
    String dTitle = "JobStart at Dufferin\n";
    /**
     * The D addr.
     */
    String dAddr = "219 Dufferin Street, Suite #1C\n" +
            "(King Street West & Dufferin Street)";
    /**
     * The C title.
     */
    String cTitle = "JobStart at Chauncey\n";
    /**
     * The C addr.
     */
    String cAddr = "41 Chauncey Avenue\n " +
            "(Islington Avenue & South of Bloor Street West)";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendars_home);

        Button mLakeShore = findViewById(R.id.xLakeShoreCalendar);
        Button mDufferin = findViewById(R.id.xDufferinCalendar);
        Button mChauncey = findViewById(R.id.xChaunceyCalendar);

        mLakeShore.setText(setSpannableString(lTitle));
        mLakeShore.append(lAddr);

        mDufferin.setText(setSpannableString(dTitle));
        mDufferin.append(dAddr);

        mChauncey.setText(setSpannableString(cTitle));
        mChauncey.append(cAddr);

        mLakeShore.setOnClickListener(v -> {
            startActivity(new Intent(CalendarsHome.this, LakeCalendarActivity.class));
        });

        mDufferin.setOnClickListener(v -> {
            startActivity(new Intent(CalendarsHome.this, DufferinCalendarActivity.class));
        });

        mChauncey.setOnClickListener(v -> {
            startActivity(new Intent(CalendarsHome.this, ChaunceyCalendarActivity.class));
        });
    }

    /**
     * Sets spannable string.
     * Used to stylize the appearance of text on the activity, done dynamically since it takes less resources
     * @param textString the text string
     * @return the spannable string
     */
    public SpannableString setSpannableString(String textString) {

        SpannableString spanString = new SpannableString(textString);
        spanString.setSpan(new StyleSpan(Typeface.BOLD), 0, textString.length(), 0);
        spanString.setSpan(new RelativeSizeSpan(2f), 0, textString.length(), 0);

        return spanString;
    }
}
