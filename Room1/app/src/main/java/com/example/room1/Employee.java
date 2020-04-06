package com.example.room1;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "Employee_Table")
public class Employee extends ArrayList<Employee> {


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

    public Employee(String phone, String name, String address)
    {
        //this.id = id;
        this.name = name;
        this.address = address;
        this.phone=phone;
    }
    public String getPhone(){return this.phone;}
    public String getAddress() {
        return this.address;
    }
    public String getName() { return this.name; }
    public int getEmpId() {
        return empId;
    }
    /*  public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }*/

  /*  public void setName(String name) {this.name = name;}

    public void setPhone(String phone){this.phone=phone;}

     public void setAddress(String address) {this.address = address;}*/


}