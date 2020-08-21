package com.hackerrank.sample.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee extends Model {
	private int age;
	private Date dob;
	
	public Employee() {
	}

	public Employee(Long id, String name) {
		super(id, name);
	}
	
	
}
