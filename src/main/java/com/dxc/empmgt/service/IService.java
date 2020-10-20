package com.dxc.empmgt.service;

import com.dxc.empmgt.entities.Employee;

import java.util.List;

public interface IService {
    public Employee save(Employee employee);
    public Employee findById(int id);
    public Employee findByName(String name);
    public List<Employee> findAll();
    public void remove(int id);
}
