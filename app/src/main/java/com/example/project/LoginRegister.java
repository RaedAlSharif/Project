package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;

public class LoginRegister extends AppCompatActivity {

    EditText username, password;
    Button btn, btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);

        username = findViewById(R.id.editTextTextPersonName);
        password = findViewById(R.id.editTextTextPassword);
        btn = findViewById(R.id.button3);
        btn1 = findViewById(R.id.button);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), register.class));
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final String us = username.getText().toString();
                final String ps = password.getText().toString();


                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");

                Query check = reference.orderByChild("username").equalTo(us);

                check.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            username.setError(null);


                            String passwordEntered = dataSnapshot.child(us).child("password").getValue(String.class);

                            if (passwordEntered.equals(ps)) {
                                username.setError(null);


                                String UsernameEntered = dataSnapshot.child(us).child("username").getValue(String.class);
                                String phoneEntered = dataSnapshot.child(us).child("phone").getValue(String.class);
                                int EmailEntered = dataSnapshot.child(us).child("score").getValue(int.class);

                                Intent intent = new Intent(getApplicationContext(), PreMainPage.class);

                                intent.putExtra("username", UsernameEntered);
                                intent.putExtra("password", passwordEntered);
                                intent.putExtra("score", EmailEntered);

                                startActivity(intent);


                            } else {
                                password.setError("Wrong password");
                                password.requestFocus();
                            }

                        } else {
                            username.setError("NO such user exist");
                            username.requestFocus();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });
    }
}