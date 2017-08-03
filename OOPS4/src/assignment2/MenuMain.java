package assignment2;

import java.util.*;

public class MenuMain {
	public static void main(String[] args){
		Menu main_menu = new Menu();
		
		List<MenuItem> main_menu_items = main_menu.addToMenu();
		
		while(true){
			showMainMenu(main_menu_items);
		}
		
		displayAndPerformAction(main_menu);
	}
	
	public static void showMainMenu(List<MenuItem> mi){
		if(mi.size() >0){
			for(int i=0; i< mi.size(); i++){
				System.out.println(mi.get(i).getMenuItemName());
			}
		}
				
	}
	
	public static int getInput(){
		try {
			Scanner scan = new Scanner(System.in);
			System.out.print("Select an option:");
			
			String choice = scan.next();
			int validChoice = Integer.parseInt(choice);
			
			return validChoice - 1;
		
		} catch (Exception e) {
			return -1;
		}
	}
	
	public static void displayAndPerformAction(Menu menu){
		display(menu);
		
		int choice=getInput();
			MenuItem menuItem= menu.getSelection(choice);
	
		
		if(menuItem==null){
			System.out.println("Wrong input");
			displayAndPerformAction(menu);
		}else if(menuItem instanceof ActionableMenuItem){
			((ActionableMenuItem)menuItem).triggerAction(menuItem.getMenuItemName());
		}else{
			displayAndPerformAction((Menu)menuItem);
		}
	}
}
