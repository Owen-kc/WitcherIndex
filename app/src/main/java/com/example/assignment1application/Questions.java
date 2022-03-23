package com.example.assignment1application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Questions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        setTitle("The Witcher Index");

        WebView myBrowser = findViewById(R.id.webview);
        myBrowser.setWebViewClient(new WebViewClient());
        myBrowser.loadUrl("https://witcher.fandom.com/wiki/Witcher_Wiki");
        WebSettings webSettings = myBrowser.getSettings();
        webSettings.setJavaScriptEnabled(true);


        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"recipient@example.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
        i.putExtra(Intent.EXTRA_TEXT   , "body of email");
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Questions.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    }