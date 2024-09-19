package com.kazama.spring_jpa_base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.kazama.spring_jpa_base.common.utils.DataInitializer;
import com.kazama.spring_jpa_base.dto.CreateUserRequestDto;
import com.kazama.spring_jpa_base.entity.Employee;
import com.kazama.spring_jpa_base.entity.QEmployee;
import com.kazama.spring_jpa_base.repository.EmployeeRepository;
import com.kazama.spring_jpa_base.service.EmployeeService;
import com.querydsl.jpa.impl.JPAQueryFactory;


@Service
public class EmployeeServceImpl implements EmployeeService{

    @Autowired
	private EmployeeRepository employeeRepository;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Autowired
    private DataInitializer dataInitializer;

    private final Random random = new Random();


    @Override
    public void create(CreateUserRequestDto requestDto) {
        // TODO Auto-generated method stub

        Employee employee = 
        Employee.builder()
                .name(requestDto.getName())
                .address(requestDto.getAddress())
                .build();
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> fetchAll() {
        // TODO Auto-generated method stub

        QEmployee employee = QEmployee.employee;
        return jpaQueryFactory
                        .select(employee)
                        .from(employee)
                        .fetch();
    }

    @Override
    public void generateNRandomEmployee(int numOfEmployee) {
        List<Employee> employees = new ArrayList<>();
        for(int i=0; i < numOfEmployee;i++){
            Employee employee = generateRandomEmployee();
            employees.add(employee);
        }

        employeeRepository.saveAll(employees);
        employeeRepository.flush();

    }

    private Employee generateRandomEmployee() {
        String firstName = getRandomElement(dataInitializer.getFirstNames());
        String lastName = getRandomElement(dataInitializer.getLastNames());
        String name = firstName + ", " + lastName;

        String city = getRandomElement(dataInitializer.getCities());
        String district = getRandomElement(dataInitializer.getDistricts());
        String street = getRandomElement(dataInitializer.getStreets());
        String address = city + ", " + district + ", " + street;

        return Employee.builder()
                .name(name)
                .address(address)
                .build();
    }


    private <T> T getRandomElement(List<T> list) {
        return list.get(random.nextInt(list.size()));
    }

}
