package com.example.assignment1application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Skellige extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skellige);
        VideoView videoView = findViewById(R.id.skelligevideoxml);
        setTitle("The Witcher Index");
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.skelligevid;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }

    public void cerysButtonClick(View v){
        startActivity(new Intent(Skellige.this, Cerys.class));
        overridePendingTransition(R.transition.slide_in_right,R.transition.slide_out_left);
    }

    public void udalrykButtonClick(View v){
        startActivity(new Intent(Skellige.this, Udalryk.class));
        overridePendingTransition(R.transition.slide_in_right,R.transition.slide_out_left);

    }
}