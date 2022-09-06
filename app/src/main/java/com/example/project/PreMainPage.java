package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class PreMainPage extends AppCompatActivity {

    public static MediaPlayer mediaPlayer;
    int score2;
    String username2;
    String password2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_main_page);
        TextView tv = findViewById(R.id.textView15);



        Bundle extra = getIntent().getExtras();

        if (extra != null) {
            int score = extra.getInt("score");
            String username = extra.getString("username");
            String password = extra.getString("password");

            score2 =score;
            username2 = username;
            password2 = password;
        }
        tv.setText( String.valueOf(score2));


        mediaPlayer = MediaPlayer.create(PreMainPage.this , R.raw.song3);
        mediaPlayer.setLooping(true);

        mediaPlayer.start();


        ImageButton learn = findViewById(R.id.Ib);
        ImageButton play = findViewById(R.id.Ib2);

        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext() , MainPage.class));
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , PlayingPart.class);

                intent.putExtra("score" , score2);
                intent.putExtra("username" , username2);
                intent.putExtra("password" , password2);
                startActivity(intent);

            }
        });
    }
}