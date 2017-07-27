package assignment1;

import java.util.HashMap;
import java.util.Map;

public class Promotion {
	static Map<Integer, Double> product_discount = new HashMap<Integer, Double>();

	public static void makePromotionMap(ProductPromotion[] promotions) {
		for(ProductPromotion offer: promotions) {
			for(int prod_id : offer.getProductCode()) {
				product_discount.put(prod_id, offer.getPromotionAmount());
			}
		}
	}
	
	/**@Method	calculateAmountForPromotion(double promotion_amount, double selling_price)
	 * find total amount available for discount from percent of promotion
	 * @return	promotion amount in cost
	*/
	public static double calculateAmountForPromotion(ProductPromotion promoted , SaleLineItem order_item) {
		double discount = promoted.getPromotionAmount() * order_item.getQuantity();
		return (isPercentPromotion(promoted) ? order_item.getInitialPrice()*discount/100.0 : discount);
	}
	
	public static double calculateAmountForPromotion(OrderPromotion promoted , double order_total) {
		double discount = promoted.getOrderDiscount();
		return (isPercentPromotion(promoted) ? order_total*discount/100.0 : discount);
	}
	
	/**@Method	discountedPrice(double promotion_amount, double selling_price)
	 * find total amount available for discount from percent of promotion
	 * @return	promotion amount in cost
	*/
	public static double discountedPrice(double promotion_amount, double selling_price) {
		return (selling_price - promotion_amount); 
	}
	
	private static boolean isPercentPromotion(ProductPromotion pp) {
		return ("ProductFixedPercentPromotion".equals(pp.getPromotionType()) );
	}
	
	private static boolean isPercentPromotion(OrderPromotion pp) {
		return ("OrderFixedPercentPromotion".equals(pp.getPromotionType()) );
	}
}
