package assignment1;

import org.junit.*;
import java.util.*;

public class EmployeeSortTest {
	Employee employee;
	EmployeeList operation;
	List<Employee> list;
	
	@Before
	public void setUp() {
		operation = new EmployeeList();
		list = new ArrayList<Employee>();
	}

/*******ADD OPERATIONS********/
	@Test
	public void testAddNull() {
		employee = null;
		Assert.assertFalse( operation.add( employee ) );
	}
	
	@Test
	public void testAddNullElementValue() {
		employee = new Employee(null, 2, "this");
		Assert.assertFalse( operation.add( employee ) );
	}
	
	@Test
	public void testAddValidEmployee() {
		employee = new Employee("this", 2, "address");
		Assert.assertTrue( operation.add( employee ) );
		
		Assert.assertEquals( 1, operation.size() );
		Assert.assertEquals(2, (int)operation.getEmployee(0).getEmployeeId());
	}
	
	@Test
	public void testAddDuplicateElement() {
		employee = new Employee("name", 2, "address");
		Assert.assertTrue( operation.add( employee ) );
		
		Assert.assertEquals(1, operation.size() );
		Assert.assertEquals(2, (int)operation.getEmployee(0).getEmployeeId());
		
		employee = new Employee("new name", 2, "new address");
		Assert.assertFalse( operation.add( employee ) );
		
		Assert.assertEquals(1, operation.size() );
		Assert.assertEquals(2, operation.getEmployee(0).getEmployeeId());
	}
	
	@Test
	public void testAddSameName() {
		employee = new Employee("name", 2, "address");
		Assert.assertTrue( operation.add( employee ) );
		
		Assert.assertEquals(1, operation.size() );
		Assert.assertEquals(2, (int)operation.getEmployee(0).getEmployeeId());
		
		employee = new Employee("name", 3, "new address");
		Assert.assertTrue( operation.add( employee ) );
		
		Assert.assertEquals(2, operation.size() );
		Assert.assertEquals(2, operation.getEmployee(0).getEmployeeId());
	}
	
/********REMOVE OPERATIONS**********/
	@Test
	public void testRemoveEmptyList() {
		Assert.assertFalse( operation.remove(10));
	}
	
	@Test
	public void testRemoveInvalidId() {
		Assert.assertFalse( operation.remove(-10));
	}
	
	@Test
	public void testRemoveFromSingleElementList() {
		employee = new Employee("name", 2, "address");
		Assert.assertTrue( operation.add( employee ) );
		
		Assert.assertEquals(1, operation.size() );
		Assert.assertEquals(2, (int)operation.getEmployee(0).getEmployeeId());
		
		Assert.assertTrue( operation.remove(2));
		Assert.assertEquals(0, operation.size() );
	}
	
	@Test
	public void testRemoveFromList() {
		employee = new Employee("XYZ", 1, "address");
		Assert.assertTrue( operation.add( employee ) );
		employee = new Employee("AbC", 3, "address");
		Assert.assertTrue( operation.add( employee ) );
		employee = new Employee("A", 2, "address");
		Assert.assertTrue( operation.add( employee ) );
		employee = new Employee("AA", 1, "address");
		Assert.assertFalse( operation.add( employee ) );
		
		Assert.assertEquals(3, operation.size() );
		Assert.assertTrue(operation.remove(1));
		Assert.assertEquals(2, operation.size() );
		
		Assert.assertEquals(3, operation.getEmployee(0).getEmployeeId());
	}

/********NATURAL SORTING**********/	
	@Test
	public void testNaturalSortForNullList() {
		operation.sortByNaturalOrdering();
		Assert.assertEquals("[]", Arrays.toString( operation.getEmployeeList().toArray() ));
	}
	
	@Test
	public void testNaturalSortForSingleElementList() {
		employee = new Employee("hello", 2, "address");
		operation.add(employee);
		
		operation.sortByNaturalOrdering();
		Assert.assertEquals("hello", operation.getEmployee(0).getEmployeeName() );
		Assert.assertEquals(2, operation.getEmployee(0).getEmployeeId() );
	}
	
	@Test
	public void testNaturalSortForList() {
	employee = new Employee("XYZ", 1, "address");
		Assert.assertTrue( operation.add( employee ) );
		employee = new Employee("AbC", 3, "address");
		Assert.assertTrue( operation.add( employee ) );
		employee = new Employee("A", 2, "address");
		Assert.assertTrue( operation.add( employee ) );
		employee = new Employee("aA", 8, "address");
		Assert.assertTrue( operation.add( employee ) );
	
		operation.sortByNaturalOrdering();
		Assert.assertEquals("A", operation.getEmployee(0).getEmployeeName());
		Assert.assertEquals("aA", operation.getEmployee(1).getEmployeeName());
		Assert.assertEquals("AbC", operation.getEmployee(2).getEmployeeName());
		Assert.assertEquals("XYZ", operation.getEmployee(3).getEmployeeName());
	}

/**********SORT ORDER BY ID***********/
	@Test
	public void testIdSortForNullList() {
		operation.sortById();
		Assert.assertEquals("[]", Arrays.toString( operation.getEmployeeList().toArray() ));
	}
	
	@Test
	public void tesIdSortForSingleElementList() {
		employee = new Employee("XYZ", 1, "address");
		Assert.assertTrue( operation.add( employee ) );
		
		operation.sortById();
		Assert.assertEquals(1, operation.getEmployee(0).getEmployeeId());
	}
	
	@Test
	public void testIdSortForList() {
	employee = new Employee("XYZ", 1, "address");
		Assert.assertTrue( operation.add( employee ) );
		employee = new Employee("AbC", 3, "address");
		Assert.assertTrue( operation.add( employee ) );
		employee = new Employee("A", 2, "address");
		Assert.assertTrue( operation.add( employee ) );
		employee = new Employee("aA", 8, "address");
		Assert.assertTrue( operation.add( employee ) );
	
		operation.sortById();
		Assert.assertEquals(1, operation.getEmployee(0).getEmployeeId());
		Assert.assertEquals(2, operation.getEmployee(1).getEmployeeId());
		Assert.assertEquals(3, operation.getEmployee(2).getEmployeeId());
		Assert.assertEquals(8, operation.getEmployee(3).getEmployeeId());
	}
}
