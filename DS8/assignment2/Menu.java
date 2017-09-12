package assignment2;

import java.util.*;

/**@Class	Menu
 * add menu items to the menu
 **/
public class Menu {
	// arrayList containing menu item for operations.
	private List<MenuItem> menuItemList;

	public Menu() {
		menuItemList = new ArrayList<MenuItem>();
	}
	
	// create menu to be displayed
	public void createMenu(int sequenceNumber, String menuOptionName) {
		menuItemList.add(new MenuItem(sequenceNumber, menuOptionName));
	}
	
	// menu containing options for datatype
	public List<MenuItem> getMenu() {
		return menuItemList;
	}
}