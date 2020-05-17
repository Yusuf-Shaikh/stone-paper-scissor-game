package com.example.stonepaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class game2 extends AppCompatActivity {
    private TextView player2page;
    private ImageButton stone2,paper2,scissor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);
        //
        SharedPreferences sharedPreferencesp1 = getSharedPreferences("player2",MODE_PRIVATE);
        String player2name = sharedPreferencesp1.getString("player2", " player 2");
        //
        player2page = (TextView) findViewById(R.id.player2page);
        stone2 = (ImageButton) findViewById(R.id.stone2);
        paper2 = (ImageButton) findViewById(R.id.paper2);
        scissor2 = (ImageButton) findViewById(R.id.scissor2);
        //
        player2page.setText(player2name);
        //
        stone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String player2ans = "stone";
                passplayer2ans(player2ans);
                continuegame();
            }
        });
        //
        paper2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String player2ans = "paper";
                passplayer2ans(player2ans);
                continuegame();
            }
        });
        //
        scissor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  player2ans = "scissor";
                passplayer2ans(player2ans);
                continuegame();
            }
        });
    }
    public void continuegame() {
        Intent intent = new Intent(game2.this,roundresult.class);
        startActivity(intent);

    }
    public void passplayer2ans(String player2ans) {
        SharedPreferences p2ans = getSharedPreferences("player2ans",MODE_PRIVATE);
        SharedPreferences.Editor editor1 = p2ans.edit();
        editor1.putString("player2ans",player2ans);
        editor1.apply();
    }
    @Override
    public void onBackPressed() {
    }
}
