package com.mysite.projects.service;

import com.mysite.projects.entity.Employee;

import java.util.List;

public interface EmployeeService {
    int createEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(int id);

    List<Employee> getAllEmployees();

    List<Employee> getAllEmployees(String employeeName, Integer employeeAge, Boolean employeeAdmin);

    Employee getEmployee(int id);
}
