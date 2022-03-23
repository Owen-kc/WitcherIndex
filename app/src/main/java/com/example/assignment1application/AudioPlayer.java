package com.example.assignment1application;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class AudioPlayer extends AppCompatActivity {

    Button playBtn;
    SeekBar positionBar, volumeBar;
    TextView elapsedTimeLabel, remainingTimeLabel;
    MediaPlayer mp;
    int totalTime;
    int[] myMusic = {R.raw.trail, R.raw.hos, R.raw.geraltofrivia};
    int mCompleted = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_player);
        playBtn = findViewById(R.id.playBtn);
        elapsedTimeLabel = findViewById(R.id.elapsedTimeLabel);
        remainingTimeLabel = findViewById(R.id.remainingTimeLabel);
        setTitle("The Witcher Index");


        ((TextView)findViewById(R.id.musicName)).setText("Now Playing: The Trail - Marcin Przybyłowicz ");
        ((ImageView)findViewById(R.id.albumCover)).setBackgroundResource(R.drawable.witcheralbum);

        // Media Player
        mp = MediaPlayer.create(this, R.raw.trail);
        //mp.setLooping(true);
        mp.seekTo(0);
        mp.setVolume(0.5f, 0.5f);
        totalTime = mp.getDuration();

        // Position Bar
        positionBar = findViewById(R.id.positionBar);
        positionBar.setMax(totalTime);
        positionBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if (fromUser) {
                            mp.seekTo(progress);
                            positionBar.setProgress(progress);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                }
        );


        // Volume Bar
        volumeBar = findViewById(R.id.volumeBar);
        volumeBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        float volumeNum = progress / 100f;
                        mp.setVolume(volumeNum, volumeNum);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                }
        );

        // Thread (Update positionBar & timeLabel)
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mp != null) {
                    try {
                        Message msg = new Message();
                        msg.what = mp.getCurrentPosition();
                        handler.sendMessage(msg);
                        Thread.sleep(1000);
                    } catch (InterruptedException ignored) {}
                }
            }
        }).start();

    }

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            int currentPosition = msg.what;
            // Update positionBar.
            positionBar.setProgress(currentPosition);

            // Update Labels.
            String elapsedTime = createTimeLabel(currentPosition);
            elapsedTimeLabel.setText(elapsedTime);

            String remainingTime = "- " + createTimeLabel(totalTime - currentPosition);
            remainingTimeLabel.setText(remainingTime);

            return true;
        }
    });

    public String createTimeLabel(int time) {
        String timeLabel = "";
        int min = time / 1000 / 60;
        int sec = time / 1000 % 60;

        timeLabel = min + ":";
        if (sec < 10) timeLabel += "0";
        timeLabel += sec;

        return timeLabel;
    }

    public void nextSong(View view){
        mp.reset();
        playBtn.setBackgroundResource(R.drawable.play);
        mCompleted++;
        if (mCompleted == 0) {
            ((ImageView)findViewById(R.id.albumCover)).setBackgroundResource(R.drawable.witcheralbum);
            ((TextView)findViewById(R.id.musicName)).setText("Now Playing: The Trail - Marcin Przybyłowicz ");
            mp = MediaPlayer.create(this, R.raw.trail);
            //mp.setLooping(true);
            mp.seekTo(0);
            mp.setVolume(0.5f, 0.5f);
            totalTime = mp.getDuration();
        }
        else if (mCompleted == 1) {
            ((ImageView)findViewById(R.id.albumCover)).setBackgroundResource(R.drawable.hos);
            ((TextView)findViewById(R.id.musicName)).setText("Now Playing: Evil's Touches - Marcin Przybyłowicz ");
            mp = MediaPlayer.create(this, R.raw.hos);
            //mp.setLooping(true);
            mp.seekTo(0);
            mp.setVolume(0.5f, 0.5f);
            totalTime = mp.getDuration();
        }
        else if (mCompleted == 2) {
            ((ImageView)findViewById(R.id.albumCover)).setBackgroundResource(R.drawable.baw);
            ((TextView)findViewById(R.id.musicName)).setText("Now Playing: Geralt of Rivia - Marcin Przybyłowicz ");
            mp = MediaPlayer.create(this, R.raw.geraltofrivia);
            //mp.setLooping(true);
            mp.seekTo(0);
            mp.setVolume(0.5f, 0.5f);
            totalTime = mp.getDuration();
        }
        else if (mCompleted == 3) {
            ((ImageView)findViewById(R.id.albumCover)).setBackgroundResource(R.drawable.w2);
            ((TextView)findViewById(R.id.musicName)).setText("Now Playing: Dwarven Stone  - Adam Skorupa");
            mp = MediaPlayer.create(this, R.raw.dwarvenstone);
            //mp.setLooping(true);
            mp.seekTo(0);
            mp.setVolume(0.5f, 0.5f);
            totalTime = mp.getDuration();
        }
        else if (mCompleted == 4) {
            ((ImageView)findViewById(R.id.albumCover)).setBackgroundResource(R.drawable.toss);
            ((TextView)findViewById(R.id.musicName)).setText("Now Playing: Toss a Coin to Your Witcher - Joey Batey");
            mp = MediaPlayer.create(this, R.raw.toss);
            //mp.setLooping(true);
            mp.seekTo(0);
            mp.setVolume(0.5f, 0.5f);
            totalTime = mp.getDuration();
        }
    }

    public void prevSong(View view){
        mp.reset();
        playBtn.setBackgroundResource(R.drawable.play);
        mCompleted--;
        if (mCompleted == 0) {
            ((TextView)findViewById(R.id.musicName)).setText("Now Playing: The Trail - Marcin Przybyłowicz ");
            ((ImageView)findViewById(R.id.albumCover)).setBackgroundResource(R.drawable.witcheralbum);
            mp = MediaPlayer.create(this, R.raw.trail);
            //mp.setLooping(true);
            mp.seekTo(0);
            mp.setVolume(0.5f, 0.5f);
            totalTime = mp.getDuration();
        }
        else if (mCompleted == 1) {
            ((TextView)findViewById(R.id.musicName)).setText("Now Playing: Evil's Touches - Marcin Przybyłowicz ");
            ((ImageView)findViewById(R.id.albumCover)).setBackgroundResource(R.drawable.hos);
            mp = MediaPlayer.create(this, R.raw.hos);
            //mp.setLooping(true);
            mp.seekTo(0);
            mp.setVolume(0.5f, 0.5f);
            totalTime = mp.getDuration();
        }
        else if (mCompleted == 2) {
            ((TextView)findViewById(R.id.musicName)).setText("Now Playing: Geralt of Rivia - Marcin Przybyłowicz ");
            ((ImageView)findViewById(R.id.albumCover)).setBackgroundResource(R.drawable.baw);
            mp = MediaPlayer.create(this, R.raw.geraltofrivia);
            //mp.setLooping(true);
            mp.seekTo(0);
            mp.setVolume(0.5f, 0.5f);
            totalTime = mp.getDuration();
        }
        else if (mCompleted == 3) {
            ((TextView)findViewById(R.id.musicName)).setText("Now Playing: Dwarven Stone - Adam Skorupa");
            ((ImageView)findViewById(R.id.albumCover)).setBackgroundResource(R.drawable.w2);
            mp = MediaPlayer.create(this, R.raw.dwarvenstone);
            //mp.setLooping(true);
            mp.seekTo(0);
            mp.setVolume(0.5f, 0.5f);
            totalTime = mp.getDuration();
        }
        else if (mCompleted == 4) {
            ((TextView)findViewById(R.id.musicName)).setText("Now Playing: Toss a Coin to Your Witcher - Joey Batey");
            ((ImageView)findViewById(R.id.albumCover)).setBackgroundResource(R.drawable.toss);
            mp = MediaPlayer.create(this, R.raw.toss);
            //mp.setLooping(true);
            mp.seekTo(0);
            mp.setVolume(0.5f, 0.5f);
            totalTime = mp.getDuration();
        }
    }

    public void playBtnClick(View view) {

        if (!mp.isPlaying()) {
            // Stopping
            mp.start();
            playBtn.setBackgroundResource(R.drawable.stop);

        } else {
            // Playing
            mp.pause();
            playBtn.setBackgroundResource(R.drawable.play);
        }
    }
}