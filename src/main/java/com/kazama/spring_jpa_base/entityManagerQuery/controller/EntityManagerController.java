package com.kazama.spring_jpa_base.entityManagerQuery.controller;

import com.kazama.spring_jpa_base.entityManagerQuery.service.EntityManagerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntityManagerController {
    

    @Autowired
    private EntityManagerService entityManagerService;

    @GetMapping("/test")
    public String test(){
        return entityManagerService.query();

    }
}
