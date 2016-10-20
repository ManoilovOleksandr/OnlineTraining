package com.mysite.projects.dao;

import com.mysite.projects.entity.Employee;
import com.mysite.projects.utils.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    public EmployeeDAOImpl() {
    }

    @Autowired
    private HibernateUtil hibernateUtil;

    @Override
    public int createEmployee(Employee employee) {
        return (Integer) hibernateUtil.create(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee employeeFromDB = getEmployee(employee.getId());
        employeeFromDB.setAdmin(employee.getAdmin());
        employeeFromDB.setAge(employee.getAge());
        employeeFromDB.setName(employee.getName());
        return hibernateUtil.update(employeeFromDB);
    }

    @Override
    public void deleteEmployee(int id) {
        Employee employee = new Employee();
        employee.setId(id);
        hibernateUtil.delete(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return hibernateUtil.fetchAll(Employee.class);
    }

    @Override
    public Employee getEmployee(int id) {
        return hibernateUtil.fetchById(id, Employee.class);
    }

    @Override
    public List<Employee> getAllEmployees(String employeeName) {

        if (employeeName.length() == 0 || employeeName.equals("")){
            return getAllEmployees();
        }
        List<Employee> filtered = new ArrayList<>();
        for (Employee employee : getAllEmployees()) {
            if (employee.getName().toLowerCase().equals(employeeName.toLowerCase())){
                filtered.add(employee);
            }
        }
        return filtered;
    }

    @Override
    public List<Employee> getAllEmployees(int employeeAge) {
        if (employeeAge==0) return getAllEmployees();
        List<Employee> filtered = new ArrayList<>();
        for (Employee employee : getAllEmployees()) {
            if (employee.getAge() == employeeAge){
                filtered.add(employee);
            }
        }
        return filtered;
    }


    @Override
    public List<Employee> getAllEmployees(Boolean employeeAdmin) {

        List<Employee> filtered = new ArrayList<>();
        if (employeeAdmin == null || employeeAdmin == false) {
            for (Employee employee : getAllEmployees()) {
                if (employee.getAdmin() == null || employee.getAdmin() == false) {
                    filtered.add(employee);
                }
            }
        }else if (employeeAdmin) {
            for (Employee employee : getAllEmployees()) {
                if (employee.getAdmin() != null && employee.getAdmin() != false) {
                    filtered.add(employee);
                }
            }
        }
        return filtered;
    }
}
