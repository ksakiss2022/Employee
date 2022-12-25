package com.example.employeebookspring.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Employee {

    private static int counter;
    private Integer id;
    private String firstName;
    private String lastName;
    private int department;
    private int salary;

    //  private static int sequenceumNumber = 1;
    //    private String patronymic;
    public Employee(String firstName, String lastName, int department, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        this.id = counter++;
    }

    protected Employee() {
    }

//    public Employee() {
//    }

  //  public static int getCounter() {
   //     return counter;
   // }

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

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }


    public abstract Set<Integer> getExistingDepartments();

    public abstract List<Employee> getEmployeesFromDepartment(int departmentId);

    public abstract int getSalarySumOfDepartament(int departamentId);

    public abstract Map<Integer, List<Employee>> getEmployeesByDepartament();

    public abstract int getMinSalaryOfDepartament(int departamantId);

    public abstract int getMaxSalaryOfDepartament(int departamantId);
}