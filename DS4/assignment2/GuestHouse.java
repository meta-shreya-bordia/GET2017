package assignment2;

import java.util.*;

public class GuestHouse {
	private Scanner input;
	private Controller controller;
	private int numberOfRooms;
	private int numberOfGuests;
	
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
	
	//Program execution starts here
	public void allocationService() {
		Controller controller = new Controller();
		
		int numberOfRooms  = getTotalNumberOfRooms();
		int numberOfGuests = getTotalNumberOfGuests(numberOfRooms);
		
		while(numberOfGuests > 0) {
			printAllocatedRoom();
			numberOfGuests--;
		}
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
		
		return totalRooms;
	}
	
	public void printAllocatedRoom(){
		Guest toAllocate = getGuestDetails();
		
	}
	
/*********GUEST DETAILS********/	

	public int getTotalNumberOfGuests(int numberOfRooms){
		System.out.println("Enter total number of guests to allocate rooms to:");
		int numberOfGuests = input.nextInt();
		
		while(numberOfGuests<= 0 && numberOfGuests <= numberOfRooms) {
			System.out.println("Invalid guest count."
							+"\nEnter total number of guests to allocate rooms to:");
			numberOfGuests = input.nextInt();
		}
		
		return numberOfGuests;
	}
	
	public Guest getGuestDetails() {
		String guestName;
		int guestAge;
		
		System.out.println("Welcome Guest to The Guest House"
						+ "\nPlease provide us your details so we can serve you better:"
						+ "\nEnter your Name:");
		guestName = input.next();

		System.out.println("Enter your Age:");
		
		guestAge = input.nextInt();
		while( guestAge <= 0 && guestAge > 100) {
			System.out.println("Please enter valid age details:");
			guestAge = input.nextInt();
		}
		
		return new Guest(guestName, guestAge);
	}
}