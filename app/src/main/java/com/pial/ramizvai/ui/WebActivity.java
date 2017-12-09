package com.pial.ramizvai.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.pial.ramizvai.R;

public class WebActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webView = findViewById(R.id.webView);
        String url = getIntent().getExtras().getString("url");
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://"+url);
    }
}
