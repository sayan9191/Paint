package com.example.paint;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView name,number, email,gender;
    TextView btnStartPaint,btnLogOut,UserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        name= findViewById(R.id.name);
//        number= findViewById(R.id.number);
//        email= findViewById(R.id.email);
//        gender= findViewById(R.id.gender);
//        btnStartPaint= findViewById(R.id.btnStartPaint);
//        btnLogOut= findViewById(R.id.btnLogOut);
        UserName= findViewById(R.id.txtUserName);

        Intent intent= getIntent();
        String fName= intent.getStringExtra("key1");
//        name.setText(fName);
        UserName.setText(fName);
//        String Mobile= intent.getStringExtra("key2");
//        number.setText(Mobile);
//        String Email= intent.getStringExtra("key3");
//        email.setText(Email);
//        String Gender= intent.getStringExtra("key5");
//        gender.setText(Gender);


//        btnLogOut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(getApplicationContext(),SignIn.class);
//                startActivity(intent);
//            }
//        });
//        btnStartPaint.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(getApplicationContext(),PaintPage.class);
//                startActivity(intent);
//            }
//        });
    }
}