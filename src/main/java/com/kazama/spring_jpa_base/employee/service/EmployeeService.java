package com.kazama.spring_jpa_base.employee.service;

import java.util.List;

import com.kazama.spring_jpa_base.employee.dto.CreateUserRequestDto;
import com.kazama.spring_jpa_base.employee.entity.Employee;

public interface EmployeeService {
    

    public void create(CreateUserRequestDto requestDto);

    public List<Employee> fetchAll();

    public void generateNRandomEmployee(int numOfEmployee);
}
