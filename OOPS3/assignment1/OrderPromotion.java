package assignment1;

public class OrderPromotion{
	private String order_type;
	private double order_discount;
	private double min_order_amount;
	
	public OrderPromotion(){
		
	}
	
	public OrderPromotion(String order){
		String[] order_details = order.split(",");
		
		this.order_type = order_details[0];
		this.order_discount = Double.parseDouble(order_details[1]);
		this.min_order_amount = Double.parseDouble(order_details[2]);
	}
	
	/**@Method	calculateAmountForPromotion(double total_price)
	 * overall discount applicable for total order
	 * */
	public double calculateAmountForPromotion(double total_price) {
		return Promotion.calculateAmountForPromotion(this, total_price);
	}
	
	/** access order promotion details */
	public String getPromotionType() {
		return this.order_type;
	}
	
	public double getOrderDiscount() {
		return this.order_discount;
	}
	
	public double getMinimumOrderCost() {
		return this.min_order_amount;
	}
}