package com.humber.jobstart.Activities.Jobs;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.method.ScrollingMovementMethod;
import android.text.style.StyleSpan;
import android.widget.TextView;

import com.google.gson.Gson;
import com.humber.jobstart.R;
import com.humber.jobstart.ViewHandlers.PerfectScrollableTextView;
import com.humber.jobstart.Models.Jobs;

/**
 * The type View job activity.
 */
public class ViewJobActivity extends AppCompatActivity {

    private TextView mGetJobTitle,
            mGetPostedDate, mGetApplyDate, mGetStatus, mGetType,
            mGetLocation, mGetSalary, mGetContact, mGetJobID;
    private PerfectScrollableTextView mGetDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_job);

        Gson gson = new Gson();
        Jobs j = gson.fromJson(getIntent().getStringExtra("job"), Jobs.class);

        mGetJobID = findViewById(R.id.xGetJobID);
        mGetJobTitle = findViewById(R.id.xGetJobTitle);
        mGetPostedDate = findViewById(R.id.xGetJobPost);
        mGetApplyDate = findViewById(R.id.xGetJobEnd);
        mGetStatus = findViewById(R.id.xGetJobStatus);
        mGetType = findViewById(R.id.xGetJobType);
        mGetDescription = findViewById(R.id.xGetJobDesc);
        mGetLocation = findViewById(R.id.xGetJobLocation);
        mGetSalary = findViewById(R.id.xGetJobSalary);
        mGetContact = findViewById(R.id.xGetJobApplyContact);

        mGetJobID.setText(setSpannableString("Job ID: "));
        mGetJobID.append(j.getId());

        mGetJobTitle.setText(setSpannableString("Job Title: "));
        mGetJobTitle.append(j.getTitle());

        mGetPostedDate.setText(setSpannableString("Posted Date: "));
        mGetPostedDate.append(j.getPostDate());

        mGetApplyDate.setText(setSpannableString("Apply By: "));
        mGetApplyDate.append(j.getApplyDate());

        mGetStatus.setText(setSpannableString("Employment Status: "));
        mGetStatus.append(j.getStatus());

        mGetType.setText(setSpannableString("Employment Type: "));
        mGetType.append(j.getType());

        mGetDescription.setMovementMethod(new ScrollingMovementMethod());
        mGetDescription.setText(setSpannableString("Description: "));
        mGetDescription.append(j.getDescription());

        mGetLocation.setText(setSpannableString("City/Location: "));
        mGetLocation.append(j.getLocation());

        mGetSalary.setText(setSpannableString("Salary/Wages: "));
        mGetSalary.append(j.getSalary());

        mGetContact.setText(setSpannableString("To Apply: "));
        mGetContact.append(j.getContact());

    }

    /**
     * Sets spannable string.
     *
     * @param textString the text string
     * @return the spannable string
     */
    public SpannableString setSpannableString(String textString) {

        SpannableString spanString = new SpannableString(textString);
        spanString.setSpan(new StyleSpan(Typeface.BOLD), 0, textString.length(), 0);
        return spanString;
    }
}

