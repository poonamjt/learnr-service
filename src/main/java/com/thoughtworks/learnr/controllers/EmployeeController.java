package com.thoughtworks.learnr.controllers;

import com.thoughtworks.learnr.models.Employee;
import com.thoughtworks.learnr.repositories.EmployeeRepository;
import com.thoughtworks.learnr.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    @RequestMapping(value = "", method = RequestMethod.GET)
//    @ResponseBody
//    public List<Employee> getAllUsers() {
//        return employeeService.getAllEmployees();
//    }

    @RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
    @ResponseBody
    public Employee getEmployee(@PathVariable("employeeId") String employeeId){
        return employeeService.getEmployee(employeeId);
    }


}
