package assignment1;

import java.io.File;
import java.util.Arrays;

public class PrintProductDetails {
	public static ProductList[] printProductList(String filename, ReadProductDetails file){
		ProductList[] product_details = file.readProductList(new File(filename));
		
		System.out.println("List of all product items:");
		System.out.println("\nProduct Code \t Product Name \t\t\t Price");
		
		for(ProductList item: product_details){
			System.out.println(item.getProductCode()+"\t\t"+item.getProductName()+"\t\t"+item.getProductCost());
		}
		
		return product_details;
	}
	
	public static ProductPromotion[] printProductPromotionList(String filename, ReadProductDetails file){
		ProductPromotion[] product_details = file.readProductPromotion(new File(filename));
		
		System.out.println("\nList of all product items on discount:");
		System.out.println("\nPromotion Type \t\t\t Promotion Amount \t List of Applicable Products");
		
		for(ProductPromotion item: product_details){
			System.out.println(item.getPromotionType()+"\t\t"+item.getPromotionAmount()+"\t\t"+Arrays.toString(item.getProductCode()) );
		}
		
		return product_details;
	}
	
	public static OrderPromotion[] printOrderPromotion(String filename, ReadProductDetails file){
		OrderPromotion[] order_details = file.readOrderPromotion(new File(filename));
		
		System.out.println("\nList of all order discounts:");
		System.out.println("\nProduct Code \t\t\t Order Discount Available \t Available on Minimum Order Total Of");
		
		for(OrderPromotion item: order_details){
			System.out.println(item.getPromotionType()+"\t\t"+item.getOrderDiscount()+"\t\t\t"+item.getMinimumOrderCost());
		}
		
		return order_details;
	}
}
