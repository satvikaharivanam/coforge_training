package com.coforge.ems.dto;

import com.coforge.ems.model.Employee;

public class EmployeeDTO {

//	private int eid;
//
//	private String ename;
//
//	private int esalary;

//	private int dno;
	
	private Employee employee;

	private DepartmentDTO department;

	public EmployeeDTO() {
		super();

	}

	public EmployeeDTO(Employee employee, DepartmentDTO department) {
		super();
		this.employee = employee;
		this.department = department;
	}

//	public int getEid() {
//		return eid;
//	}
//
//	public void setEid(int eid) {
//		this.eid = eid;
//	}
//
//	public String getEname() {
//		return ename;
//	}
//
//	public void setEname(String ename) {
//		this.ename = ename;
//	}
//
//	public int getEsalary() {
//		return esalary;
//	}
//
//	public void setEsalary(int esalary) {
//		this.esalary = esalary;
//	}

//	public int getDno() {
//		return dno;
//	}
//
//	public void setDno(int dno) {
//		this.dno = dno;
//	}
//	

	public DepartmentDTO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDTO department) {
		this.department = department;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	

	

}
