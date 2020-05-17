package com.example.stonepaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {
    private Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        start = (Button) findViewById(R.id.homestart);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valuesclear();
                openplayerselect();
            }
        });
    }
    public void openplayerselect() {
        //this opens next activity
        Intent intent = new Intent(home.this,playerselect.class);
        startActivity(intent);
    }
    public void valuesclear() {
        SharedPreferences sharedPreferences = getSharedPreferences("roundcount",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("roundcount",0);
        editor.apply();
        SharedPreferences p1s = getSharedPreferences("p1score",MODE_PRIVATE);
        SharedPreferences.Editor editor1 = p1s.edit();
        editor1.putInt("p1score",0);
        editor1.apply();
        SharedPreferences p2s = getSharedPreferences("p2score",MODE_PRIVATE);
        SharedPreferences.Editor editor2 = p2s.edit();
        editor2.putInt("p2score",0);
        editor2.apply();
    }
    @Override
    public void onBackPressed() {
    }
}
