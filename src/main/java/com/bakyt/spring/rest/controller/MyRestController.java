package com.bakyt.spring.rest.controller;


import com.bakyt.spring.rest.entity.EmployeeNew;
import com.bakyt.spring.rest.exception_handling.NoSuchEmployeeException;
import com.bakyt.spring.rest.service.EmployeeNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private EmployeeNewService employeeService;

    @GetMapping("/employees")
    public List<EmployeeNew> showAllEmployees() {
        List<EmployeeNew> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }
    @GetMapping("/employees/{id}")
    public EmployeeNew getEmployee(@PathVariable int id) {
        EmployeeNew employee = employeeService.getEmployee(id);
        if(employee==null) {
            throw new NoSuchEmployeeException("There is no such employee with id " + id + "in database!");
        }
        return employee;
    }
    @PostMapping("/employees")
    public EmployeeNew addNewEmployee(@RequestBody EmployeeNew employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }
    @PutMapping("/employees")
    public EmployeeNew updateEmployee(@RequestBody EmployeeNew employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return "Employee with id " + id + " was deleted!";
    }
}