package com.example.assignment1application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

public class Gallery extends AppCompatActivity {

    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        setTitle("The Witcher Index");

        viewFlipper = findViewById(R.id.view_flipper);
    }

    public void goPrevious(View view)
    {
        viewFlipper.setInAnimation(this,R.anim.slide_in_right);
        viewFlipper.setOutAnimation(this,R.anim.slide_out_left);
        viewFlipper.showPrevious();
    }

    public void goNext(View view)
    {
        viewFlipper.setInAnimation(this,R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this,R.anim.slide_out_right);
        viewFlipper.showNext();
    }

}