package bitm.faravy.sqlitedatabasemad28;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import bitm.faravy.sqlitedatabasemad28.Database.Employee;

/**
 * Created by BITM Trainer 601 on 12/18/2017.
 */

public class EmployeeAdapter extends ArrayAdapter<Employee>{
    private Context context;
    private ArrayList<Employee>employees;
    public EmployeeAdapter(@NonNull Context context, ArrayList<Employee>employees) {
        super(context, R.layout.employee_row,employees);
        this.context = context;
        this.employees = employees;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.employee_row,parent,false);
        TextView nameTv = convertView.findViewById(R.id.nameValue);
        TextView desgTv = convertView.findViewById(R.id.desgValue);
        nameTv.setText(employees.get(position).getEmployeeName());
        desgTv.setText(employees.get(position).getEmployeeDesignation());
        return convertView;
    }
}
