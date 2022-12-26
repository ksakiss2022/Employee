package com.example.employeebookspring.service;

import com.example.employeebookspring.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface DepartamentServiceImpl {
    Set<Integer> getExistingDepartments();

    List<Employee> getEmployeesFromDepartment(int departmentId);

    int getSalarySumOfDepartament(int departamentId);

    Map<Integer, List<Employee>> getEmployeesByDepartament();

    int getMinSalaryOfDepartament(int departamantId);

    int getMaxSalaryOfDepartament(int departamantId);
}
