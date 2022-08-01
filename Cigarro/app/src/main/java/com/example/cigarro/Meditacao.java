package com.example.cigarro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Meditacao extends AppCompatActivity {
    VideoView video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditacao);
        getSupportActionBar().hide();
        video = findViewById(R.id.videoView);
        String c = "android.resource://"+getPackageName()+"/"+R.raw.med2;

        Uri uri = Uri.parse(c);
        video.setVideoURI(uri);
        MediaController mc = new MediaController(this);
        video.setMediaController(mc);
        mc.setAnchorView(video);

    }
    public void voltar(View v){
        Intent i = new Intent(this,Inspiracao.class);
        startActivity(i);
    }
}