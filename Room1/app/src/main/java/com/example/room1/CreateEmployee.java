package com.example.room1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class CreateEmployee extends AppCompatActivity {
    EditText name;
    EditText Add;
    EditText num;
    Button Adduser;
   // Employee emp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_employee);
    name = findViewById(R.id.name);
    Add = findViewById(R.id.Address);
    num = findViewById(R.id.phone);
    Adduser = findViewById(R.id.addu);
    Adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // emp = new Employee(num.getText().toString(),name.getText().toString(),Add.getText().toString());
                //Todo Add to database



                Intent i = new Intent();
             i.putExtra("name", name.getText().toString());
             i.putExtra("num",num.getText().toString());
             i.putExtra("Add",Add.getText().toString());
                setResult(Activity.RESULT_OK,i);
                finish();


            }
        });


    }

}
