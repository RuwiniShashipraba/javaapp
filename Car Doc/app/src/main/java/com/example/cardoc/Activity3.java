package com.example.cardoc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Activity3 extends AppCompatActivity {
    Button sub_btn,next_but;
    EditText OwnerName,type,millage,year,phone,model,address;
    ListView show;
    ArrayList<String> addArray;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        sub_btn = findViewById(R.id.submit_app);
        next_but = findViewById(R.id.next);
        OwnerName = findViewById(R.id.OwnerName_app);
        type = findViewById(R.id.type_app);
        millage = findViewById(R.id.millage_app);
        year = findViewById(R.id.year_app);
        phone = findViewById(R.id.phone_app);
        model = findViewById(R.id.model_app);
        address = findViewById(R.id.address_app);
        addArray = new ArrayList<>();
        show=findViewById(R.id.list_view);


        sub_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = OwnerName.getText().toString();
                String type1 = type.getText().toString();
                String mill= millage.getText().toString();
                String year1 = year.getText().toString();
                String tel = phone.getText().toString();
                String mode = model.getText().toString();
                String add = address.getText().toString();


                boolean check = validation(name,type1,mill,year1,tel,mode,add);
                if (check == true) {

                    Toast.makeText(getApplicationContext(), "Data is valid", Toast.LENGTH_SHORT).show();
                    //openActivity4();

                } else {
                    Toast.makeText(getApplicationContext(), "Sorry", Toast.LENGTH_SHORT).show();
                }
            }
        });
        next_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = OwnerName.getText().toString();
                String type1 = type.getText().toString();
                String mill= millage.getText().toString();
                String year1 = year.getText().toString();
                String tel = phone.getText().toString();
                String mode = model.getText().toString();
                String add = address.getText().toString();


                boolean check = validation(name,type1,mill,year1,tel,mode,add);
                if (check == true) {

                    Toast.makeText(getApplicationContext(), "Data is valid", Toast.LENGTH_SHORT).show();
                    openActivity4();

                } else {
                    Toast.makeText(getApplicationContext(), "Sorry", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private boolean validation(String name,String type1,String mill,String year1,String tel,String mode,String add) {
        if(name.length()==0){
            OwnerName.requestFocus();
            OwnerName.setError("Please Input Your User Name.");
            return false;
        }
        else if(!name.matches("[a-zA-z]+")){
            OwnerName.requestFocus();
            OwnerName.setError("Please Fill Correctly");
            return false;
        }
        else if(mode.length()==0){
            model.requestFocus();
            model.setError("Please Input Car Model.");
            return false;
        }
        else if(!(mode.matches("[a-zA-z]+"))){
            model.requestFocus();
            model.setError("Please Fill Correctly");
            return false;
        }
        else if(mill.length()==0){
            millage.requestFocus();
            millage.setError("Please Input the Millage.");
            return false;
        }
        else if(!mill.matches("[0-9]+")){
            millage.requestFocus();
            millage.setError("Please Fill Correctly");
            return false;
        }
        else if(year1.length()==0){
            year.requestFocus();
            year.setError("Please Input the car reg year.");
            return false;
        }
        else if(!year1.matches("[0-9]+")){
            year.requestFocus();
            year.setError("Please Fill Correctly");
            return false;
        }
        else if(type1.length()==0){
            type.requestFocus();
            type.setError("Please Input Gear Type.");
            return false;
        }
        else if(!type1.matches("[a-zA-z]+")){
            type.requestFocus();
            type.setError("Please Fill Correctly");
            return false;
        }

        else if(!(tel.length()==10)){
            phone.requestFocus();
            phone.setError("Please Input Your tel number.");
            return false;
        }
        else if(!tel.matches("[0-9]+")){
            phone.requestFocus();
            phone.setError("Please Fill Correctly");
            return false;
        }

        else if(add.length()==0){
            address.requestFocus();
            address.setError("Please Input Your address.");
            return false;
        }
        else if(!add.matches("[a-zA-z]+")){
            address.requestFocus();
            address.setError("Please Fill Correctly");
            return false;
        }


        else{
            addArray.add(mode);
            addArray.add(type1);
            addArray.add(year1);
            addArray.add(name);
            ArrayAdapter<String> adapter= new ArrayAdapter<String>(Activity3.this, android.R.layout.simple_list_item_1,addArray);
            show.setAdapter(adapter);
            //((TextView)findViewById(R.id.model_app)).setText(" ");
            //((TextView)findViewById(R.id.type_app)).setText(" ");
            //((TextView)findViewById(R.id.year_app)).setText(" ");
            //((TextView)findViewById(R.id.OwnerName_app)).setText(" ");
            return true;

        }


    }
    public void openActivity4(){
        Intent intent = new Intent(this, Activity4.class);
        startActivity(intent);
    }


}