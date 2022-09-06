package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlayingPart extends AppCompatActivity {

    int score2;
    String username2;
    String password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_part);

        TextView tv = findViewById(R.id.textView17);

        Bundle extra = getIntent().getExtras();

        if (extra != null) {
            int score = extra.getInt("score");
            score2 = score;
            String username = extra.getString("username");
            String password = extra.getString("password");
            username2 = username;
            password2 = password;
        }
        tv.setText(String.valueOf(score2));

        Button ball = findViewById(R.id.TrackBall);
        Button findsmilar = findViewById(R.id.similarPicatures);
        Button math = findViewById(R.id.mathq);

        ball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext() , BallTracker.class));
            }
        });
        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , Mth.class);

                intent.putExtra("score" , score2);
                intent.putExtra("username" , username2);
                intent.putExtra("password" , password2);

                startActivity(intent);

            }
        });
        findsmilar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getApplicationContext() , SimilarPictures.class);

                intent.putExtra("score" , score2);
                intent.putExtra("username" , username2);
                intent.putExtra("password" , password2);

                startActivity(intent);
            }
        });



    }
}