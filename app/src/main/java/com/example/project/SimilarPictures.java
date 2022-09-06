package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;

public class SimilarPictures extends AppCompatActivity {

    int[] images = {R.drawable.snowman, R.drawable.xray, R.drawable.lemon, R.drawable.zebra, R.drawable.orange, R.drawable.lemon};
    boolean bim1 = false;
    boolean bim2 = false;
    boolean bim3 = false;
    boolean bim4 = false;
    boolean bim5 = false;
    boolean bim6 = false;

    int score;
    String un;
    String ps;
    FirebaseDatabase fb;
    DatabaseReference rf;

    TextToSpeech textToSpeech;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_similar_pictures);

        fb = FirebaseDatabase.getInstance();
        rf = fb.getReference("users");


        Bundle extra = getIntent().getExtras();

        if (extra != null) {
            int score2 = extra.getInt("score");
            score = score2 + score +1;
            String username = extra.getString("username");
            String password = extra.getString("password");
            un = username;
            ps = password;

            Helper helper = new Helper(username, password, score);

            rf.child(username).setValue(helper);
        }
            ImageButton im1 = findViewById(R.id.imageView17);

            ImageButton im2 = findViewById(R.id.imageView18);
            ImageButton im3 = findViewById(R.id.imageView19);
            ImageButton im4 = findViewById(R.id.imageView20);
            ImageButton im5 = findViewById(R.id.imageView21);
            ImageButton im6 = findViewById(R.id.imageView22);

            Button btn = findViewById(R.id.button4);


            ImageButton[] imgBtn = {im1, im2, im3, im4, im5, im6};
            boolean[] bimg = {bim1, bim2, bim3, bim4, bim5, bim6};
            int[] ints = new int[6];

            for (int i = 0; i < images.length; i++) {
                int index = (int) (Math.random() * 6);
                ints[i] = index;
                imgBtn[i].setImageResource(images[index]);
            }

            im1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bim1 = true;
                    im1.setImageResource(R.drawable.purple);

                }
            });
            im2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bim2 = true;
                    im2.setImageResource(R.drawable.purple);

                }
            });
            im3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bim3 = true;
                    im3.setImageResource(R.drawable.purple);

                }
            });
            im4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bim4 = true;
                    im4.setImageResource(R.drawable.purple);

                }
            });
            im5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bim5 = true;
                    im5.setImageResource(R.drawable.purple);

                }
            });
            im6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bim6 = true;
                    im6.setImageResource(R.drawable.purple);

                }
            });

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for (int i = 0; i < imgBtn.length - 1; i++) {
                        for (int j = 1; j < ints.length - 1; j++) {
                            if (ints[i] == ints[j]) {
                                bimg[i] = true;
                                bimg[i + 1] = true;
                                Toast.makeText(SimilarPictures.this, "CORRECT!!!", Toast.LENGTH_SHORT).show();
                                textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                    @Override
                                    public void onInit(int i) {
                                        if (i == TextToSpeech.SUCCESS){
                                            int lang = textToSpeech.setLanguage(Locale.ENGLISH);
                                            textToSpeech.setSpeechRate((float) 0.1);
                                            int s = textToSpeech.speak("That's Indeed Correct , Good Job" , TextToSpeech.QUEUE_FLUSH,null);

                                        }
                                    }
                                });

                                Intent intent = new Intent(getApplicationContext() , PreMainPage.class);

                                intent.putExtra("score" , score);
                                intent.putExtra("username" , un);
                                intent.putExtra("password" , ps);
                                PreMainPage.mediaPlayer.stop();
                                startActivity(intent);
                            }
                        }
                    }
                }
            });
    }
}