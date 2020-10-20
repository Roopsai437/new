package com.dxc.empmgt.service;

import com.dxc.empmgt.entities.Employee;
import com.dxc.empmgt.exceptions.EmployeeNotFoundException;
import com.dxc.empmgt.exceptions.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ServiceImpl implements IService {

    @Autowired
    private com.dxc.empmgt.dao.Dao dao;


    public Employee save(Employee employee){
            validate(employee);
            employee=dao.save(employee);
             return employee;
    }

public Employee findById(int id){

    Optional<Employee> optional = dao.findById(id);
    if (!optional.isPresent()) {
        throw new EmployeeNotFoundException("employee not found for id=" + id);
    }
    Employee employee = optional.get();
    return employee;
}
public Employee findByName(String name){

        Employee employee=dao.findByName(name);
        return employee;
}
public List<Employee> findAll(){
        List list=dao.findAll();
        return list;
}
public void remove(int id){
        dao.deleteById(id);
}

    public void validate(Object arg) {
        if (arg == null) {
            throw new InvalidArgumentException("argument is null");
        }
    }
}
