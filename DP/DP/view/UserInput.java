package view;

import java.util.*;

/**@Class DisplayInput
 * get user input and menu options 
 * create a new customer
 * create a new Cart object
 **/
public class UserInput{
	private static Scanner input = new Scanner(System.in);
	
	private static UserInput getUserInput = null;
	public static UserInput getInstance() {
		if(getUserInput == null) {
			getUserInput = new UserInput();
		}
		
		return getUserInput;
	}
	
	public int getProductCode(){
		System.out.println("Enter product code: ");
		int product_id = input.nextInt();
		return product_id;
	}
	
	public int getProductQuantity(){
		System.out.println("Enter product quantity: ");
		int product_quantity = input.nextInt();
		return product_quantity;
	}
	
	public int getMenuOption(){
		System.out.println("Your choice: ");
		int menu_option = input.nextInt();
		return menu_option;
	}
}