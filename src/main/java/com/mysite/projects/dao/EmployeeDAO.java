package com.mysite.projects.dao;

import com.mysite.projects.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    int createEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(int id);
    List<Employee> getAllEmployees();

//    List<Employee> getAllEmployees(String employeeName);
//    List<Employee> getAllEmployees(int employeeAge);
//    List<Employee> getAllEmployees(Boolean employeeAdmin);

    List<Employee> getAllEmployees(String employeeName, Integer employeeAge, Boolean employeeAdmin);

    Employee getEmployee(int id);
}
