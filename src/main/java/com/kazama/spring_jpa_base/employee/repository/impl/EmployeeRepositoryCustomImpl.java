package com.kazama.spring_jpa_base.employee.repository.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kazama.spring_jpa_base.employee.entity.Employee;
import com.kazama.spring_jpa_base.employee.entity.QEmployee;
import com.kazama.spring_jpa_base.employee.repository.EmployeeRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmployeeRepositoryCustomImpl implements EmployeeRepositoryCustom {

    @Autowired
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Employee> findAllUseQueryDSL() {

        QEmployee employees = QEmployee.employee;

        return jpaQueryFactory
                    .select(employees)
                    .from(employees)
                    .fetch();
    }
    
}
