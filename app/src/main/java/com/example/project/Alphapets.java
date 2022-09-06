package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.Locale;

public class Alphapets extends AppCompatActivity {

    TextToSpeech textToSpeech;

    int[] gorseller = {R.drawable.apple2,R.drawable.banana,R.drawable.cat,R.drawable.dog,R.drawable.elephant,R.drawable.fish,R.drawable.giraph,R.drawable.horn,R.drawable.igloo,R.drawable.jacket,R.drawable.kangaroo,R.drawable.lemon,R.drawable.milk,R.drawable.nail,R.drawable.orange,R.drawable.popcorn,R.drawable.queen,R.drawable.rainbow,R.drawable.strawberry,R.drawable.train,R.drawable.umbrella,R.drawable.vollyball,R.drawable.whale,R.drawable.xray,R.drawable.yacht,R.drawable.zebra};
    String[] alpha = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    String[] word = {"Apple","Banana","Cat","Dog","Elephant","Fish","Giraffe","Horn","Igloo","Jacket","Kangaroo","Lemon","Milk","Nail","Orange","Popcorn","Queen","Rainbow","Strawberry","Train","Umbrella","Volleyball","Whale","X-ray","Yacht","Zebra"};
    int index =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphapets);



        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    int lang = textToSpeech.setLanguage(Locale.ENGLISH);
                    textToSpeech.setSpeechRate((float) 0.1);
                    int s = textToSpeech.speak("A Apple" , TextToSpeech.QUEUE_FLUSH,null);
                }
            }
        });

        PreMainPage.mediaPlayer.stop();

        TextView alphapets = findViewById(R.id.textView7);
        TextView words = findViewById(R.id.textView8);
        Button btn = findViewById(R.id.button15);
        Button btn2 = findViewById(R.id.button16);
        ImageSwitcher is = findViewById(R.id.imageView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                if (index == gorseller.length){
                    index = 0;
                }
                alphapets.setText(alpha[index]);
                words.setText(word[index]);
                is.setImageResource(gorseller[index]);

                textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i == TextToSpeech.SUCCESS){
                            int lang = textToSpeech.setLanguage(Locale.ENGLISH);
                            textToSpeech.setSpeechRate((float) 0.1);
                            int s = textToSpeech.speak(alpha[index] +"  "+ word[index] , TextToSpeech.QUEUE_FLUSH,null);
                        }
                    }
                });
            }
        }); btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index--;

                if(index < 0){
                    index = gorseller.length;
                }
                if (index == gorseller.length){
                    index = 0;
                }
                alphapets.setText(alpha[index]);
                words.setText(word[index]);
                is.setImageResource(gorseller[index]);

                textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i == TextToSpeech.SUCCESS){
                            int lang = textToSpeech.setLanguage(Locale.ENGLISH);
                            textToSpeech.setSpeechRate((float) 0.1);
                            int s = textToSpeech.speak(alpha[index] +"  "+ word[index] , TextToSpeech.QUEUE_FLUSH,null);
                        }
                    }
                });
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
    }
}