package com.example.employee;

public class EmployeeNotFoundException
        extends RuntimeException{
    public EmployeeNotFoundException(Long id){
        super("Employee not found " + id);
    }
}
