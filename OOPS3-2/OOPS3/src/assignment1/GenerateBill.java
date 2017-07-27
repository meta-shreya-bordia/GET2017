package assignment1;

import java.io.*;

/**
 * @Class	GenerateBill
 * write to invoice file generated bill for user
 * */

public class GenerateBill {
	private static double sub_total 				= 0;
	private static double product_level_discounts 	= 0;
	private static double order_level_discounts 	= 0;
	private static double total_bill 				= 0;

	private BufferedWriter writer;
	
	/**write to specified file
	 * requires all user orders demands
	 * products available
	 * product promotions available
	 * and total order promotions to be applied
	 * @return	writes to text file
	 * */
	public void writeGeneratedBill(String filename, SaleLineItem[] your_orders, ProductPromotion[] all_promotions, OrderPromotion[] all_order_off){
		try{
			writer = new BufferedWriter(new FileWriter(new File(filename)));
			printCustomerOrder				(your_orders);
			printApplicableProductDiscounts	(your_orders, all_promotions);
			printApplicableOrderDiscount	(all_order_off);
			printTotalBill					();

		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				writer.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	/**@Method	printCustomerOrder(SaleInvoice[] your_orders)
	 * print product details and quantity selected by user into file
	 * */
	public void printCustomerOrder(SaleLineItem[] your_orders) throws IOException{
		writer.write("#####################################################\n" + System.getProperty("line.separator") 
					+ "YOUR ORDER :\n" + System.getProperty("line.separator")
					+ "#####################################################\n"+System.getProperty("line.separator"));
		
		writer.write(System.getProperty("line.separator") + "PURCHASED PRODUCTS :"+ System.getProperty("line.separator"));
		for(SaleLineItem item : your_orders) {
			writer.write("Product	: "+ item.getProductCode() + System.getProperty("line.separator"));
			writer.write("Cost	: "+ item.getRate() + "("+ item.getQuantity() +" x "+ item.getInitialPrice() +")" +System.getProperty("line.separator"));
			
			sub_total += item.getRate();
		}		
		
		total_bill += sub_total;
	}

	/**@Method	printApplicableProductDiscounts(SaleInvoice[] your_orders, ProductPromotion[] available_promotions)
	 * print product promotions available for some products selected by user and corresponding discount value into file
	 * */
	public void printApplicableProductDiscounts(SaleLineItem[] your_orders, ProductPromotion[] available_promotions) throws IOException{
		writer.write("APPLIED PROMOTIONS/DISCOUNTS :"+ System.getProperty("line.separator"));
		
		for(SaleLineItem order_item : your_orders) {
			if(order_item.isApplicableForPromotion()) {
				double discount = order_item.getDiscount();
				double discount_amount = order_item.calculateAmountForPromotion(available_promotions);

				writer.write("Promotion: "+ discount + " off on "+ order_item.getProductName() + " [Code: " + order_item.getProductCode()+"]" + System.getProperty("line.separator"));
				writer.write("Discount : "+ discount_amount + "" +System.getProperty("line.separator"));
				
				product_level_discounts += discount_amount;
			}
		}
		
		total_bill -= product_level_discounts;
	}

	/**@Method	printApplicableOrderDiscount(OrderPromotion[] all_order_off)
	 * Maximum discount available from list of total order promotions
	 * */
	public void printApplicableOrderDiscount(OrderPromotion[] all_order_off) throws IOException{
		OrderPromotion offer_to_apply = new OrderPromotion();
		double discount_amount = 0, applicable_discount =0;
		
		for(OrderPromotion op : all_order_off){
			discount_amount = op.calculateAmountForPromotion(total_bill);
			
			if(total_bill >= op.getMinimumOrderCost() && discount_amount > applicable_discount) {
				applicable_discount = discount_amount;
				offer_to_apply = op;
			}
		}
		
		double discount = offer_to_apply.getOrderDiscount();
		
		if(applicable_discount > 0) {
			writer.write("Promotion: "+ discount + " off on orders above "+ offer_to_apply.getMinimumOrderCost() + System.getProperty("line.separator"));
			writer.write("Discount : "+ discount_amount + "\n" + System.getProperty("line.separator"));
			
			order_level_discounts = discount_amount;
		}
		
		total_bill -= order_level_discounts;
	}
	
	/**@Method	printTotalBill()
	 * print sub total, promotions applied and final bill generated
	 * */
	public void printTotalBill() throws IOException{
		writer.write("Sub Total:\t\t"				+ sub_total + System.getProperty("line.separator")
					 + "Product Level Discounts:"   + product_level_discounts + System.getProperty("line.separator")
					 + "Order Level Discounts:\t"   + order_level_discounts + System.getProperty("line.separator")
					 + "Total Discounts: \t"		+ (product_level_discounts + order_level_discounts) + System.getProperty("line.separator")	
					 + "Total: \t\t\t"				+ String.format("%.2f", total_bill));
	}
}
