package bitm.faravy.sqlitedatabasemad28.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by BITM Trainer 601 on 12/18/2017.
 */

public class EmployeeDatabaseSource {
    private EmployeeDatabaseHelper helper;
    private SQLiteDatabase db;

    public EmployeeDatabaseSource(Context context) {
        helper = new EmployeeDatabaseHelper(context);
    }
    public void open(){
        db = helper.getWritableDatabase();
    }
    public void close(){
        db.close();
    }

    public boolean insertEmployee(Employee employee){
        this.open();
        ContentValues values = new ContentValues();
        values.put(EmployeeDatabaseHelper.EMP_COL_NAME,employee.getEmployeeName());
        values.put(EmployeeDatabaseHelper.EMP_COL_DESIGNATION,employee.getEmployeeDesignation());
        long insertedRow = db.insert(EmployeeDatabaseHelper.TABLE_EMPLOYEE,null,values);
        this.close();
        if(insertedRow > 0){
            return true;
        }else{
            return false;
        }
    }
    public ArrayList<Employee>getAllEmployees(){
        this.open();
        ArrayList<Employee>employees = new ArrayList<>();
        Cursor cursor = db.query(EmployeeDatabaseHelper.TABLE_EMPLOYEE,null,null,null,null,null,null);
        if(cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                int id = cursor.getInt(cursor.getColumnIndex(EmployeeDatabaseHelper.EMP_COL_ID));
                String name = cursor.getString(cursor.getColumnIndex(EmployeeDatabaseHelper.EMP_COL_NAME));
                String desg = cursor.getString(cursor.getColumnIndex(EmployeeDatabaseHelper.EMP_COL_DESIGNATION));
                employees.add(new Employee(id,name,desg));
            }while (cursor.moveToNext());
        }
        cursor.close();
        this.close();
        return employees;
    }
    public boolean deleteEmployee(int id){
        this.open();
        int deletedRow = db.delete(EmployeeDatabaseHelper.TABLE_EMPLOYEE,
                EmployeeDatabaseHelper.EMP_COL_ID+"="+id,null);
        if(deletedRow > 0){
            return true;
        }else{
            return false;
        }
    }
    public Employee getEmployeeById(int id){
        this.open();
        Employee employee = null;
        Cursor cursor = db.query(EmployeeDatabaseHelper.TABLE_EMPLOYEE,
                null,
                EmployeeDatabaseHelper.EMP_COL_ID+"="+id,
                null,
                null,null,null);
        if(cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            int empid = cursor.getInt(cursor.getColumnIndex(EmployeeDatabaseHelper.EMP_COL_ID));
            String name = cursor.getString(cursor.getColumnIndex(EmployeeDatabaseHelper.EMP_COL_NAME));
            String desg = cursor.getString(cursor.getColumnIndex(EmployeeDatabaseHelper.EMP_COL_DESIGNATION));
            employee = new Employee(empid,name,desg);
        }
        this.close();
        return employee;
    }
    public boolean updateEmployee(Employee employee){
        this.open();
        ContentValues values = new ContentValues();
        values.put(EmployeeDatabaseHelper.EMP_COL_NAME,employee.getEmployeeName());
        values.put(EmployeeDatabaseHelper.EMP_COL_DESIGNATION,employee.getEmployeeDesignation());
        int updatedRow = db.update(EmployeeDatabaseHelper.TABLE_EMPLOYEE,
                values,
                EmployeeDatabaseHelper.EMP_COL_ID+"="+employee.getEmpId(),
                null);
        if(updatedRow > 0){
            return true;
        }else{
            return false;
        }
    }

}
