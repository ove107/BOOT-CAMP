package com.example.jetpackexercise1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.jetpackexercise1.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
private EmployeeAdapter employeeAdapter;
RelativeLayout relativeLayout;
    RandomColorGenerator mg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        getLifecycle().addObserver(new MainActivityObserver());
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setHasFixedSize(true);
        employeeAdapter = new EmployeeAdapter(populate(),this);
        binding.recyclerView.setAdapter(employeeAdapter);
         mg = ViewModelProviders.of(this ).get(RandomColorGenerator.class);
        relativeLayout =(RelativeLayout) findViewById(R.id.mainlayout);
        relativeLayout.setBackgroundColor(mg.ColorGenerate());
    }
    private List<Employee> populate(){
        List<Employee> employee =new ArrayList<>();
        employee.add(new Employee("Jai","Ayodhya","ayodhya@sitaram.com","15234567"));
        employee.add(new Employee("Shri","Ayodhya","ayodhya@sitaram.com","15346786"));
        employee.add(new Employee("Ram","Ayodhya","ayodhya@sitaram.com","15075043"));
        employee.add(new Employee("Sita","Ayodhya","ayodhya@sitaram.com","15234567"));
        employee.add(new Employee("Shravan","Jharkhand","ayodhya@sitaram.com","15234567"));
        employee.add(new Employee("Babla","Kanpur","some@some.com","15234567"));
        employee.add(new Employee("Seth Ji","Kanpur","some@some.com","15234567"));
        employee.add(new Employee("Raju","Kanpur","some@some.com","15234567"));
        employee.add(new Employee("Shyam","Kanpur","some@some.com","15234567"));
        employee.add(new Employee("BabuRao","Kanpur","some@some.com","15234567"));

      //  EmployeeAdapter emma = new EmployeeAdapter(employee,this);

        return employee;
    }

    public void change(View view) {
        relativeLayout.setBackgroundColor(mg.ColorGenerate());

    }
}
