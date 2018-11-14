package com.thoughtworks.learnr.controllers;

import com.thoughtworks.learnr.models.Employee;
import com.thoughtworks.learnr.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

//@CrossOrigin(origins = "http://example.com", maxAge = 3600)
//origins = "http://example.com", maxAge = 3600)
@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getAllUsers() {
        return employeeService.getAllEmployees();
    }

    @RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
    @ResponseBody
  //  @CrossOrigin(origins = "http://localhost:3004")
    public Employee getEmployee(@PathVariable("employeeId") String employeeId){
        return employeeService.getEmployee(employeeId);
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity addItem(@Valid @RequestBody Employee employee )
    {
        employeeService.addEmployee(employee);
        return new ResponseEntity( employee.getId(), HttpStatus.CREATED );
    }


//    @RequestMapping(method = RequestMethod.GET)
//    @CrossOrigin(origins = "http://localhost:3004")
//    @ResponseBody
//    public Employee get() {
//        Employee employee = new Employee();
//        employee.setId("123");
//
//
//        return employee;
//    }
}
