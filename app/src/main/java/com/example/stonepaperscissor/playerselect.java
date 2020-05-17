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

public class playerselect extends AppCompatActivity {
    private Button next;
    private EditText round;
    private EditText player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playerselect);
        next = (Button) findViewById(R.id.next);
        round = (EditText) findViewById(R.id.round);
        player = (EditText) findViewById(R.id.players);
        //this happpens when next button is clicked
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkuserinput();
            }
        });
    }
    public void checkuserinput() {
        if((TextUtils.isEmpty(round.getText().toString()))||(TextUtils.isEmpty(player.getText().toString()))) {
            Toast.makeText(this, "Enter number of rounds and number of players", Toast.LENGTH_SHORT).show();
        }
        else {
            if((Integer.parseInt(round.getText().toString())>0)&&(Integer.parseInt(round.getText().toString())<9))
            {
                if((Integer.parseInt(player.getText().toString())==2)||(Integer.parseInt(player.getText().toString())==1)) {
                    passonround();
                    opennameselect();
                }
                else {
                    Toast.makeText(this, "select only one or two player", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(this, "select number of round between 1 and 9 ", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void passonround() {
        //this passe the number of player
        Integer numberofplayer = Integer.parseInt(player.getText().toString());
        SharedPreferences sharedpreferences = getSharedPreferences("players",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt("players",numberofplayer);
        editor.apply();
        //this passes number of round
        Integer numberofround = Integer.parseInt(round.getText().toString());
        SharedPreferences sharedpreferences1 = getSharedPreferences("round",MODE_PRIVATE);
        SharedPreferences.Editor editor1 = sharedpreferences1.edit();
        editor1.putInt("round",numberofround);
        editor1.apply();
    }
    public void opennameselect() {
        //this opens next activity
        Intent selectname = new Intent(playerselect.this,nameselect.class);
        startActivity(selectname);
    }

}
