package com.example.employee;


import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final EmplyeModelAssembler emplyeModelAssembler;

    public EmployeeController(EmployeeRepository employeeRepository, EmplyeModelAssembler emplyeModelAssembler) {
        this.employeeRepository = employeeRepository;
        this.emplyeModelAssembler = emplyeModelAssembler;
    }


    /*
       GET /employees
       Get /employees/{id}
       POST /employees

       Delete /employees/{id}

       PUT /employees/{id}
     */

    @GetMapping("/employees")
    public List<Employee> all(){
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public EntityModel<Employee> one(@PathVariable Long id){

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(
                        () -> new EmployeeNotFoundException(id));

        return emplyeModelAssembler.toModel(employee);
    }

    @PostMapping("/employees")
    public Employee newEmployee(@RequestBody Employee employee){
       return employeeRepository.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void delete(@PathVariable Long id){
        employeeRepository.deleteById(id);
    }

    @PutMapping("/employees/{id}")
    public Employee editEmployee(@RequestBody Employee employee, @PathVariable Long id){
        return employeeRepository.findById(id)
                .map(loadEmployee -> {
                    loadEmployee.setName(employee.getName());
                    loadEmployee.setRole(employee.getRole());
                    return employeeRepository.save(loadEmployee);
                }).orElseGet(() -> {
                   return employeeRepository.save(employee);
                });
    }
}
