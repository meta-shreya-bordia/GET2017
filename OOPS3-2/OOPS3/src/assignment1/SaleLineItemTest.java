package assignment1;

import org.junit.*;

public class SaleLineItemTest {
	SaleLineItem  invoice;
	
	@Before
	public void setUp() {
		invoice = new SaleLineItem();
		invoice.setValues(new Customer(1001, 1), new ProductList("1001, Black Jeans, 364.8"));
	}

	@Test
	public void testCalculateDiscount() {
		//done from HashMap that is initialized from file read
	}
	
}
