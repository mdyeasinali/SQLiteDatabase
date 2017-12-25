package bitm.faravy.sqlitedatabasemad28.Database;

/**
 * Created by BITM Trainer 601 on 12/18/2017.
 */

public class Employee {
    private int empId;
    private String employeeName;
    private String employeeDesignation;

    public Employee(int empId, String employeeName, String employeeDesignation) {
        this.empId = empId;
        this.employeeName = employeeName;
        this.employeeDesignation = employeeDesignation;
    }

    public Employee(String employeeName, String employeeDesignation) {
        this.employeeName = employeeName;
        this.employeeDesignation = employeeDesignation;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeDesignation() {
        return employeeDesignation;
    }

    public void setEmployeeDesignation(String employeeDesignation) {
        this.employeeDesignation = employeeDesignation;
    }
}
