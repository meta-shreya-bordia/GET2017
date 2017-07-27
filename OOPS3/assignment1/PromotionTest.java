package assignment1;

import org.junit.*;

public class PromotionTest {
	ProductPromotion product_promo;
	OrderPromotion order_promo;
	ProductList product;
	SaleLineItem invoice;
	
	@Before
	public void setUp() {
		product_promo 	= new ProductPromotion("ProductFixedPercentPromotion,15,1001;5001;5003;1003;5008;4005");
		order_promo		= new OrderPromotion("OrderFixedAmountPromotion,200.00,2000.00");
		product			= new ProductList("1001, Black Jeans, 350.00");
		
		invoice			= new SaleLineItem();
	}
	
	/** Test for a valid user order that yields a product discount*/
	@Test
	public void testProductPromotion() {
		Customer.checkValidOrderSize(1);
		invoice.setValues(new Customer(1001, 1), product);
		Assert.assertEquals(52.5, Promotion.calculateAmountForPromotion(product_promo , invoice), 0.1);
	}
	
	/** Test for a valid user order that yields an order discount*/
	@Test
	public void testOrderPromotion() {
		Assert.assertEquals(200.00, Promotion.calculateAmountForPromotion(order_promo , 2001.0), 0.1);
	}
}
