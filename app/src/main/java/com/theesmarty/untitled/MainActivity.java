package com.theesmarty.untitled;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView img;
    private Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=findViewById(R.id.dice);
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
                break;
            case 2: img.setImageResource(R.drawable.dice_2);
                break;
            case 3: img.setImageResource(R.drawable.dice_3);
                break;
            case 4: img.setImageResource(R.drawable.dice_4);
                break;
            case 5: img.setImageResource(R.drawable.dice_5);
                break;
            case 6: img.setImageResource(R.drawable.dice_6);
                break;
        }
    }
}