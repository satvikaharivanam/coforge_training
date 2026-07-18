package com.coforge.ems.service;

import java.util.List;
import java.util.Optional;

import com.coforge.ems.model.Employee;
import com.corforge.ems.exception.InvalidEmployeeNotFoundException;
import com.corforge.ems.exception.InvalidEmployeeObjectException;

public interface EmployeeService {
	
	public boolean saveEmployee(Employee employee) throws InvalidEmployeeObjectException;

	public boolean updateEmployee(int eid, Employee employee) throws InvalidEmployeeObjectException, InvalidEmployeeNotFoundException;

	public boolean deleteEmployee(int eid) throws InvalidEmployeeObjectException, InvalidEmployeeNotFoundException;

	public Optional<Employee> findEmployeeById(int eid) throws InvalidEmployeeNotFoundException, InvalidEmployeeObjectException;

	public List<Employee> findAllEmployees();

	public List<Employee> findEmployeeByName(String ename) throws InvalidEmployeeObjectException, InvalidEmployeeNotFoundException;

	public boolean deleteEmployeeByName(String ename) throws InvalidEmployeeObjectException, InvalidEmployeeNotFoundException;

	public List<Employee> findEmployeeByDno(int dno) throws InvalidEmployeeNotFoundException, InvalidEmployeeObjectException;

	public List<Integer> getEidsList();

	public String getInfo();
	
	
	

}
