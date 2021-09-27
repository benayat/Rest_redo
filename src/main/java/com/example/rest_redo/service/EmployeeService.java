package com.example.rest_redo.service;


import com.example.rest_redo.model.Employee;
import com.example.rest_redo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public Iterable<Employee> createBulk(List<Employee> employeeList){
        return employeeRepository.saveAll(employeeList);
    }
    public Optional<Employee> findById(String id){
        return employeeRepository.findById(id);
    }
    public List<Employee> getAllEmployeesByName(String name, Pageable pageable){
        return employeeRepository.findByEmployeeNameUsingCustomQuery(name, pageable);
    }
//    public List<Employee> getAllEmployeesByRole(String role, Pageable pageable){
//        return employeeRepository.(role, pageable);
//    }

}
