package com.kazama.spring_jpa_base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kazama.spring_jpa_base.repository.EmployeeRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SpringJpaBaseApplication {




	public static void main(String[] args) {
		
		SpringApplication.run(SpringJpaBaseApplication.class, args);
	}

}
