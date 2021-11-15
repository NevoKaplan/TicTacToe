package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

public class winningScreen extends AppCompatActivity {

    boolean tied;
    String winningPlayer;
    VideoView cri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winning_screen);
        Intent intent = getIntent();
        tied = intent.getBooleanExtra("tied", false);
        if (tied)
            winningPlayer = "It's a Tie!";
        else
            winningPlayer = intent.getStringExtra("winningPlayer") + " Won!";
        TextView announce2 = findViewById(R.id.announce2);
        announce2.setText(winningPlayer);
        cri = (VideoView)findViewById(R.id.cri);
        String critikal = "android.resource://com.example.tictactoe/" + R.raw.cr1tikalpenguinz0;
        Uri uri = Uri.parse(critikal);
        cri.setVideoURI(uri);
        cri.start();
    }

    public void home(View view) { finish(); }
}