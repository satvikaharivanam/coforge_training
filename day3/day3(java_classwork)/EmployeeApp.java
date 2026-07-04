package com.coforge.day3;

public class EmployeeApp {

	public static void main(String[] args) {
		Employee satvika = new Employee(103, "Satvika", 15000);
		satvika.display();
		Employee harshika = new Employee(101, "Harshika", 15000);
		harshika.display();
		Employee neha = new Employee(102, "Neha", 15000);
		neha.display();
		
		
		
		satvika.setSalary(20000);
		satvika.display();
		
		System.out.println(satvika.getSalary());

	}

}
