package com.prudhviraj.cachingConcurrentTransactionManagement.cachingAndTransaction.services.impl;


import com.prudhviraj.cachingConcurrentTransactionManagement.cachingAndTransaction.entities.Employee;
import com.prudhviraj.cachingConcurrentTransactionManagement.cachingAndTransaction.entities.SalaryAccount;
import com.prudhviraj.cachingConcurrentTransactionManagement.cachingAndTransaction.repositories.SalaryAccountRepository;
import com.prudhviraj.cachingConcurrentTransactionManagement.cachingAndTransaction.services.SalaryAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class SalaryAccountServiceImpl implements SalaryAccountService {

    private final SalaryAccountRepository salaryAccountRepository;

    @Override
    public void createAccount(Employee employee) {

       if(employee.getName().equals("Bavigadda Prudhviraj")) throw new RuntimeException("Bavigadda Prudhviraj is not allowed");

        SalaryAccount salaryAccount = SalaryAccount.builder()
                .employee(employee)
                .balance(BigDecimal.ZERO)
                .build();

        salaryAccountRepository.save(salaryAccount);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public SalaryAccount incrementBalance(Long accountId) {

        SalaryAccount salaryAccount = salaryAccountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        BigDecimal prevBalance = salaryAccount.getBalance();
        BigDecimal newBalance = prevBalance.add(BigDecimal.valueOf(1L));

        salaryAccount.setBalance(newBalance);

        return salaryAccountRepository.save(salaryAccount);
    }
}
