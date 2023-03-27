package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeJpaService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class EmployeeController{
    @Autowired
    private EmployeeJpaService employeeJpaService;

    @GetMapping("/employees")
    public ArrayList<Employee> getEmployees(){
        return employeeJpaService.getEmployees();
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeJpaService.addEmployee(employee);
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        return employeeJpaService.getEmployee(employeeId);
    }

    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable("employeeId") int employeeId, @RequestBody Employee employee){
        return employeeJpaService.updateEmployee(employeeId, employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId){
        employeeJpaService.deleteEmployee(employeeId);
    }
}