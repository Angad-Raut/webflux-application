package com.projectx.webflux.controller;

import com.projectx.webflux.dto.EmployeeDto;
import com.projectx.webflux.dto.EntityIdDto;
import com.projectx.webflux.entity.Employee;
import com.projectx.webflux.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody EmployeeDto dto) {
        return employeeService.create(dto);
    }

    @PostMapping(value = "/getEmployeeById")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Employee> findById(@RequestBody EntityIdDto dto) {
        Mono<Employee> result = employeeService.findById(dto);
        return result;
    }

    @PostMapping(value = "/getById")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Mono<Employee>> getById(@RequestBody EntityIdDto dto) {
        Mono<Employee> result = employeeService.findById(dto);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @RequestMapping(value = "/findByName/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Employee> findByName(@PathVariable("name") String name) {
        Flux<Employee> result = employeeService.findByName(name);
        return result;
    }

    @GetMapping(value = "/getAllEmployees",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Employee> findAll() {
        Flux<Employee> result = employeeService.findAll();
        return result;
    }

    @PutMapping(value = "/update")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Employee> update(@RequestBody EmployeeDto dto) {
        Mono<Employee> result = employeeService.update(dto);
        return result;
    }

    @PostMapping(value = "/deleteById")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@RequestBody EntityIdDto id) {
        return employeeService.delete(id);
    }
}
