package assignment2;

public class MenuItem {
	private String menuName;
	private int menuItemIndex;

	public MenuItem() {

	}

	public MenuItem(int option, String menuItem) {
		this.menuName = menuItem;
		this.menuItemIndex = option;
	}

	// getter for menuName
	public String getMenuItemName() {
		return this.menuName;
	}

	// getter for menuItemOption
	public int getMenuItemOption() {
		return this.menuItemIndex;
	}
}
