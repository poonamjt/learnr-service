package com.thoughtworks.learnr.services;

import com.thoughtworks.learnr.models.Employee;
import com.thoughtworks.learnr.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployee( String id ) {
        return employeeRepository.findById(id)
                .orElseThrow( RuntimeException::new);
    }

    public void addEmployee(Employee employee) {
        employeeRepository.insert(employee);
    }
}

