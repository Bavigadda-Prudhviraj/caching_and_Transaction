package com.prudhviraj.cachingConcurrentTransactionManagement.cachingAndTransaction.services;


import com.prudhviraj.cachingConcurrentTransactionManagement.cachingAndTransaction.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto getEmployeeById(Long id);
    EmployeeDto createNewEmployee(EmployeeDto employeeDto);
    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);
    void deleteEmployee(Long id);
}
