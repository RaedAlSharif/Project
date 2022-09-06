package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class YearsMonths extends AppCompatActivity {

    TextToSpeech textToSpeech;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_years_months);

        Button btn1 = findViewById(R.id.bt111);
        Button btn2 = findViewById(R.id.bt222);
        Button btn3 = findViewById(R.id.bt333);
        Button btn4 = findViewById(R.id.bt444);
        Button btn5 = findViewById(R.id.bt555);
        Button btn6 = findViewById(R.id.bt666);
        Button btn7 = findViewById(R.id.bt777);

        TextView tv = findViewById(R.id.Tv2);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    int lang = textToSpeech.setLanguage(Locale.ENGLISH);
                    textToSpeech.setSpeechRate((float) 0.5);
                    int s = textToSpeech.speak("Sunday" , TextToSpeech.QUEUE_FLUSH,null);
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
                            int s = textToSpeech.speak("Sunday" , TextToSpeech.QUEUE_FLUSH,null);
                        }
                    }
                });

                tv.setText("Sunday");
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
                            int s = textToSpeech.speak("Monday" , TextToSpeech.QUEUE_FLUSH,null);
                        }
                    }
                });
                tv.setText("Monday");
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
                            int s = textToSpeech.speak("Tuesday" , TextToSpeech.QUEUE_FLUSH,null);
                        }
                    }
                });
                tv.setText("Tuesday");
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
                            int s = textToSpeech.speak("Wednesday" , TextToSpeech.QUEUE_FLUSH,null);
                        }
                    }
                });
                tv.setText("Wednesday");
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
                            int s = textToSpeech.speak("Thursday" , TextToSpeech.QUEUE_FLUSH,null);
                        }
                    }
                });
                tv.setText("Thursday");
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
                            int s = textToSpeech.speak("Friday" , TextToSpeech.QUEUE_FLUSH,null);
                        }
                    }
                });
                tv.setText("Friday");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i == TextToSpeech.SUCCESS){
                            int lang = textToSpeech.setLanguage(Locale.ENGLISH);
                            textToSpeech.setSpeechRate((float) 0.5);
                            int s = textToSpeech.speak("Saturday" , TextToSpeech.QUEUE_FLUSH,null);
                        }
                    }
                });
                tv.setText("Saturday");
            }
});
    }
}
