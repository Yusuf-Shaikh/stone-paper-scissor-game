package com.example.stonepaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class game extends AppCompatActivity {
    private TextView player1page;
    private ImageButton stone1,paper1,scissor1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //
        SharedPreferences sharedPreferencesp1 = getSharedPreferences("player1",MODE_PRIVATE);
        String player1name = sharedPreferencesp1.getString("player1", " player 1");
        //
        player1page = (TextView) findViewById(R.id.player1page);
        stone1 = (ImageButton) findViewById(R.id.stone1);
        paper1 = (ImageButton) findViewById(R.id.paper1);
        scissor1 = (ImageButton) findViewById(R.id.scissor1);
        //
        player1page.setText(player1name);
        //
        stone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String player1ans = "stone";
                passplayer1ans(player1ans);
                checkforplayer();
            }
        });
        //
        paper1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String player1ans = "paper";
                passplayer1ans(player1ans);
                checkforplayer();
            }
        });
        //
        scissor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String player1ans = "scissor";
                passplayer1ans(player1ans);
                checkforplayer();
            }
        });
    }
    public void checkforplayer() {
        SharedPreferences sharedPreferences = getSharedPreferences("players",MODE_PRIVATE);
        Integer players = sharedPreferences.getInt("players",MODE_PRIVATE);
        if(players==1){
            continue1playergame();
        }
        if(players==2){
            continue2playergame();
        }
    }
    public void passplayer1ans(String player1ans) {
        SharedPreferences p1ans = getSharedPreferences("player1ans",MODE_PRIVATE);
        SharedPreferences.Editor editor1 = p1ans.edit();
        editor1.putString("player1ans",player1ans);
        editor1.apply();
    }
    public void continue1playergame() {
        SharedPreferences sharedpreferencesp2 = getSharedPreferences("player2",MODE_PRIVATE);
        SharedPreferences.Editor editor1 = sharedpreferencesp2.edit();
        editor1.putString("player2","COMPUTER");
        editor1.apply();
        String compans = "player2answer";
        Integer temp = (int)(Math.random()*(3))+1;
        if(temp==1){
            compans = "stone";
        }
        if(temp==2){
            compans = "paper";
        }
        if(temp==3){
            compans = "scissor";
        }
        SharedPreferences p2ans = getSharedPreferences("player2ans",MODE_PRIVATE);
        SharedPreferences.Editor editor2 = p2ans.edit();
        editor2.putString("player2ans",compans);
        editor2.apply();
        //shows result
        Intent intent = new Intent(game.this,roundresult.class);
        startActivity(intent);
    }
    public void continue2playergame() {
        Intent intent = new Intent(game.this,game2.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
    }
}
