package com.coforge.ems.util;

public class ApplicationProperties {
	// for DBUtil class
	public static String driver = "com.mysql.cj.jdbc.Driver";
	public static String url = "jdbc:mysql://localhost:3306/c";
	public static String username = "root";
	public static String password = "";
	
	// // application response properties
	public static String insert = "insert into tbl_employee values (?,?,?,?)";
	public static final String insertSuccess = "SUCCESS : Employee Record Inserted";
	public static final String DBfail = "FAILED : DB Failed";
	public static final String updateID = "update tbl_employee set eid = ? where eid = ?";
	public static final String updateName = "update tbl_employee set ename = ? where eid = ?";
	public static final String updateSalary = "update tbl_employee set esalary = ? where eid = ?";
	public static final String findAll = "select * from tbl_employee ";
	public static final String updateDno = "update tbl_employee set dno = ? where eid = ?";
	public static final String delete = "delete from tbl_employee where eid = ?";
	public static final String findOne = "select * from tbl_employee where eid = ?";
	public static final String updateSuccess = "SUCCESS : Employee Record Updated";
	public static final String deleteSuccess = "SUCCESS : Employee Record Deleted";
	
	
}
