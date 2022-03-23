package com.example.assignment1application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Cerys extends AppCompatActivity {

    private ImageView cerysInfoScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerys);
        setTitle("The Witcher Index");
    }

    public void goHide(View v) {

        cerysInfoScreen =  findViewById(R.id.vilgefortzinfo);
        cerysInfoScreen.setVisibility(View.GONE);
        //  androidIcon.setVisibility(View.INVISIBLE);

    }

    public void goShow(View v) {
        cerysInfoScreen = findViewById(R.id.vilgefortzinfo);
        cerysInfoScreen.setVisibility(View.VISIBLE);
    }
}