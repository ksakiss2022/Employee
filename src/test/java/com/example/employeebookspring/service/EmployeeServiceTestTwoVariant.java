package com.example.employeebookspring.service;
import com.example.employeebookspring.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static java.lang.Math.E;
import static java.time.chrono.JapaneseEra.values;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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
    private final Employee employeeDima_1 = new Employee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1_20000);
    private final Employee employeeJulia_2 = new Employee(FIRST_NAME_2, LAST_NAME_2, DEPARTMENT_2, SALARY_2_30000);
    private final Employee employeeNatali_3 = new Employee(FIRST_NAME_3, LAST_NAME_3, DEPARTMENT_3, SALARY_3_60000);

    private EmployeeService employeeService;
        @Test
        public Collection<Employee> getAllEmployees() {
            return this.getAllEmployees();
        }

        @Test
        void getSalarySum() {

            final int actual = (SALARY_1_20000+SALARY_2_30000+SALARY_3_60000);
            final int expected = employeeService.getSalarySum();
            assertEquals(expected, actual);
        }

        @Test
        void getSaleryMax() {
            final int actual = SALARY_3_60000;
            final int expected = employeeService.getSaleryMax();
            assertEquals(expected, actual);
        }

        @Test
        void getSaleryMin() {
            final int actual = SALARY_1_20000;
            final int expected = employeeService.getSaleryMin();
            assertEquals(expected, actual);
        }

        @Test
        void getAverageSalary() {
            final double actual = ((SALARY_1_20000+SALARY_2_30000+SALARY_3_60000)/3);
            final double expected = employeeService.getAverageSalary();
            assertEquals(expected, actual);
        }
    }


