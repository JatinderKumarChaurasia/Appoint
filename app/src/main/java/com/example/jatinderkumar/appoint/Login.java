package com.example.jatinderkumar.appoint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {
    Button SignUp,SignIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SignUp =(Button) findViewById(R.id.SignUp);
        SignIn =(Button) findViewById(R.id.SignIn);
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Login.this,SignIn.class);
                startActivity(intent);
            }
        });
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,SignUp.class);
                startActivity(intent);
            }
        });

    }
}
