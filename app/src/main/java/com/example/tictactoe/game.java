package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class game extends AppCompatActivity {

    int i = 0;
    int count = 0;
    int[] box = {9, 9, 9, 9, 9, 9, 9, 9, 9};
    int[] [] winningPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        TextView playerStatus = (TextView) findViewById(R.id.players);
        playerStatus.setText("Lets Play........!");

    }

    @SuppressLint("SetTextI18n")
    public void click(View view) {
        ImageView c = (ImageView) view;
        int tappedBox = Integer.parseInt(c.getTag().toString());
        if (box[tappedBox] == 9) {
            box[tappedBox] = i;
            c.setTranslationY(-1000f);
            if (i == 0) {
                c.setImageResource(R.drawable.cross);
                c.animate().translationYBy(1000f).setDuration(300);
                i = 1;
                count = count + 1;
            } else {
                c.setImageResource(R.drawable.circle);
                c.animate().translationYBy(1000f).setDuration(300);
                i = 0;
                count = count + 1;
            }
            CheckWinner();
        }
    }
    //Checking winner
    @SuppressLint("SetTextI18n")
    public void CheckWinner() {
        for(int[] winningPos: winningPositions) {
            if(box[winningPos[0]]==box[winningPos[1]] && box[winningPos[1]]==box[winningPos[2]]
                    && box[winningPos[0]]!=9 && count <= 9) {
                //Some one has won who was that ..........!
                TextView WhoWin = (TextView) findViewById(R.id.player_status);
                if(i==0){
                    WhoWin.setText("Player-2 Win..!");
                } else {
                    WhoWin.setText("Player-1 Win..!");
                }
                GridLayout layout = (GridLayout) findViewById(R.id.gridLayout);
                layout.setVisibility(View.VISIBLE);
                Button playAgain = (Button) findViewById(R.id.PlayAgain);
                playAgain.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(game.this, game.class);
                        startActivity(intent);
                    }
                });
            }
            else{
                if(count==9){
                    @SuppressLint("CutPasteId") TextView text = (TextView) findViewById(R.id.player_status);
                    text.setText("Match Draw");
                    GridLayout layout = (GridLayout) findViewById(R.id.gridLayout);
                    layout.setVisibility(View.VISIBLE);
                    @SuppressLint("CutPasteId") Button PlayAgain = (Button) findViewById(R.id.PlayAgain);
                    PlayAgain.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(game.this, game.class);
                            startActivity(intent);
                        }
                    });
                }
            }
        }
    }
}
