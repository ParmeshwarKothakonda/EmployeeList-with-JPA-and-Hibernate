package com.example.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.employee.model.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeJpaRepository extends JpaRepository<Employee,Integer>{

}