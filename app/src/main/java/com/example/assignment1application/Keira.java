package com.example.assignment1application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Keira extends AppCompatActivity {

    private ImageView keiraInfoScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keira);
    }

    public void goHide(View v) {

        keiraInfoScreen =  findViewById(R.id.vilgefortzinfo);
        keiraInfoScreen.setVisibility(View.GONE);
        //  androidIcon.setVisibility(View.INVISIBLE);

    }

    public void goShow(View v) {
        keiraInfoScreen = findViewById(R.id.vilgefortzinfo);
        keiraInfoScreen.setVisibility(View.VISIBLE);
    }
}