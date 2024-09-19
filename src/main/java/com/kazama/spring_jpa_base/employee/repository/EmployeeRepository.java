package com.kazama.spring_jpa_base.employee.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kazama.spring_jpa_base.employee.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {  

}
