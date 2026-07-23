package com.coforge.ems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.ems.dto.DepartmentDTO;
import com.coforge.ems.dto.EmployeeDTO;
//import com.coforge.ems.exception.InvalidEmployeeNotFoundException;
//import com.coforge.ems.exception.InvalidEmployeeObjectException;
import com.coforge.ems.model.Employee;
import com.coforge.ems.service.EmployeeService;

import jakarta.validation.Valid;

// @Controller  -- returns webpages like jsp
// when we us @controller we need to annotate every method with responce controller,
// to return the output 
// @restcontroller -- returns Returns REST API responses (JSON/XML/Text)
// @RestController it combines @Controller and @ResponseBody, so every method 
// automatically returns the response body (typically JSON), 
// eliminating the need to annotate each method with @ResponseBody.
@RestController // because this is a restful application
@RequestMapping("/api/v1/ems")
public class EmployeeController {

//	
//	@GetMapping("/welcome") // url pattern must me small 
//	public String sayWelcome() {
//		return "heyo";
//	}

	// this is field injection
	// this injection after the object to created
	// this for testing and fast writing of the code we use field injection
//	@Autowired because field is least preffered 
	private EmployeeService service;
	private Environment environment;

	// this is constructor injection
	// in this in starting injection will happened when the control comes to
	// controller
	@Autowired
	public EmployeeController(EmployeeService service, Environment environment) {
		super();
		this.service = service;
		this.environment = environment;
	}

	@PostMapping("/employees")
	public ResponseEntity<String> saveEmployee(@Valid @RequestBody Employee employee) {
		// in case of spring mvc we use modelattribute
		// and we use modelattrube becasue the data is coming from http protocal
		// postman send the data by binding the data coming for other app in
		// form of http request protocal body
		ResponseEntity<String> responseEntity = null;
		
		
			boolean status = service.saveEmployee(employee);
			if (status) 
				responseEntity = new ResponseEntity<>(environment.getProperty("ems.save.successInsert"),HttpStatus.OK);
		
		return responseEntity;

	}

	@PutMapping("/employees/{eid}")
	public ResponseEntity<String> updateEmployee( @PathVariable("eid") int eid,@Valid @RequestBody Employee employee) {
		// in case of spring mvc we use modelattribute
		// and we use modelattrube becasue the data is coming from http protocal
		// postman send the data by binding the data coming for other app in
		// form of http request protocal body
		ResponseEntity<String> responseEntity = null;
//		try {
			boolean status = service.updateEmployee(eid, employee);
			if (status) {
				responseEntity = new ResponseEntity<>(environment.getProperty("ems.save.successUpdate"), HttpStatus.OK);
			} // why should we not use try catch in controller?  because each module must have single responsibility 
//		} catch (InvalidEmployeeObjectException e) {
//			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
//		} catch (InvalidEmployeeNotFoundException e) {
//			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
//		} catch (Exception e) {
//
//			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.fail"), HttpStatus.BAD_REQUEST);
//		}
		return responseEntity;

	}

	@DeleteMapping("/employees/{eid}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("eid") int eid) {
		// in case of spring mvc we use modelattribute
		// and we use modelattrube becasue the data is coming from http protocal
		// postman send the data by binding the data coming for other app in
		// form of http request protocal body
		ResponseEntity<String> responseEntity = null;
//		try {
			boolean status = service.deleteEmployee(eid);
			if (status) {
				responseEntity = new ResponseEntity<>(environment.getProperty("ems.delete.successDelete"),
						HttpStatus.OK);
			}
//		} catch (InvalidEmployeeObjectException e) {
//			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
//		} catch (InvalidEmployeeNotFoundException e) {
//			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
//		} catch (Exception e) {
//			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.fail"), HttpStatus.BAD_REQUEST);
//		}
		return responseEntity;

	}

	@GetMapping("/employees/{eid}")
	public ResponseEntity<?> findEmployee(@PathVariable("eid") int eid) {
		// in case of spring mvc we use modelattribute
		// and we use modelattrube becasue the data is coming from http protocal
		// postman send the data by binding the data coming for other app in
		// form of http request protocal body
		ResponseEntity<?> responseEntity = null;
//		try {
			Optional<Employee> employee = service.findEmployeeById(eid);
			if (employee.get()!=null) {
				responseEntity = new ResponseEntity<>(employee.get(),HttpStatus.OK);
			}
//		} catch (InvalidEmployeeObjectException e) {
//			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
//		} catch (InvalidEmployeeNotFoundException e) {
//			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
//		} catch (Exception e) {
////			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.fail"), HttpStatus.BAD_REQUEST);
//		}
		return responseEntity;

	}
	
	@GetMapping("/employees")
	public ResponseEntity<?> findAllEmployee() {
		// in case of spring mvc we use modelattribute
		// and we use modelattrube becasue the data is coming from http protocal
		// postman send the data by binding the data coming for other app in
		// form of http request protocal body
		ResponseEntity<?> responseEntity = null;
//		try {
			List<Employee> employees = service.findAllEmployees();
//			if (!employees.isEmpty()) {
				responseEntity = new ResponseEntity<>(employees,HttpStatus.OK);
//			}
//		} catch (InvalidEmployeeObjectException e) {
//			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
//		} catch (InvalidEmployeeNotFoundException e) {
//			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
//		} catch (Exception e) {
//			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.fail"), HttpStatus.BAD_REQUEST);
//		}
		return responseEntity;

	}
	
