package com.katrenich.alex.androidapprozetka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = findViewById(R.id.webview);
        // вмикаємо підтримку JavaScript
        mWebView.getSettings().setJavaScriptEnabled(true);
        // задаємо клієнт для обробки всіх посилань нашим додатком
        mWebView.setWebViewClient(new MyWebViewClient());
        // вказуємо інтернет-сторінку для завантаження
        mWebView.loadUrl("https://m.rozetka.com.ua");

    }

    // Повернення в стеку до попереднього стану екрану
    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    // внутрішній клас, що для переходу по посиланням всередині додатку
    private class MyWebViewClient extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            view.loadUrl(url);
            return true;
        }
    }

}
