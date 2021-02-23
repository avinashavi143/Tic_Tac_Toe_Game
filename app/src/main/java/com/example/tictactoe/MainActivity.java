package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button singlePlayer;
    private Button doublePlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        singlePlayer = (Button) findViewById(R.id.singlePlayer);
        doublePlayer = (Button) findViewById(R.id.doublePlayer);

        singlePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, game.class);
                intent.putExtra("gameType","single");
                startActivity(intent);
            }
        });

        doublePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, game.class);
                intent.putExtra("gameType","multi");
                startActivity(intent);
            }
        });

    }
}