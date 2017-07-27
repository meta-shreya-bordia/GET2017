package session2;

public class Multiple extends Questions{
	
	/**
	 * @Method isValidInput(String participant_answer,Questions question_object)
	 * checking input multiple choices are right or not 
	 * @param Question objects
	 * @return boolean , true if input is valid else return false 
	 * */
	public static boolean isValidInput(String participant_answer,Questions question_object){
		String[] multiple_choices = participant_answer.split("/");
		
		//check into hashset
		for (String choice : multiple_choices) {
			if (question_object != null && question_object.multiple_choice_options != null && multiple_choices.length > 0 && !question_object.multiple_choice_options.contains(choice)) {
				return false; 		
			}
		}
		return true;
	}
}
