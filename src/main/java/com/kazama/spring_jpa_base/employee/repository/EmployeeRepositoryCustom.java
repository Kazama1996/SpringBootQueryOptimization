package com.kazama.spring_jpa_base.employee.repository;

import java.util.List;

import com.kazama.spring_jpa_base.employee.entity.Employee;

import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositoryCustom {
    
    List<Employee> findAllUseQueryDSL();
}
