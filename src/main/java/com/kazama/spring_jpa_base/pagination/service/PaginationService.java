package com.kazama.spring_jpa_base.pagination.service;

import java.util.List;

import com.kazama.spring_jpa_base.employee.entity.Employee;
import com.kazama.spring_jpa_base.pagination.dto.limitoffset.LimitOffsetRequestDto;

public interface PaginationService {


    public List<Employee> fetchEmployeesWithLimitOffset(LimitOffsetRequestDto request);
    
}  
