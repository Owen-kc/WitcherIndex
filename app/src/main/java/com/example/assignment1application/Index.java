package com.example.assignment1application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        setTitle("The Witcher Index");
    }

    public void goChangeVector(View view)
    {
        ImageView imageView = findViewById(R.id.world1);
        imageView.setImageResource(R.drawable.world3);
    }
}