package service;

import java.util.List;

import dao.EmployeeDaoImpl;
import entity.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	
	EmployeeDaoImpl employeeDao;
	
	public EmployeeServiceImpl(){
		employeeDao = new EmployeeDaoImpl();
	}
	

	//show all employees
	public List<Employee> findEmployees() {
		return employeeDao.findEmployees();
	}


	//add employee
	public Integer addEmployee(Employee employee) {
		
		int totalEmployees = employeeDao.count();	
		int id = totalEmployees + 1;
		employee.setId(id);
		int rowsEffected = employeeDao.addEmployee(employee);
		return rowsEffected;
	}
	

	//update employee
	public Integer updateEmployee(int employeeId, int columnNo, String value) {
		int rowsEffected = employeeDao.updateEmployee(employeeId, columnNo, value);
		return rowsEffected;
		
	}

	
	//delete employee
	public Integer deleteEmployee(int employeeId) {
		int rowsEffected = employeeDao.deleteEmployee(employeeId);
		return rowsEffected;
		
	}

}
