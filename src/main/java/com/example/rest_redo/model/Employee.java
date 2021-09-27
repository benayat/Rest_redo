package com.example.rest_redo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.util.Objects;

import static org.springframework.data.elasticsearch.annotations.FieldType.*;

@Document(indexName = "employee")
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @Id
    private String id;

    @Field(type = Text, name = "name")
    private String name;

    @Field(type = Text, name = "role")
    private String role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getId().equals(employee.getId()) && getName().equals(employee.getName()) && getRole().equals(employee.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getRole());
    }
}
