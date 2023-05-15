package com.springboot.davis.employeeApi.dao;

import com.springboot.davis.employeeApi.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();

    public Employee findById(int theId);
    public Employee save(Employee theEmployee);
    public void deleteById(int theId);
}
