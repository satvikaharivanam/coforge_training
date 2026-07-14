package com.coforge.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.coforge.model.Employee;

public class HQLMain {
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		
		SessionFactory  factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		// HQL Query  static query 
//		Query query = session.createQuery("from Employee");
//		List<Employee> employees = 	query.list();
//		
//		System.out.println(employees);
		
//		Query query = session.createQuery("from Employee where eid = 103"); // static select query.
//		List<Employee> employees = 	query.list();
//		
//		System.out.println(employees);
		
		// hql dynamic query
//		Query query = session.createQuery("from Employee where eid = :id");
//		query.setParameter("id", 123);
//		List<Employee> employee=  query.list();
//		
//		System.out.println(employee);
////		
//		Query query = session.createQuery("select ename from Employee");
//		List<Employee> employee=  query.list();
//		List<String> list = query.list();
//		
//		System.out.println(employee);
//		System.out.println(list);
		
//		Query query = session.createQuery("update Employee set ename = :name where eid = :id");
//		query.setParameter("name", "satvika");
//		query.setParameter("id", 123);
//		int n = query.executeUpdate();
////		List<Employee> employee=  query.list();
////		List<String> list = query.list();
//		
//				if (n==1)
//		System.out.println("updated");
//				else 
//		System.out.println("not updated");
		
		// hql delete
				Query query = session.createQuery("delete from Employee where eid = :id");
//				query.setParameter("name", "satvika");
				query.setParameter("id", 123);
				int n = query.executeUpdate();
//				List<Employee> employee=  query.list();
//				List<String> list = query.list();
				
						if (n==1)
				System.out.println("deleted");
						else 
				System.out.println("not deleted");
				
		
		transaction.commit();
		session.close();
		factory.close();
		
		System.out.println("Employee Record Saved");
		
		
		
		
	}
}
