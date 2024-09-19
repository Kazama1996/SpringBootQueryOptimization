package com.kazama.spring_jpa_base.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kazama.spring_jpa_base.entity.Employee;
import com.kazama.spring_jpa_base.entity.QEmployee;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {  

}
