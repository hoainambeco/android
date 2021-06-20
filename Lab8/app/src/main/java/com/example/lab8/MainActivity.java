package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtURL;
    Button btnDuyet;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.webview);
        btnDuyet = findViewById(R.id.btnDuyet);
        txtURL = findViewById(R.id.txtURL);
        webView.setWebViewClient(new WebViewClient());
    }
    public void load(View view){
        if (Ex2.checkInternet(MainActivity.this)){
            String url = txtURL.getText().toString();
            webView.loadUrl(url);
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient(){});
        }
        else {
            Toast.makeText(getApplicationContext(),"Không có kết nối interner",Toast.LENGTH_SHORT).show();
        }
    }
}
class MyWebView extends WebViewClient{
    @Override
    public boolean shouldOverrideUrlLoading(WebView view,String url){
        return false;
    }
}