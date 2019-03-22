package com.humber.jobstart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.airbnb.lottie.LottieAnimationView;

public class DonateUs extends AppCompatActivity {

    private WebView donate;
    private LottieAnimationView loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_us);

        loading = findViewById(R.id.xLoading);

        donate = findViewById(R.id.xWebView);
        donate.setWebViewClient(new WebViewClient());
        donate.loadUrl("https://www.canadahelps.org/en/charities/jobstart/");
        WebSettings webSettings = donate.getSettings();
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setJavaScriptEnabled(true);

        donate.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress < 100 && loading.getVisibility() == ProgressBar.GONE) {
                    loading.setVisibility(ProgressBar.VISIBLE);
                    // donate.setVisibility(View.VISIBLE);
                }
                if (progress == 100) {
                    loading.setVisibility(ProgressBar.GONE);
                    // txtview.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (donate.canGoBack()) {
            donate.goBack();
        } else {
            super.onBackPressed();
        }
    }
}