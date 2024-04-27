package com.theesmarty.untitled;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class RockPaperScissorActivity extends AppCompatActivity {

    private TextView score,turns,resultText,win,pc,bc;
    private Button rock,paper,scissor;
    private int s=0,t=8;
    private String result;
    private static String[] options={"Rock","Paper","Scissor"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissor);
        score = findViewById(R.id.score);
        turns = findViewById(R.id.turns);
        resultText = findViewById(R.id.RPS);
        rock = findViewById(R.id.rock);
        paper = findViewById(R.id.paper);
        scissor = findViewById(R.id.scissor);
        win = findViewById(R.id.win);
        pc = findViewById(R.id.pc);
        bc = findViewById(R.id.bc);

        updateScoreBoard();

        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pc.setText("Rock");
                playGame("Rock");
            }
        });

        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pc.setText("Paper");
                playGame("Paper");
            }
        });

        scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pc.setText("Scissor");
                playGame("Scissor");
            }
        });
    }

    private void updateScoreBoard() {
        score.setText("Score: "+s);
    }

    private void playGame(String userChoice){
        Random r = new Random();
        int bot = r.nextInt(3);
        String botChoice = options[bot];
        bc.setText(options[bot]);
        String result = Result(userChoice,botChoice);
        displayResult(result);
        t--;
        updateTurnsLeft(t);
        if(t==0){
            endGame();
        }
    }
    private void displayResult(String result) {
        win.setText(result);
        updateScoreBoard();
    }

    private void updateTurnsLeft(int t) {
        turns.setText("Turns left: "+t);
    }
    private String Result(String userChoice,String botChoice){
        if(userChoice.equals(botChoice)){
            return "Tie!";
        } else if (userChoice.equals("Rock") && botChoice.equals("Scissor") || userChoice.equals("Paper") && botChoice.equals("Rock") || userChoice.equals("Scissor") && botChoice.equals("Paper")) {
            s++;
            return "You Win!!";
        } else{
            s--;
            return "Bot Win!!";
        }
    }
    private void endGame() {
        rock.setEnabled(false);
        paper.setEnabled(false);
        scissor.setEnabled(false);
        if(s>0){
            result = "Congratulations!! You Won!!";
        }
        else if(s<0){
            result = "Oops!! Bot won!!";
        }
        else{
            result = "Well!! It's a Tie!!";
        }
        AlertDialog.Builder builder= new AlertDialog.Builder(RockPaperScissorActivity.this);
        builder.setTitle("Result");
        builder.setMessage(result);
        builder.setCancelable(false);
        builder.setNeutralButton("Ok", (DialogInterface.OnClickListener)(dialog,which)->{
            Intent in = new Intent(RockPaperScissorActivity.this, MainActivity.class);
            startActivity(in);
            finish();
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}