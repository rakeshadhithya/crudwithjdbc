package controller;
import java.util.List;
import entity.Employee;
import service.EmployeeService;

/*refactor:
1. handle exceptions nicely later, remove ssl exception and add own exceptions
2. use enums, refer to calculator app
3. write another controller for student table, which runs separately
4. create interfaces instead of hardcoding the service and repo
5. pattern instead of numerous switch cases
*/

import service.EmployeeServiceImpl;

public class EmployeeController {

	EmployeeService employeeService;
	
	public EmployeeController(){
		employeeService = new EmployeeServiceImpl();
	}
	

	//show all employees
	public void findEmployees() {
		List<Employee> employeeList = employeeService.findEmployees();
		System.out.printf("%-12s %-12s %-12s %-12s", "employeeId", "Name", "Department", "Salary");
		System.out.println();
		for(int i=0; i<employeeList.size(); i++) {
			Employee employee = employeeList.get(i);
			int id = employee.getId();
			String name = employee.getName();
			String department = employee.getDepartment();
			String salary = employee.getSalary();
			//System.out.printf("%d\t %s\t %s\t %s%n", id, name, department, salary);
			System.out.printf("%-12d %-12s %-12s %-12s%n", id, name, department, salary);
			
		}
	}


	//add employee
	public void addEmployee(Employee employee) {
		
		int rowsEffected = employeeService.addEmployee(employee);
		if(rowsEffected>0)
			System.out.println("Inserted successfully, no. of rows effected: "+ rowsEffected);
		else
			System.out.println("Insertion Failed. Try inserting again.");
	}
	

	//update employee
	public void updateEmployee(int employeeId, int columnNo, String value) {
		int rowsEffected = employeeService.updateEmployee(employeeId, columnNo, value);
		if(rowsEffected > 0)
			System.out.println("Updated successfully, No. of rows effected: "+ rowsEffected);
		else
			System.out.println("Updation failed, try updating again.");	
	}

	
	//delete employee
	public void deleteEmployee(int employeeId) {
		int rowsEffected = employeeService.deleteEmployee(employeeId);
		if(rowsEffected>0)
			System.out.println("Deleted successfully, No. of rows effected: "+rowsEffected);
		else
			System.out.println("Deletion failed, try deleting again.");		
	}


}
