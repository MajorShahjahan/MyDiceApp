package com.example.mydiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView diceImage1 = findViewById(R.id.diceImage1);
        ImageView diceImage2 = findViewById(R.id.diceImage2);
       final MediaPlayer mp = MediaPlayer.create(this,R.raw.dice_sound);

        int[] diceImages = {R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,
                R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};



        Button button = findViewById(R.id.rollButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int randomNumber = random.nextInt(6);

                diceImage1.setImageResource(diceImages[randomNumber]);

                Random random1 = new Random();
                int randomObject = random1.nextInt(6);

                diceImage2.setImageResource(diceImages[randomObject]);

                YoYo.with(Techniques.FlipInY)
                        .duration(500)
                        .repeat(0)
                        .playOn(findViewById(R.id.diceImage1));

                YoYo.with(Techniques.FlipInY)
                        .duration(500)
                        .repeat(0)
                        .playOn(findViewById(R.id.diceImage2));

                mp.start();


            }
        });



    }
}