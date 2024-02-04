package com.tap.application;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.tap.dao.EmployeeBOIMP;
import com.tap.module.Employee;


@WebServlet("/EditServlet2")  
public class EditServlet2 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	        int id = Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			String email = request.getParameter("email");
			String department = request.getParameter("department");
			int salary = Integer.parseInt(request.getParameter("salary"));
			PrintWriter out = response.getWriter();		
			Employee employee = new Employee(id, name, email, department, salary);
			EmployeeBOIMP em = new EmployeeBOIMP();
			response.setContentType("text/html");
			int update = em.update(employee);
			
			if(update >0) {
				response.sendRedirect("View.jsp");  	
			}
			else{  
	            out.println("Sorry! unable to update record");  
	        }  
	          
	}

}
