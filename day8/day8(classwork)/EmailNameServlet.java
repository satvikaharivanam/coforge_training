package com.coforge.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmailNameServlet
 */
@WebServlet("/EmailNameServlet")
public class EmailNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		
		if(email!= null && email.equals("satvika@gmail.com")) {
			out.println("<b><font color = 'green'>Valid</font></b>");
		}else {
			out.println("<b><font color = 'red'>Invalid</font></b>");
		}
		
		out.close();
	}

	
}
