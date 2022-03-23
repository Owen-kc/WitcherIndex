package com.example.assignment1application;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Imlerith extends AppCompatActivity {

    private ImageView imlerithInfoScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imlerith);
        setTitle("The Witcher Index");
    }

    public void goHide(View v) {

        imlerithInfoScreen =  findViewById(R.id.vilgefortzinfo);
        imlerithInfoScreen.setVisibility(View.GONE);
        //  androidIcon.setVisibility(View.INVISIBLE);

    }

    public void goShow(View v) {
        imlerithInfoScreen = findViewById(R.id.vilgefortzinfo);
        imlerithInfoScreen.setVisibility(View.VISIBLE);
    }
}