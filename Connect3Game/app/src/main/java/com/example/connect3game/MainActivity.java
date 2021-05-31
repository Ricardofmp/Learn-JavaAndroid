package com.example.connect3game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //amarelo é 0, vermelho é 1; 2 é que o quadrado está vazio;
    int activePlayer = 0;
    boolean gameActive = true;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8}, {0,3,6}, {1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void dropin(View view){

        ImageView counter = (ImageView) view;
        counter.setTranslationY(-1500);
        Log.i("Tag:", counter.getTag().toString());

        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        gameState[tappedCounter] = activePlayer;

        if(activePlayer == 0 && gameActive){
            counter.setImageResource(R.drawable.yellow);
            activePlayer = 1;
        }else{
            counter.setImageResource(R.drawable.red);
            activePlayer = 0;
        }

        counter.animate().translationYBy(1500).rotation(3600).setDuration(300);

        for(int[] winningPosition : winningPositions){
            if(gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2){
                String winner = "";
                gameActive = false;
                if(activePlayer == 1){
                    winner = "Yellow";
                }
                else{
                    winner= "Red";
                    }
                Toast.makeText(this, winner + " is the winner!", Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}