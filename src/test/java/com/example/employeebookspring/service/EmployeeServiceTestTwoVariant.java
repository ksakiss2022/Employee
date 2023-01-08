package com.example.employeebookspring.service;

import com.example.employeebookspring.record.EmployeeRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTestTwoVariant {

    private final String LAST_NAME_1 = "Petrov";
    private final String LAST_NAME_2 = "Blohina";
    private final String LAST_NAME_3 = "Coval";
    private final String FIRST_NAME_1 = "Dima";
    private final String FIRST_NAME_2 = "Julia";
    private final String FIRST_NAME_3 = "Natali";
    private final int DEPARTMENT_1 = 1;
    private final int DEPARTMENT_2 = 2;
    private final int DEPARTMENT_3 = 3;
    private final int SALARY_1_20000 = 20_000;
    private final int SALARY_2_30000 = 30_000;
    private final int SALARY_3_60000 = 60_000;

    private final EmployeeRequest employeeDima1 = new EmployeeRequest(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1_20000);
    private final EmployeeRequest employeeJulia2 = new EmployeeRequest(FIRST_NAME_2, LAST_NAME_2, DEPARTMENT_2, SALARY_2_30000);
    private final EmployeeRequest employeeNatali3 = new EmployeeRequest(FIRST_NAME_3, LAST_NAME_3, DEPARTMENT_3, SALARY_3_60000);
    private EmployeeService employeeService;

    @BeforeEach
    public void setup() {
        employeeService = new EmployeeService();
        Stream.of(
                employeeDima1,
                employeeJulia2,
                employeeNatali3
        ).forEach(employeeService::addEmployee);
    }

    @Test
    public void getAllEmployees() {
        assertEquals(3, employeeService.getAllEmployees().size());
    }

    @Test
    void getSalarySum() {
        final int actual = (SALARY_1_20000 + SALARY_2_30000 + SALARY_3_60000);
        final int expected = employeeService.getSalarySum();
        assertEquals(expected, actual);
    }
    @Test
    void getSalaryMax() {
        assertEquals(SALARY_3_60000, employeeService.getSaleryMax());
    }

    @Test
    void getSaleryMin() {
        assertEquals(SALARY_1_20000, employeeService.getSaleryMin());
    }

    @Test
    void getAverageSalary() {
        final double actual=((SALARY_1_20000 + SALARY_2_30000 + SALARY_3_60000) / 3d);
        final double expected = employeeService.getAverageSalary();
        assertEquals(expected,actual);
    }
}


