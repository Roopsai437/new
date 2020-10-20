package com.dxc.empmgt.controller;


import com.dxc.empmgt.dto.CreateEmployeeRequest;
import com.dxc.empmgt.dto.EmployeeDto;
import com.dxc.empmgt.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Validated
@RestController
@RequestMapping("/employee")
public class Controller {
    @Autowired com.dxc.empmgt.service.IService service;

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto create(@RequestBody @Valid CreateEmployeeRequest requestData) {
        Employee employee = new Employee(requestData.getName(), requestData.getAge());
        employee = service.save(employee);
        EmployeeDto response = toDto(employee);
        return response;

    }
    @GetMapping("/find/{id}")
    public EmployeeDto find(@PathVariable("id") int id) {
       Employee employee =service.findById(id);
       EmployeeDto response=toDto(employee);
       return response;
    }
    @GetMapping("/find/{name}")
    public EmployeeDto findByName(@PathVariable("name") String name) {
        Employee employee = service.findByName(name);
        EmployeeDto dto = toDto(employee);
        return dto;

    }

    @GetMapping("/findall")
    public List<EmployeeDto>findall(){
       List<Employee> employee=service.findAll();
       List<EmployeeDto> result=new ArrayList<>();
        for(Employee ar:employee) {
            EmployeeDto dto = toDto(ar);
            result.add(dto);
        }
        return  result;


    }
    

    @DeleteMapping("/delete/{id}")
    public void deleteTestById(@PathVariable("id") Integer id) {
        service.remove(id);
    }

    public EmployeeDto toDto(Employee employee) {
        EmployeeDto dto = new EmployeeDto();
        dto.setName(employee.getName());
        dto.setAge(employee.getAge());
        return dto;
    }
}
