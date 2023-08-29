package com.projectx.webflux.service;

import com.projectx.webflux.dto.EmployeeDto;
import com.projectx.webflux.dto.EntityIdDto;
import com.projectx.webflux.entity.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IEmployeeService {
    String create(EmployeeDto e);

    Mono<Employee> findById(EntityIdDto id);

    Flux<Employee> findByName(String name);

    Flux<Employee> findAll();

    Mono<Employee> update(EmployeeDto e);

    String delete(EntityIdDto id);
}
