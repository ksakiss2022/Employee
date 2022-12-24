package com.example.employeebookspring.service;

public class EmployeeSeviceExeption extends Exception {
    public EmployeeSeviceExeption() {
        super();
    }
    public EmployeeSeviceExeption(String massage) {
        super(massage);
    }
}
