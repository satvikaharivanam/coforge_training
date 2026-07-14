package com.coforge.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity 
@Table (name = "tbl_course")
public class Course {
	@Id
	@Column (name = "course_id",length = 5)
	private int course_id;
	@Column (name = "course_name",length = 50)
	private String course_name;
	public Course() {
	}
	public Course(int i, String string) {
		// TODO Auto-generated constructor stub
		super();
		this.course_id = i;
		this.course_name = string;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	
	@ManyToMany(mappedBy = "courses")
	
	
	private Set<Student> students = new HashSet<Student>();
	
	public Set<Student> getStudents() {
	    return students;
	}

	public void setCourses(Set<Student> students) {
	    this.students = students;
	}
	
	
	
}
