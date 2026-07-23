package com.coforge.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.PathVariable;

import com.coforge.ems.dto.DepartmentDTO;
import com.coforge.ems.exception.InvalidEmployeeNotFoundException;
import com.coforge.ems.exception.InvalidEmployeeObjectException;
import com.coforge.ems.model.Employee;
import com.coforge.ems.repo.EmployeeRepo;
import com.coforge.ems.service.client.DepartmentClient;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepo repo;
	private Environment environment;
	private DepartmentClient client;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepo repo, Environment environment, DepartmentClient client) {
		super();
		this.repo = repo;
		this.environment = environment;
		this.client = client;
	}

	@Override
	public boolean saveEmployee(Employee employee) {
//		if(employee!=null 
//				&& employee.getEid() > 0 
//				&& employee.getEname()!=null 
//				&& employee.getDno()>0 
//				&& employee.getEsalary()>0) {
//			
			repo.save(employee); // will return either the exception or true ani 
			return true;
//		}
//		else throw new InvalidEmployeeObjectException(environment.getProperty("ems.invalid.emp-details"));
		
		
		
	}

	@Override
	public boolean updateEmployee(int eid, Employee employee) {
//		if(eid > 0 && employee!=null 
//				&& employee.getEid() >0 
//				&& employee.getEname()!=null 
//				&& employee.getDno() >0
//				&& employee.getEsalary()>0) {
			if(!repo.existsById(eid)) throw new InvalidEmployeeNotFoundException(environment.getProperty("ems.invalid.emp-notfound"));
			repo.save(employee);
			return true;
//		} else throw new InvalidEmployeeObjectException(environment.getProperty("ems.invalid.emp-details"));
	}

	@Override
	public boolean deleteEmployee(int eid)  {
//		if(eid > 0) { 
			if(!repo.existsById(eid)) throw new InvalidEmployeeNotFoundException(environment.getProperty("ems.invalid.emp-notfound"));
			repo.deleteById(eid);  
			return true;
//		else throw new InvalidEmployeeObjectException(environment.getProperty("ems.invalid.emp-details"));
	}

	@Override
	public Optional<Employee> findEmployeeById(int eid) throws InvalidEmployeeNotFoundException, InvalidEmployeeObjectException {
		
//		if(eid > 0) {
			if(!repo.existsById(eid)) throw new InvalidEmployeeNotFoundException(environment.getProperty("ems.invalid.emp-notfound"));
			Optional<Employee> employee = repo.findById(eid);
			return employee;
//		} else throw new InvalidEmployeeObjectException(environment.getProperty("ems.invalid.emp-details"));
//		
	}

	@Override
	public List<Employee> findAllEmployees() {
		
		
		List<Employee> employees = (List<Employee>) repo.findAll();
		return employees;
	}

	@Override
	public List<Employee> findEmployeeByName(String ename)  {
		List<Employee> employees = null;
		if(ename!=null) 
		employees = repo.findByEname(ename);
		if(employees.isEmpty()) throw new InvalidEmployeeNotFoundException(environment.getProperty("ems.invalid.emp-notfound"));
		return employees;
//		else throw new InvalidEmployeeObjectException(environment.getProperty("ems.invalid.emp-details"));
			
	}

	@Override
	@Transactional
	public boolean deleteEmployeeByName(String ename) throws InvalidEmployeeObjectException, InvalidEmployeeNotFoundException {
		int n = 0;
		if(ename !=null)  
			n = repo.deleteByEname(ename);  
			if(n==0) throw new InvalidEmployeeNotFoundException(environment.getProperty("ems.invalid.emp-notfound"));
			return true;
			
//		else throw new InvalidEmployeeObjectException(environment.getProperty("ems.invalid.emp-details"));
	
	}

	@Override
	public List<Employee> findEmployeeByDno(int dno) throws InvalidEmployeeNotFoundException, InvalidEmployeeObjectException {
		List<Employee> employees = null;
		if(dno>0) 
		employees = repo.findByDno(dno);
		if(employees.isEmpty()) throw new InvalidEmployeeNotFoundException(environment.getProperty("ems.invalid.emp-notfound"));
		return employees;
		
//		else throw new InvalidEmployeeObjectException(environment.getProperty("ems.invalid.emp-details"));
		
	
	}

	@Override
	public List<Integer> getEidsList() {
		List<Integer> employeesId= repo.getEids();
		return employeesId;
	}

	@Override
	public String getInfo() {
		
		String info = repo.getAggregate();
		return info;
	}

}
