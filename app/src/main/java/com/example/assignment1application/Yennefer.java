package com.example.assignment1application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Yennefer extends AppCompatActivity {
    private ImageView yenneferInfoScreen;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yennefer);
        setTitle("The Witcher Index");
    }

    public void goHide(View v) {

        yenneferInfoScreen =  findViewById(R.id.vilgefortzinfo);
        yenneferInfoScreen.setVisibility(View.GONE);
        //  androidIcon.setVisibility(View.INVISIBLE);

    }

    public void goShow(View v) {
        yenneferInfoScreen = findViewById(R.id.vilgefortzinfo);
        yenneferInfoScreen.setVisibility(View.VISIBLE);
    }
}