package com.example.employeebookspring.controller;

import com.example.employeebookspring.model.Employee;
import com.example.employeebookspring.service.DepartamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartamentController {
    private final DepartamentService departamentService;

    @Autowired
    public DepartamentController(DepartamentService departamentService) {
        this.departamentService = departamentService;
    }

    @GetMapping()
    public String getExistingDepartments() {
        return "Существующий департамент: " + departamentService.getExistingDepartments().toString();
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getEmployeesByDepartament() {
        return departamentService.getEmployeesByDepartament();
    }

    @GetMapping("/{id}/employees")
    public Collection<Employee> getEmployeesFromDepartment(@PathVariable("id") int departamentId) {
        return departamentService.getEmployeesFromDepartment(departamentId);
    }

    @GetMapping("/{id}/salary/sum")
    public int getSalarySumOfDepartament(@PathVariable("id") int departamentId) {
        return departamentService.getSalarySumOfDepartament(departamentId);
    }

    @GetMapping("/{id}/salary/min")
    public int getMinSalaryOfDepartament(@PathVariable("id") int departamentId) {
        return departamentService.getMinSalaryOfDepartament(departamentId);
    }

    @GetMapping("/{id}/salary/max")
    public int getMaxSalaryOfDepartament(@PathVariable("id") int departamentId) {
        return departamentService.getMaxSalaryOfDepartament(departamentId);
    }
}
