package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String p1 = "P1";
    private String p2 = "P2";
    TextView p1Text;
    TextView p2Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p1Text = findViewById(R.id.P1Named);
        p2Text = findViewById(R.id.P2Named);
    }

    public void goToSite (View view) {
        goToUrl ("https://nevokaplan4.wixsite.com/bibis-adventure");
    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    public void clicked(View view) {
        p1 = "P1";
        p2 = "P2";
        if (view.getId() == R.id.confirm)
        {
           if (!(p1Text.getText().toString().matches(""))){
               p1 = p1Text.getText().toString();
           }
           if (!(p2Text.getText().toString().matches(""))){
               p2 = p2Text.getText().toString();
           }
        }
        Intent intent = new Intent(this, game.class);
        intent.putExtra("p1", p1);
        intent.putExtra("p2", p2);
        startActivityForResult(intent, 10);
    }
}