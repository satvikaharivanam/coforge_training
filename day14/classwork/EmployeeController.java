package com.coforge.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.coforge.ems.model.Employee;
import com.coforge.ems.service.EmployeeService;

@Controller // we are telling that is acting as controller // this scans the dispatcher- servlet
public class EmployeeController {
	@Autowired // annotation based injection -- to inject dependency object automatically 
	// in springboot   happens automaticallly
	// autowired is the feild injections 
	private EmployeeService service; // using dependency injection 
	
	
	@RequestMapping("home") //this is annotation based
	public ModelAndView loadHomePage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("EmployeeHomePage"); // this will go to the dispatcher servelt 
		// this will internally becomes /web-inf/views/employeehomepage.jsp
		// we can also mention /web-inf/views/employeehomepage.jsp instead of just employeehomepage 
		return mv; //this becomes request dispatcher forword 
		
		//
	}
	
	//using mAttirute automatically 
	@RequestMapping(method = RequestMethod.POST ,value = "employee", params = "insert")
	public ModelAndView createEmployee(@ModelAttribute Employee employee) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("EmployeeHomePage");
		
		boolean status = service.createEmployee(employee);
		String result = "";
		if(status) {
			result = "SUCCESS : Employee Object Saved";
		}else {
			result = "FAIL : Employee Object Not Saved";
		}
		
		
		mv.addObject("result", result);
		return mv;
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "employee" , params = "update")
	public ModelAndView updateEmployee(@ModelAttribute Employee employee) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("EmployeeHomePage");
		
		boolean status = service.updateEmployee(employee);
		String result = "";
		
		if(status) {
			result = "SUCCESS : Employee Object Updated";
		} else {
			result = "FAIL : Employee Object Not Updated";
		}
		
		mv.addObject("result", result);
		return mv;
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "employee" , params = "delete")
	public ModelAndView deleteEmployee(@RequestParam int eid) { // request param is used to get eid from the param
		ModelAndView mv = new ModelAndView();
		mv.setViewName("EmployeeHomePage");
		
		boolean status = service.deleteEmployee(eid);
		String result = "";
		
		if(status) {
			result = "SUCCESS : Employee Object Deleted";
		} else {
			result = "FAIL : Employee Object Not Deleted";
		}
		
		mv.addObject("result", result);
		return mv;
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "employee" , params = "find")
	public ModelAndView FindEmployee(@RequestParam int eid) { // request param is used to get eid from the param
		ModelAndView mv = new ModelAndView();
		mv.setViewName("EmployeeHomePage");
		
		String result = "";
		Employee employee = service.findEmployee(eid);
		if(employee!=null) {
			result = employee.toString();
		} else {
			result = "FAIL : Employee Object Not Found";
		}
		
		mv.addObject("result", result);
		return mv;
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "employee" , params = "findAll")
	public ModelAndView FindAllEmployee() { // request param is used to get eid from the param
		ModelAndView mv = new ModelAndView();
		mv.setViewName("EmployeeHomePage");
		
		String result = "";
		List<Employee> employees = service.findAllEmployee();
		if(employees!=null) {
			result = employees.toString();
		} else {
			result = "FAIL : Employee Object Not Found";
		}
		
		mv.addObject("result", result);
		return mv;
		
	}
	
	
	
	
}	
