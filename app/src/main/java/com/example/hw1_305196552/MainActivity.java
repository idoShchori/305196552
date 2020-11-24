package com.example.hw1_305196552;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   public static final int WIN=8;
   private String[] imgs=new String[2];
    private ImageButton button1;
    private ImageView p1i;
    private ImageView p2i;
    private TextView score1;
    private TextView score2;
    private String name1="";
    private String name2="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 =findViewById(R.id.shuffle);
        p1i =findViewById(R.id.Left_Card);
        p2i=findViewById(R.id.Right_Card);
        score1=findViewById(R.id.left_Player_Score);
        score2=findViewById(R.id.right_Player_Score);


        Logics game=new Logics();
             button1.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                    if(game.getP1Score()!=WIN &&game.getP2Score()!=WIN) {
                        imgs = game.oneGame();
                        changeImg(imgs[0], imgs[1]);
                        changeScore(game);
                    }else{//check winner and send massage to next window
                        String Win=whoWin(game);

                        Intent myIntent = new Intent(MainActivity.this, WinnerWinnerChickenDinner.class);
                        myIntent.putExtra("Winner", Win);
                        startActivity(myIntent);
                        finish();

                    }

                 }
             });

    }
    private void changeScore(Logics game) {
        score1.setText(""+game.getP1Score());
        score2.setText(""+game.getP2Score());
    }

    public void changeImg(String name1,String name2){
        int img1=this.getResources().getIdentifier(name1, "drawable", this.getPackageName());
        int img2=this.getResources().getIdentifier(name2, "drawable", this.getPackageName());
        p1i.setImageResource(img1);
        p2i.setImageResource(img2);

    }
    public String whoWin(Logics game) {
        if (game.getP1Score()>game.getP2Score())
            return "Ido Win's";
        else if(game.getP1Score()<game.getP2Score()){
            return "Stav Win's";
        }
        return "draw";
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
    }
        @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}