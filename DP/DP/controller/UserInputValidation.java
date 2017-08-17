package controller;

import view.*;

/**@Class	UserValidations
 * responsible for user input validations at the front end
 * no null values or invalid entries(numbers in name)
 * to be passed to facade
 **/
public class UserInputValidation implements IBaseController{
	private static UserInputValidation user_controller = null;
	
	public static UserInputValidation getInstance() {
		if(user_controller == null) {
			user_controller = new UserInputValidation();
		}
		
		return user_controller;
	}
	
	public boolean isValidSaleLineItem(int product_code, int quantity) {
		return (isValidProductCode(product_code) & isValidQuantity(quantity) );
	}
	
	public boolean isValidProductCode(int product_code) {
		return (product_code > 0);
	}
	
	public boolean isValidQuantity(int product_quantity) {
		return (product_quantity > 0);
	}
	
	public boolean isValidMenuOption(int user_input){
		return (user_input > 0 || user_input < BaseView.getMenu().size() );
	}
}
