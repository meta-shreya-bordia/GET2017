package assignment1;

public class SaleLineItem {	
	private int product_code;
	private String product_name;
	private int quantity;
	private double selling_price;

	private double rate;
	
	public void setValues(Customer order, ProductList product) {
		this.product_code = order.getProductCode();
		this.product_name = product.getProductName();
		this.quantity     = order.getProductQuantity();
		this.selling_price= product.getProductCost();
		
		this.rate = selling_price * quantity;
	}
		
	public SaleLineItem() {
		
	}
	
	public SaleLineItem(Customer user_order, ProductList[] all_products) {
		for(ProductList product : all_products) {
			if(user_order.getProductCode() == product.getProductCode()) {
				setValues(user_order, product);
				break;
			}
		}
	}
		
	public boolean isApplicableForPromotion() {
		return (Promotion.product_discount.containsKey(this.product_code) );
	}	
	
	public double calculateAmountForPromotion(ProductPromotion[] all_promotions) {
		for(ProductPromotion applicable_promo: all_promotions) {
			for(int prod_id : applicable_promo.getProductCode()) {
				if(this.product_code == prod_id) {
					return Promotion.calculateAmountForPromotion(applicable_promo, this);
				}
			}
		}
		
		return 0;
	}
	
	public double getDiscount() {
		return (Promotion.product_discount.get(this.product_code) );
	}

	public int getProductCode() {
		return product_code;
	}

	public String getProductName() {
		return product_name;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getInitialPrice() {
		return selling_price;
	}
	
	public double getRate() {
		return rate;
	}	
}
