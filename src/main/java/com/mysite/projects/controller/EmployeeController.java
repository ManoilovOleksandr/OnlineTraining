package com.mysite.projects.controller;

import com.mysite.projects.entity.Employee;
import com.mysite.projects.service.EmployeeService;
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

    public EmployeeController() {
    }

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("createEmployee")
    public ModelAndView createEmployee(@ModelAttribute Employee employee) {
        return new ModelAndView("employeeForm");
    }

    @RequestMapping("editEmployee")
    public ModelAndView editEmployee(@RequestParam int id, @ModelAttribute Employee employee) {
        employee = employeeService.getEmployee(id);
        return new ModelAndView("employeeFormUpdate", "employeeObject", employee);
    }

    @RequestMapping("saveEmployee")
    public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
        if (employee.getId() == 0) {
            employeeService.createEmployee(employee);
        } else {
            employeeService.updateEmployee(employee);
        }
        return new ModelAndView("redirect:getAllEmployees");
    }

    @RequestMapping("deleteEmployee")
    public ModelAndView deleteEmployee(@RequestParam int id) {
        employeeService.deleteEmployee(id);
        return new ModelAndView("redirect:getAllEmployees");
    }

    @RequestMapping(value = {"getAllEmployees", "/"})
    public ModelAndView getAllEmployees(@RequestParam(required = false) Integer page) {
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
    public ModelAndView searchEmployee(@RequestParam(value = "searchName") String searchName,
                                       @RequestParam(value = "searchAge") Integer searchAge,
                                       @RequestParam(value = "searchIsAdmin") Boolean searchIsAdmin,
                                       @RequestParam(required = false) Integer page) {

        ModelAndView modelAndView = new ModelAndView("searchEmployee");
        List<Employee> employeeList = employeeService.getAllEmployees(searchName, searchAge, searchIsAdmin);
        PagedListHolder<Employee> pagedListHolder = new PagedListHolder<>(employeeList);
        pagedListHolder.setPageSize(10);
        modelAndView.addObject("maxPages", pagedListHolder.getPageCount());

        if (page == null || page < 1 || page > pagedListHolder.getPageCount()) page = 1;

        modelAndView.addObject("page", page);
        if (page == null || page < 1 || page > pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(0);
            modelAndView.addObject("employeeList", pagedListHolder.getPageList());
            modelAndView.addObject("searchName", searchName);
            modelAndView.addObject("searchAge", searchAge);
            modelAndView.addObject("searchIsAdmin", searchIsAdmin);
        } else if (page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page - 1);
            modelAndView.addObject("employeeList", pagedListHolder.getPageList());
            modelAndView.addObject("searchName", searchName);
            modelAndView.addObject("searchAge", searchAge);
            modelAndView.addObject("searchIsAdmin", searchIsAdmin);
        }
        return modelAndView;
    }
}