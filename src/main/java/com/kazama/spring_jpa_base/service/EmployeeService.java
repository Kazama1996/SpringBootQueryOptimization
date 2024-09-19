package com.kazama.spring_jpa_base.service;

import java.util.List;

import com.kazama.spring_jpa_base.dto.CreateUserRequestDto;
import com.kazama.spring_jpa_base.entity.Employee;

public interface EmployeeService {
    

    public void create(CreateUserRequestDto requestDto);

    public List<Employee> fetchAll();

    public void generateNRandomEmployee(int numOfEmployee);
}
