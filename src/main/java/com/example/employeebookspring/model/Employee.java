package com.example.employeebookspring.model;

import com.example.employeebookspring.record.EmployeeRequest;

public class Employee extends EmployeeRequest {

    private static int counter;
    private Integer id;
    private String firstName;
    private String lastName;
    private int department;
    private int salary;

    public Employee(String firstName, String lastName, int department, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        this.id = counter++;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    //    public static int getSalary(int i) {return salary;
//    }
    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", department=" + department + ", salary=" + salary + '}';
    }


}