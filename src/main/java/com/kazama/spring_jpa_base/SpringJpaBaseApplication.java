package com.kazama.spring_jpa_base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SpringJpaBaseApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringJpaBaseApplication.class, args);
	}

}
