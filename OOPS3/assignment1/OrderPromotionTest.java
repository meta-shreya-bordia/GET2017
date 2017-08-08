package assignment1;

import org.junit.*;

public class OrderPromotionTest {
	OrderPromotion op;
	
	@Before
	public void setUp() {
		op = new OrderPromotion("OrderFixedAmountPromotion,200.00,2000.00");
	}
	
	@Test
	public void testInvalidOrderPromotion() {
		Assert.assertEquals(0, op.calculateAmountForPromotion(1500), 0.01);
	}
	
	@Test
	public void testValidOrderPromotion() {
		Assert.assertEquals(200, op.calculateAmountForPromotion(7000), 0.01);
	}
}
