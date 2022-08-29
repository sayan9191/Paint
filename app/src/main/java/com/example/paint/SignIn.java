package com.example.paint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {
    Button btnSkip;
    EditText edittxtMobile;
    TextView btnOtp,btnSignUp,txtPolicy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        btnSkip= findViewById(R.id.btnSkip);
        btnOtp= findViewById(R.id.btnOtp);
        btnSignUp= findViewById(R.id.btnSignUp);
        edittxtMobile= findViewById(R.id.edittxtMobile);

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),signUp.class);
                startActivity(intent);
            }
        });
        btnOtp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String mobile= edittxtMobile.getText().toString();
                if(mobile.length() != 18){

                    Toast.makeText(SignIn.this, "Enter a valid Mobile Number", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(SignIn.this, "Welcome to Paint", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}