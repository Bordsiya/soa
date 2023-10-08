package com.example.firstservice.exception.not_found;

import com.example.commonservice.exception.not_found.ResourceNotFoundException;
public class EmployeeNotFoundException extends ResourceNotFoundException {
    public EmployeeNotFoundException(Integer employeeId) {
        super("Employee", "employee-id", employeeId.toString());
    }
}
