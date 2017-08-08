package assignment1;

import java.util.*;
import java.io.*;

/***
 * @Class	Record
 * for user interactive systems
 * insert a new user
 * or insert a connection to existing user
 * by UI console
 * **/
public class Record {
	/**@Class	insertNewUser()
	 * scan user profile details
	 * check if same user does not exist in DB
	 * and then update total users
	 * **/
	public static String insertNewUser(){
		Scanner input = new Scanner(System.in);
		
		String user_profile = "";
		System.out.println("Enter your details: ");
		
		System.out.println("Enter your Name: ");
		String user_name = input.nextLine();
		
		while( ! isValidValue(user_name) ){
			System.out.println("Enter correct details");
			user_name = input.nextLine();
		}
		user_profile += user_name.trim() + ",";
		
		System.out.println("Are you a user or organisation: ");
		String user_type = input.nextLine();
		while( ! isValidEntity(user_type) ){
			System.out.println("Enter correct details");
			user_type = input.nextLine();
		}
		user_profile += user_type.trim().toLowerCase() + ",";
		
		if("user".equals(user_type.trim().toLowerCase()) ){
			System.out.println("For User: "
					+ "\n\tEnter your age: ");
			int user_age = input.nextInt();
			while(! isValidNumber(user_age)){
				System.out.println("Enter correct details");
				user_age = input.nextInt();
			}
			user_profile += user_age + ",";
			
			System.out.println("\tEnter your hobbies: ");
			String user_hobbies = input.nextLine();
			input.nextLine();
			while(! isValidValue(user_hobbies)){
				System.out.println("Enter correct details");
				user_hobbies = input.nextLine();
			}
			user_profile += user_hobbies.trim() + ",";
			
		}else{
			System.out.println("For organisation: \n\tEnter your Domain: ");
			String user_domain = input.nextLine();
			
			while(! isValidValue(user_domain)){
				System.out.println("Enter correct details");
				user_domain = input.nextLine();
			}
			user_profile += user_domain.trim() + ",";
		}
		
		input.close();
		return user_profile;
	}
	
	/**
	 * @Method	insertNewConnection(Node current_user, String connect_to_name)
	 * add a new connection between two existing users
	 * users enter connecting user's name
	 * **/
	public static void insertNewConnection(Node current_user, String connect_to_name){
		
	}
	
	/**
	 * @Method	writeNewUser(String filename)
	 * if valid record,
	 * create 
	 * */
	private static void writeNewUser(String filename){
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filename), true));
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	private static boolean isValidValue(String user_name){
		return true;
	}
	
	private static boolean isValidEntity(String user_type){
		if("user".equals(user_type.trim()) || "organisation".equals(user_type.trim()))
			return true;
		return false;
	}
	
	private static boolean isValidNumber(int user_age){
		if(user_age <= 0 && user_age > 100){
			return false;
		}
		return true;
	}
}
