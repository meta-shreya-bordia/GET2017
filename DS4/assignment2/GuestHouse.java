package assignment2;

import java.util.*;

public class GuestHouse {
	private Scanner input;
	private Controller controller;
	
/******ALLOCATION OPERATIONS******/	
	private static GuestHouse service;
	private GuestHouse() {
		controller = new Controller();
		input = new Scanner(System.in);
	}
	
	public static GuestHouse getInstance() {
		if(service == null) {
			synchronized(GuestHouse.class) {
				if(service == null) {
					return service= new GuestHouse();
				}
			}
		}
		return service;
	}
	
/********GUEST HOUSE DETAILS*********/	
	public int getTotalNumberOfRooms() {
		System.out.println("Welcome to The Guest House"
					+ "\nEnter Total Number of Rooms:");
		int totalRooms = input.nextInt();
		
		while(totalRooms <= 1 || !controller.isPrimeNumber(totalRooms)) {
			System.out.println("Invalid Rooms available"
					+ "\nEnter Total Number of Rooms:");
			totalRooms = input.nextInt();
		}
		
		controller.setTotalNumberOfRooms(totalRooms);
		return totalRooms;
	}
	
	public void printAllocatedRoom(){
		Guest toAllocate = getGuestDetails();
		int roomNumber = controller.bookRoom(toAllocate);
		System.out.println("You have been alloted room number: "+ roomNumber);
	}
	
	public void printAllRoomDetails(){
		Object[] roomDetails = controller.getRoomDetails();
		
		System.out.println("Room Number"
						+ "\tGuest in Room"
						+ "\tGuest Age");
		for(int roomNumber=0; roomNumber < roomDetails.length; roomNumber++){
			System.out.print(roomNumber+1);
			
			Guest guest = (Guest)roomDetails[roomNumber];
			if(guest == null){
				System.out.println("**Room Available**");
			}else{
				System.out.println("\t\t"+ guest.getGuestName()
								 +"\t\t" + guest.getGuestAge());
			}
		}				
	}
	
/*********GUEST DETAILS********/	
	public Guest getGuestDetails() {
		String guestName;
		int guestAge;
		
		System.out.println("Welcome Guest to The Guest House"
						+ "\nPlease provide us your details so we can serve you better:"
						+ "\nEnter your Name:");
		guestName = input.next();

		System.out.println("Enter your Age:");
		
		guestAge = input.nextInt();
		while( guestAge <= 0 || guestAge > 100) {
			System.out.println("Please enter valid age details:");
			guestAge = input.nextInt();
		}
		
		return new Guest(guestName, guestAge);
	}
}