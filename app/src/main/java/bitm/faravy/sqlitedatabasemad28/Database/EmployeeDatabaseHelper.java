package bitm.faravy.sqlitedatabasemad28.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by BITM Trainer 601 on 12/18/2017.
 */

public class EmployeeDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "employee_db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_EMPLOYEE = "tbl_employee";
    public static final String EMP_COL_ID = "emp_id";
    public static final String EMP_COL_NAME = "emp_name";
    public static final String EMP_COL_DESIGNATION = "emp_designation";

    public static final String CREATE_TABLE_EMPLOYEE = "CREATE TABLE "+TABLE_EMPLOYEE+"("+
            EMP_COL_ID+" INTEGER PRIMARY KEY, "+
            EMP_COL_NAME+" TEXT, "+
            EMP_COL_DESIGNATION+" TEXT);";

    public EmployeeDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_EMPLOYEE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_EMPLOYEE);
        onCreate(db);
    }
}
