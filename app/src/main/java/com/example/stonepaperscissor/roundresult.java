package com.example.stonepaperscissor;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class roundresult extends AppCompatActivity {
    private TextView player1info,player2info,player1score,player2score,player1choice,player2choice,result;
    private Button home,nextround;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roundresult);
        //intent to get number of rounds
        SharedPreferences sharedPreferences = getSharedPreferences("round",MODE_PRIVATE);
        Integer round = sharedPreferences.getInt("round",MODE_PRIVATE);
        //intent to get player1 ans
        SharedPreferences p1ans = getSharedPreferences("player1ans",MODE_PRIVATE);
        String player1ans = p1ans.getString("player1ans", " player 1 ans");
        //intent to get player2 ans
        SharedPreferences p2ans = getSharedPreferences("player2ans",MODE_PRIVATE);
        String player2ans = p2ans.getString("player2ans", " player 2 ans");
        //intent to get player1 name
        SharedPreferences p1 = getSharedPreferences("player1",MODE_PRIVATE);
        String player1 = p1.getString("player1", " player 1");
        //intent to get player2 name
        SharedPreferences p2 = getSharedPreferences("player2",MODE_PRIVATE);
        String player2 = p2.getString("player2", " player 2");
        //
        Integer p1score = get1score();
        //
        Integer p2score = get2score();
        //
        Integer roundcheck = getroundcount();
        //
        player1info = (TextView) findViewById(R.id.player1info);
        player1score = (TextView) findViewById(R.id.player1score);
        player1choice = (TextView) findViewById(R.id.player1choice);
        player2info = (TextView) findViewById(R.id.player2info);
        player2score = (TextView) findViewById(R.id.player2score);
        player2choice = (TextView) findViewById(R.id.player2choice);
        result = (TextView) findViewById(R.id.result);
        home = (Button) findViewById(R.id.home);
        nextround = (Button) findViewById(R.id.nextround);


        player1info.setText(player1);
        player2info.setText(player2);
        player1choice.setText(player1ans);
        player2choice.setText(player2ans);
        //game logic
        if(player1ans==player2ans) {
            result.setText("Round Draw !");
        }
        if(player1ans.equals("stone") && player2ans.equals("scissor")) {
            p1score++;
            updatep1score(p1score);
            result.setText(player1+" wins the round!");
        }
        if(player1ans.equals("scissor") && player2ans.equals("paper")) {
            p1score++;
            updatep1score(p1score);
            result.setText(player1+" wins the round !");
        }
        if(player1ans.equals("paper") && player2ans.equals("stone")) {
            p1score++;
            updatep1score(p1score);
            result.setText(player1+" wins the round !");
        }
        if(player2ans.equals("stone") && player1ans.equals("scissor")) {
            p2score++;
            updatep2score(p2score);
            result.setText(player2+" wins the round !");
        }
        if(player2ans.equals("scissor") && player1ans.equals("paper")) {
            p2score++;
            updatep2score(p2score);
            result.setText(player2+" wins the round !");
        }
        if(player2ans.equals("paper") && player1ans.equals("stone")) {
            p2score++;
            updatep2score(p2score);
            result.setText(player2+" wins the round !");
        }

        //sets the score
        p1score = get1score();
        p2score = get2score();
        player1score.setText(player1+" : "+p1score);
        player2score.setText(player2+" : "+p2score);
        //
        roundcheck++;
        updateroundcount(roundcheck);
        if(roundcheck==round){
            nextround.setEnabled(false);
            if(p1score==p2score){
                String temp = (String) result.getText();
                result.setText(temp+"\n"+"GAME DRAW !!");
            }
            if(p1score>p2score){
                if(player2.equals("COMPUTER")){
                    result.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#88D969")));
                }
                String temp = (String) result.getText();
                result.setText(temp+"\n"+player1+" WINS THE GAME !!");
            }
            if(p1score<p2score){
                if(player2.equals("COMPUTER")){
                    result.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                }
                String temp = (String) result.getText();
                result.setText(temp+"\n"+player2+" WINS THE GAME !!");
            }
        }

        //nextround
        nextround.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextroundf();
            }
        });
        //home
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmainactivity();
            }
        });

    }
    public Integer getroundcount() {
        SharedPreferences sharedPreferences = getSharedPreferences("roundcount",MODE_PRIVATE);
        Integer roundcount= sharedPreferences.getInt("roundcount",0);
        return roundcount;
    }
    public Integer get1score() {
        SharedPreferences p1s = getSharedPreferences("p1score",MODE_PRIVATE);
        Integer p1score= p1s.getInt("p1score",0);
        return p1score;
    }
    public Integer get2score() {
        SharedPreferences p2s = getSharedPreferences("p2score",MODE_PRIVATE);
        Integer p2score= p2s.getInt("p2score",0);
        return p2score;
    }
    public void updateroundcount(Integer roundcount) {
        SharedPreferences sharedPreferences = getSharedPreferences("roundcount",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("roundcount",roundcount);
        editor.apply();
    }
    public void updatep1score(Integer p1score) {
        SharedPreferences p1s = getSharedPreferences("p1score",MODE_PRIVATE);
        SharedPreferences.Editor editor1 = p1s.edit();
        editor1.putInt("p1score",p1score);
        editor1.apply();
    }
    public void updatep2score(Integer p2score) {
        SharedPreferences p2s = getSharedPreferences("p2score",MODE_PRIVATE);
        SharedPreferences.Editor editor2 = p2s.edit();
        editor2.putInt("p2score",p2score);
        editor2.apply();
    }
    public void nextroundf() {
        Intent selectname = new Intent(roundresult.this,game.class);
        startActivity(selectname);
    }
    //this resets all the value
    public void openmainactivity() {
        Intent selectname = new Intent(roundresult.this,home.class);
        startActivity(selectname);
    }
    @Override
    public void onBackPressed() {
    }
}
