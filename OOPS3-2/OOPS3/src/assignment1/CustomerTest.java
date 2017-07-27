package assignment1;

import org.junit.*;

/** Test user entered details
 * for proper validations
 * */

public class CustomerTest {
	
	@Test
	public void testInValidQuantity() {
		Assert.assertFalse( Customer.checkValidQuantity(-4));
	}
	
	@Test
	public void testZeroQuantity() {
		Assert.assertFalse( Customer.checkValidQuantity(0));
	}
	
	@Test
	public void testValidQuantity() {
		Assert.assertTrue( Customer.checkValidQuantity(4));
	}
	
	@Test
	public void testInValidOrderSize(){
		Assert.assertFalse(Customer.checkValidOrderSize(-4));
	}
	
	@Test
	public void testZeroOrderSize(){
		Assert.assertFalse(Customer.checkValidOrderSize(0));
	}
	
	@Test
	public void testValidOrderSize(){
		Assert.assertTrue(Customer.checkValidOrderSize(4));
	}
}
