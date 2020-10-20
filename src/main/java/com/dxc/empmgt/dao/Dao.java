package com.dxc.empmgt.dao;

import com.dxc.empmgt.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Dao extends JpaRepository<Employee,Integer> {
	Employee findByName(String name);

}
