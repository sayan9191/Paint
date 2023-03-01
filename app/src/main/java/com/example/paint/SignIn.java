
package com.example.paint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        btnSkip= findViewById(R.id.btnSkip);
        btnOtp= findViewById(R.id.btnOtp);
        btnSignUp= findViewById(R.id.btnSignUp);
        edittxtMobile= findViewById(R.id.edittxtMobile);
        sharedPreferences = getSharedPreferences("MyUserPrefs" , Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();

//        sharedPreferences1= getSharedPreferences("MyUserPrefs1",Context.MODE_PRIVATE);



        String userName  = sharedPreferences.getString("key1", "");
        System.out.println(userName);
        String number= sharedPreferences.getString("Number", "");
        System.out.println(number);

//        if (!number.isEmpty()){
//            startActivity(new Intent(this, MainActivity.class));
//            finish();
//        }
//        else{
//
//        }

        if(!userName.isEmpty() || !number.isEmpty()){
            startActivity(new Intent(this , MainActivity.class));
            finish();
        }else{
//            startActivity(new Intent(this, SignIn.class));
        }

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
                finish();
            }
        });

        btnOtp.setOnClickListener(view ->{
            createUserMobile();
        });
    }


    private  void createUserMobile(){
        String mobile= edittxtMobile.getText().toString().trim();
        if (mobile.length()!=10){
            Toast.makeText(SignIn.this, "Enter a valid Mobile Number", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent= new Intent(getApplicationContext(),MainActivity.class);
            SharedPreferences.Editor editor= sharedPreferences.edit();
            editor.putString("Number", mobile);
            editor.commit();
            startActivity(intent);
            finish();
        }
    }
}