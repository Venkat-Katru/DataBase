<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  
import="java.util.List,com.tap.dao.EmployeeBOIMP, com.tap.module.Employee"  %>
<!DOCTYPE html>
<html>
<head>
    <title>View Employees</title>
    <link rel="stylesheet" type="text/css" href="table.css">
</head>
<body>
    <a href='index.html'>
        <button type="button" id="bt3">Add New Employee</button>
    </a>
    <%
        EmployeeBOIMP em = new EmployeeBOIMP();
        List<Employee> list = em.getall();
    %>
    
    <table>
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>EMAIL</th>
            <th>DEPARTMENT</th>
            <th>SALARY</th>
            <th>EDIT</th>
            <th>DELETE</th>
        </tr>
        <%
            for (Employee e : list) {
        %>
        <tr>
            <td><%= e.getId() %></td>
            <td><%= e.getName() %></td>
            <td><%= e.getEmail() %></td>
            <td><%= e.getDepartment() %></td>
            <td><%= e.getSalary() %></td>
            <td>
                <a href='updatejsp.jsp?id=<%= e.getId() %>'>
                    <button id="bt1" type="button">EDIT</button>
                </a>
            </td>
            <td>
                <a href='DeleteServlet?id=<%= e.getId() %>'>
                    <button id="bt2" type="button">DELETE</button>
                </a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>