package com.example.dicegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView upDie, downDie, resultImage;
    Button higherButton, lowerButton;

    int [] diceArray = {R.drawable.dice1,
            R.drawable.dice2,
            R.drawable.dice3,
            R.drawable.dice4,
            R.drawable.dice5,
            R.drawable.dice6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        upDie = findViewById(R.id.up_die);
        downDie = findViewById(R.id.down_die);
        higherButton = findViewById(R.id.higher_button);
        lowerButton = findViewById(R.id.lower_button);
        resultImage = findViewById(R.id.result_image);

        higherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = diceRolling();
                if (result>0) {
                    resultImage.setImageResource(R.drawable.computer_win);
                }
                else if (result<0){
                    resultImage.setImageResource(R.drawable.user_win);
                }
                else {
                    resultImage.setImageResource(R.drawable.tie_tie);
                }
            }
        });

        lowerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = diceRolling();
                if (result<0) {
                    resultImage.setImageResource(R.drawable.computer_win);
                }
                else if (result>0){
                    resultImage.setImageResource(R.drawable.user_win);
                }
                else {
                    resultImage.setImageResource(R.drawable.tie_tie);
                }
            }
        });
    }

    private int diceRolling() {
        Random rand = new Random();

        int randNumUp = rand.nextInt(6);
        int randNumDown = rand.nextInt(6);

        upDie.setImageResource(diceArray[randNumUp]);
        downDie.setImageResource(diceArray[randNumDown]);

        return randNumUp - randNumDown;
    }
}