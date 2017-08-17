package model;

public class Product{
	private int product_code;
	private String product_name;
	private double product_cost;
	
	/*should be in DAO in-memory map*/
	//private static Map<Integer, Double> available_product = new HashMap<Integer, Double>();
	
	public Product(){
		
	}
	
	/** Store file read(DAO) for in-memory storage**/
	public Product(String product){
		String[] product_details = product.trim().split(",");
		this.product_code = Integer.parseInt(product_details[0]);
		this.product_name = product_details[1].trim();
		this.product_cost = Double.parseDouble(product_details[2]);
	}
		
	/** get all product details */
	public int getProductCode() {
		return this.product_code;
	}
	
	public String getProductName() {
		return this.product_name;
	}

	public double getProductPrice() {
		return this.product_cost;
	}
}
