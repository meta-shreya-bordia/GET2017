package model;

public class SaleLineItem{	
	private int product_code;
	private String product_name;
	private double price;
	
	private int quantity;
	private double total_price;

	public SaleLineItem(Product product, int quantity){
		this.product_code = product.getProductCode();
		this.product_name = product.getProductName();
		this.price		  = product.getProductPrice();
		this.quantity	  = quantity;
		
		this.setTotalProductPrice();
	}
	
	public int getProductCode() {
		return product_code;
	}

	public String getProductName() {
		return product_name;
	}

	public int getProductQuantity() {
		return quantity;
	}
	
	public double getProductPrice() {
		return this.price;
	}
	
	public double getTotalProductPrice() {
		return total_price;
	}
	
	public void setProductQuantity(int quantity) {
		this.quantity = quantity;
	}	
		
	public void setTotalProductPrice() {
		this.total_price = this.price * this.quantity;
	}
}
