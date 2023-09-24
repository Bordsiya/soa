package com.example.firstservice.exception.not_found;

public class EmployeeNotFoundException extends ResourceNotFoundException {
    public EmployeeNotFoundException(Integer employeeId) {
        super("Employee", "employee-id", employeeId.toString());
    }
}
