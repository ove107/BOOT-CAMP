package com.example.jetpackexercise1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.jetpackexercise1.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AddEmployee.AddEmployeeListener {
private ActivityMainBinding binding;
private EmployeeAdapter employeeAdapter;
RelativeLayout relativeLayout;
    RandomColorGenerator mg;
    AddEmployee Add;
    List<Employee> employee;
    private EmployeeViewModel mEmployeeViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
       // getLifecycle().addObserver(new MainActivityObserver());

        mEmployeeViewModel = ViewModelProviders.of(this).get(EmployeeViewModel.class);
        mEmployeeViewModel.getAllEmployee().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(@Nullable final List<Employee> employees) {
                employeeAdapter.setEmpl(employees);
                employeeAdapter.notifyDataSetChanged();
            }
        });
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        binding.recyclerView.setHasFixedSize(true);
        employeeAdapter = new EmployeeAdapter(populate(),this);
        binding.recyclerView.setAdapter(employeeAdapter);

         mg = ViewModelProviders.of(this ).get(RandomColorGenerator.class);
        relativeLayout =(RelativeLayout) findViewById(R.id.mainlayout);
        mg.generated=true;
        relativeLayout.setBackgroundColor(mg.getColour());
        Add = new AddEmployee();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,Add).commit();
    }
    private List<Employee> populate(){
        employee =new ArrayList<>();
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
        mg.generated=false;
        relativeLayout.setBackgroundColor(mg.getColour());


    }

    @Override
    public void onImplementEmployeeListener(CharSequence name, CharSequence add, CharSequence email, CharSequence phone) {

    mEmployeeViewModel.insert(new Employee(name.toString(),add.toString(),email.toString(),phone.toString()));
    employeeAdapter.notifyDataSetChanged();
    }
}
