package com.coforge.ems.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.coforge.ems.dao.EmployeeDAO;
import com.coforge.ems.exception.InvalidEmployeeObjectException;
import com.coforge.ems.model.Employee;

public class EmployeeService {
	
	private EmployeeDAO dao = new EmployeeDAO();
	
	public int createEmployee(Employee employee) throws  ClassNotFoundException, SQLException, InvalidEmployeeObjectException {
		int n = 0;
		
		if(employee!=null && employee.getEid() > 0 && employee.getEname()!=null && employee.getEsalary() >0)
			n = dao.createEmployee(employee);
		else 
			throw new InvalidEmployeeObjectException();
		
		return n;
	}
	
	public int updateEmployeeId( int id , int newId) throws ClassNotFoundException, SQLException, InvalidEmployeeObjectException {
		int n = 0;
		if(id>0 && newId>0) {
			n = dao.updateEmployeeId(id,newId);
		}else throw new InvalidEmployeeObjectException();
		
		return n;
		
	}
	
	public int updateEmployeeName( int id , String newName) throws ClassNotFoundException, SQLException, InvalidEmployeeObjectException {
		int n = 0;
		if(id>0 && newName!=null) {
			n = dao.updateEmployeeName(id,newName);
		}else throw new InvalidEmployeeObjectException();
		
		return n;
		
	}
	
	public int updateEmployeeSalary( int id , int newSalary) throws ClassNotFoundException, SQLException, InvalidEmployeeObjectException {
		int n = 0;
		if(id>0 && newSalary>0) {
			n = dao.updateEmployeeSalary(id,newSalary);
		}else throw new InvalidEmployeeObjectException();
		
		return n;
		
	}
	
	public int updateEmployeeDepartment( int id , int newDept) throws ClassNotFoundException, SQLException, InvalidEmployeeObjectException {
		int n = 0;
		if(id>0 && newDept>0) {
			n = dao.updateEmployeeDepartment(id,newDept);
		}else throw new InvalidEmployeeObjectException();
		
		return n;
		
	}
	
	public int deleteEmployee(int id) throws ClassNotFoundException,SQLException,InvalidEmployeeObjectException {
		int n = 0;
		if (id <= 0)
	        throw new InvalidEmployeeObjectException();

	    n = dao.deleteEmployee(id);

	    if (n == 0)
	        throw new InvalidEmployeeObjectException();

	    return n;
		
	}
	
	public Employee showEmployee(int id) throws ClassNotFoundException,SQLException,InvalidEmployeeObjectException {
		Employee employee;
		if(id<= 0) throw new InvalidEmployeeObjectException();
		
		employee = dao.showEmployee(id);
		if(((CharSequence) employee).isEmpty()) throw new InvalidEmployeeObjectException();
		
		return employee;
	}
	
	public List<Employee> showAllEmployees() throws ClassNotFoundException,SQLException,InvalidEmployeeObjectException {
		List<Employee> employeeList = new ArrayList<>();
		
		employeeList = dao.showAllEmployees();
		
		if(employeeList.isEmpty()) throw new InvalidEmployeeObjectException();
		return employeeList;
		
	}
	
	
	
}
