package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Numbers extends AppCompatActivity {
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);


        Button btn1 = findViewById(R.id.bt1);
        Button btn2 = findViewById(R.id.bt2);
        Button btn3 = findViewById(R.id.bt3);
        Button btn4 = findViewById(R.id.bt4);
        Button btn5 = findViewById(R.id.bt5);
        Button btn6 = findViewById(R.id.bt6);
        Button btn7 = findViewById(R.id.bt7);
        Button btn8 = findViewById(R.id.bt8);
        Button btn9 = findViewById(R.id.bt9);

        TextView tv = findViewById(R.id.Tv);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    int lang = textToSpeech.setLanguage(Locale.ENGLISH);
                    textToSpeech.setSpeechRate((float) 0.5);
                    int s = textToSpeech.speak("1" , TextToSpeech.QUEUE_FLUSH,null);
                }
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i == TextToSpeech.SUCCESS){
                            int lang = textToSpeech.setLanguage(Locale.ENGLISH);
                            textToSpeech.setSpeechRate((float) 0.5);
                            int s = textToSpeech.speak("1" , TextToSpeech.QUEUE_FLUSH,null);
                        }
                    }
                });

                tv.setText("1");
            }
        });btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i == TextToSpeech.SUCCESS){
                            int lang = textToSpeech.setLanguage(Locale.ENGLISH);
                            textToSpeech.setSpeechRate((float) 0.5);
                            int s = textToSpeech.speak("2" , TextToSpeech.QUEUE_FLUSH,null);
                        }
                    }
                });
                tv.setText("2");
            }
        });btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i == TextToSpeech.SUCCESS){
                            int lang = textToSpeech.setLanguage(Locale.ENGLISH);
                            textToSpeech.setSpeechRate((float) 0.5);
                            int s = textToSpeech.speak("3" , TextToSpeech.QUEUE_FLUSH,null);
                        }
                    }
                });
                tv.setText("3");
            }
        });btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i == TextToSpeech.SUCCESS){
                            int lang = textToSpeech.setLanguage(Locale.ENGLISH);
                            textToSpeech.setSpeechRate((float) 0.5);
                            int s = textToSpeech.speak("4" , TextToSpeech.QUEUE_FLUSH,null);
                        }
                    }
                });
                tv.setText("4");
            }
        });btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i == TextToSpeech.SUCCESS){
                            int lang = textToSpeech.setLanguage(Locale.ENGLISH);
                            textToSpeech.setSpeechRate((float) 0.5);
                            int s = textToSpeech.speak("5" , TextToSpeech.QUEUE_FLUSH,null);
                        }
                    }
                });
                tv.setText("5");
            }
        });btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i == TextToSpeech.SUCCESS){
                            int lang = textToSpeech.setLanguage(Locale.ENGLISH);
                            textToSpeech.setSpeechRate((float) 0.5);
                            int s = textToSpeech.speak("6" , TextToSpeech.QUEUE_FLUSH,null);
                        }
                    }
                });
                tv.setText("6");
            }
        });btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i == TextToSpeech.SUCCESS){
                            int lang = textToSpeech.setLanguage(Locale.ENGLISH);
                            textToSpeech.setSpeechRate((float) 0.5);
                            int s = textToSpeech.speak("7" , TextToSpeech.QUEUE_FLUSH,null);
                        }
                    }
                });
                tv.setText("7");
            }
        });btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i == TextToSpeech.SUCCESS){
                            int lang = textToSpeech.setLanguage(Locale.ENGLISH);
                            textToSpeech.setSpeechRate((float) 0.5);
                            int s = textToSpeech.speak("8" , TextToSpeech.QUEUE_FLUSH,null);
                        }
                    }
                });
                tv.setText("8");
            }
        });btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i == TextToSpeech.SUCCESS){
                            int lang = textToSpeech.setLanguage(Locale.ENGLISH);
                            textToSpeech.setSpeechRate((float) 0.5);
                            int s = textToSpeech.speak("9" , TextToSpeech.QUEUE_FLUSH,null);
                        }
                    }
                });
                tv.setText("9");
            }
        });
    }
}