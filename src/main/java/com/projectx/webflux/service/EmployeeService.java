package com.projectx.webflux.service;

import com.projectx.webflux.dto.EmployeeDto;
import com.projectx.webflux.dto.EntityIdDto;
import com.projectx.webflux.entity.Employee;
import com.projectx.webflux.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;


@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    EmployeeRepository employeeRepo;

    public static final String ADD_EMPLOYEE="Employee added successfully!";
    public static final String DELETE_EMPLOYEE="Employee deleted successfully!";

    public String create(EmployeeDto e) {
        employeeRepo.save(toEntity(e)).subscribe();
        return ADD_EMPLOYEE;
    }

    public Mono<Employee> findById(EntityIdDto id) {
        return employeeRepo.findById(id.getEntityId());
    }

    public Flux<Employee> findByName(String name) {
        return employeeRepo.findByName(name);
    }

    public Flux<Employee> findAll() {
        return employeeRepo.findAll();
    }

    public Mono<Employee> update(EmployeeDto e) {
        Employee data = toEntity(e);
        return employeeRepo.save(data);
    }

    public String delete(EntityIdDto id) {
        employeeRepo.deleteById(id.getEntityId()).subscribe();
        return DELETE_EMPLOYEE;
    }
    private Employee toEntity(EmployeeDto dto) {
        return Employee.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .emailId(dto.getEmailId())
                .mobileNo(dto.getMobileNo())
                .address(dto.getAddress())
                .salary(dto.getSalary())
                .status(true)
                .insertedTime(new Date())
                .updatedTime(new Date())
                .build();
    }
}
