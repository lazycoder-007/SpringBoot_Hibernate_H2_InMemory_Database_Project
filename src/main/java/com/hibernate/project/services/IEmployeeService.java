package com.hibernate.project.services;

import com.hibernate.project.entities.Employee;

import java.util.List;

public interface IEmployeeService {

    List<Employee> getAllEmployee();

    Employee getEmployee(Integer id);

    void addUpdateEmployee(Employee employee);

    void deleteEmployee(Integer Id);
}
