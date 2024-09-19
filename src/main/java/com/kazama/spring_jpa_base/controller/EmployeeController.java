package com.kazama.spring_jpa_base.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.kazama.spring_jpa_base.dto.CreateUserRequestDto;
import com.kazama.spring_jpa_base.entity.Employee;

public interface EmployeeController {
    
    ResponseEntity<?> create(CreateUserRequestDto requestDto);


    ResponseEntity<?> fetchAll();

    ResponseEntity<?> createNRandom(Integer numOfUser);
}
