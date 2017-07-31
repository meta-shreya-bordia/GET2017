package assignment1;

/**@Class	Customer
 * check validations of input from user
 * map values of product code x quantity
 * for each user
 * */
public class Customer {
	
	private int [][] order_items;
	private static int item_number = -1;
	private static int total_items;
	
	public Customer() {
		
	}
	
	/**store valid product and quantity of each order item
	 * */
	public Customer(int product_code, int quantity) {
		++item_number;
		order_items = new int[total_items][2];
		order_items[item_number][0] = product_code;
		order_items[item_number][1] = quantity;
	}
	
	/** check if user entered quantity is a valid number*/
	public static boolean checkValidQuantity(int user_quantity) {
		return (user_quantity <= 0 ? false : true);
	}
	
	/** check that a valid entry for bill order is entered*/
	public static boolean checkValidOrderSize(int order_size) {
		if(order_size > 0) {
			total_items = order_size;
			return true;
		}
		return false;
	}
	
	/** access private elements of user order details*/
	public int getProductCode() {
		return this.order_items[item_number][0];
	}
	
	public int getProductQuantity() {
		return this.order_items[item_number][1];
	}
}
