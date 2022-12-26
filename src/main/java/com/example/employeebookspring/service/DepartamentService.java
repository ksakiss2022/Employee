package com.example.employeebookspring.service;

import com.example.employeebookspring.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DepartamentService implements DepartamentServiceImpl {

    private final EmployeeService employeeService;


    public DepartamentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Set<Integer> getExistingDepartments() {
        return employeeService.getAllEmployees().stream().map(Employee::getDepartment).collect(Collectors.toSet());
    }


    @Override
    public List<Employee> getEmployeesFromDepartment(int departmentId) {
        return employeeService.getAllEmployees().stream().filter(employee -> employee.getDepartment() == departmentId).collect(Collectors.toList());
    }


    @Override
    public int getSalarySumOfDepartament(int departamentId) {
        return getEmployeesFromDepartment(departamentId).stream().mapToInt(Employee::getSalary).sum();
    }

    @Override
    public Map<Integer, List<Employee>> getEmployeesByDepartament() {
        return getExistingDepartments().stream().collect(Collectors.toMap(dept -> dept, this::getEmployeesFromDepartment));
    }

    @Override
    public int getMinSalaryOfDepartament(int departamantId) {
        return getEmployeesFromDepartment(departamantId).stream().mapToInt(Employee::getSalary).min().orElseThrow();
    }

    @Override
    public int getMaxSalaryOfDepartament(int departamantId) {
        return getEmployeesFromDepartment(departamantId).stream().mapToInt(Employee::getSalary).max().orElseThrow();
    }
}
