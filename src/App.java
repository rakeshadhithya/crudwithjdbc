import java.util.Scanner;

import controller.EmployeeController;
import entity.Employee;

public class App {


    	public static void main(String[] args) {
		
		EmployeeController EmployeeController = new EmployeeController();

		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
	
		
		while(flag) {
			System.out.println();
			System.out.println("Select a option:");
			System.out.println("1. Show Employees");
			System.out.println("2. Add Employee");
			System.out.println("3. Update Employee");
			System.out.println("4. Delete Employee");
			System.out.println("5. Exit");
			int option = scanner.nextInt();
			switch(option) {
			
			//show employees
			case 1: {
				EmployeeController.findEmployees();
				break;
			}
			
			//add employee
			case 2: {
				System.out.println("Enter employee name:");
				String employeeName = scanner.next();
				
				System.out.println("Enter employee department:");
				String employeeDepartment = scanner.next();
				
				System.out.println("Enter employee salaray:");
				String employeeSalary = scanner.next();
				
				EmployeeController.addEmployee(new Employee(null,employeeName, employeeDepartment, employeeSalary));
				break;
				
			}
			
			//update employee
			case 3: {
				System.out.println("Enter employee id:");
				int employeeId = scanner.nextInt();
				
				System.out.println("Select a option:");
				System.out.println("2. Update name");
				System.out.println("3. Update department");
				System.out.println("4. Update salary");
				int columnNo = scanner.nextInt(); 
				
				System.out.println("Enter the value to update");
				String value = scanner.next();
                
				EmployeeController.updateEmployee(employeeId, columnNo, value);			
				break;
			}
			
			//delete employee
			case 4: {
				System.out.println("Enter employee id:");
				int employeeId = scanner.nextInt();
				EmployeeController.deleteEmployee(employeeId);
				break;
				
			}
			
			//exit
			case 5: {
				System.out.println("Bye!");
				scanner.close();
				flag=false;
			}
			}
		}	
		
	}

}
