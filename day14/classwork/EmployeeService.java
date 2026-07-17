package com.coforge.ems.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.coforge.ems.model.Employee;

@Service
public class EmployeeService {
	private List<Employee> employees = new ArrayList<>();

	public boolean createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		boolean status = employees.add(employee);
		
		
		return status;
	}
	
	public boolean updateEmployee(Employee employee) {
		
		
		
		for(int i=0;i<employees.size();i++) {
			Employee emp = employees.get(i);
			if(emp.getEid() == employee.getEid()) {
				employees.remove(i);
				employees.add(employee);
				return true;
			}
		}
		
		return false;
	}

	public boolean deleteEmployee(int eid) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<employees.size();i++) {
			Employee emp = employees.get(i);
			if(emp.getEid() == eid) {
				employees.remove(i);
				return true;
			}
		}
		return false;
	}

	public Employee findEmployee(int id) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<employees.size();i++) {
			Employee emp = employees.get(i);
			if(emp.getEid() == id) {
					
				return emp;
			}
		}
		return null;
	}

	public List<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		
		return employees;
	}
	
}
