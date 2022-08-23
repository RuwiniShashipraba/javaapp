package com.example.cardoc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn, btn2;
    EditText userLog, passwordLog;



    private static final String TAG = "MainActivity";

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");
        ImageView firstImage = (ImageView) findViewById(R.id.firstImage);

        int imageResource = getResources().getIdentifier("@drawable/cars", null, this.getPackageName());
        firstImage.setImageResource(imageResource);

        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        userLog = findViewById(R.id.editUserName);
        passwordLog = findViewById(R.id.editPassword);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = userLog.getText().toString();
                String password = passwordLog.getText().toString();


                boolean check = validation(name, password);
                if (check == true) {
                    Toast.makeText(getApplicationContext(), "Data is valid", Toast.LENGTH_SHORT).show();
                    openActivity2();
                } else {
                    Toast.makeText(getApplicationContext(), "Sorry", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity5();

            }
        });



    }

    private boolean validation(String name, String password) {
        if(name.length()==0){
            userLog.requestFocus();
            userLog.setError("Please Input Your User Name.");
            return false;
        }
        else if(!name.matches("[a-zA-z]+")){
            userLog.requestFocus();
            userLog.setError("Please Fill Correctly");
            return false;
        }

        else if(password.length()<=4){
            passwordLog.requestFocus();
            passwordLog.setError("Please Input a valid password");
            return false;
        }
        else{
            return true;

        }


    }




    public void openActivity2(){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
    public void openActivity5(){
        Intent intent = new Intent(this, Activity5.class);
        startActivity(intent);
    }





    }