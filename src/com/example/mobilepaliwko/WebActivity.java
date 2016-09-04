package com.example.mobilepaliwko;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class WebActivity extends Activity {

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web);
		
		WebView webView = new WebView(this);
		
		
		WebSettings webSettings = webView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webSettings.setGeolocationEnabled(true);
		webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
	    webSettings.setAppCacheEnabled(true);
	    webSettings.setDatabaseEnabled(true);
	    webSettings.setDomStorageEnabled(true);
	    webView.setWebChromeClient(new WebChromeClient());

		
		webView.loadUrl("http://10.0.2.2:8000/map");
		
		setContentView(webView);
	}
}
