package assignment1;

import java.util.*;

public class EmployeeList {
	private List<Employee> employeeList =  null;
	
	public EmployeeList() {
		employeeList = new ArrayList<Employee>();
	}
	
	public boolean add( Employee employee2 ) {
		if(employee2 == null || employee2.getEmployeeName()== null || employee2.getEmployeeAddress()==null || employeeList.contains(employee2) ) {
			return false;
		}
		
		return employeeList.add( employee2 ); 
	}
	
	public boolean remove( int employeeId ) {
		if( employeeId <= 0 ) {
			return false;
		}
		
		Employee employeeToRemove = null;
		for(Employee emp: employeeList) {
			if( employeeId == emp.getEmployeeId() ) {
				employeeToRemove = emp;
				break;
			}
		}
		
		if( employeeToRemove == null) {
			return false;
		}
		
		employeeList.remove(employeeToRemove);
		return true;
	}
	
	public int size() {
		return employeeList.size();
	}
	
	public List<Employee> getEmployeeList(){
		return this.employeeList;
	}
	
	public Employee getEmployee(int index) {
		return employeeList.get(index);
	}
	
	public void sortById() {
		Collections.sort(employeeList, new CompareById());
	}
	
	public void sortByNaturalOrdering() {
		Collections.sort(employeeList);
	}
	
	public static void main(String[] args) {
		EmployeeList e = new EmployeeList();
		
		e.add(new Employee("llplolpoa", 100, "thus"));
		e.add(new Employee("pppaab", 29, "thus"));
		e.add(new Employee("aac", 3, "thus"));
		e.add(new Employee("pppaab", 24, "thus"));
		e.add(new Employee("hola", 5, "thus"));
		e.add(new Employee("hell", 24, "thus"));
		e.add(new Employee("xyz", 10, "thus"));
		
		for( Employee ee: e.getEmployeeList()) {
			System.out.println(ee.getEmployeeName() + "\t" + ee.getEmployeeId() + "\t" + ee.getEmployeeAddress() );
		}
		
		System.out.println("\n\n\n\n");
		e.sortById();
		
		for( Employee ee: e.getEmployeeList()) {
			System.out.println(ee.getEmployeeName() + "\t" + ee.getEmployeeId() + "\t" + ee.getEmployeeAddress() );
		}
		
		System.out.println("\n\n\n\n");
		e.sortByNaturalOrdering();
		
		for( Employee ee: e.getEmployeeList()) {
			System.out.println(ee.getEmployeeName() + "\t" + ee.getEmployeeId() + "\t" + ee.getEmployeeAddress() );
		}
		
	}
}
