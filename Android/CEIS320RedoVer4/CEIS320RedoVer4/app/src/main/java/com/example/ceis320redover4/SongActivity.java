package com.example.ceis320redover4;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class SongActivity extends AppCompatActivity {
    private VideoView vidView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        vidView = (VideoView) findViewById(R.id.vidView);
        vidView.setMediaController(new MediaController(this)); //add media controller
        Uri video = Uri.parse("android.resource://" +getPackageName()+ "/"+ R.raw.goodmorning);
        vidView.setVideoURI(video);
        vidView.setZOrderOnTop(true); //don't merge video with other widgets
    }

    protected void onResume() {
        super.onResume();
        vidView.start();
    }
    protected void onPause() {
        vidView.stopPlayback();
        super.onPause();
    }
}