package session2;

import java.util.HashMap;
import java.util.Scanner;

public class Participation {
	/*
	 * HashMap storing all_participant_answers,
	 * */
	static HashMap<String, String> all_participant_answers = new HashMap<String, String>();
	
	/**
	 * @Method compareStrings(String source_string,String compare_with_string)
	 * this method is comparing two strings
	 * @return Integer , Zero, Negative or Positive
	 * */
	public static boolean compareStrings(String source_string, String compare_with_string) {
		return source_string.trim().equals(compare_with_string.trim());
	}
	
	/**
	 * @Method storeUserAnswers(int no_of_users,Questions[] question_object)
	 *         take user input and store the valid response
	 * @param number of users and Question objects
	 * @return void
	 * */
	public static void storeUserAnswers(int no_of_users, Questions[] question_object) {
		Scanner scan_input = new Scanner(System.in);
		
		for (int user_no = 1; user_no <= no_of_users; user_no++) {
			System.out.println("User no " + (user_no));
			
			all_participant_answers.put("Participant " + (user_no), "");
			
			for (int question_index = 0; question_index < question_object.length; question_index++) {
				String question_string = question_object[question_index].question_text+ ","+ question_object[question_index].question_type;

				if(question_object[question_index].options != null){	
					System.out.println(question_string+ ","+ question_object[question_index].options);
				}else{
					System.out.println(question_string);
				}
				
				String participant_answer = "";
		
				participant_answer = scan_input.nextLine();
				
				/*Single Select Question*/
				if (compareStrings("Single Select", question_object[question_index].question_type.trim())){
					
					while(! Single.isValidInput(participant_answer, question_object[question_index])) {
						System.out.println("Invalid Input");
						question_index--;
						participant_answer = scan_input.nextLine();
					}
					
					Single.recordUserInputForSingleSelect(participant_answer, question_object[question_index]);
				
					/*Multiple Select Question*/
				}else if (compareStrings("Multi Select",question_object[question_index].question_type.trim())){
					
					while( ! Multiple.isValidInput(participant_answer, question_object[question_index])) {
						System.out.println("HERE: Invalid Input");
					
						question_index--;
						participant_answer = scan_input.nextLine();
					}
					
					/*Test Type Question*/
				}else if ( compareStrings("Text", question_object[question_index].question_type.trim())) {
					
					while( !Text.isValidInput(participant_answer)) {
						System.out.println("Invalid number input");
						question_index--;
						participant_answer = scan_input.nextLine();
					}
					
					/*Number type Question*/
				}else if (compareStrings("Number", question_object[question_index].question_type.trim())) {
					
					while(! Number.isValidInput(participant_answer)) {
						System.out.println("Invalid number input");
						question_index--;
						participant_answer = scan_input.nextLine();
					}
				}

				String previous_response = Participation.all_participant_answers.get("Participant " + (user_no));
				Participation.all_participant_answers.put("Participant " + (user_no), previous_response + ","+ participant_answer);
			}
		}
		scan_input.close();
	}
}
