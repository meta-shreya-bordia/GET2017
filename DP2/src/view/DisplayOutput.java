package view;

import java.util.*;
import model.*;
import facade.*;
import dao.*;

/**@Class	DisplayOutput
 * 1. Display menu
 * 2. display error based on user invalid input (Controller checking)
 * 3. display error based on DB invalid entries (Facade checking)
 **/
public class DisplayOutput {
	private static DisplayOutput show_to_user;
	
	public static DisplayOutput getInstance() {
		if(show_to_user == null) {
			show_to_user = new DisplayOutput();
		}
		
		return show_to_user;
	}
	
	//create menu: by base view// called by base view
	public void displayMenu(List<Menu> menu_list) {
		System.out.println("Choose from the options:");
		for(Menu menuitem: menu_list){
			System.out.println(menuitem.getMenuItemOption()+" "+menuitem.getMenuItemName());
		}
	}
	
	public void displayProductList(List<Product> product_list){
		for(Product product_item : product_list){
			System.out.println("Product Code:"+ product_item.getProductCode());
			System.out.println("Product: \t"+ product_item.getProductName());
			System.out.println("Price:   \t"+ product_item.getProductPrice());
			
			System.out.println();
		}
	}
	
	public void displayCart(Map<Integer, SaleLineItem> your_cart){
		for(Map.Entry<Integer, SaleLineItem> cart_item : your_cart.entrySet()){
			SaleLineItem line_item = cart_item.getValue();
			System.out.println("Product Code: "+ line_item.getProductCode());
			System.out.println("Product: \t"+ line_item.getProductName());
			System.out.println("Quantity:\t"+ line_item.getProductQuantity());
			System.out.println("Price:   \t"+ line_item.getProductPrice()+" * "+line_item.getProductQuantity()+" = "+line_item.getTotalProductPrice());
			
			System.out.println();
		}
	}
	
	public void displayBill(Map your_cart, double bill_total){
		System.out.println("#####################################################\n"
						 + "\t\t\tYOUR ORDER :\n"
						 + "#####################################################\n");
		
		System.out.println("Purcahsed Products:");
		displayCart(your_cart);
		
		System.out.println("\nYour bill total is: "+ bill_total);
	}
	
	public void displayMessage(String message){
		System.out.println(message);
	}
}
