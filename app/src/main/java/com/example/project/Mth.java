package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;

public class Mth extends AppCompatActivity {

    int score;
    String un;
    String ps;
    FirebaseDatabase fb;
    DatabaseReference rf;

    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mth);
        fb = FirebaseDatabase.getInstance();
        rf = fb.getReference("users");



        Bundle extra = getIntent().getExtras();

        if (extra != null) {
            int score2 = extra.getInt("score");
            score = score2 + score ;
            String username = extra.getString("username");
            String password = extra.getString("password");
            un = username;
            ps = password;

            Helper helper = new Helper(username, password, score);

            rf.child(username).setValue(helper);
        }
        TextView nu1 = findViewById(R.id.textView12);
        TextView nu2 = findViewById(R.id.textView11);
        TextView sign2 = findViewById(R.id.textView10);

        Button btn = findViewById(R.id.submit);
        Button btn2 = findViewById(R.id.submit2);

        EditText ed = findViewById(R.id.editTextNumber);


            int num1 = (int) (Math.random() * 10);

            int num2 = (int) (Math.random() * 10);

            int sign = (int) (Math.random() * 3);

            if (num2 > num1) {
                int temp = num2;
                num2 = num1;
                num1 = temp;
            }
        nu1.setText("" + num1);
            nu2.setText("" + num2);
        if (sign == 1)
            sign2.setText("+");
        else if (sign == 2)
            sign2.setText("-");
        else
            sign2.setText("*");


        int finalNum = num1;
        int finalNum1 = num2;
        btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String value = ed.getText().toString();
                    int finalValue = Integer.parseInt(value);

                    if (sign == 1) {
                        if (finalNum + finalNum1 == finalValue) {
                            score++;
                            Toast.makeText(Mth.this, "CORRECT!!!", Toast.LENGTH_SHORT).show();
                            textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                @Override
                                public void onInit(int i) {
                                    if (i == TextToSpeech.SUCCESS){
                                        int lang = textToSpeech.setLanguage(Locale.ENGLISH);
                                        textToSpeech.setSpeechRate((float) 0.1);
                                        int s = textToSpeech.speak("Well Done You are smart" , TextToSpeech.QUEUE_FLUSH,null);
                                    }
                                }
                            });
                            Intent intent = new Intent(getApplicationContext() , Mth.class);

                            intent.putExtra("score" , score);
                            intent.putExtra("username" , un);
                            intent.putExtra("password" , ps);
                            startActivity(intent);
                        }
                        else
                            Toast.makeText(Mth.this, "Wrong Answer , The correct answer was "+ (finalNum + finalNum1), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext() , Mth.class);

                        intent.putExtra("score" , score);
                        intent.putExtra("username" , un);
                        intent.putExtra("password" , ps);
                        startActivity(intent);                    }
                    else if(sign == 2) {
                            if (finalNum - finalNum1 == finalValue) {
                                score++;
                                Toast.makeText(Mth.this, "CORRECT!!!", Toast.LENGTH_SHORT).show();
                                textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                    @Override
                                    public void onInit(int i) {
                                        if (i == TextToSpeech.SUCCESS){
                                            int lang = textToSpeech.setLanguage(Locale.ENGLISH);
                                            textToSpeech.setSpeechRate((float) 0.1);
                                            int s = textToSpeech.speak("Correct, You are good" , TextToSpeech.QUEUE_FLUSH,null);
                                        }
                                    }
                                });
                                Intent intent = new Intent(getApplicationContext() , Mth.class);

                                intent.putExtra("score" , score);
                                intent.putExtra("username" , un);
                                intent.putExtra("password" , ps);
                                startActivity(intent);                            } else
                                Toast.makeText(Mth.this, "Wrong Answer , The correct answer was "+ (finalNum - finalNum1), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext() , Mth.class);

                        intent.putExtra("score" , score);
                        intent.putExtra("username" , un);
                        intent.putExtra("password" , ps);
                        startActivity(intent);
                    }
                    else {
                        if (finalNum * finalNum1 == finalValue) {
                            score++;
                            Toast.makeText(Mth.this, "CORRECT!!!", Toast.LENGTH_SHORT).show();
                            textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                @Override
                                public void onInit(int i) {
                                    if (i == TextToSpeech.SUCCESS){
                                        int lang = textToSpeech.setLanguage(Locale.ENGLISH);
                                        textToSpeech.setSpeechRate((float) 0.1);
                                        int s = textToSpeech.speak("Correct, You are good" , TextToSpeech.QUEUE_FLUSH,null);
                                    }
                                }
                            });
                            Intent intent = new Intent(getApplicationContext() , Mth.class);

                            intent.putExtra("score" , score);
                            intent.putExtra("username" , un);
                            intent.putExtra("password" , ps);
                            startActivity(intent);                            } else
                            Toast.makeText(Mth.this, "Wrong Answer , The correct answer was "+ (finalNum - finalNum1), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext() , Mth.class);

                        intent.putExtra("score" , score);
                        intent.putExtra("username" , un);
                        intent.putExtra("password" , ps);
                        startActivity(intent);

                    }
                }
            });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , PreMainPage.class);

                intent.putExtra("score" , score);
                intent.putExtra("username" , un);
                intent.putExtra("password" , ps);

                PreMainPage.mediaPlayer.stop();
                startActivity(intent);
            }
        });



        }

    }
