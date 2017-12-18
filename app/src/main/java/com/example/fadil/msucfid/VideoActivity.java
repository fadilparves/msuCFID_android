package com.example.fadil.msucfid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by fadil on 17/12/2017.
 */

public class VideoActivity extends AppCompatActivity {

    VideoView vid;
    public String url;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_player);

        Intent intent = getIntent();
        String file = intent.getStringExtra("File");

        url = "http://c14c113c.ngrok.io" + file ;

        vid = findViewById(R.id.vid);

        MediaController mc = new MediaController(this);

        vid.setMediaController(mc);
        vid.setVideoURI(Uri.parse(url));

        vid.requestFocus();
        vid.start();
    }
}
