package com.tap.application;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/Login")
public class Login extends HttpServlet {
	static int  count=3;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
       
		
		if((name.equals("venkat"))&& (password.equals("venkat@123")))
		{
			RequestDispatcher rd1 = request.getRequestDispatcher("/index.html");
		    rd1.forward(request, response);
		    count=3;
			
		}
		else
		{
			if(count-->1)
			{
				 request.setAttribute("message", count);
				RequestDispatcher rd2 = request.getRequestDispatcher("/login2jsp.jsp");
				
				rd2.forward(request, response);
			}
			else
			{
				RequestDispatcher rd3 = request.getRequestDispatcher("/blocked.html");
				rd3.forward(request, response);
			}
			
		}
		
		
	}

}
