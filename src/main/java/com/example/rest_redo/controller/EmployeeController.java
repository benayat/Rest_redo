package com.example.rest_redo.controller;


import com.example.rest_redo.model.Employee;
import com.example.rest_redo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> searchEmployeeByName(@RequestParam String name){
        return employeeService.getAllEmployeesByName(name, PageRequest.of(0, 10));

    }
//    @GetMapping("/role")
//    public List<Employee> searchEmployeeByRole(@RequestParam String role){
//        List<Employee> employeeList = employeeService.getAllEmployeesByRole(role, PageRequest.of(0, 10));
//        return employeeList;
//    }
    @GetMapping("/id")
    public Optional<Employee> searchEmployeeById(@RequestParam String id){
        return employeeService.findById(id);
    }
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }
    @PostMapping("/createInBulk")
    public List<Employee> addEmployeeInBulk(@RequestBody List<Employee> EmployeeList){
        return (List<Employee>) employeeService.createBulk(EmployeeList);
    }


}
