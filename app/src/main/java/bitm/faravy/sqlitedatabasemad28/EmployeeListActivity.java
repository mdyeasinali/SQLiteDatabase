package bitm.faravy.sqlitedatabasemad28;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import bitm.faravy.sqlitedatabasemad28.Database.Employee;
import bitm.faravy.sqlitedatabasemad28.Database.EmployeeDatabaseSource;

public class EmployeeListActivity extends AppCompatActivity {

    private ListView listView;
    private EmployeeAdapter employeeAdapter;
    private EmployeeDatabaseSource source;
    private ArrayList<Employee>employees = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);

        listView = findViewById(R.id.empListView);
        source = new EmployeeDatabaseSource(this);
        employees = source.getAllEmployees();
        employeeAdapter = new EmployeeAdapter(this,employees);
        listView.setAdapter(employeeAdapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                int empId = employees.get(position).getEmpId();
                source.deleteEmployee(empId);
                reloadActivity();
                return false;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Employee employee = employees.get(position);
                int empId = employee.getEmpId();
                startActivity(new Intent(EmployeeListActivity.this,
                        MainActivity.class).putExtra("id",empId));
            }
        });

    }

    private void reloadActivity() {
        startActivity(new Intent(this,EmployeeListActivity.class));
    }
}
