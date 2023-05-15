package com.springboot.davis.employeeApi.rest;

import com.springboot.davis.employeeApi.dao.EmployeeDAO;
import com.springboot.davis.employeeApi.entity.Employee;
import com.springboot.davis.employeeApi.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    private List<Employee> findAll(){

        return employeeService.findAll();
    }
    @GetMapping("/employees/{employeeId}")
    private Employee findById(@PathVariable int employeeId ){

        Employee employee = employeeService.findById(employeeId);

        if (employee == null){
            throw new RuntimeException("Employee Id not found " + employeeId);
        }

        return employee;
    }

    @PostMapping("/employees")
    private Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @PutMapping("/employees")
    private Employee updateEmployee(@RequestBody  Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    private String deleteEmployeeById(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null){
            throw new RuntimeException("Employee Id not found " + employeeId);
        }
        employeeService.deleteById(employeeId);

        return "Employee of Id " + employeeId + "has been deleted";
    }
}
