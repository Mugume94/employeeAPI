package com.springboot.davis.employeeApi.service;

import com.springboot.davis.employeeApi.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int theId);
    public Employee save(Employee theEmployee);
    public void deleteById(int theId);
}
