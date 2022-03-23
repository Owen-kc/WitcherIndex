package com.example.assignment1application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Joachim extends AppCompatActivity {

    private ImageView joachimInfoScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joachim);
        setTitle("The Witcher Index");
    }

    public void goHide(View v) {

        joachimInfoScreen =  findViewById(R.id.vilgefortzinfo);
        joachimInfoScreen.setVisibility(View.GONE);
        //  androidIcon.setVisibility(View.INVISIBLE);

    }

    public void goShow(View v) {
        joachimInfoScreen = findViewById(R.id.vilgefortzinfo);
        joachimInfoScreen.setVisibility(View.VISIBLE);
    }
}