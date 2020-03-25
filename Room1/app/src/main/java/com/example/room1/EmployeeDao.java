package com.example.room1;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
//order by name ASC
import java.util.List;

@Dao
public interface EmployeeDao
{
    @Insert
    void insertEmployee(Employee emp);

    @Update
    void updateEmployee(Employee emp);

    @Query("Delete from Employee_Table ")
    void deleteAllEmployee();

    @Query("Select * from Employee_Table ")
    LiveData<List<Employee>> getEmployeeList();
}