package employee;

import java.util.*;
import org.json.simple.JSONObject;

public class EmployeeFacade {
	private Map<String, Employee> emp_available = new HashMap<String, Employee>();
	
	public EmployeeFacade() {
		List<JSONObject> employee_details = FileReader.readFile("Employee.json");
		makeMap(employee_details);
	}
	
	private void makeMap(List<JSONObject> emp_details) {
		for(JSONObject emp: emp_details) {
			Employee add_emp = new Employee(emp.get("ID").toString(), emp.get("Name").toString());
			emp_available.put(add_emp.getEmpName(), add_emp);
		}
	}
	
	//GET
	public Employee getEmployeeByName(String name) {
		for(Map.Entry<String, Employee> emp : emp_available.entrySet()) {
			if(emp.getValue().getEmpName().equals(name)) {
				return emp.getValue();
			}
		}
		return null;
	}
	
	//GET
	public Employee getEmployeeById(String id) {
		for(Map.Entry<String, Employee> emp : emp_available.entrySet()) {
			if(emp.getKey().equals(id)) {
				return emp.getValue();
			}
		}
		return null;
	}
	
	//GET
	public List<Employee> getAllEmployees(){
		List<Employee> employees = new ArrayList<Employee>();
		
		if(emp_available != null && emp_available.size() > 0) {
			for(Map.Entry<String, Employee> emp : emp_available.entrySet()) {
				employees.add(emp.getValue());
			}
		}
		return employees;
	}
	
	//POST
	public void addEmployee(String id, String name) {
		Employee new_emp = new Employee(id, name);
		emp_available.put(id, new_emp);
		
		//write to JSON file this change
	}
	
	//POST
	public void deleteEmployee(String id) {
		emp_available.remove(id);
		
		//write this change to file
	}
}
