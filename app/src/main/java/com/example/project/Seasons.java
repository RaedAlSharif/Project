package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.Locale;

public class Seasons extends AppCompatActivity {


    TextToSpeech textToSpeech;
    int[] gorseller = {R.drawable.spring , R.drawable.summer , R.drawable.aut , R.drawable.winter};
    int[] gorseller2 = {R.drawable.springsun , R.drawable.summersun , R.drawable.fall , R.drawable.snowman};
    String[] seasons = {"Spring" , "Summer" , "Fall" , "Winter"};
    int index =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seasons);


        TextView tv = findViewById(R.id.textView9);
        Button btn = findViewById(R.id.button2);
        ImageSwitcher is = findViewById(R.id.imageView2);
        ImageSwitcher is2 = findViewById(R.id.Is);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    int lang = textToSpeech.setLanguage(Locale.ENGLISH);
                    textToSpeech.setSpeechRate((float) 0.5);
                    int s = textToSpeech.speak("Spring" , TextToSpeech.QUEUE_FLUSH,null);
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                index++;
                textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i == TextToSpeech.SUCCESS){
                            int lang = textToSpeech.setLanguage(Locale.ENGLISH);
                            textToSpeech.setSpeechRate((float) 0.5);
                            int s = textToSpeech.speak(seasons[index] , TextToSpeech.QUEUE_FLUSH,null);
                        }
                    }
                });
                if (index == gorseller.length) {
                    index = 0;
                }
                tv.setText(seasons[index]);
                is.setImageResource(gorseller[index]);
                if (index == gorseller2.length) {
                    index = 0;
                }
                is2.setImageResource(gorseller2[index]);
            }
        });
        is.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                imageView.setMaxHeight(250);
                imageView.setMaxWidth(250);
                return imageView;
            }
        });

        is.setImageResource(gorseller[index]);
 is2.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                imageView.setMaxHeight(250);
                imageView.setMaxWidth(250);
                return imageView;
            }
        });
        is2.setImageResource(gorseller2[index]);


    }

    public void clickImage(View view){
        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(this, R.anim.hyperspace_jump);
        view.startAnimation(hyperspaceJumpAnimation);
    }
}