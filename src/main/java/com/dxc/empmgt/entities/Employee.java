package com.dxc.empmgt.entities;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;




@Entity
public class Employee {

	
	@Id
	@GeneratedValue
	private Integer id;
	
	 
	private String name;
    private int age;
    
    
    
    
    public Employee() {}
    
    public Employee(String name,int age) {
    	this.name=name;
    	this.age=age;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public boolean equals(Object arg) {
		if (this == arg) {
			return true;
		}

		if (arg == null || !(arg instanceof Employee)) {
			return false;
		}

		Employee that = (Employee) arg;
		boolean isequal = this.id == that.id;
		return isequal;
	}

	@Override
	public int hashCode() {
		return id;
	}

}
