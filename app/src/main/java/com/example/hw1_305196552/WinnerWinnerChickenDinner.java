package com.example.hw1_305196552;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WinnerWinnerChickenDinner extends AppCompatActivity {
    private TextView winner;
    private Button ext;
    private Button rstrt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner_winner_chicken_dinner);
        winner=findViewById(R.id.winner);
        ext=findViewById(R.id.Exit);
        rstrt=findViewById(R.id.Play_Again);
        winner.setText(getIntent().getStringExtra("Winner"));
        rstrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(WinnerWinnerChickenDinner.this, MainActivity.class);
                startActivity(myIntent);
                finish();
            }
        });
        ext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}