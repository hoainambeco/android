package com.example.slide8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    String link="https://raw.githubusercontent.com/huuhuybn/BrightLife/master/README.md";
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webview);
//        webView.loadUrl(url);
//        webView.setWebViewClient(new WebViewClient(){
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                super.onPageFinished(view, url);
//                Toast.makeText(MainActivity.this,url,Toast.LENGTH_LONG).show();
//            }
//        });
        String html = "<p>I am normal</p>\n" +
                "<p style=\"color:red;\">I am red</p>\n" +
                "<p style=\"color:blue;\">I am blue</p>\n" +
                "<p style=\"font-size:50px;\">I am big</p>";
        webView.loadData(html, "text/html", "utf-8");
        //Bước 1 khởi tạo 1 thread. AsuncTassk
        //2. tạo kết nối đọc dữ liệu lấy được từ InputStream
        //3. hiển thị nội dung lấy được với scanner
        AsyncTask asyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                try {
                    URL url = new URL(link);
                    HttpsURLConnection connection =
                            (HttpsURLConnection) url.openConnection();
                    InputStream inputStream = connection.getInputStream();
                    Scanner scanner = new Scanner(inputStream);
                    String data = "";
                    while (scanner.hasNext()){
                        data +=scanner.nextLine();
                    }
                    scanner.close();
                    return data;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
                Toast.makeText(MainActivity.this,o.toString(),Toast.LENGTH_LONG).show();
            }
        };
        asyncTask.execute();
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}