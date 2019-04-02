package com.humber.jobstart.Activities;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.card.MaterialCardView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.humber.jobstart.R;

import java.util.List;

public class UpdatesActivity extends AppCompatActivity {

    MaterialCardView mTwitter, mLinkedIn, mFacebook, mYoutube;
    private String TAG = "UPDATES_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updates);

        mTwitter = findViewById(R.id.xTwitterFeed);
        mLinkedIn = findViewById(R.id.xLinkedinFeed);
        mFacebook = findViewById(R.id.xFacebookFeed);
        mYoutube = findViewById(R.id.xYoutube_feed);

        mTwitter.setOnClickListener(v -> {
            Intent intent;
            try {
                // get the Twitter app if possible
                this.getPackageManager().getPackageInfo("com.twitter.android", 0);
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id=768850872436678656"));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            } catch (Exception e) {
                // no Twitter app, revert to browser
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/JobStartTO"));
                Log.d(TAG, "Error opening Twitter App");
            }
            this.startActivity(intent);
        });

        mLinkedIn.setOnClickListener(v -> {
            String pageId = "job-start";
            final String urlFb = "linkedin://" + pageId;
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(urlFb));

            final PackageManager packageManager = getPackageManager();
            List<ResolveInfo> list = packageManager.queryIntentActivities(intent,
                    PackageManager.MATCH_DEFAULT_ONLY);

            if (list.size() == 0) {
                final String urlBrowser = "http://www.linkedin.com/company/" + pageId;
                intent.setData(Uri.parse(urlBrowser));
            }
            startActivity(intent);
        });

        mFacebook.setOnClickListener(v -> {
            Intent intent;
            try {
                // get the Facebook app if possible
                this.getPackageManager().getPackageInfo("com.facebook.katana", 0);
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://facewebmodal/f?href=https://www.facebook.com/JobStartTO/"));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            } catch (Exception e) {
                // no Facebook app, revert to browser
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/JobStartTO/"));
                Log.e(TAG, "Error opening facebook app");
            }
            this.startActivity(intent);
        });

        mYoutube.setOnClickListener(v -> {
            Intent intent;
            try {
                // get the Youtube app if possible
                this.getPackageManager().getPackageInfo("com.google.android.youtube", 0);
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://www.youtube.com/channel/UCcz4CSrzwM6ssUKQdmJ2c6g/featured?"));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            } catch (Exception e) {
                // no Facebook app, revert to browser
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCcz4CSrzwM6ssUKQdmJ2c6g/featured?"));
                Log.e(TAG, "Error opening YouTube app");
            }
            this.startActivity(intent);
        });
    }


}
