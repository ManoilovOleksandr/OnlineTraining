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
    public List<Employee> getAllEmployees(String employeeName, Integer employeeAge, Boolean employeeAdmin) {

        List<Employee> filtered = new ArrayList<>();

        //all null
        if (employeeAge == null && employeeAdmin == null && employeeName.equals("")) {
            return getAllEmployees();
        }
        //only employeeName
        if (employeeAge == null && employeeAdmin == null && !employeeName.equals("")) {
            for (Employee employee : getAllEmployees()) {
                if (employee.getName().toLowerCase().equals(employeeName.toLowerCase())) {
                    filtered.add(employee);
                }
            }
            //only employeeAge
        } else if (employeeAdmin == null && employeeName.equals("") && employeeAge != null) {
            for (Employee employee : getAllEmployees()) {
                if (employee.getAge() == employeeAge) {
                    filtered.add(employee);
                }
            }
            //only isAdmin
        } else if (employeeName.equals("") && employeeAge == null && employeeAdmin != null) {
            if (employeeAdmin == null) {
                filtered = getAllEmployees();
            }
            if (employeeAdmin == false) {
                for (Employee employee : getAllEmployees()) {
                    if (employee.getAdmin() == false) {
                        filtered.add(employee);
                    }
                }
            } else if (employeeAdmin) {
                for (Employee employee : getAllEmployees()) {
                    if (employee.getAdmin() == true) {
                        filtered.add(employee);
                    }
                }
            }
            //employeeName && employeeAge
        } else if (!employeeName.equals("") && employeeAge != null && employeeAdmin == null) {
            for (Employee employee : getAllEmployees()) {
                if (employee.getName().toLowerCase().equals(employeeName.toLowerCase()) && employee.getAge() == employeeAge) {
                    filtered.add(employee);
                }
            }
            //employeeName && employeeAdmin
        } else if (!employeeName.equals("") && employeeAge == null && employeeAdmin != null) {
            if (employeeAdmin == false) {
                for (Employee employee : getAllEmployees()) {
                    if (employee.getAdmin() == false && employee.getName().toLowerCase().equals(employeeName.toLowerCase())) {
                        filtered.add(employee);
                    }
                }
            } else if (employeeAdmin) {
                for (Employee employee : getAllEmployees()) {
                    if (employee.getAdmin() == true && employee.getName().toLowerCase().equals(employeeName.toLowerCase())) {
                        filtered.add(employee);
                    }
                }
            }
            // employeeAge && employeeAdmin
        } else if (employeeName.equals("") && employeeAge != null && employeeAdmin != null) {
            if (employeeAdmin == false) {
                for (Employee employee : getAllEmployees()) {
                    if (employee.getAdmin() == false && employee.getAge() == employeeAge) {
                        filtered.add(employee);
                    }
                }
            } else if (employeeAdmin) {
                for (Employee employee : getAllEmployees()) {
                    if (employee.getAdmin() == true && employee.getAge() == employeeAge) {
                        filtered.add(employee);
                    }
                }
            }
            // All exists
        } else if (!employeeName.equals("") && employeeAge != null && employeeAdmin != null) {
            if (employeeAdmin == false) {
                for (Employee employee : getAllEmployees()) {
                    if (employee.getAdmin() == false && employee.getAge() == employeeAge && employee.getName().toLowerCase().equals(employeeName.toLowerCase())) {
                        filtered.add(employee);
                    }
                }
            } else if (employeeAdmin) {
                for (Employee employee : getAllEmployees()) {
                    if (employee.getAdmin() == true && employee.getAge() == employeeAge && employee.getName().toLowerCase().equals(employeeName.toLowerCase())) {
                        filtered.add(employee);
                    }
                }
            }
        }
        return filtered;
    }

}
