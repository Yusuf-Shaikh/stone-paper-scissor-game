package com.example.stonepaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class nameselect extends AppCompatActivity {
    private Button startgame;
    private EditText player1name;
    private EditText player2name;
    private Integer players;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nameselect);
        //this gets the number of player
        SharedPreferences sharedPreferences = getSharedPreferences("players",MODE_PRIVATE);
        players = sharedPreferences.getInt("players",MODE_PRIVATE);
        //
        startgame = (Button) findViewById(R.id.startgame);
        player1name = (EditText) findViewById(R.id.player1name);
        player2name = (EditText) findViewById(R.id.player2name);
        //this removes the player 2 input box if there is only 1 player
        if(players==1){
            player2name.setVisibility(View.GONE);
        }
        //this starts the game
        startgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(players==1){
                    checkusername();
                }
                if(players==2){
                    checkusernames();
                }
            }
        });
    }
    //this happens if there is only one player
    public void checkusername() {
        if((TextUtils.isEmpty(player1name.getText().toString()))) {
            Toast.makeText(this, "Enter valid user names", Toast.LENGTH_SHORT).show();
        }
        else {
            passdatato1player();
        }
    }
    //if there is only one player this sets name for player 1
    public void passdatato1player() {
        //sets name for player1
        String player1 = player1name.getText().toString().toUpperCase();
        SharedPreferences sharedpreferencesp1 = getSharedPreferences("player1",MODE_PRIVATE);
        SharedPreferences.Editor editor1 = sharedpreferencesp1.edit();
        editor1.putString("player1",player1);
        editor1.apply();
        //opens the game activity
        Intent intent = new Intent(nameselect.this,game.class);
        startActivity(intent);
    }
    //this happens if there r 2 players
    public void checkusernames() {
        if((TextUtils.isEmpty(player1name.getText().toString()))||(TextUtils.isEmpty(player2name.getText().toString()))) {
            Toast.makeText(this, "Enter valid user names", Toast.LENGTH_SHORT).show();
        }
        else {
            passdatatogame1();
        }
    }
    //if there r two players this sets the name for two players
    public void passdatatogame1() {
        //sets name for player1
        String player1 = player1name.getText().toString().toUpperCase();
        SharedPreferences sharedpreferencesp1 = getSharedPreferences("player1",MODE_PRIVATE);
        SharedPreferences.Editor editor1 = sharedpreferencesp1.edit();
        editor1.putString("player1",player1);
        editor1.apply();
        //sets name for player2
        String player2 = player2name.getText().toString().toUpperCase();
        SharedPreferences sharedpreferencesp2 = getSharedPreferences("player2",MODE_PRIVATE);
        SharedPreferences.Editor editor2 = sharedpreferencesp2.edit();
        editor2.putString("player2",player2);
        editor2.apply();
        //opens the game activity
        Intent intent = new Intent(nameselect.this,game.class);
        startActivity(intent);
    }

}
