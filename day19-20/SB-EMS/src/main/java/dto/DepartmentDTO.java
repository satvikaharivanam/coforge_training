package com.coforge.ems.dto;


// this is not entity, this is a data transfer object 
public class DepartmentDTO {
	
	private int dno;
	
	private String dname;
	
	public DepartmentDTO() {
		super();
		
	}

	public DepartmentDTO(int dno, String dname) {
		super();
		this.dno = dno;
		this.dname = dname;
	}

	public int getDno() {
		return dno;
	}

	public void setDno(int dno) {
		this.dno = dno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	@Override
	public String toString() {
		return "Department [dno=" + dno + ", dname=" + dname + "]";
	}
	
	
	
	
}
