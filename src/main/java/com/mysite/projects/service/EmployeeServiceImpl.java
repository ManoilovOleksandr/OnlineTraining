package com.mysite.projects.service;

import com.mysite.projects.dao.EmployeeDAO;
import com.mysite.projects.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    public EmployeeServiceImpl() {

    }

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public int createEmployee(Employee employee) {
        return employeeDAO.createEmployee(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeDAO.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    public List<Employee> getAllEmployees(String employeeName, Integer employeeAge, Boolean employeeAdmin) {
        return employeeDAO.getAllEmployees(employeeName, employeeAge, employeeAdmin);
    }
}
