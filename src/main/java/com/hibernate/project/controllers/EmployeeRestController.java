package com.hibernate.project.controllers;

import com.hibernate.project.entities.Employee;
import com.hibernate.project.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeRestController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET, value = "/employee")
    public List<Employee> getAllEmployee()
    {
        return employeeService.getAllEmployee();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/employee/{employeeId}")
    public Employee getEmployee(@PathVariable Integer employeeId)
    {
        return employeeService.getEmployee(employeeId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/employee")
    public void addUpdateEmployee(@RequestBody Employee employee)
    {
        employeeService.addUpdateEmployee(employee);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/employee/{employeeId}")
    public void deleteEmployee(@PathVariable Integer employeeId)
    {
        employeeService.deleteEmployee(employeeId);
    }
}
