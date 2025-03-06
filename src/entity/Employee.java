package entity;

public class Employee {
	
	private Integer id;
	private String name;
	private String department;
	private String salary;
	
	
	public Employee(Integer id, String name, String department, String salary) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	public Employee(){}

	
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}

}
