package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class game extends AppCompatActivity {

    // hello Dvir, 100 please, thanks.

    String p1;
    String p2;
    String current;
    String other;
    TextView announce;
    Controller controller;
    ImageView example;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent = getIntent();
        p1 = intent.getStringExtra("p1");
        p2 = intent.getStringExtra("p2");
        controller = new Controller(p1, p2);
        announce = findViewById(R.id.announce);
        current = p1;
        announce.setText(current + "'s Turn");
        example = findViewById(R.id.example);
        example.setImageResource(R.drawable.ix);
    }

    public void backToMain(View view){
        finish();
    }

    public void clicked(View view) {
        other = current;
        current = controller.setMove(Integer.parseInt(view.getTag().toString()));
        announce.setText(current + "'s Turn");
        if (current.equals(p1)) {
            example.setImageResource(R.drawable.ix);
            //((ImageView)view).setAdjustViewBounds(true);
            ((ImageView)view).setImageResource(R.drawable.igol);
        }
        else {
            example.setImageResource(R.drawable.igol);
            //((ImageView)view).setAdjustViewBounds(true);
            ((ImageView)view).setImageResource(R.drawable.ix);
        }
        view.setEnabled(false);
        int won = controller.check();
        if (won > 0)
            goToWin(won);
    }

    public void goToWin(int won) {
        Intent imean = new Intent(this, winningScreen.class);
        boolean tied = false;
        if (won == 2) {
            imean.putExtra("winningPlayer", other);
        }
        else if (won == 1)
            tied = true;
        imean.putExtra("tied", tied);
        startActivityForResult(imean, 7);
        backToMain(null);
    }

    public void goToSite (View view) {
        goToUrl ("https://www.google.com/search?q=%D7%97%D7%9E%D7%90%D7%A8&sxsrf=AOaemvLcQ7CbH9CxZHf8vxuAV-gnuMgMmg:1636792392057&source=lnms&tbm=isch&sa=X&ved=2ahUKEwi9reXo9pT0AhUyiP0HHU4MAGwQ_AUoAXoECAEQAw&biw=1920&bih=929&dpr=1#imgrc=oYt5geOIrniU-M");
    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}