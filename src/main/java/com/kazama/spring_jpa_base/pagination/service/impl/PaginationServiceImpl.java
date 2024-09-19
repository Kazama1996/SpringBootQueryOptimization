package com.kazama.spring_jpa_base.pagination.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.kazama.spring_jpa_base.common.utils.PaginationUtils;
import com.kazama.spring_jpa_base.employee.entity.Employee;
import com.kazama.spring_jpa_base.employee.entity.QEmployee;
import com.kazama.spring_jpa_base.pagination.dto.limitoffset.LimitOffsetRequestDto;
import com.kazama.spring_jpa_base.pagination.service.PaginationService;
import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaginationServiceImpl implements PaginationService {


    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Employee> fetchEmployeesWithLimitOffset(LimitOffsetRequestDto requestDto) {


        List<Tuple> queryResult = execQueryEmployeesWithLimitOffset(requestDto);


        return queryResult.stream()
        .map(tuple -> Employee.builder()
            .id(tuple.get(QEmployee.employee.id))  
            .name(tuple.get(QEmployee.employee.name))  
            .build())
        .collect(Collectors.toList());  



    }
    private List<Tuple> execQueryEmployeesWithLimitOffset(LimitOffsetRequestDto requestDto){
     
        QEmployee employees = QEmployee.employee;

        PaginationUtils pagination = new PaginationUtils()
                                    .addPageNumber(requestDto.getPageNumber())
                                    .addRowsPerPage(requestDto.getRowsPerPage())
                                    .build();

        return jpaQueryFactory
        .select(
            employees.id,
            employees.name
        ).from(employees)
        .limit(pagination.getLimit())
        .offset(pagination.getOffset())
        .fetch();

    }
    

}
