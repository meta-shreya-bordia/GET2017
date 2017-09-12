package assignment1;

import java.util.Comparator;

public class CompareById extends Employee implements Comparator<Employee>{
	@Override
	public int compare(Employee employee1, Employee employee2) {
		return ( employee1.getEmployeeId() - employee2.getEmployeeId() );
	}
}
