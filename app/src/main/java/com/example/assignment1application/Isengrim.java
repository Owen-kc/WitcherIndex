package com.example.assignment1application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Isengrim extends AppCompatActivity {

    private ImageView isengrimInfoScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isengrim);
        setTitle("The Witcher Index");
    }

    public void goHide(View v) {

        isengrimInfoScreen =  findViewById(R.id.vilgefortzinfo);
        isengrimInfoScreen.setVisibility(View.GONE);
        //  androidIcon.setVisibility(View.INVISIBLE);

    }

    public void goShow(View v) {
        isengrimInfoScreen = findViewById(R.id.vilgefortzinfo);
        isengrimInfoScreen.setVisibility(View.VISIBLE);
    }
}