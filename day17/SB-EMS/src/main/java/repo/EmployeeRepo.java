package com.coforge.ems.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coforge.ems.model.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
	// to automattically create the implemention of the reposotory i.e. the 
	// database connetions 
	// by mentioning the <Entity class, type of the primary key>
	// ioc container will give the implementations 
	public List<Employee> findByEname(String ename);
//	public void deleteByEname(String ename);
	public int deleteByEname(String ename);
	public List<Employee> findByDno(int dno);
	
	// custom query methods 
	@Query("select eid from Employee")
	public List<Integer> getEids();
	
	@Query("select max(esalary),min(esalary),sum(esalary),avg(esalary),count(*) from Employee")
	public String getAggregate();

}

/*
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	
	
}
*/
