package com.example.assignment1application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Roche extends AppCompatActivity {

    private ImageView vernonInfoScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roche);
        setTitle("The Witcher Index");
    }

    public void goHide(View v) {

        vernonInfoScreen =  findViewById(R.id.vilgefortzinfo);
        vernonInfoScreen.setVisibility(View.GONE);
        //  androidIcon.setVisibility(View.INVISIBLE);

    }

    public void goShow(View v) {
        vernonInfoScreen = findViewById(R.id.vilgefortzinfo);
        vernonInfoScreen.setVisibility(View.VISIBLE);
    }
}