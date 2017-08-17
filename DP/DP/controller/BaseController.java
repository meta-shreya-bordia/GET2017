package controller;

//All the modules controller can access
import view.*;
import facade.*;
import enums.DBType;
import factory.ControllerFactory;

/**@Class	baseController
 * handles all controller calls
 * holds BaseFacade object
 * handles all exceptions raised.
 **/
public class BaseController implements IBaseController{
	private static BaseController controller = null;
		
	DisplayOutput show_to_user = DisplayOutput.getInstance();
	UserInput get_user_input   = UserInput.getInstance();
	
	private BaseController() {}
	
	//singleton object creation: double checking to reduce amount of time required to get object instance
	public static BaseController getInstance() {
		if(controller == null) {
			synchronized(BaseController.class) {
				if(controller == null) {
					controller = new BaseController();
				}
			}
		}
		
		return controller;
	}
		
	/**@Method	triggerMenuAction(int option)
	 * @param	user selected menu option value
	 * checks for valid param value, then implements an action listener on option selected
	 **/
	public void triggerMenuAction(int option){
		if( (UserInputValidation.getInstance()).isValidMenuOption(option) ){
			//if option == valid then add action-able menu item
			callActionListener(option);
		}else{
			//error handling
			displayMessage("Invalid Option Value");
		}
	}
	
	public void displayMessage(String message){
		show_to_user.displayMessage(message);
	}
	
	/** @param	user selected valid menu option value
	 * calls appropriate controller to perform action based on menu option
	 **/
	public void callActionListener(int option) {
		int product_code, product_quantity;
		IBaseController cart_controller = ControllerFactory.getInstance(DBType.Cart);
		
		switch(option) {
		/** how to use menuitem enum:
		 * 1 view product list
		 * 2 add product to cart with quantity
		 * 3 change product quantity
		 * 4 delete product from cart
		 * 5 view cart
		 * 6 generate bill
		 * 7 exit
		 **/
	
			case 1:
				show_to_user.displayProductList( ProductController.getInstance().getProductList() );
				break;
			case 2:
				product_code 	 = get_user_input.getProductCode();
				product_quantity = get_user_input.getProductQuantity();
				((CartController)cart_controller).addToCart(product_code, product_quantity);
				break;
			case 3:
				product_code 	 = get_user_input.getProductCode();
				product_quantity = get_user_input.getProductQuantity();
				((CartController)cart_controller).updateCartItem(product_code, product_quantity);
				break;
			case 4:
				product_code 	 = get_user_input.getProductCode();
				((CartController)cart_controller).deleteFromCart(product_code);				
				break;
			case 5:
				show_to_user.displayCart( ((CartController)cart_controller).getCart() );
				break;
			case 6:
				show_to_user.displayBill( ((CartController)cart_controller).getCart(), ((CartController)cart_controller).getBillTotal() );
				break;
			case 7:
				System.exit(0);
				break;
		}
	}
}
