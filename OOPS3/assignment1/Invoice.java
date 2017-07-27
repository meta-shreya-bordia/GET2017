package assignment1;

import java.util.Scanner;

/**@Class Invoice
 * for console based user interaction
 * */
public class Invoice {	
	static String fill_bill 			= "Invoice.txt";
	static String getProductDetails 	= "ProductList.csv";
	static String getProductPromotions 	= "ProductPromo.csv";
	static String getOrderPromotions 	= "OrderPromo.csv";
	
	public static void main(String[] args){
		ReadProductDetails file = new ReadProductDetails();
		
		ProductList[] 		all_products 	= PrintProductDetails.printProductList(getProductDetails, file);
		ProductPromotion[] 	all_promotions	= PrintProductDetails.printProductPromotionList(getProductPromotions, file);
		OrderPromotion[] 	all_order_off 	= PrintProductDetails.printOrderPromotion(getOrderPromotions, file);
		
		ProductList.makeProductMap  (all_products);
		Promotion.makePromotionMap	(all_promotions);
		
		SaleLineItem[] your_orders = getCustomerOrder(all_products);
		new GenerateBill().writeGeneratedBill(fill_bill, your_orders, all_promotions, all_order_off);
		new ReadGeneratedBill().readGeneratedBill(fill_bill);
	}
	
	public static SaleLineItem[] getCustomerOrder(ProductList[] available_products) {
		Scanner order = new Scanner(System.in);
		
		System.out.println("\n\n\nEnter number of items you want to buy: ");
		int order_count = order.nextInt();
		while( ! Customer.checkValidOrderSize(order_count)) {
			System.out.println("Wrong Order Size. Re-enter.");
			order_count = order.nextInt();
		}
		
		SaleLineItem[] items = new SaleLineItem[order_count];
		
		System.out.println("\nEnter Product Code \t Quantity");
		for(int count = 0; count < order_count; count++) {
			int user_product_code = order.nextInt();
			
			while(! ProductList.checkValidProduct(user_product_code) ) {
				System.out.println("Wrong Product Code. Re-enter.");
				user_product_code = order.nextInt();
			}
				
			int product_quantity = order.nextInt();
			while(! Customer.checkValidQuantity(product_quantity) ) {
				System.out.println("Wrong Product Quantity. Re-enter.");
				product_quantity = order.nextInt();
			}
			
			items[count] = new SaleLineItem(new Customer(user_product_code, product_quantity), available_products);
		}
		
		order.close();
		return items;
	}
}
