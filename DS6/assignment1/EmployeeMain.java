package assignment1;

import java.util.*;

public class EmployeeMain {
	EmployeeList getEmployees;
	Scanner input;
	
	public EmployeeMain() {
		getEmployees = new EmployeeList();
		input = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		EmployeeMain emp = new EmployeeMain();
		
		while(true) {
			emp.startMenu();
		}
	}
	
	public void startMenu() {
		System.out.println("1. Add an employee"
					   + "\n2. Delete an Employee"
					   + "\n3. View employees sorted by Natural Order"
					   + "\n4. View Employees sorted by ID"
					   + "\n5. Exit");
		
		int option = input.nextInt();
		
		performAction(option);
	}
	
	public void performAction(int option) {
		switch(option) {
		case 1:
			boolean added = getEmployees.add( inputEmployeeDetails() );
			String message = (added ? "Employee successfully added to list" : "Sorry. Employee already exists in database"); 
			System.out.println(message);
			
			break;
		case 2:
			boolean removed = getEmployees.remove( inputEmployeeId() );
			String msg = (removed ? "Employee successfully removed from list" : "Sorry. Employee does not exist in database"); 
			
			System.out.println(msg);
			break;
		
		case 3: 
			getEmployees.sortByNaturalOrdering();
			printEmployeeList();
			break;
		case 4: 
			getEmployees.sortById();
			printEmployeeList();
			break;
		case 5: System.exit(0);
			break;
		}
	}
	
	public Employee inputEmployeeDetails() {
		String name, address;
		int id;
		
		System.out.println("Please provide us your details:"
						+ "\nEnter Employee ID");
		id = input.nextInt();
		
		while( id <= 0 ) {
			System.out.println("Invalid ID details");
			id = input.nextInt();
		}
		
		System.out.println("Enter Employee Name");
		name = input.next();
		
		System.out.println("Enter Employee Address");
		address = input.next();
		
		return new Employee( name, id, address);
	}
	
	public int inputEmployeeId() {
		System.out.println("Enter Employee ID to remove:");
		int id = input.nextInt();
		return id;
	}
	
	public void printEmployeeList() {
		List<Employee> employeeDetails = getEmployees.getEmployeeList();
		
		if( employeeDetails.isEmpty() ) {
			System.out.println("No employees in record."
							+ "\nAdd an employee?");
			return;
		}
		
		System.out.println("Employee Name\t\tEmployee ID\t\tEmployee Address");
		for( Employee emp: employeeDetails ) {
			System.out.println(emp.getEmployeeName() + "\t\t" + emp.getEmployeeId() + "\t\t" + emp.getEmployeeAddress() );
		}
		System.out.print("\n\n\n");
	}
}
    