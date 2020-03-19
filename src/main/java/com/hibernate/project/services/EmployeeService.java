package com.hibernate.project.services;

import com.hibernate.project.entities.Employee;
import com.hibernate.project.exceptions.EmployeeNotPresentException;
import com.hibernate.project.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(Integer Id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(Id);
        if (optionalEmployee.isPresent())
            return optionalEmployee.get();
        throw new EmployeeNotPresentException("Employee not present");
    }

    @Override
    public void addUpdateEmployee(Employee employee) {
        if (employee.getId() == null) {
            employeeRepository.save(employee);
        } else {
            Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getId());
            if (optionalEmployee.isPresent()) {
                Employee updateEmployee = optionalEmployee.get();
                updateEmployee.setFirstName(employee.getFirstName());
                updateEmployee.setLastName(employee.getLastName());
                updateEmployee.setEmail(employee.getEmail());
                employeeRepository.save(updateEmployee);
            }
            else
            {
                employeeRepository.save(employee);
            }
        }
    }

    @Override
    public void deleteEmployee(Integer Id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(Id);
        if (optionalEmployee.isPresent())
            employeeRepository.delete(optionalEmployee.get());
        else
            throw new EmployeeNotPresentException("Employee not present");
    }
}
