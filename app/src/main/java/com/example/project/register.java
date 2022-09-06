package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {

    EditText username, password;
    int score;
    Button btn;
    FirebaseDatabase fb;
    DatabaseReference rf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        username = findViewById(R.id.edit_name);
        password = findViewById(R.id.edit_password);
        btn = findViewById(R.id.butt);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                fb = FirebaseDatabase.getInstance();
                rf = fb.getReference("users");

                String name = username.getText().toString();
                String password1 = password.getText().toString();

                if (TextUtils.isEmpty(name)){
                    username.setError("username is required");
                    username.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(password1)){
                    password.setError("Password is required");
                    password.requestFocus();
                    return;
                }

                if (password1.length() < 6){
                    password.setError("password should be at least 6 characters");
                    password.requestFocus();
                    return;
                }




                Helper helper = new Helper(name , password1 , score);

                rf.child(name).setValue(helper);

                Intent intent = new Intent(getApplicationContext() , LoginRegister.class);
                startActivity(intent);

            }
        });
    }

}
