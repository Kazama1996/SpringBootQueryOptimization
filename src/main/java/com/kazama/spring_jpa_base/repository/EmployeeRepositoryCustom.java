package com.kazama.spring_jpa_base.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kazama.spring_jpa_base.entity.Employee;

@Repository
public interface EmployeeRepositoryCustom {
    
    List<Employee> findAllUseQueryDSL();
}
