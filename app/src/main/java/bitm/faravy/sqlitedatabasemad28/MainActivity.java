package bitm.faravy.sqlitedatabasemad28;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bitm.faravy.sqlitedatabasemad28.Database.Employee;
import bitm.faravy.sqlitedatabasemad28.Database.EmployeeDatabaseSource;

//SQLiteOpenHelper -->create database, table
//SQLiteDatabase -->CRUD --> insert,update,delete,query
//ContentValues -->insert, update
//Cursor -->put query data

public class MainActivity extends AppCompatActivity {
    private EmployeeDatabaseSource source;
    private int empId;
    private EditText nameET, designationET;
    private Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameET = findViewById(R.id.nameET);
        saveBtn = findViewById(R.id.saveBtn);
        designationET = findViewById(R.id.designationET);
        source = new EmployeeDatabaseSource(this);
        empId = getIntent().getIntExtra("id",0);
        if(empId > 0){
            Employee employee = source.getEmployeeById(empId);
            nameET.setText(employee.getEmployeeName());
            designationET.setText(employee.getEmployeeDesignation());
            saveBtn.setText("Update");
        }
    }

    public void saveEmployee(View view) {
        if(empId > 0){
            String name = ((EditText)findViewById(R.id.nameET)).getText().toString();
            String desg = ((EditText)findViewById(R.id.designationET)).getText().toString();
            Employee employee = new Employee(empId,name,desg);
            boolean status = source.updateEmployee(employee);
            if(status){
                Toast.makeText(this, "updated", Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(this, "failed to update", Toast.LENGTH_SHORT).show();
            }
        }else{
            String name = ((EditText)findViewById(R.id.nameET)).getText().toString();
            String desg = ((EditText)findViewById(R.id.designationET)).getText().toString();
            Employee employee = new Employee(name,desg);
            boolean status = source.insertEmployee(employee);
            if(status){
                Toast.makeText(this, "inserted", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "failed to insert", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void viewEmployee(View view) {
        startActivity(new Intent(MainActivity.this,EmployeeListActivity.class));
    }
}
