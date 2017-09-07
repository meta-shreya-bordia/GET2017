package assignment2;

import java.util.Scanner;

public class Main {
	GuestHouse service; 
	Scanner input;
		
	public static void main(String[] args) {
		Main main = new Main();
		
		int guestCount = 0;
		int numberOfRooms  = main.getTotalNumberOfRooms();
		
		while( guestCount < numberOfRooms ){
			main.performAction( main.printMenu() );
			guestCount++;
		}
		
		System.out.println("Sorry. No more rooms available.");
	}
	
	public Main(){
		service = GuestHouse.getInstance();
		input   = new Scanner(System.in);
	}
	
	public int getTotalNumberOfRooms(){
		return service.getTotalNumberOfRooms();
	}
	
	public int printMenu(){
		System.out.println("Welcome to The Guest House"
					+ "\n1 Book a room"
					+ "\n2 View room details"
					+ "\n3 Exit");
		int option = input.nextInt();
		
		while(option <= 0  || option > 3){
			option = input.nextInt();
		}
		
		return option;
	}
	
	public void performAction(int option){
		switch(option){
			case 1: service.printAllocatedRoom();
				break;
			case 2: service.printAllRoomDetails();
				break;
			case 3: System.exit(0);
				break;
		}
	}
}
