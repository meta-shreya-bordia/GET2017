package assignment2;

import java.util.*;

public class Menu extends MenuItem{
	private static String[] main_menu_items = {
			"1. Show Matrix",
			"2. Adding to your matrix",
			"3. Multiplying your matrix",
			"4. Find transpose of you matrix",
			"5. Update your matrix",
			"6. Exit current operations",
			"7. Start new",
			"8. Go back"
	};

	private static String[] add_sub_menu = {
		"1. Add a scaler quantity to your matrix",
		"2. Add a matrix"
	};
	
	private static String[] multiply_sub_menu = {
		"1. Multiply a scaler quantity to your matrix",
		"2. Multiply with a matrix"
	};
	
	private List<MenuItem> sub_menu = new ArrayList<MenuItem>();
	
	public Menu(){}
		
	public List<MenuItem> geMenuItems(){
		return this.sub_menu;
	}
	
	public List<MenuItem> addToMenu(){
		for(String item_name: main_menu_items){
			MenuItem mi = new ActionableMenuItem(new MatrixOperations());
			mi.setMenuItemName(item_name);
			sub_menu.add(mi);
		}	
	return sub_menu;
	}
}