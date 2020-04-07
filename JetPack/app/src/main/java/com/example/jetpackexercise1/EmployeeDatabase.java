package com.example.jetpackexercise1;


import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Employee.class}, version = 2,exportSchema = false)
public abstract class EmployeeDatabase extends RoomDatabase
{
    public abstract EmployeeDao employeeDAO();
    private static EmployeeDatabase databaseInstance;
    static EmployeeDatabase getDatabase(final Context context)
    {
        if (databaseInstance == null)
        {
            synchronized (EmployeeDatabase.class)
            {
                if (databaseInstance == null)
                {
                    databaseInstance = Room.databaseBuilder(context.getApplicationContext() ,
                            EmployeeDatabase.class ,
                            "Employee_Database")
                            .fallbackToDestructiveMigration()
                            .addCallback(sEmpCallback)
                            .build();
                }
            }
        }
        return databaseInstance;
    }
    private static RoomDatabase.Callback sEmpCallback = new RoomDatabase.Callback(){  @Override
    public void onOpen (@NonNull SupportSQLiteDatabase db){
        super.onOpen(db);
       // new PopulateDbAsync(databaseInstance).execute();
    }
    };

  /*  private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final EmployeeDao mDao;
        //String[] words = {"dolphin", "crocodile", "cobra"};
        PopulateDbAsync(EmployeeDatabase db) {
            mDao = db.employeeDAO();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate the database
            // when it is first created
            Employee e1 = new Employee("AMAN","Aman","aman@aman.com");
            Employee e2 = new Employee("123406789","Naman","naman@naman.com");
            Employee e3 = new Employee("123056789","Lakshman","lakshman@lakshman.com");

            //  mDao.deleteAllEmployee();
            mDao.insert(e2);
            mDao.insert(e3);
            //for (int i = 0; i <3; i++) {
            //Word word = new Word(words[i]);
            mDao.insert(e1);
            //}
            return null;
        }
    }*/

}
