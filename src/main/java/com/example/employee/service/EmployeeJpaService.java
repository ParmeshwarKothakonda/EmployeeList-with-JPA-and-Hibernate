package com.example.employee.service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.repository.EmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.*;

@Service
public class EmployeeJpaService implements EmployeeRepository{

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;


    @Override
    public ArrayList<Employee> getEmployees(){
        List<Employee> employeeList = employeeJpaRepository.findAll();
        ArrayList<Employee> employees = new ArrayList<>(employeeList);

        return employees;
    }

    @Override
    public Employee addEmployee(Employee employee){
        try{
            employeeJpaRepository.save(employee);
            return employee;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Employee getEmployee(int employeeId){
        try{
            Employee requestedEmployee = employeeJpaRepository.findById(employeeId).get();
            return requestedEmployee;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public Employee updateEmployee(int employeeId, Employee employee){
        try{
            Employee existingEmployee = employeeJpaRepository.findById(employeeId).get();

            if(employee.getEmployeeName() != null){
                existingEmployee.setEmployeeName(employee.getEmployeeName());
            }

            if(employee.getEmail() != null){
                existingEmployee.setEmail(employee.getEmail());
            }

            if(employee.getDepartment() != null){
                existingEmployee.setDepartment(employee.getDepartment());
            }

            employeeJpaRepository.save(existingEmployee);
            
            return existingEmployee;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }


    @Override
    public void deleteEmployee(int employeeId){
        try{
            employeeJpaRepository.deleteById(employeeId);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }
}