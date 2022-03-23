package com.example.assignment1application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Neutral extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neutral);
        setTitle("The Witcher Index");

        VideoView videoView = findViewById(R.id.neutralvideo);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.neutralvid;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);


    }

    public void geraltButtonClick(View v){
        startActivity(new Intent(Neutral.this, Geralt.class));
        overridePendingTransition(R.transition.slide_in_right,R.transition.slide_out_left);
    }

    public void yenneferButtonClick(View v){
        startActivity(new Intent(Neutral.this, Yennefer.class));
        overridePendingTransition(R.transition.slide_in_right,R.transition.slide_out_left);
    }

    public void trissButtonClick(View v){
        startActivity(new Intent(Neutral.this, Triss.class));
        overridePendingTransition(R.transition.slide_in_right,R.transition.slide_out_left);
    }


}