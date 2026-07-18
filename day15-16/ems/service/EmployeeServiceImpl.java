package com.coforge.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coforge.ems.model.Employee;
import com.coforge.ems.repo.EmployeeRepo;
import com.corforge.ems.exception.InvalidEmployeeNotFoundException;
import com.corforge.ems.exception.InvalidEmployeeObjectException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepo repo;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public boolean saveEmployee(Employee employee) throws InvalidEmployeeObjectException {
		if(employee!=null 
				&& employee.getEid() > 0 
				&& employee.getEname()!=null 
				&& employee.getDno()>0 
				&& employee.getEsalary()>0) {
			
			repo.save(employee); // will return either the exception or true ani 
			return true;
		}
		else throw new InvalidEmployeeObjectException();
		
		
		
	}

	@Override
	public boolean updateEmployee(int eid, Employee employee) throws InvalidEmployeeObjectException, InvalidEmployeeNotFoundException {
		if(eid > 0 && employee!=null 
				&& employee.getEid() >0 
				&& employee.getEname()!=null 
				&& employee.getDno() >0
				&& employee.getEsalary()>0) {
			if(!repo.existsById(eid)) throw new InvalidEmployeeNotFoundException();
			repo.save(employee);
			return true;
		} else throw new InvalidEmployeeObjectException();
	}

	@Override
	public boolean deleteEmployee(int eid) throws InvalidEmployeeObjectException, InvalidEmployeeNotFoundException {
		if(eid > 0) { 
			if(!repo.existsById(eid)) throw new InvalidEmployeeNotFoundException();
			repo.deleteById(eid);  
			return true;}
		else throw new InvalidEmployeeObjectException();
	}

	@Override
	public Optional<Employee> findEmployeeById(int eid) throws InvalidEmployeeNotFoundException, InvalidEmployeeObjectException {
		
		if(eid > 0) {
			if(!repo.existsById(eid)) throw new InvalidEmployeeNotFoundException();
			Optional<Employee> employee = repo.findById(eid);
			return employee;
		} else throw new InvalidEmployeeObjectException();
		
	}

	@Override
	public List<Employee> findAllEmployees() {
		
		
		List<Employee> employees = (List<Employee>) repo.findAll();
		return employees;
	}

	@Override
	public List<Employee> findEmployeeByName(String ename) throws InvalidEmployeeObjectException, InvalidEmployeeNotFoundException {
		List<Employee> employees = null;
		if(ename!=null) {
		employees = repo.findByEname(ename);
		if(employees.isEmpty()) throw new InvalidEmployeeNotFoundException();
		return employees;}
		else throw new InvalidEmployeeObjectException();
		
	}

	@Override
	@Transactional
	public boolean deleteEmployeeByName(String ename) throws InvalidEmployeeObjectException, InvalidEmployeeNotFoundException {
		if(ename !=null) { 
		
			int n = repo.deleteByEname(ename);  
			if(n==0) throw new InvalidEmployeeNotFoundException();
			return true;
			}
		else throw new InvalidEmployeeObjectException();
	
	}

	@Override
	public List<Employee> findEmployeeByDno(int dno) throws InvalidEmployeeNotFoundException, InvalidEmployeeObjectException {
		List<Employee> employees = null;
		if(dno>0) {
		employees = repo.findByDno(dno);
		if(employees.isEmpty()) throw new InvalidEmployeeNotFoundException();
		return employees;
		}
		else throw new InvalidEmployeeObjectException();
		
	
	}

	@Override
	public List<Integer> getEidsList() {
		List<Integer> employeesId= repo.getEids();
		return employeesId;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		
		String info = repo.getAggregate();
		return info;
	}
	
}
