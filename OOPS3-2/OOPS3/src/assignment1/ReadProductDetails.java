package assignment1;

import java.io.*;

public class ReadProductDetails {	
	public ProductList[] readProductList(File product_list) {
		String[] list_of_product = ReadFile.readFile(product_list);
		ProductList[] product_details = new ProductList[list_of_product.length];
		
		for(int p_id = 0; p_id < list_of_product.length; p_id++){
			product_details[p_id] = new ProductList(list_of_product[p_id]);
		}
		
		return product_details;
	}
	
	public ProductPromotion[] readProductPromotion(File product_promotion) {
		String[] list_of_product = ReadFile.readFile(product_promotion);
		ProductPromotion[] product_details = new ProductPromotion[list_of_product.length];
		
		for(int p_id = 0; p_id < list_of_product.length; p_id++){
			product_details[p_id] = new ProductPromotion(list_of_product[p_id]);
		}
		
		return product_details;
	}
	
	public OrderPromotion[] readOrderPromotion(File order_promotion) {
		String[] list_of_product = ReadFile.readFile(order_promotion);
		OrderPromotion[] order_details = new OrderPromotion[list_of_product.length];
		
		for(int p_id = 0; p_id < list_of_product.length; p_id++){
			order_details[p_id] = new OrderPromotion(list_of_product[p_id]);
		}
		return order_details;
	}
}
