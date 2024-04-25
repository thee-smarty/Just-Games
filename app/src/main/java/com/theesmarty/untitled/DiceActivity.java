package com.theesmarty.untitled;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;

public class DiceActivity extends AppCompatActivity {
    private ImageView img;
    private Random r;
    TextView score;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);
        img=findViewById(R.id.dice);
        score = findViewById(R.id.PlayerId);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });
    }

    private void rollDice(){
        r=new Random();
        int rand=r.nextInt(6)+1;
        switch(rand){
            case 1: img.setImageResource(R.drawable.dice_1);
                score.setText("ONE");
                break;
            case 2: img.setImageResource(R.drawable.dice_2);
                score.setText("TWO");
                break;
            case 3: img.setImageResource(R.drawable.dice_3);
                score.setText("THREE");
                break;
            case 4: img.setImageResource(R.drawable.dice_4);
                score.setText("FOUR");
                break;
            case 5: img.setImageResource(R.drawable.dice_5);
                score.setText("FIVE");
                break;
            case 6: img.setImageResource(R.drawable.dice_6);
                score.setText("SIX");
                break;
        }
    }
}