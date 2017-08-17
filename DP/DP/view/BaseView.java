package view;

import java.util.*;
import controller.BaseController;

/**@Class	BaseView
 * handles all view calls to make
 * then calls BaseController for validations
 **/
public class BaseView {
	DisplayOutput show_to_user;
	UserInput get_user_input;
	BaseController controller;
	private static BaseView view = null;
	
	private BaseView() {		
		//create a cart for the new user: in CartDAO
		//done in controller object
		show_to_user = DisplayOutput.getInstance();
		get_user_input   = UserInput.getInstance();
		controller  = BaseController.getInstance();
		
		//only create menu once
		Console.createMenu();
		
		// display menu until user exits loop
		while(true) {
			userInteraction();
		}
	}
	
	/**singleton class**/
	public static BaseView getInstance() {
		if(view == null) {
			synchronized (BaseView.class) {
				if(view == null) {
					view = new BaseView();
				}
			}
		}
		
		return view;
	}
	
	public void userInteraction() {
		displayMenu();
		int selected_option = get_user_input.getMenuOption();
		controller.triggerMenuAction(selected_option);
	}
	
	/**@Method	displayMenu
	 * over ridden method in sub-classes
	 * when extended into web-based type
	 * pass parameter to decide which method to call
	 * @return	type=void, displays menu onto console/browser
	 **/
	public void displayMenu() {
		show_to_user.displayMenu(getMenu());
	}
	
	public static List<Menu> getMenu() {
		return Console.getMenu();
	}
}
