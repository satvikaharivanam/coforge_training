package com.coforge.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.coforge.model.Employee;

public class MainClass {
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		
		SessionFactory  factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Employee employee = new Employee(109, "harshika" , 43000,20);
		
//		session.save(employee);
		
//		session.update(employee);
		
//		Employee employee = session.get(Employee.class, 107);
//		System.out.println(employee);
		
		session.delete(employee);
		transaction.commit();
		session.close();
		factory.close();
		
		System.out.println("Employee Record Saved");
		
		
		
		
	}
}
