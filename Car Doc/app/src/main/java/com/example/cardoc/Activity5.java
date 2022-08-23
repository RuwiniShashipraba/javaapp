package com.example.cardoc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity5 extends AppCompatActivity {
    Button sign_btn;
    EditText signName,telnum,add,email,useNa,pass,conPa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);
        sign_btn = findViewById(R.id.submit_app);
        signName = findViewById(R.id.UserName_app);
        telnum = findViewById(R.id.phone_app);
        add = findViewById(R.id.address_app);
        email = findViewById(R.id.email_app);
        useNa = findViewById(R.id.use_app);
        pass = findViewById(R.id.pass_app);
        conPa = findViewById(R.id.conPass_app);

        sign_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = signName.getText().toString();
                String telnum1 = telnum.getText().toString();
                String adds = add.getText().toString();
                String emails = email.getText().toString();
                String usena = useNa.getText().toString();
                String psaaw = pass.getText().toString();
                String cpassw = conPa.getText().toString();


                boolean check = validation(name, telnum1, adds, emails, usena, psaaw, cpassw);
                if (check == true) {
                    Toast.makeText(getApplicationContext(), "Data is valid", Toast.LENGTH_SHORT).show();
                    openActivity4();
                } else {
                    Toast.makeText(getApplicationContext(), "Sorry", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private boolean validation(String name, String telnum1, String adds, String emails, String usena, String psaaw, String cpassw) {
        if (name.length() == 0) {
            signName.requestFocus();
            signName.setError("Please Input Your Name.");
            return false;
        } else if (!name.matches("[a-zA-z]+")) {
            signName.requestFocus();
            signName.setError("Please Fill Correctly");
            return false;
        } else if (telnum1.length() == 0) {
            telnum.requestFocus();
            telnum.setError("Please Input Your Telephone Number.");
            return false;
        }
        else if (!(telnum1.length() == 10)) {
            telnum.requestFocus();
            telnum.setError("Please Input a valid Telephone Number.");
            return false;
        }
        else if (!telnum1.matches("[0-9]+")) {
            telnum.requestFocus();
            telnum.setError("Please Fill Correctly");
            return false;
        } else if (adds.length() == 0) {
            add.requestFocus();
            add.setError("Please Input Your Address.");
            return false;
        } else if (!adds.matches("[a-zA-z0-9,-]+")) {
            add.requestFocus();
            add.setError("Please Fill Correctly");
            return false;
        } else if (emails.length() == 0) {
            email.requestFocus();
            email.setError("Please Input Your email.");
            return false;
        } else if (!emails.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")) {
            email.requestFocus();
            email.setError("Please Fill Correctly");
            return false;
        } else if (usena.length() == 0) {
            useNa.requestFocus();
            useNa.setError("Please Input User Name.");
            return false;
        } else if (!usena.matches("[a-zA-Z]+")) {
            useNa.requestFocus();
            useNa.setError("Please Fill Correctly");
            return false;
        } else if (psaaw.length() <= 4) {
            pass.requestFocus();
            pass.setError("Please Input a valid password with minimum 4 characters.");
            return false;
        } else if ((cpassw.length() <= 4)) {
            conPa.requestFocus();
            conPa.setError("Please check again");
            return false;
        } else {
            return true;

        }
    }
    public void openActivity4(){
        Intent intent = new Intent(this, Activity4.class);
        startActivity(intent);
    }
}