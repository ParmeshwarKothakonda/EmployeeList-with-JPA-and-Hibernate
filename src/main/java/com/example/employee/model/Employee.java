package com.example.employee.model;

import javax.persistence.*;


@Entity
@Table(name="employeelist")
public class Employee{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeid")
    private int employeeId;

    @Column(name = "employeename")
    private String employeeName;

    @Column(name = "email")
    private String email;

    @Column(name = "department")
    private String department;

    public Employee(int employeeId, String employeeName, String email, String department){
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.email = email;
        this.department = department;
    }

    Employee(){};
    public void setEmployeeId(int employeeId){
        this.employeeId = employeeId;
    }

    public int getEmployeeId(){ //GETTER
        return this.employeeId;
    }

    public void setEmployeeName(String employeeName){
        this.employeeName = employeeName;
    }

    public String getEmployeeName(){ //GETTER
        return this.employeeName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){ //GETTER
        return this.email;
    }

    public void setDepartment(String department){
        this.department = department;
    }

    public String getDepartment(){ //GETTER
        return this.department;
    }

    
}