package com.kazama.spring_jpa_base.pagination.controller.impl;

import java.util.List;

import com.kazama.spring_jpa_base.employee.entity.Employee;
import com.kazama.spring_jpa_base.pagination.controller.PaginationController;
import com.kazama.spring_jpa_base.pagination.dto.limitoffset.LimitOffsetRequestDto;
import com.kazama.spring_jpa_base.pagination.service.PaginationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaginnationControllerImpl implements PaginationController {

    

    @Autowired
    private PaginationService paginationService;



    @Override
    @PostMapping("/limitoffset")
    public ResponseEntity<?> queryWithLimitOffset(@RequestBody LimitOffsetRequestDto requestDto) {
        // TODO Auto-generated method stub


        List<Employee> paginationResult = paginationService.fetchEmployeesWithLimitOffset(requestDto);

        return ResponseEntity.ok().body(paginationResult);
    }
    



}
