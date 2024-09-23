package com.prudhviraj.cachingConcurrentTransactionManagement.cachingAndTransaction.services;


import com.prudhviraj.cachingConcurrentTransactionManagement.cachingAndTransaction.entities.Employee;
import com.prudhviraj.cachingConcurrentTransactionManagement.cachingAndTransaction.entities.SalaryAccount;

public interface SalaryAccountService {
    void createAccount(Employee employee);

    SalaryAccount incrementBalance(Long accountId);
}
