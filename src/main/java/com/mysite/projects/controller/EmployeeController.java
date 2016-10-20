package com.mysite.projects.controller;

import com.mysite.projects.entity.Employee;
import com.mysite.projects.service.EmployeeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class EmployeeController {

    private static final Logger logger = Logger.getLogger(EmployeeController.class);

    public EmployeeController() {
    }

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("createEmployee")
    public ModelAndView createEmployee(@ModelAttribute Employee employee) {
        logger.info("Creating Employee. Data: " + employee);
        return new ModelAndView("employeeForm");
    }

    @RequestMapping("editEmployee")
    public ModelAndView editEmployee(@RequestParam int id, @ModelAttribute Employee employee) {
        logger.info("Updating the Employee for the Id " + id);
        employee = employeeService.getEmployee(id);
        return new ModelAndView("employeeForm", "employeeObject", employee);
    }

    @RequestMapping("saveEmployee")
    public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
        logger.info("Saving the Employee. Data : " + employee);
        if (employee.getId() == 0) {
            employeeService.createEmployee(employee);
        } else {
            employeeService.updateEmployee(employee);
        }
        return new ModelAndView("redirect:getAllEmployees");
    }

    @RequestMapping("deleteEmployee")
    public ModelAndView deleteEmployee(@RequestParam int id) {
        logger.info("Deleting the Employee. Id : " + id);
        employeeService.deleteEmployee(id);
        return new ModelAndView("redirect:getAllEmployees");
    }

    @RequestMapping(value = {"getAllEmployees", "/"})
    public ModelAndView getAllEmployees(@RequestParam(required = false) Integer page) {
        logger.info("Getting the all Employees.");
        ModelAndView modelAndView = new ModelAndView("employeeList");

        List<Employee> employeeList = employeeService.getAllEmployees();
        PagedListHolder<Employee> pagedListHolder = new PagedListHolder<>(employeeList);
        pagedListHolder.setPageSize(10);
        modelAndView.addObject("maxPages", pagedListHolder.getPageCount());

        if (page == null || page < 1 || page > pagedListHolder.getPageCount()) page = 1;
        modelAndView.addObject("page", page);

        if (page == null || page < 1 || page > pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(0);
            modelAndView.addObject("employeeList", pagedListHolder.getPageList());
        } else if (page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page - 1);
            modelAndView.addObject("employeeList", pagedListHolder.getPageList());
        }
        return modelAndView;
    }

    @RequestMapping("searchEmployee")
    public ModelAndView searchEmployee(@RequestParam("searchName") String searchName, @RequestParam(required = false) Integer page) {
        logger.info("Searching the Employee. Employee Names: " + searchName);

        ModelAndView modelAndView = new ModelAndView("searchEmployeeListByName");

        List<Employee> employeeList = employeeService.getAllEmployees(searchName);
        PagedListHolder<Employee> pagedListHolder = new PagedListHolder<>(employeeList);
        pagedListHolder.setPageSize(10);
        modelAndView.addObject("maxPages", pagedListHolder.getPageCount());

        if (page == null || page < 1 || page > pagedListHolder.getPageCount()) page = 1;

        modelAndView.addObject("page", page);
        if (page == null || page < 1 || page > pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(0);
            modelAndView.addObject("employeeList", pagedListHolder.getPageList());
            modelAndView.addObject("searchName", searchName);
        } else if (page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page - 1);
            modelAndView.addObject("employeeList", pagedListHolder.getPageList());
            modelAndView.addObject("searchName", searchName);
        }
        return modelAndView;
    }

    @RequestMapping("searchEmployeeByAge")
    public ModelAndView searchEmployee(@RequestParam(value = "searchAge", defaultValue = "0") int searchAge, @RequestParam(required = false) Integer page) {
        logger.info("Searching the Employee. Employee Age: " + searchAge);

        ModelAndView modelAndView = new ModelAndView("searchEmployeeListByAge");

        List<Employee> employeeList = employeeService.getAllEmployees(searchAge);
        PagedListHolder<Employee> pagedListHolder = new PagedListHolder<>(employeeList);
        pagedListHolder.setPageSize(10);
        modelAndView.addObject("maxPages", pagedListHolder.getPageCount());

        if (page == null || page < 1 || page > pagedListHolder.getPageCount()) page = 1;

        modelAndView.addObject("page", page);
        if (page == null || page < 1 || page > pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(0);
            modelAndView.addObject("employeeList", pagedListHolder.getPageList());
            modelAndView.addObject("searchAge", searchAge);
        } else if (page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page - 1);
            modelAndView.addObject("employeeList", pagedListHolder.getPageList());
            modelAndView.addObject("searchAge", searchAge);
        }
        return modelAndView;

    }

    @RequestMapping("searchEmployeeByIsAdmin")
    public ModelAndView searchEmployee(@RequestParam(value = "searchIsAdmin", required = false) Boolean searchIsAdmin, @RequestParam(required = false) Integer page) {
        logger.info("Searching the Employee. Employee IsAdmin: " + searchIsAdmin);
        ModelAndView modelAndView = new ModelAndView("searchEmployeeListByIsAdmin");

        List<Employee> employeeList = employeeService.getAllEmployees(searchIsAdmin);
        PagedListHolder<Employee> pagedListHolder = new PagedListHolder<>(employeeList);
        pagedListHolder.setPageSize(10);
        modelAndView.addObject("maxPages", pagedListHolder.getPageCount());

        if (page == null || page < 1 || page > pagedListHolder.getPageCount()) page = 1;

        modelAndView.addObject("page", page);
        if (page == null || page < 1 || page > pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(0);
            modelAndView.addObject("employeeList", pagedListHolder.getPageList());
            modelAndView.addObject("searchIsAdmin", searchIsAdmin);
        } else if (page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page - 1);
            modelAndView.addObject("employeeList", pagedListHolder.getPageList());
            modelAndView.addObject("searchIsAdmin", searchIsAdmin);
        }
        return modelAndView;
    }

}