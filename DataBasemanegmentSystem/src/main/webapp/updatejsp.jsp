<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 

import="com.tap.dao.EmployeeBOIMP, com.tap.module.Employee" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Employee</title>
    <link rel='stylesheet' type='text/css' href='style2.css'>
</head>
<body>
    <%
        response.setContentType("text/html");
        int id = Integer.parseInt(request.getParameter("id"));
        EmployeeBOIMP employeeBOIMP = new EmployeeBOIMP();
        Employee e11 = employeeBOIMP.get(id);
    %>
    <div class="main">
        <div class="reg">
            <h1 style='text-align:center;'>Update Employee</h1>
            <form action='EditServlet2' method='post' id="in">
                <br>
                <br>
                <label>ID:</label><br>
                <input type="number" name="id" id="na1" value="<%= e11.getId() %>" placeholder="Enter your id"><br>

                <label>NAME:</label><br>
                <input type="text" name="name" id="na2" value="<%= e11.getName() %>" placeholder="Enter your name"><br><br>

                <label>EMAIL:</label><br>
                <input type="email" name="email" id="na3" value="<%= e11.getEmail() %>" placeholder="Enter your Email"><br><br>

                <label>DEPARTMENT:</label>&nbsp; &nbsp;
                <select name="department" style="width:150px" id="sec">
                    <option value="<%= e11.getDepartment() %>"><%= e11.getDepartment() %></option>
                    <option>select</option>
                    <option>HR</option>
                    <option>IT</option>
                    <option>SALES</option>
                    <option>BUSINESS</option>
                    <option>MARKETING</option>
                    <option>Other</option>
                </select><br><br>
                
                <label>SALARY:</label><br>
                <input type="number" name="salary" id="na4" value="<%= e11.getSalary() %>" placeholder="Enter your salary"><br><br>

                <button type="submit" value="Save Employee" id="sub">Update</button>
            </form>
        </div>
    </div>
</body>
</html>                                               