package com.example.room1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerview;
    EmployeeAdapter adapter;
    Employee empl;
    final int START_ACTIVITY =1;
    private EmployeeViewModel mEmployeeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEmployeeViewModel = ViewModelProviders.of(this).get(EmployeeViewModel.class);
        mEmployeeViewModel.getAllEmployee().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(@Nullable final List<Employee> employees) {
                adapter.setEmp(employees);
                adapter.notifyDataSetChanged();
            }
        });
        recyclerview = findViewById(R.id.recycler_view);
        adapter= new EmployeeAdapter(this);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,CreateEmployee.class);
                startActivityForResult(i,START_ACTIVITY);
                

            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == START_ACTIVITY) {
            if(resultCode == Activity.RESULT_OK){
               // Word word = new Word(data.getStringExtra(NewWord.EXTRA_REPLY));
                empl = new Employee(data.getStringExtra("num"),data.getStringExtra("name"),data.getStringExtra("Add"));
            //  adapter.setEmp(empl);
                mEmployeeViewModel.insert(empl);
                adapter.notifyDataSetChanged();
                Toast.makeText(
                        getApplicationContext(),
                        "DATA SAVED",
                        Toast.LENGTH_LONG).show();

            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
                Toast.makeText(
                        getApplicationContext(),
                        "Not saved no data",
                        Toast.LENGTH_LONG).show();
            }
        }
    }//onAc

}
