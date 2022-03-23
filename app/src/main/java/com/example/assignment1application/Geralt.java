package com.example.assignment1application;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

public class Geralt extends AppCompatActivity {

    private ImageView geraltInfoScreen;
    private CheckBox geralt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geralt);
        setTitle("The Witcher Index");

    }
    public void goHide(View v) {

        geraltInfoScreen =  findViewById(R.id.vilgefortzinfo);
        geraltInfoScreen.setVisibility(View.GONE);
        //  androidIcon.setVisibility(View.INVISIBLE);

    }

    public void goShow(View v) {
        geraltInfoScreen = findViewById(R.id.vilgefortzinfo);
        geraltInfoScreen.setVisibility(View.VISIBLE);
    }

    public void goCheckCheese(View v) {
        geralt =  findViewById(R.id.geraltCheck);
        if (geralt.isChecked())
            Toast.makeText(getBaseContext(), "I hate portals...",
                    Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getBaseContext(), "It's said, spitefully, the silver one is for monsters and the iron for humans. A lie, of course",
                    Toast.LENGTH_SHORT).show();

    }

    public void goSound(View v) {
        MediaPlayer mp = MediaPlayer.create(Geralt.this, R.raw.geraltsound);
        mp.start();
    }
}