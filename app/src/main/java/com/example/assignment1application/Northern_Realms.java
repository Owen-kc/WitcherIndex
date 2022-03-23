package com.example.assignment1application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Northern_Realms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_northern_realms);
        setTitle("The Witcher Index");

        VideoView videoView = findViewById(R.id.northernrealmsvideo);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.northernrealmsvideo;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }

    public void rocheButtonClick(View v){
        startActivity(new Intent(Northern_Realms.this, Roche.class));
        overridePendingTransition(R.transition.slide_in_right,R.transition.slide_out_left);
    }

    public void keiraButtonClick(View v){
        startActivity(new Intent(Northern_Realms.this, Keira.class));
        overridePendingTransition(R.transition.slide_in_right,R.transition.slide_out_left);
    }
}