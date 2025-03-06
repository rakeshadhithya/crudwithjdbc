package service;

import java.util.List;

import entity.Employee;

public interface EmployeeService {
    
    public List<Employee> findEmployees();
    public Integer addEmployee(Employee employee);
    public Integer updateEmployee(int employeeId, int columnNo, String value);
    public Integer deleteEmployee(int employeeId);
    
}