	@GetMapping("/employees/ename/{ename}")
	public ResponseEntity<?> findEmployeeByName(@PathVariable("ename") String ename) {
		// in case of spring mvc we use modelattribute
		// and we use modelattrube becasue the data is coming from http protocal
		// postman send the data by binding the data coming for other app in
		// form of http request protocal body
		ResponseEntity<?> responseEntity = null;
//		try {
			List<Employee> employees = service.findEmployeeByName(ename);
			if (!employees.isEmpty()) {
				responseEntity = new ResponseEntity<>(employees,HttpStatus.OK);
			}
//		} catch (InvalidEmployeeObjectException e) {
//			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
//		} catch (InvalidEmployeeNotFoundException e) {
//			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
//		} catch (Exception e) {
//			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.fail"), HttpStatus.BAD_REQUEST);
//		}
		return responseEntity;

	}
	
	@DeleteMapping("/employees/ename/{ename}")
	public ResponseEntity<?> deleteEmployeeByName(@PathVariable("ename") String ename) {
		// in case of spring mvc we use modelattribute
		// and we use modelattrube becasue the data is coming from http protocal
		// postman send the data by binding the data coming for other app in
		// form of http request protocal body
		ResponseEntity<?> responseEntity = null;
//		try {
			boolean status = service.deleteEmployeeByName(ename);
			if (status) {
				responseEntity = new ResponseEntity<>(environment.getProperty("ems.delete.successDelete"),
   HttpStatus.OK);
			}
//		} catch (InvalidEmployeeObjectException e) {
//			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
//		} catch (InvalidEmployeeNotFoundException e) {
//			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
//		} catch (Exception e) {
//			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.fail"), HttpStatus.BAD_REQUEST);
//		}
		return responseEntity;

	}
	
	@GetMapping("/employees/dno/{dno}")
	public ResponseEntity<?> findEmployeeByDno(@PathVariable("dno") int dno) {
		// in case of spring mvc we use modelattribute
		// and we use modelattrube becasue the data is coming from http protocal
		// postman send the data by binding the data coming for other app in
		// form of http request protocal body
		ResponseEntity<?> responseEntity = null;
//		try {
			List<Employee> employees = service.findEmployeeByDno(dno);
			if (!employees.isEmpty()) {
				responseEntity = new ResponseEntity<>(employees,HttpStatus.OK);
			}
//		} catch (InvalidEmployeeObjectException e) {
//			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
//		} catch (InvalidEmployeeNotFoundException e) {
//			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
//		} catch (Exception e) {
//			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.fail"), HttpStatus.BAD_REQUEST);
//		}
		return responseEntity;

	}
	
	@GetMapping("/employees/eids")
	public ResponseEntity<?> getEidsList() {
		// in case of spring mvc we use modelattribute
		// and we use modelattrube becasue the data is coming from http protocal
		// postman send the data by binding the data coming for other app in
		// form of http request protocal body
		ResponseEntity<?> responseEntity = null;
//		try {
			List<Integer> employees = service.getEidsList();
//			if (!employees.isEmpty()) {
				responseEntity = new ResponseEntity<>(employees,HttpStatus.OK);
//			}
//		} catch (InvalidEmployeeObjectException e) {
//			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
//		} catch (InvalidEmployeeNotFoundException e) {
//			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
//		} catch (Exception e) {
//			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.fail"), HttpStatus.BAD_REQUEST);
//		}
		return responseEntity;

	}
	
	@GetMapping("/employees/info")
	public ResponseEntity<?> getInfo() {
		// in case of spring mvc we use modelattribute
		// and we use modelattrube becasue the data is coming from http protocal
		// postman send the data by binding the data coming for other app in
		// form of http request protocal body
		ResponseEntity<?> responseEntity = null;
//		try {
			String info = service.getInfo();
//			if (!employees.isEmpty()) {
				responseEntity = new ResponseEntity<>(info,HttpStatus.OK);
//			}
//		} catch (InvalidEmployeeObjectException e) {
//			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
//		} catch (InvalidEmployeeNotFoundException e) {
//			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
//		} catch (Exception e) {
//			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.fail"), HttpStatus.BAD_REQUEST);
//		}
		return responseEntity;

	}
	
	// rest end points for feignclient departement
	@GetMapping("/employees/departments/{dno}")
	public ResponseEntity<?> findDepartmentById(@PathVariable("dno") int dno){
		ResponseEntity<?> responseEntity = null;
		DepartmentDTO department = service.findDepartmentById(dno);
		if(department!=null)
		responseEntity = new ResponseEntity<>(department,HttpStatus.OK);
		else responseEntity = new ResponseEntity<>("Department Not Found",HttpStatus.BAD_REQUEST);
		return responseEntity;
	}
	
	@GetMapping("/employees/departments")
	public ResponseEntity<List<DepartmentDTO>> findAllDepartments(){
		ResponseEntity<List<DepartmentDTO>> responseEntity = null;
		List<DepartmentDTO> departments = service.findAllDepartments();
//		if(!departments.isEmpty())
		responseEntity = new ResponseEntity<>(departments,HttpStatus.OK);
//		else responseEntity = new ResponseEntity<>("Departments Not Found",HttpStatus.BAD_REQUEST);
		return responseEntity;
	}
	
	@GetMapping("/employees/{eid}/departments")
	public ResponseEntity<?> findEmployeeDetails(@PathVariable("eid") int eid){
		ResponseEntity<?> responseEntity = null;
//		try {
			EmployeeDTO employeeDTO = null;
			Employee employee = service.findEmployeeById(eid).get();
			DepartmentDTO department = service.findDepartmentById(employee.getDno());
			employeeDTO = new EmployeeDTO(employee,department);
			if (employee!=null) {
				responseEntity = new ResponseEntity<>(employeeDTO,HttpStatus.OK);
			}
			
			return responseEntity;
	}

}
