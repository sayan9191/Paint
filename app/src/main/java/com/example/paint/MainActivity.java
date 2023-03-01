package com.example.paint;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView name,number, email,gender;
    TextView btnLogOut,UserName;
    Button btnDetail,btnStartPaint;
    int flag=0;


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name= findViewById(R.id.name);
        number= findViewById(R.id.number);
        email= findViewById(R.id.email);
        gender= findViewById(R.id.gender);
        btnDetail= findViewById(R.id.btnDetail);
        btnStartPaint= findViewById(R.id.btnStartPaint);
        btnLogOut= findViewById(R.id.btnLogOut);
        UserName= findViewById(R.id.txtUserName);

        SharedPreferences sharedPreferences= getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        String fName= sharedPreferences.getString("key1", "");
        name.setText(fName);
        UserName.setText(fName);
        String Mobile= sharedPreferences.getString("key2","");

        number.setText(Mobile);
        String Email= sharedPreferences.getString("key3", "");
        email.setText(Email);
        String Gender= sharedPreferences.getString("key5","");
        gender.setText(Gender);




        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == 0) {
                    LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linerLayout);
                    linearLayout.setVisibility(view.VISIBLE);
                    btnDetail.setText("Hide");
                    flag=1;
                }
                else if(flag==1){
                    LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linerLayout);
                    linearLayout.setVisibility(view.INVISIBLE);
                    btnDetail.setText("Details");
                    flag=0;
                }
            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences= getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.clear();
                editor.apply();
                finish();
                Intent intent=new Intent(getApplicationContext(),SignIn.class);
                startActivity(intent);
            }
        });
        btnStartPaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),PaintPage.class);
                startActivity(intent);
            }
        });

    }
}