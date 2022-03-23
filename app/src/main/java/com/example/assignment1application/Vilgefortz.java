package com.example.assignment1application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Vilgefortz extends AppCompatActivity {

    private ImageView vilgefortzInfoScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vilgefortz);
        setTitle("The Witcher Index");
    }

    public void goHide(View v) {

        vilgefortzInfoScreen =  findViewById(R.id.vilgefortzinfo);
        vilgefortzInfoScreen.setVisibility(View.GONE);
        //  androidIcon.setVisibility(View.INVISIBLE);

    }

    public void goShow(View v) {
        vilgefortzInfoScreen = findViewById(R.id.vilgefortzinfo);
        vilgefortzInfoScreen.setVisibility(View.VISIBLE);
    }
}