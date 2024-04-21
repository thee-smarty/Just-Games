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

public class MainActivity extends AppCompatActivity {
    private ImageView img;
    private Random r;
    int count;
    Spinner sp;
    TextView player;
    String[] playerCount = {"1 Player","2 Players", "3 Players", "4 Players","5 Player"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=findViewById(R.id.dice);
        sp = (Spinner) findViewById(R.id.players);
        player = findViewById(R.id.PlayerId);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,playerCount);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=1;i<=count;i=(i+1)%count)
                {
                    rollDice();
                    player.setText("Player"+i);
                }
            }
        });
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        count = (int) parent.getItemAtPosition(pos);
    }

    public void onNothingSelected(AdapterView<?> parent) {
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
                rollDice();
                break;
        }
    }
}