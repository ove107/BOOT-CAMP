package com.example.jetpackexercise1;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Employee_Table")
public class Employee{


    public void setEmpId(int empId) {
        this.empId = empId;
    }

    /* @ColumnInfo(name = "ID")

            @NonNull
            private int id;*/
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "employee_id")
    private int empId;



    @ColumnInfo(name="name")
    @NonNull
    private String name;

    @ColumnInfo(name="phone")
    @NonNull
    private String phone;

    @ColumnInfo(name="Address")
    @NonNull
    private String address;


    public String getEmail() {
        return email;
    }

    @ColumnInfo(name="Email")
    @NonNull
    private String email;

    public Employee(String name, String address, String email,String phone)
    {
        //this.id = id;
        this.name = name;
        this.address = address;
        this.phone=phone;
        this.email=email;
    }
    public String getPhone(){return this.phone;}
    public String getAddress() {
        return this.address;
    }
    public String getName() { return this.name; }
    public int getEmpId() {
        return empId;
    }

}