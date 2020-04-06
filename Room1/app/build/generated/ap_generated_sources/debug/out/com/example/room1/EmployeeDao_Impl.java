package com.example.room1;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.lifecycle.ComputableLiveData;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.InvalidationTracker.Observer;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unchecked")
public final class EmployeeDao_Impl implements EmployeeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfEmployee;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfEmployee;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllEmployee;

  public EmployeeDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEmployee = new EntityInsertionAdapter<Employee>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Employee_Table`(`employee_id`,`name`,`phone`,`Address`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Employee value) {
        stmt.bindLong(1, value.getEmpId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getPhone() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPhone());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAddress());
        }
      }
    };
    this.__updateAdapterOfEmployee = new EntityDeletionOrUpdateAdapter<Employee>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Employee_Table` SET `employee_id` = ?,`name` = ?,`phone` = ?,`Address` = ? WHERE `employee_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Employee value) {
        stmt.bindLong(1, value.getEmpId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getPhone() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPhone());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAddress());
        }
        stmt.bindLong(5, value.getEmpId());
      }
    };
    this.__preparedStmtOfDeleteAllEmployee = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Employee_Table ";
        return _query;
      }
    };
  }

  @Override
  public void insert(Employee emp) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfEmployee.insert(emp);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateEmployee(Employee emp) {
    __db.beginTransaction();
    try {
      __updateAdapterOfEmployee.handleMultiple(emp);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllEmployee() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllEmployee.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllEmployee.release(_stmt);
    }
  }

  @Override
  public LiveData<List<Employee>> getAllEmployee() {
    final String _sql = "SELECT * FROM Employee_Table ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<Employee>>(__db.getQueryExecutor()) {
      private Observer _observer;

      @Override
      protected List<Employee> compute() {
        if (_observer == null) {
          _observer = new Observer("Employee_Table") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfEmpId = _cursor.getColumnIndexOrThrow("employee_id");
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
          final int _cursorIndexOfPhone = _cursor.getColumnIndexOrThrow("phone");
          final int _cursorIndexOfAddress = _cursor.getColumnIndexOrThrow("Address");
          final List<Employee> _result = new ArrayList<Employee>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Employee _item;
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpPhone;
            _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            final String _tmpAddress;
            _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            _item = new Employee(_tmpPhone,_tmpName,_tmpAddress);
            final int _tmpEmpId;
            _tmpEmpId = _cursor.getInt(_cursorIndexOfEmpId);
            _item.setEmpId(_tmpEmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }
}
