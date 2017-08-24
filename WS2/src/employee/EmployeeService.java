package employee;

import java.util.*;
import java.io.*;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/***
1. Create a Employee
2. Retrieve a employee info by giving its  id as input
3. Retrieve all employees info whose name matches as input name
4. Retrieve all employee
5. Delete an employee by specifying id
***/

@Path("/employees")
public class EmployeeService {
	EmployeeFacade emp_details;
	
	public EmployeeService() {
		emp_details = new EmployeeFacade();
	}

	//POST for creating: Path to each method for be able to locate on browser
	@POST
	@Path("/create/")
	@Produces(MediaType.TEXT_HTML)
//	@Consumes(MediaType.)
	public void createEmployee(@FormParam("id") String id,
			@FormParam("employeename") String name,
			@Context HttpServletResponse response) throws IOException {
		
		emp_details.addEmployee(id, name);
		response.sendRedirect("./getAll");
	}
	
	//GET to display onto browser
	@GET
	@Path("/getAll/")
//	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployees() {
		return emp_details.getAllEmployees();
	}

	@GET
	@Path("getById/{employee}")
	public Employee getEmployee(@PathParam("employee") String id) {
		return emp_details.getEmployeeById(id);
	}
	
	@POST
	@Path("/getById")
	@Produces(MediaType.TEXT_HTML)
//	@Consumes(MediaType.)
	public void getEmployeeById(@FormParam("id") String id,
			@Context HttpServletResponse response) throws IOException {
		
		response.sendRedirect("./getById/"+id);
	}

	@GET
	@Path("deleteById/{employee}")
	public List<Employee> deleteEmployee(@PathParam("employee") String id) {
		emp_details.deleteEmployee(id);;
		return emp_details.getAllEmployees();
	}

	@POST
	@Path("deleteById")
	@Produces(MediaType.TEXT_HTML)
//	@Consumes(MediaType.)
	public void deleteEmployeeById(@FormParam("id") String id,
			@Context HttpServletResponse response) throws IOException {
		
		response.sendRedirect("./deleteById/"+id);
	}
	
	@GET
	@Path("getByName/{employee}")
	public Employee getEmployeeByName(@PathParam("employee") String name) {
		return emp_details.getEmployeeByName(name);
	}
	
	@POST
	@Path("getEmployeeByName")
	@Produces(MediaType.TEXT_HTML)
//	@Consumes(MediaType.)
	public void getEmployeeByName(@FormParam("employeeName") String name,
			@Context HttpServletResponse servletResponse) throws IOException {
		
		servletResponse.sendRedirect("./getByName/"+name);
	}
}