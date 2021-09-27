package com.example.rest_redo.repository;

import com.example.rest_redo.model.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


public interface EmployeeRepository  extends ElasticsearchRepository<Employee, String> {
    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    List<Employee> findByEmployeeNameUsingCustomQuery(String name, Pageable pageable);
}
