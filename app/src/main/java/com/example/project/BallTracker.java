package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class BallTracker extends AppCompatActivity {

    private int screenWidth;
    private int screenHeight;

    private float ballX;
    private float ballY;

    private float ball2X;
    private float ball2Y;

    private float ball3X;
    private float ball3Y;

    private float ball4X;
    private float ball4Y;

    private float ball5X;
    private float ball5Y;

    private float ball6X;
    private float ball6Y;

    private Handler handler = new Handler();
    private Timer timer = new Timer();
    private ImageView ball;
    private ImageView ball2;
    private ImageView ball3;
    private ImageView ball4;
    private ImageView ball5;
    private ImageView ball6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ball_tracker);



        ball = findViewById(R.id.imageView6);
        ball2 = findViewById(R.id.imageView7);
        ball3 = findViewById(R.id.imageView8);
        ball4 = findViewById(R.id.imageView9);
        ball5 = findViewById(R.id.imageView10);
        ball6 = findViewById(R.id.imageView11);

        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        ball.setX(-29.0f);
        ball.setY(-45.0f);

        ball2.setX(-56.0f);
        ball2.setY(screenHeight + 79.0f);

        ball3.setX(-40.0f);
        ball3.setY(-23.0f);

        ball4.setX(-74.0f);
        ball4.setY(screenHeight + 26.0f);

        ball5.setX(-55.0f);
        ball5.setY(-80.0f);

        ball6.setX(-92.0f);
        ball6.setY(screenHeight + 34.0f);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        changePos();
                    }
                });
            }
        } , 0 ,15);
    }
        public void changePos(){
           ballY -= 10;
           if (ball.getY() + ball.getHeight() < 0) {
               ballX = (float) Math.floor(Math.random() * (screenWidth - ball.getWidth()));

           ballY = screenHeight + 100.0f;
           }
           ball.setX(ballX);
           ball.setY(ballY);

           ball3Y -= 10;
           if (ball3.getY() + ball3.getHeight() < 0) {
               ball3X = (float) Math.floor(Math.random() * (screenWidth - ball3.getWidth()));

           ball3Y = screenHeight + 100.0f;
           }
           ball3.setX(ball3X);
           ball3.setY(ball3Y);

           ball5Y -= 10;
           if (ball5.getY() + ball5.getHeight() < 0) {
               ball5X = (float) Math.floor(Math.random() * (screenWidth - ball5.getWidth()));

           ball5Y = screenHeight + 100.0f;
           }
           ball5.setX(ball5X);
           ball5.setY(ball5Y);

           ball2Y += 10;
           if (ball2.getY() > screenHeight){
               ball2X = (float) Math.floor(Math.random() * (screenWidth - ball2.getWidth()));
               ball2Y = -100f;
           }
           ball2.setX(ball2X);
           ball2.setY(ball2Y);

           ball4Y += 10;
           if (ball4.getY() > screenHeight){
               ball4X = (float) Math.floor(Math.random() * (screenWidth - ball4.getWidth()));
               ball4Y = -100f;
           }
           ball4.setX(ball4X);
           ball4.setY(ball4Y);

           ball6Y += 10;
           if (ball6.getY() > screenHeight){
               ball6X = (float) Math.floor(Math.random() * (screenWidth - ball6.getWidth()));
               ball6Y = -100f;
           }
           ball6.setX(ball6X);
           ball6.setY(ball6Y);

        }


}