package com.sadek.pseedcowebview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity
{
    private WebView webViewMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewByIdes();

        WebSettings webSettings = webViewMainActivity.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webViewMainActivity.setWebViewClient(new CallBack());
//        webViewMainActivity.loadUrl("https://kholodalshahba.com");
        webViewMainActivity.loadUrl("http://pseedco.com");
    }

    private void findViewByIdes()
    {
        webViewMainActivity = (WebView) findViewById(R.id.webViewMainActivity);
    }

    private class CallBack extends WebViewClient
    {
        @Override
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event)
        {
            return false;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (event.getAction() == KeyEvent.ACTION_DOWN)
        {
            switch (keyCode)
            {
                case KeyEvent.KEYCODE_BACK:
                {
                    if (webViewMainActivity.canGoBack())
                    {
                        webViewMainActivity.goBack();
                    }
                    else
                    {
                        finish();
                    }
                    return true;
                }
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}