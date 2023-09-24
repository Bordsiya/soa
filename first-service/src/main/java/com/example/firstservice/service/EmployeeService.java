package com.example.firstservice.service;

import com.example.firstservice.entity.Employee;
import com.example.firstservice.exception.not_found.EmployeeNotFoundException;
import com.example.firstservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(
            EmployeeRepository employeeRepository
    ) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployeeById(Integer employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(employeeId));
    }
}
