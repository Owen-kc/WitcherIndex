package com.example.assignment1application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Nilfgaard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nilfgaard);
        setTitle("The Witcher Index");

        VideoView videoView = findViewById(R.id.nilfgaardvid);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.nilfgaardvideo;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }

    public void vilgefortzButtonClick(View v){
        startActivity(new Intent(Nilfgaard.this, Vilgefortz.class));
        overridePendingTransition(R.transition.slide_in_right,R.transition.slide_out_left);
    }

    public void joachimButtonClick(View v){
        startActivity(new Intent(Nilfgaard.this, Joachim.class));
        overridePendingTransition(R.transition.slide_in_right,R.transition.slide_out_left);

    }
}