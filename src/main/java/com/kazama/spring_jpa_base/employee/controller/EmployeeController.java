package com.kazama.spring_jpa_base.employee.controller;

import org.springframework.http.ResponseEntity;


import com.kazama.spring_jpa_base.employee.dto.CreateUserRequestDto;

public interface EmployeeController {
    
    ResponseEntity<?> create(CreateUserRequestDto requestDto);


    ResponseEntity<?> fetchAll();

    ResponseEntity<?> createNRandom(Integer numOfUser);
}
