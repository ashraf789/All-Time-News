package com.example.syed.alltimenews;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

public class NewsViewer extends AppCompatActivity {

    WebView myWebView;
    ProgressBar progressBar;
    TextView waitingText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_viewer);
        myWebView = (WebView) findViewById(R.id.web_viewer);
        progressBar = (ProgressBar) findViewById(R.id.progress_show);
        waitingText = (TextView) findViewById(R.id.waiting_view);

        myWebView.loadUrl(getIntent().getStringExtra("siteName"));
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new setWebviewClient());
    }

    class setWebviewClient extends WebViewClient {

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            progressBar.setVisibility(View.GONE);
            waitingText.setVisibility(View.GONE);
            super.onPageFinished(view, url);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    { //if back key is pressed
        if((keyCode == KeyEvent.KEYCODE_BACK)&& myWebView.canGoBack())
        {
            myWebView.goBack();
            return true;

        }

        return super.onKeyDown(keyCode, event);

    }

}
