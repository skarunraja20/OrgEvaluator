package com.swissre.assignment;

import java.util.ArrayList;
import java.util.List;

public class Employee {

	private int id;
	private String firstname;
	private String lastname;
	private int salary;
	private Integer managerId;
	private List<Employee> subordinates;

	public Employee(int id, String firstname, String lastname, int salary, Integer managerId) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.salary = salary;
		this.managerId = managerId;
		this.subordinates = new ArrayList<>();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public List<Employee> getSubordinates() {
		return subordinates;
	}

	public void addSubordinate(Employee e) {
		this.subordinates.add(e);

	}
}
