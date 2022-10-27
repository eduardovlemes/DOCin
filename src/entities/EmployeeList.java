package entities;

import persons.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {
    public static List<Employee> employees = new ArrayList<>();
    public static void addEmployee(Employee employee){
        employees.add(employee);
    }
    public static Employee returnEmployee (Integer idEmployee){
        return employees.get(idEmployee);
    }
    public static List<Employee> returnAllEmployees(){
        return employees;
    }
}
