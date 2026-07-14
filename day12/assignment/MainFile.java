package com.coforge.main;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.coforge.model.Course;
import com.coforge.model.Student;

public class MainFile {
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		
		SessionFactory  factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
//		
//		Course course = new Course(1,"Springboot");
//		
//		session.save(course);
//		Student student = session.get(Student.class, 199);
//		
//		Course course1 = session.get(Course.class, 1);
		Course course2 = session.get(Course.class, 4);
		
//		course1.getStudents().add(student);
//		student.getCourses().add(course1);
//		student.getCourses().add(course2);
		Set<Student> students = course2.getStudents();
		for(Student s:students) {
			System.out.println(s.getStudent_id());
			System.out.println(s.getStudent_name());
		}
//		session.save(student);
		
		transaction.commit();
		session.close();
		factory.close();
		
	}
}
