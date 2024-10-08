package com.kazama.spring_jpa_base.employee.controller.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kazama.spring_jpa_base.employee.controller.EmployeeController;
import com.kazama.spring_jpa_base.employee.dto.CreateUserRequestDto;
import com.kazama.spring_jpa_base.employee.service.EmployeeService;

@RestController
public class EmployeeControllerImpl implements EmployeeController {


    @Autowired
    EmployeeService employeeService;

    @Override
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateUserRequestDto requestDto) {
        employeeService.create(requestDto);
    return ResponseEntity.status(HttpStatusCode.valueOf(201)).body("You create a employee");
    }

    @Override
    @GetMapping("/fetchAll")
    public ResponseEntity<?> fetchAll() {

        return ResponseEntity.ok().body(employeeService.fetchAll());
    }

    @Override
    @GetMapping("/generateN")
    public ResponseEntity<?> createNRandom(@RequestParam Integer numOfUser) {


        employeeService.generateNRandomEmployee(numOfUser);

        return ResponseEntity.ok().body("You create "+numOfUser+"employees");

    }


   


    
}
