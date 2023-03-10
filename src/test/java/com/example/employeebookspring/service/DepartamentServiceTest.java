package com.example.employeebookspring.service;

import com.example.employeebookspring.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartamentServiceTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartamentService departamentService;
    private List<Employee> actualEmployees;


    @BeforeEach
    public void setUp() {

        Employee employee1 = new Employee("Dima", "Petrov", 1, 20000) {
        };
        Employee employee2 = new Employee("Julia", "Blohina", 2, 30000) {
        };
        Employee employee3 = new Employee("Natali", "Coval", 3, 60000) {
        };
        actualEmployees = new ArrayList<>(List.of(employee1, employee2, employee3));
        when(employeeService.getAllEmployees()).thenReturn(actualEmployees);
    }


    @Test
    void getExistingDepartments() {
        final Set<Integer> actual = actualEmployees.stream().map(Employee::getDepartment).collect(Collectors.toSet());
        final Set<Integer> expected = departamentService.getExistingDepartments();
        assertEquals(expected, actual);
    }

    @Test
    void getEmployeesFromDepartment() {
        final int departmentId = 1;
        final List<Employee> actual = actualEmployees.stream()
                .filter(e -> e.getDepartment() == departmentId).collect(Collectors.toList());
        final List<Employee> expected = departamentService.getEmployeesFromDepartment(departmentId);
        assertEquals(expected, actual);
    }


    @Test
    void getSalarySumOfDepartament() {
        final int departmentId = 1;
        final int actual = actualEmployees.stream()
                .filter(e -> e.getDepartment() == departmentId).mapToInt(Employee::getSalary).sum();
        final int expected = departamentService.getSalarySumOfDepartament(departmentId);
        assertEquals(expected, actual);
    }


    @Test
    void getEmployeesByDepartament() {
        final Map<Integer, List<Employee>> actual = actualEmployees.stream()
                .map(Employee::getDepartment).collect(Collectors.toSet()).stream()
                .collect(Collectors.toMap(dept -> dept,
                        dept -> actualEmployees.stream().filter(e -> e.getDepartment() == dept).
                                collect(Collectors.toList())));
        final Map<Integer, List<Employee>> expected = departamentService.getEmployeesByDepartament();
        assertEquals(expected, actual);
    }

    @Test
    void getMinSalaryOfDepartament() {
        final int departament = 1;
        final int actual = actualEmployees.stream().filter(e -> e.getDepartment() == departament)
                .mapToInt(Employee::getSalary).min().orElse(0);
        final int expected = departamentService.getMinSalaryOfDepartament(departament);
        assertEquals(expected, actual);
    }

    @Test
    void getMaxSalaryOfDepartament() {
        final int department = 1;
        final int actual = actualEmployees.stream().filter(e -> e.getDepartment() == department)
                .mapToInt(Employee::getSalary).max().orElse(0);
        final int expected = departamentService.getMaxSalaryOfDepartament(department);
        assertEquals(expected, actual);
    }
}