package view;

/**@Class	Menu
 * menuitem enum:
 * 			 1 view product list
 * 			 2 add product to cart with quantity
 * 			 3 change product quantity
 * 			 4 delete product from cart
 * 			 5 generate bill
 * 			 6 view cart
 * 			 7 exit
 **/
class Menu {
	private String menu_name;
	private int menu_option;	
	
	public Menu() {
		
	}
	
	public Menu(int option, String menuitem) {
		this.menu_name  = menuitem;
		this.menu_option= option; 
	}
	
	public String getMenuItemName(){
		return this.menu_name;
	}
	
	public int getMenuItemOption(){
		return this.menu_option;
	}
}
  