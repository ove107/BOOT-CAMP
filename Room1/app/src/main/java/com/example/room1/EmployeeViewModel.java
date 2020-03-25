package com.example.room1;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class EmployeeViewModel extends AndroidViewModel {
    private EmployeeRepository mRepository;
    private LiveData<List<Employee>> mAllEmployee;
    public EmployeeViewModel(@NonNull Application application) {
        super(application);
        mRepository = new EmployeeRepository(application);
        mAllEmployee = mRepository.getAllEmployee();
    }
    LiveData<List<Employee>> getAllEmployee(){
        return mAllEmployee;
    }
    public void insert(Employee emp){mRepository.insert(emp);}
}