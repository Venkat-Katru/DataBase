package com.tap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.module.Employee;

public class EmployeeBOIMP  implements EmployeeBO{
	private static Connection con=null;
	private static PreparedStatement pt=null;
	private static Statement ct=null;
	private static ResultSet res=null;
	private static final String INSERT_QUERY="insert into `employee`(`id`,`name`,`email`,`department`,`salary`)values(?,?,?,?,?)";
	
	private static final String UPDATE_QUERY="update `employee` set `name`=?,`email`=?,`department`=?,`salary`=? where `id`=?" ;
	private static final String DELETE_QUERY="delete from  `employee` where `id`=?";
	private static final String SELECT_QUERY="select * from `employee`";
	
	public EmployeeBOIMP() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database1","root","root");
		}
		catch(ClassNotFoundException | SQLException e1)
		{
			e1.printStackTrace();
		}
	}

	
	public int save(Employee e) {
		try {
			 pt = con.prepareStatement(INSERT_QUERY);
			pt.setInt(1, e.getId());
			pt.setString(2,e.getName());
			pt.setString(3,e.getEmail());
			pt.setString(4,e.getDepartment());
			pt.setInt(5, e.getSalary());
			return pt.executeUpdate();
			
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}	
		return 0;
	}

	
	public int update(Employee e) {
		
		 try {
			pt = con.prepareStatement(UPDATE_QUERY);
			pt.setString(1,e.getName());
			pt.setString(2,e.getEmail());
			pt.setString(3,e.getDepartment());
			pt.setInt(4, e.getSalary());
			pt.setInt(5, e.getId());
			return pt.executeUpdate();
		
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
			
			
		return 0;
	}
	
	public int delete(int id) {
		
		try {
			pt=con.prepareStatement(DELETE_QUERY);
			pt.setInt(1,id);
			return pt.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return 0;
	}

	public int delete(Employee e) {
		
		return delete(e.getId());
	}

	@Override
	public Employee get(int id) {
		String SELECT_QUERY1="select * from `employee` where `id`="+id;
		Employee e2 = new Employee();
		try {
		   ct = con.createStatement();
		   res = ct.executeQuery(SELECT_QUERY1);
			 while(res.next())
			 {
				 int id1 = res.getInt("id");
				 String name=res.getString("name");
				 String email=res.getString("email");
				 String department=res.getString("department");
				 int salary = res.getInt("salary");
				 
				 e2.setId(id1);
				 e2.setName(name);
				 e2.setEmail(email);
				 e2.setDepartment(department);
				 e2.setSalary(salary);
				 return e2;
				
			 }
		}
			 
			
			
		 catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	
	public List<Employee> getall() {
		
		ArrayList<Employee> arrayList1 = new ArrayList<Employee>();
		try {
			 ct = con.createStatement();
			 res = ct.executeQuery(SELECT_QUERY);
			 while(res.next())
			 {
				 int id = res.getInt("id");
				 String name=res.getString("name");
				 String email=res.getString("email");
				 String department=res.getString("department");
				 int salary = res.getInt("salary");
				 
				 Employee e = new Employee(id, name, email, department, salary);
				 arrayList1 .add(e);			 }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		return arrayList1;
	}
	
	

}
