package com.example.shootime700.webviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        webView = (WebView) findViewById(R.id.web_view);
        //设置支持Javascript
        WebSettings setting = webView.getSettings();
        setting.setJavaScriptEnabled(true);
        setting.setJavaScriptCanOpenWindowsAutomatically(true);//js和android交互
        //设置页面自适应化
        setting.setUseWideViewPort(true);
        setting.setLoadWithOverviewMode(true);
        setting.setAllowFileAccess(true); // 允许访问文件
        setting.setAppCacheEnabled(true); //设置H5的缓存打开,默认关闭
        setting.setDomStorageEnabled(true);//设置可以使用localStorage
        setting.setDefaultFontSize(20);



        webView.loadUrl("http://order.wiicat.com");

        webView.setWebViewClient(new WebViewClient() {
            //程序内打开页面
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            //取得当前页面标题
            @Override
            public void onPageFinished(WebView view, String url) {
                setTitle(view.getTitle());
            }
        });
    }

    public boolean onKeyDown(int keyCode, KeyEvent envent) {
        if((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }else {
            return false;
        }
    }


}
