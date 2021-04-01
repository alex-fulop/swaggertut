package com.example.swaggertut.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Employee {
    private long employeeId;
    private String name;
    private String email;
    private String role;

}
