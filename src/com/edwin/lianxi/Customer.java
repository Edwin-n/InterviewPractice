package com.edwin.lianxi;

import java.util.HashSet;

public class Customer {

	String name;
	int age;
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
	public Customer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public static void main(String[] args) {
		Customer c1 = new Customer("John", 20);
		Customer c2 = new Customer("John", 20);
		HashSet<Customer> customerSet = new HashSet<>();
		customerSet.add(c1);
		customerSet.add(c2);
		System.out.println(customerSet.size());
		
	}
}
