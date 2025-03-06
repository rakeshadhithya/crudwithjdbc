package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Employee;
//refactor later, instead of always creating connection, statement, resultset objects
//use enum for column name
//place holders can only be used for values not for column names, instead verify 
//the column names and then write the query with place holders and string concatanation

public class EmployeeDaoImpl implements EmployeeDao{

	private static String url = "jdbc:mysql://localhost:3306/rakeshdb";

	
	//get the total rows in employees
	public int count(){
		String sqlQuery = "select count(*) from employees";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int count = -1;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, "root", "root");
			preparedStatement = connection.prepareStatement(sqlQuery);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
				count = resultSet.getInt(1);

		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	
	
	//get all employees
	public List<Employee> findEmployees() {
		String query = "select * from employees";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Employee> employeeList = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, "root", "root");
			
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Employee employee = new Employee();
				employee.setId(resultSet.getInt(1));
				employee.setName(resultSet.getString(2));
				employee.setDepartment(resultSet.getString(3));
				employee.setSalary(resultSet.getString(4));
				employeeList.add(employee);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return employeeList;
	}
	


	//insert an employee
	public Integer addEmployee(Employee employee) {
		String sqlQuery = "insert into employees values(?, ?, ?, ?)";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rowsEffected = -1;
		
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			connection = DriverManager.getConnection(url, "root", "root");
			preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, employee.getId());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setString(3, employee.getDepartment());
			preparedStatement.setString(4, employee.getSalary());
			
			rowsEffected = preparedStatement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		
		return rowsEffected;
		
		
	}


	//update an employee
	//try with resources used, finally not required
	public Integer updateEmployee(int employeeId, int columnNo, String value) {	
		//identify the column name based on columnNo
		String columnName = null;
		switch(columnNo) {
		case 2: {
			columnName = "name";
			break;
		}
		case 3:{
			columnName = "department";
			break;
		}
		case 4:{
			columnName = "salary";
			break;
		}
		}
			
		//quotes must be used in sql query to specify its a string
		String sqlQuery = "update employees set " + columnName + " = ?  where id = ? ";
		int rowsEffected = -1;
		
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			try(Connection connection = DriverManager.getConnection(url, "root", "root");
				PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
				preparedStatement.setString(1, value);
				preparedStatement.setInt(2, employeeId);	
				rowsEffected = preparedStatement.executeUpdate();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
		return rowsEffected;
	}


	
	//delete employee
	//try with resources used, finally not required
	public Integer deleteEmployee(int employeeId) {
		String sqlQuery = "delete from employees where id=?";
		int rowsEffected = -1;
		
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			try(Connection connection = DriverManager.getConnection(url, "root", "root");
				PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
				
				preparedStatement.setInt(1, employeeId);
				rowsEffected = preparedStatement.executeUpdate();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return rowsEffected;
	}

}
