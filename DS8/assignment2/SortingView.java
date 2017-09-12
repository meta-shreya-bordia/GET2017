package assignment2;

import java.util.*;

/**@Class		SortingView
 * @author 		Shreya Bordia
 * @description	create a smart system to chose appropriate sorting algorithm
 * 				for user specified inputlist
 **/
public class SortingView {
	Menu displayMenu;
	Scanner scanInput;
	
	public SortingView(){
		displayMenu = new Menu();
		scanInput = new Scanner(System.in);
	}
	
	public static void main(String[] args){
		SortingView view = new SortingView();
		Controller controller = new Controller();
		
		view.createMenu();
		
		while(true){
			view.displayMenu();
			int option = view.getUserInput();
			System.out.println( controller.performAction( option ) );
		}
	}
	
	/**@Method	createMenu()
	 * create menu based view for user to select options for
	 **/
	public void createMenu(){
		displayMenu.createMenu(1, "Add an element to the list");
		displayMenu.createMenu(2, "Remove an element from the list");
		displayMenu.createMenu(3, "Sort the list by Comparison Sorting");
		displayMenu.createMenu(4, "Sort the list by Linear Sorting");
		displayMenu.createMenu(5, "Exit");
	}

	/**@Method	displayMenu()
	 * display menu options available	
	 **/
	public void displayMenu() {
		for (MenuItem menu: displayMenu.getMenu()) {
			System.out.println( menu.getMenuItemOption() + "  " + menu.getMenuItemName());
		}
	}
	
	/**@Method	getUserInput()
	 * get user input from console
	 * @return	type = int, option selected for operation
	 **/
	public int getUserInput(){
		int option = scanInput.nextInt();
		
		return option;
	}
	
	/**@Method	getElement()
	 * get user input from console
	 * @return	type = int, element to be added/removed
	 **/
	public int getElement(){
		System.out.println("Element: ");
		int element = scanInput.nextInt();
		return element;
	}
}
