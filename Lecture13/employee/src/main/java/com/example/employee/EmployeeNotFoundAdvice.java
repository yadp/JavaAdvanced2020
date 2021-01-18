package com.example.employee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class EmployeeNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String employeeNotFound(
            EmployeeNotFoundException ex) {
        return ex.getMessage();
    }
}
