package com.example.swaggertut.api;

import com.example.exceptions.EmployeeNotFoundException;
import com.example.swaggertut.entities.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {
    private List<Employee> employees = new ArrayList<>(Arrays.asList(
        new Employee(1L, "Sam", "sam@company.com", "BE"),
        new Employee(2L, "Walter", "alter@company.com", "BE"),
        new Employee(3L, "Benny", "benny@company.com", "FE"),
        new Employee(4L, "Dan", "dan@company.com", "DE")
    ));

    private final String EMPLOYEE_NOT_FOUND = "Employee could not be found for id: %s";

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable("id") Long id) {
        return employees
                .stream()
                .filter(employee -> employee.getEmployeeId() == id)
                .findAny()
                .orElseThrow(() -> new EmployeeNotFoundException(String.format(EMPLOYEE_NOT_FOUND, id)));
    }

    @PostMapping("/employees")
    public long addEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        return employee.getEmployeeId();
    }
}
