package com.example.assignment1application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Udalryk extends AppCompatActivity {

    private ImageView udalrykInfoScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_udalryk);
        setTitle("The Witcher Index");
    }

    public void goHide(View v) {

        udalrykInfoScreen =  findViewById(R.id.vilgefortzinfo);
        udalrykInfoScreen.setVisibility(View.GONE);
        //  androidIcon.setVisibility(View.INVISIBLE);

    }

    public void goShow(View v) {
        udalrykInfoScreen = findViewById(R.id.vilgefortzinfo);
        udalrykInfoScreen.setVisibility(View.VISIBLE);
    }
}