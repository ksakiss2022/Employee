package com.example.employeebookspring.service;

import com.example.employeebookspring.model.Employee;
import com.example.employeebookspring.record.EmployeeRequest;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class EmployeeService {
    private final Map<Integer, Employee> employees = new HashMap<>();


    public Collection<Employee> getAllEmployees() {
        return this.employees.values();
    }

    public Employee addEmployee(EmployeeRequest employeeRequest){
        if (employeeRequest.getFirstName() == null || employeeRequest.getLastName() == null) {
            throw new IllegalArgumentException("Проверьте поле имя не должно быть пустым");
        }
        Employee employee = new Employee(employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getDepartment(),
                employeeRequest.getSalary()) {
        };
        this.employees.put(employee.getId(), employee);
        return employee;
    }

    public int getSalarySum() {
        return employees.values().stream().mapToInt(Employee::getSalary).sum();
    }

        public int getSaleryMax() {
            return employees.values().stream()
                    .mapToInt(Employee::getSalary)
                    .max().orElseThrow(NoSuchElementException::new);
        }

        public int getSaleryMin() {
            return employees.values().stream()
                    .mapToInt(Employee::getSalary)
                    .min().orElseThrow(NoSuchElementException::new);
        }

        public double getAverageSalary() {
            return employees.values().stream().
                    mapToInt(Employee::getSalary)
                    .average().orElseThrow(NoSuchElementException::new);
        }


        public void checkEmployee(Employee employee) throws EmployeeSeviceExeption {
            boolean firstNameIsBlankt = StringUtils.isBlank(employee.getFirstName());
            boolean lastNameIsBlankt = StringUtils.isBlank(employee.getLastName());
            if (firstNameIsBlankt || lastNameIsBlankt) {
                throw new EmployeeSeviceExeption("Не верно заданы поля имя или фамилия!");
            }
        }

   private static int lostId;
  //  private final List<Employee> employees;

   // public EmployeeRepository(List<Employee> employees) {
   //     this.employees = employees;
  //  }

   // public List<Employee> getEmployees() {
     //   return employees;
  //  }

//    public void addEmployee(Employee employee) {
//     employees.add(employee);
//     ++lostId;
//   }

    public int getLostId() {
   return lostId;
    }
}
