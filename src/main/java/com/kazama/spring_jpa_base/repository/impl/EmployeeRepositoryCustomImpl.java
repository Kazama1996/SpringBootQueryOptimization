package com.kazama.spring_jpa_base.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kazama.spring_jpa_base.entity.Employee;
import com.kazama.spring_jpa_base.entity.QEmployee;
import com.kazama.spring_jpa_base.repository.EmployeeRepositoryCustom;
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
