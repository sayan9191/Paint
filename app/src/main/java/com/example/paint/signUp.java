package com.example.paint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signUp extends AppCompatActivity {
    Button btnBack,btnSkip1;
    TextView btnSignUP,btnSignIN;
    EditText edtxtFName,edtxtLName,edittxtMobileNo,edtxtEmail,edtxtGender;
    boolean isEmailValid= false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btnBack= findViewById(R.id.btnBack);
        btnSkip1= findViewById(R.id.btnSkip1);
        btnSignUP= findViewById(R.id.btnSignUP);
        btnSignIN= findViewById(R.id.btnSignIN);
        //
        edtxtFName= findViewById(R.id.edtxtFName);
        edtxtLName= findViewById(R.id.edtxtLName);
        edittxtMobileNo= findViewById(R.id.edittxtMobileNo);
        edtxtEmail= findViewById(R.id.edtxtEmail);
        edtxtGender= findViewById(R.id.edtxtGender);
        //
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        edtxtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().matches(emailPattern) && editable.length()>0){
                    isEmailValid= true;

                }
                else{
                    edtxtEmail.requestFocus();
                    isEmailValid=false;
                }
            }
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

        });



        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),SignIn.class);
                startActivity(intent);
            }
        });

        btnSkip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        btnSignUP.setOnClickListener(view ->{
            createUser();
        });

        btnSignIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),SignIn.class);
                startActivity(intent);
            }
        });
    }

    private void createUser(){
        String fName=edtxtFName.getText().toString();
        String LName=edtxtLName.getText().toString();
        String Mobile=edittxtMobileNo.getText().toString();
        String Email=edtxtEmail.getText().toString();
        String Gender=edtxtGender.getText().toString();



        if (TextUtils.isEmpty(fName)){
            Toast.makeText(this, "Enter First Name", Toast.LENGTH_SHORT).show();
            edtxtFName.requestFocus();
        }
        else if (TextUtils.isEmpty(LName)){
            Toast.makeText(this, "Enter Last Name", Toast.LENGTH_SHORT).show();
            edtxtLName.requestFocus();
        }
        else if (Mobile.length()!=18){
            Toast.makeText(this, "Enter Valid Mobile No.", Toast.LENGTH_SHORT).show();
            edittxtMobileNo.requestFocus();
        }
        else if (!isEmailValid){
            Toast.makeText(this, "Enter Valid Email Id", Toast.LENGTH_SHORT).show();
            edtxtEmail.requestFocus();
        }
        else if (TextUtils.isEmpty(Gender)){
            Toast.makeText(this, "Enter Gender", Toast.LENGTH_SHORT).show();
            edtxtGender.requestFocus();
        }
        else{
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            intent.putExtra("key1",fName);
            intent.putExtra("key2",Mobile);
            intent.putExtra("key3",Email);
            intent.putExtra("key5",Gender);
            startActivity(intent);
        }
    }

}