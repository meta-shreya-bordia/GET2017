package assignment1;

public class Employee implements Comparable<Employee>{
	private String employeeName;
	public int employeeId;
	private String employeeAddress;
	
	public Employee() {
		
	}
	
	public Employee( String name, int id, String address) {
		this.employeeAddress = address;
		this.employeeId		 = id;
		this.employeeName	 = name;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}
	
/*****FOR INSERTING ONLY UNIQUE KEYS**/
	@Override
	public int hashCode() {
		return getEmployeeId();
	}
	
	@Override
	public boolean equals(Object employee) {
		if( employee != null && employee instanceof Employee && getEmployeeId() == ((Employee)employee).getEmployeeId() )
			return true;
		
		return false;
	}
	
/*******NATURAL ORDER SORTING**********/
	@Override
	public int compareTo(Employee employee2) {
		int difference = this.getEmployeeName().compareToIgnoreCase( employee2.getEmployeeName() );
		
		if ( difference == 0 ) {
			return ( this.getEmployeeId() - employee2.getEmployeeId() );
		}
		
		return difference;
	}
}