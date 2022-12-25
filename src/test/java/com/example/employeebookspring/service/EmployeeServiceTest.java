package com.example.employeebookspring.service;

import com.example.employeebookspring.model.Employee;
import com.example.employeebookspring.record.EmployeeRequest;
import com.example.employeebookspring.repositories.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
    @Mock
    private EmployeeService employeeService;

    private List<Employee> actualEmployees;
    private Employee employee1;

    @BeforeEach
    public void setUp() {
        employee1 = new Employee("Dima", "Petrov", 1, 20000) {};
        Employee employee2 = new Employee("Julia", "Blohina", 2, 30000) {};
        Employee employee3 = new Employee("Natali", "Coval", 3, 60000) {};
        actualEmployees = new ArrayList<>(List.of(employee1, employee2, employee3));
        when(employeeService.getAllEmployees()).thenReturn(actualEmployees);
    }

    @Test
    void getAllEmplxoyees() {
        List<Employee> expected = (List<Employee>) employeeService.getAllEmployees();
        assertEquals(expected, actualEmployees);

    }

    @Test
    void addEmployee() {

        final Employee actual = employee1;
        EmployeeRequest employee = new EmployeeRequest();
        employee.setFirstName(actual.getFirstName());
        employee.setLastName(actual.getLastName());
        employee.setDepartment(actual.getDepartment());
        employee.setSalary(actual.getSalary());

        when(employeeService.getLostId()).thenReturn(0);
        Employee expected = employeeService.addEmployee(employee);
        assertEquals(expected, actual);

    }

    @Test
    void getSalarySum() {
        final int actual = actualEmployees.stream().mapToInt(Employee::getSalary).sum();
        final int expected = employeeService.getSalarySum();
        assertEquals(expected, actual);
    }

    @Test
    void getSaleryMax() {
        final Employee actual = actualEmployees.stream().max(Comparator.comparingInt(Employee::getSalary)).get();
        final int expected = employeeService.getSaleryMax();
        assertEquals(expected, actual);
    }

    @Test
    void getSaleryMin() {
        final Employee actual=actualEmployees.stream().min(Comparator.comparingInt(Employee::getSalary)).get();
        final int expected=employeeService.getSaleryMin();
        assertEquals(expected,actual);
    }

    @Test
    void getAverageSalary() {
        final int avarege=actualEmployees.stream().mapToInt(Employee::getSalary).sum()/actualEmployees.size();
        final List<Employee>expected=actualEmployees.stream().filter(e->e.getSalary()>avarege).collect(Collectors.toList());
        final double actual=employeeService.getAverageSalary();
        assertEquals(expected,actual);
    }
}