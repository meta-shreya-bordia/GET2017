package employee;

public class Employee {
	private String id, emp_name;
	
	public Employee() {
		
	}
	
	public Employee(String id, String name) {
		this.id = id;
		this.emp_name = name;
	}

	public String getId() {
		return id;
	}

	public String getEmpName() {
		return emp_name;
	}
}
