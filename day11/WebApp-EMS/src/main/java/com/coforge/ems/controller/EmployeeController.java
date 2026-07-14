package com.coforge.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coforge.ems.exception.InvalidEmployeeObjectException;
import com.coforge.ems.model.Employee;
import com.coforge.ems.service.EmployeeService;
import com.coforge.ems.util.ApplicationProperties;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {

	private EmployeeService service = new EmployeeService();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int eid = Integer.parseInt(request.getParameter("eid"));
		PrintWriter out = response.getWriter();
		String result = "";
		
		Employee employee;
		try {
			employee = service.showEmployee(eid);
			result = employee.getEid() + " "+ employee.getEname() +" "+ employee.getEsalary() + " "+ employee.getDno();
		} catch (ClassNotFoundException | SQLException | InvalidEmployeeObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("EMSButton");
		int eid = 0;
		String ename = "";
		int esalary = 0;
		int dno = 0;
		Employee employee = null;
		String result = "";
		int n = 0;
		switch(action) {
		case "Insert":
			eid = Integer.parseInt(request.getParameter("eid"));
			ename = request.getParameter("ename");
			esalary= Integer.parseInt(request.getParameter("esalary"));
			dno = Integer.parseInt(request.getParameter("dno"));
			
			employee = new Employee(eid,ename,esalary,dno);
			try {
				n = service.createEmployee(employee);
				if(n==1) result = ApplicationProperties.insertSuccess;
			} catch (ClassNotFoundException | SQLException e) {
				result = ApplicationProperties.DBfail;
			}catch (InvalidEmployeeObjectException e) {
				result = e.getMessage();
			}
			
			response.sendRedirect("index.jsp?result="+result);
			break;	
		case "Update":
			eid = Integer.parseInt(request.getParameter("eid"));
			ename = request.getParameter("ename");
			esalary= Integer.parseInt(request.getParameter("esalary"));
			dno = Integer.parseInt(request.getParameter("dno"));
			
			employee = new Employee(eid,ename,esalary,dno);
			try {
				n = service.updateEmployee(employee);
				if(n==1) result = ApplicationProperties.updateSuccess;
				if(n==0) result = ApplicationProperties.notFound;
			} catch (ClassNotFoundException | SQLException e) {
				result = ApplicationProperties.DBfail;
			}catch (InvalidEmployeeObjectException e) {
				result = e.getMessage();
			}
			
			response.sendRedirect("index.jsp?result="+result);
			break;
		case "Delete":
			eid = Integer.parseInt(request.getParameter("eid"));
			
			try {
				n = service.deleteEmployee(eid);
				if(n==0) result = ApplicationProperties.notFound;
				if(n==1) result = ApplicationProperties.deleteSuccess;
			} catch (ClassNotFoundException | SQLException e) {
				result = ApplicationProperties.DBfail;
			} catch (InvalidEmployeeObjectException e) {
				e.getMessage();
			}
			
			response.sendRedirect("index.jsp?result="+result);
			
			break;
		case "Find":
			eid = Integer.parseInt(request.getParameter("eid"));
			try {
				employee = service.showEmployee(eid);
//				System.out.println(employee);
//				System.out.println(employee.getEid());
//				System.out.println(employee.getEname());
//				System.out.println(employee.getEsalary());
//				System.out.println(employee.getDno());
				result = employee.toString();

				response.sendRedirect(
				    "index.jsp?result=" +
				    URLEncoder.encode(result, StandardCharsets.UTF_8)
				);

//				 response.sendRedirect(
//					        "index.jsp?eid=" + employee.getEid() +
//					        "&ename=" + employee.getEname() +
//					        "&esalary=" + employee.getEsalary() +
//					        "&dno=" + employee.getDno());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				result = ApplicationProperties.DBfail;
			} catch(InvalidEmployeeObjectException e) {
				result = e.getMessage();
			}
			
//			result = employee.toString();
//			response.sendRedirect( "index.jsp?eid=" + employee.getEid() +
//				    "&ename=" + employee.getEname() +
//				    "&esalary=" + employee.getEsalary() +
//				    "&dno=" + employee.getDno());
			break;
		case "FindAll":
			
			List<Employee> employees = null;
			try {
				employees = service.showAllEmployees();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				result = ApplicationProperties.DBfail;
			} catch( InvalidEmployeeObjectException e) {
				result = e.getMessage();
			}
			
			result = employees.toString();
//			response.sendRedirect("index.jsp?result="+result);
			
			response.sendRedirect(
				    "index.jsp?result=" +
				    URLEncoder.encode(result, StandardCharsets.UTF_8)
				);
			break;
		}
		
	}

}
