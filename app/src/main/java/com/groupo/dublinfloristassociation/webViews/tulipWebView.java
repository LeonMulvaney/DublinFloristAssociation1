package com.groupo.dublinfloristassociation.webViews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.groupo.dublinfloristassociation.R;

public class tulipWebView extends AppCompatActivity {

    private WebView webView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluebell_web_view);


        webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://en.wikipedia.org/wiki/Tulip");
        webView.setWebViewClient(new WebViewClient());

    }
}
