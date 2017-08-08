package assignment1;

public class ProductPromotion{
	private String promotion_type;
	private double promotion_amount;
	private int[] product_code;
	
	ProductPromotion(){
		
	}
	
	ProductPromotion(String product){
		String[] product_details = product.split(",");
		this.promotion_type =   product_details[0];
		this.promotion_amount = Double.parseDouble(product_details[1]);
		
		String[] products = product_details[2].trim().split(";");
		product_code = new int[products.length];
		for(int item = 0; item< products.length; item++) {
			this.product_code[item] = Integer.parseInt(products[item]);
		}
	}
	
	public String getPromotionType() {
		return this.promotion_type;
	}
	
	public double getPromotionAmount() {
		return this.promotion_amount;
	}
	
	public int[] getProductCode() {
		return this.product_code;
	}
}

/**public boolean isValidForDiscount(int product_id) {
	for(int item = 0; item < product_code.length; item++) {
		if(product_id == product_code[item])
			return true;
	}
	
	return false;
}	

public double calculateAmountForPromotion(double product_selling_price) {
	Promotion calculate = new Promotion();
	
	double promotion_amt = this.promotion_amount;
	
	if("ProductFixedPercentPromotion".equals(this.getPromotionType()) )
		promotion_amt = calculate.calculateAmountForPromotion(promotion_amt, product_selling_price);
	
	return calculate.discountedPrice(promotion_amt, product_selling_price);
}
**/