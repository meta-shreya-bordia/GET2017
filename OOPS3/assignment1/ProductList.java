package assignment1;

import java.util.HashMap;
import java.util.Map;

public class ProductList {
	private int product_code;
	private String product_name;
	private double product_cost;
	
	private static Map<Integer, Double> available_product = new HashMap<Integer, Double>();
	
	public ProductList(){
		
	}
	
	public ProductList(String product){
		String[] product_details = product.split(",");
		this.product_code = Integer.parseInt(product_details[0]);
		this.product_name = product_details[1];
		this.product_cost = Double.parseDouble(product_details[2]);
	}
	
	/**store count of all available product codes and their prices
	 * */
	public static void makeProductMap(ProductList[] products) {
		for(ProductList item: products) {
			available_product.put(item.getProductCode(), item.getProductCost());
		}
	}
	
	/** check if user product code actually exists*/
	public static boolean checkValidProduct(int user_product_code) {
		return available_product.containsKey(user_product_code);
	}
	
	public int getProductCode() {
		return this.product_code;
	}
	
	public String getProductName() {
		return this.product_name;
	}
	
	public double getProductCost() {
		return this.product_cost;
	}
}
