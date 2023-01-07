package com.example.employeebookspring.controller;

import com.example.employeebookspring.model.Employee;
import com.example.employeebookspring.record.EmployeeRequest;
import com.example.employeebookspring.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employees")
    public Collection<Employee> GetAllEmployees() {
        return this.employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public void createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        this.employeeService.addEmployee(employeeRequest);

    }

    @GetMapping("/employees/salary/sum")
    public int getSalarySum() {
        return this.employeeService.getSalarySum();
    }


    @GetMapping("/employees/salary/max")
    public int getSaleryMax() {
        return this.employeeService.getSaleryMax();
    }

    @GetMapping("/employees/salary/min")
    public int getSaleryMin() {
        return this.employeeService.getSaleryMin();
    }

    @GetMapping("/employees/salary/average")
    public double getAverageSalary() {
        return this.employeeService.getAverageSalary();

    }
}

