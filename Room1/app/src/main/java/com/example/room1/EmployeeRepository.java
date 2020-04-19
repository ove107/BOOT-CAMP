package com.example.room1;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class EmployeeRepository {
    private EmployeeDao mEmployeeDao;
    private LiveData<List<Employee>> mAllEmployee;

    EmployeeRepository(Application application){
        EmployeeDatabase db = EmployeeDatabase.getDatabase(application);
        mEmployeeDao = db.employeeDAO();
        mAllEmployee = mEmployeeDao.getAllEmployee();
    }
    LiveData<List<Employee>> getAllEmployee(){return mAllEmployee;}

    public void insert(Employee emp ){new insertAsyncTask(mEmployeeDao).execute(emp);}

    private static class insertAsyncTask extends AsyncTask<Employee,Void,Void>{
        private EmployeeDao mAsyncTaskDao;
        insertAsyncTask(EmployeeDao emp){ mAsyncTaskDao = emp;}

        @Override
        protected Void doInBackground(final Employee... employees) {
            mAsyncTaskDao.insert(employees[0]);
            return null;
        }
    }
}
