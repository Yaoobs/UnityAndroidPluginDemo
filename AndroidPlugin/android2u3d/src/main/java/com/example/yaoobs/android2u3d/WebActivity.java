package com.example.yaoobs.android2u3d;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebActivity extends Activity
{
    //网页组组件
    private WebView mWebView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置当前布局
        setContentView(R.layout.activity_web);
        //获取WebView
        mWebView=(WebView)findViewById(R.id.webView);
        //获取URL
        String mUrl=this.getIntent().getStringExtra("URL");
        //加载网页
        mWebView.loadUrl(mUrl);
    }
}
