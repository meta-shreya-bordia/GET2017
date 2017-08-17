package view;

import java.util.*;

/**@Class	Console
 * console based UI
 * */
class Console {
/** menuitem enum:
 * 	 1 view product list
 * 	 2 add product to cart with quantity
 * 	 3 change product quantity
 * 	 4 delete product from cart
 * 	 5 view cart
 * 	 6 generate bill
 * 	 7 exit
**/
	private static List<Menu> menus = new ArrayList<Menu>();
	
	public static void createMenu(){
		menus.add(new Menu(1, "View product list"));
		menus.add(new Menu(2, "Add product to cart"));
		menus.add(new Menu(3, "Update product in cart"));
		menus.add(new Menu(4, "Delete product from cart"));
		menus.add(new Menu(5, "View your Cart"));
		menus.add(new Menu(6, "Generate Bill"));
		menus.add(new Menu(7, "Exit"));
	}
	
	public static List<Menu> getMenu(){
		return menus;
	}
}